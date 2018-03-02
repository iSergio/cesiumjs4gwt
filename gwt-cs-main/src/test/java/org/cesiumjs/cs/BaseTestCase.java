/*
 * Copyright 2018 iserge.
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

package org.cesiumjs.cs;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.junit.client.GWTTestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public abstract class BaseTestCase extends GWTTestCase {
    private static boolean loaded = false;

    @Override
    public String getModuleName() {
        return "org.cesiumjs.CesiumTest";
    }

    protected void beginTest(final Test test) {//final Test test) {

        if (loaded) {
            test.execute();
        } else {

            super.delayTestFinish(10_000);

            ScriptInjector.fromUrl("cs/CesiumUnminified/Cesium.js").setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {

                @Override
                public void onFailure(Exception reason) {
                    assertNotNull(reason);
                    fail("Injection failed: " + reason.toString());
                }

                @Override
                public void onSuccess(Void result) {
                    loaded = true;
                    test.execute();
                    finishTest();
                }

            }).inject();

        }

    }

    public interface Test {
        void execute();
    }
}
