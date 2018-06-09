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

package org.cesiumjs.cs.widgets.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Rectangle;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewerCesiumNavigationMixinOptions {
    /**
     * Default view when resetting the map view with the reset navigation
     * control. Values accepted are of type Cesium.Cartographic and Cesium.Rectangle
     */
    @JsProperty
    public Rectangle defaultResetView;
    /**
     * Enable or disable the compass. Values accepted are true for enabling and false to disable.
     * The default is true. The compass will not be added to the map if setting the option to false.
     */
    @JsProperty
    public boolean enableCompass;
    /**
     * Enable or disable the zoom controls. Values accepted are true for enabling and false to disable.
     * The default is true. The zoom controls  will not be added to the map if setting the option to false.
     */
    @JsProperty
    public boolean enableZoomControls;
    /**
     * Enable or disable the distance legend. Values accepted are true for enabling and false to disable.
     * The default is true. The distance legend will not be added to the map if setting the option to false.
     */
    @JsProperty
    public boolean enableDistanceLegend;
    /**
     * Enable or disable the Compass Outer Ring. Values accepted are true for enabling and false to disable.
     * The default is true. The ring will be visible but inactive if setting the option to false.
     */
    @JsProperty
    public boolean enableCompassOuterRing;

    @JsConstructor
    public ViewerCesiumNavigationMixinOptions() {}
}
