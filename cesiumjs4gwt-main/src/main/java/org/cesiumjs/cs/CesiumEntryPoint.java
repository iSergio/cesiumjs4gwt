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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * @author Serge Silaev aka iSergio
 */
public class CesiumEntryPoint implements EntryPoint {
    @Override
    public void onModuleLoad() {
        Cesium.fixSmartGWT();
        GWT.log("Cesium GTW module loaded");
        if (!Cesium.isInitialized()) {
            String message = "The Core of Cesium (Cesium.js) JavaScript libraries not loaded.\n"
                    + "If you inherit Cesium from NoScript gwt.xml, \nyou need include <script src='..../Cesium.js'> "
                    + "to load Cesium, \nalso you need include necessary css (Example: <link type=\"text/css\" href=\".../Cesium/Widgets/widget.css\">.\n"
                    + "By default Cesium path is [GWT App Name]/js/Cesium";
            GWT.log(message);
        }
    }
}
