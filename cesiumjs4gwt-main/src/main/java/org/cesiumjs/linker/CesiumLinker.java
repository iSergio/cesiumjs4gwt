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
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.LinkerOrder;

import java.util.Set;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@LinkerOrder(LinkerOrder.Order.PRE)
public class CesiumLinker extends AbstractLinker {
    @Override
    public String getDescription() {
        return "Cesium";
    }

    @Override
    public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts) throws UnableToCompleteException {
        ArtifactSet toReturn = new ArtifactSet(artifacts);

        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            // Add to Cesium.js file, path, where Cesium/Cesium.js stored.
            // It need for inject css files for example - Viewer
            if (partialPath.endsWith("/Cesium.js")) {
                String contents = CesiumLinkerUtils.getContents(emittedArtifact, logger);
                StringBuffer sb = new StringBuffer(contents);
                sb.insert(0, "window.CesiumPath = '" + context.getModuleName() + "/js/';\n");
                toReturn.remove(emittedArtifact);
                toReturn.add(emitString(logger, sb.toString(), partialPath));
            }
        }
        return toReturn;
    }
}