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

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Globe;
import org.cesiumjs.cs.core.SkyAtmosphere;
import org.cesiumjs.cs.core.SkyBox;
import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.providers.ImageryProvider;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CesiumWidgetOptions {
    /**
     * The clock to use to control current time.
     */
    @JsProperty
    public Clock clock;
    /**
     * The imagery provider to serve as the base layer. If set to false, no imagery provider will be added.
     * Default:	new BingMapsImageryProvider()
     */
    @JsProperty
    public ImageryProvider imageryProvider;
    /**
     * The terrain provider.
     * Defaults: new EllipsoidTerrainProvider
     */
    @JsProperty
    public TerrainProvider terrainProvider;
    /**
     * The skybox used to render the stars. When undefined, the default stars are used. If set to false, no skyBox, Sun, or Moon will be added.
     */
    @JsProperty
    public SkyBox skyBox;
    /**
     * Blue sky, and the glow around the Earth's limb. Set to false to turn it off.
     */
    @JsProperty
    public SkyAtmosphere skyAtmosphere;
    /**
     * The initial scene mode.
     * Default: SceneMode.SCENE3D
     */
    @JsProperty
    public SceneMode sceneMode;
    /**
     * When true, each geometry instance will only be rendered in 3D to save GPU memory.
     * Default: false
     */
    boolean scene3DOnly;
    /**
     * If true and the configuration supports it, use order independent translucency.
     * Default true
     */
    @JsProperty
    boolean orderIndependentTranslucency;
    /**
     * The map projection to use in 2D and Columbus View modes.
     * Default: new GeographicProjection()
     */
    @JsProperty
    public MapProjection mapProjection;
    /**
     * The globe to use in the scene. If set to false, no globe will be added.
     * Default: new Globe(mapProjection.ellipsoid)
     */
    @JsProperty
    public Globe globe;
    /**
     * True if this widget should control the render loop, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean useDefaultRenderLoop;
    /**
     * The target frame rate when using the default render loop.
     */
    @JsProperty
    public double targetFrameRate;
    /**
     * If true, this widget will automatically display an HTML panel to the user containing the error, if a render loop error occurs.
     * Default: true
     */
    @JsProperty
    public boolean showRenderLoopErrors;
    /**
     * Context and WebGL creation properties corresponding to options passed to Scene.
     */
    @JsProperty
    public Object contextOptions;
    /**
     * The DOM element or ID that will contain the CreditDisplay. If not specified, the credits are added to the bottom of the widget itself.
     */
    @JsProperty
    public Element creditContainer;
    /**
     * A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
     * Default: 1.0
     */
    @JsProperty
    public double terrainExaggeration;
    /**
     * Determines if shadows are cast by the sun.
     * Default: false
     */
    @JsProperty
    public boolean shadows;
    /**
     * Determines if the terrain casts or receives shadows from the sun.
     * Default: ShadowMode.RECEIVE_ONLY
     */
    @JsProperty
    public int terrainShadows;
    /**
     * Determines if the 2D map is rotatable or can be scrolled infinitely in the horizontal direction.
     * Default: MapMode2D.INFINITE_SCROLL
     */
    @JsProperty
    public int mapMode2D;

    @JsConstructor
    public CesiumWidgetOptions() {}
}
