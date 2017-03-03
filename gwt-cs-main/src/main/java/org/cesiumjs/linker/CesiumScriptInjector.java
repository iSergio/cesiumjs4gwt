/*
 * Copyright 2017 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cesiumjs.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.*;
import com.google.gwt.core.linker.CrossSiteIframeLinker;
import com.google.gwt.dev.About;
import com.google.gwt.dev.cfg.ModuleDef;
import com.google.gwt.dev.cfg.ModuleDefLoader;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@Shardable
@LinkerOrder(LinkerOrder.Order.POST)
public class CesiumScriptInjector extends AbstractLinker {
    private static String SCRIPT_LOADER = "loadCesiumScripts.js";
    private static String LOADED_SCRIPTS = "__gwt_cesiumScriptsLoaded";
    private static String PAGE_RELATIVE_MODULE_PATH = "cesiumScriptInjector.pageRelativeModulePath";

    private boolean forceScriptLoad(TreeLogger logger, String moduleName, Float gwtVersion) {
        try {
            ModuleDef module;
            Method getModuleDef;

            if (gwtVersion < 2.6f) {
                getModuleDef = ModuleDefLoader.class.getDeclaredMethod("loadFromClassPath", new Class[] {TreeLogger.class, String.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, moduleName);
            } else if (gwtVersion < 2.8f) {
                Class compilerContextClass = Class.forName("com.google.gwt.dev.CompilerContext");
                Object context = compilerContextClass.getDeclaredConstructor().newInstance();

                getModuleDef = ModuleDefLoader.class.getDeclaredMethod("loadFromClassPath", new Class[] {TreeLogger.class, compilerContextClass, String.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, compilerContextClass.cast(context), moduleName);
            } else {
                getModuleDef = ModuleDefLoader.class.getDeclaredMethod("loadFromClassPath", new Class[] {TreeLogger.class, String.class, boolean.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, moduleName, false);
            }

            if (module != null) return CrossSiteIframeLinker.class.equals(module.getActivePrimaryLinker());
            logger.log(TreeLogger.WARN, "Can't find module reference - not injecting scripts.");

        } catch (Throwable t) {
            logger.log(TreeLogger.ERROR, "Encountered an exception while trying to resolve the ModuleDef for " + moduleName, t);
        }
        return false;
    }

    private String getScriptLoaderJS(String pageRelativeModulePath) {
        return "if (!/loaded|complete/.test(document.readyState)) {\n" +
                "  document.write('<script src=\"" + pageRelativeModulePath + "/" +
                SCRIPT_LOADER + "\"></script>');\n" +
                "}\n";
    }

    private String getScriptLoadJS(Set<ScriptReference> scriptsToLoad, String pageRelativeModulePath) {
        String result = "if (!window." + LOADED_SCRIPTS + ") window." + LOADED_SCRIPTS + " = {};\n";
        for (ScriptReference script : scriptsToLoad) {
            String src = script.getSrc();
            if (!src.startsWith("cs/")) {
                continue;
            }
            result += "if (!" + LOADED_SCRIPTS + "['" + src + "']) {\n  " +
                    LOADED_SCRIPTS + "['" + src + "'] = true;\n  " +
                    "document.write('<script src=\"" + pageRelativeModulePath + "/" + src + "\">" +
                    "</script>');\n}\n";
            System.out.println(src);
        }
        return result;
    }

    private static String getPageRelativeModulePath(LinkerContext context) {
        String moduleName = context.getModuleName();

        List<String> pathBindings = null;
        for (ConfigurationProperty property : context.getConfigurationProperties()) {
            if (PAGE_RELATIVE_MODULE_PATH.equals(property.getName())) {
                pathBindings = property.getValues();
            }
        }
        if (pathBindings == null) return moduleName;

        for (String binding : pathBindings) {
            String[] parts = binding.split("=");
            if (parts.length == 2 && moduleName.equals(parts[0])) {
                System.out.println("      Setting page-relative module path for module '" + moduleName + "' using gwt.xml config");
                return parts[1];
            }
        }

        return moduleName;
    }

    @Override
    public String getDescription() {
        return "CesiumScriptInjector";
    }

    protected SyntheticArtifact emitString(TreeLogger logger, String what, String partialPath, LinkerContext context) throws UnableToCompleteException {
        if (context.isOutputCompact()) {
            what = what.replaceAll("\n\\s*", "");
        }
        return super.emitString(logger, what, partialPath);
    }

    @Override
    public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts, boolean permutation) throws UnableToCompleteException {
        Float gwtVersion = Float.parseFloat(About.getGwtVersionNum().replaceFirst("([0-9]+\\.[0-9]+).*", "$1"));
        String moduleName = context.getModuleName();

        if (permutation) {
            return artifacts;
        }

        Artifact scriptLoader = emitString(logger, "", SCRIPT_LOADER);
        ArtifactSet result = new ArtifactSet(artifacts);
        result.add(scriptLoader);

        if (gwtVersion < 2.5f || !forceScriptLoad(logger, moduleName, gwtVersion)) {
            return result;
        }

        Set<ScriptReference> scripts = result.find(ScriptReference.class);
        if (scripts.size() == 0) {
            return result;
        }

        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            if (!partialPath.endsWith(moduleName + ".nocache.js")) continue;

            System.out.println("   Invoking Linker CesiumScriptInjector");

            String pageRelativeModulePath = getPageRelativeModulePath(context);

            System.out.println("      Creating " + SCRIPT_LOADER + " to manually load the following script tags:");

            result.remove(emittedArtifact);
            String nocacheJS = CesiumLinkerUtils.getContents(emittedArtifact, logger);
            nocacheJS += getScriptLoaderJS(pageRelativeModulePath);
            result.add(emitString(logger, nocacheJS, partialPath, context));

            result.remove(scriptLoader);
            String loadTags = getScriptLoadJS(scripts, pageRelativeModulePath);
            result.add(emitString(logger, loadTags, SCRIPT_LOADER, context));

            break;
        }

        return result;
    }
}
