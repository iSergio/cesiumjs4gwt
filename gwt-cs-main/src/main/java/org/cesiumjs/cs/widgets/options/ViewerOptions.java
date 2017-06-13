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
import org.cesiumjs.cs.collections.DataSourceCollection;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Globe;
import org.cesiumjs.cs.core.SkyAtmosphere;
import org.cesiumjs.cs.core.SkyBox;
import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.enums.MapMode2D;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.providers.ImageryProvider;
import org.cesiumjs.cs.widgets.ClockViewModel;
import org.cesiumjs.cs.widgets.ProviderViewModel;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewerOptions {
    /**
     * If set to false, the Animation widget will not be created. Default: true.
     */
    @JsProperty
    public boolean animation;
    /**
     * If set to false, the BaseLayerPicker widget will not be created. Default: true.
     */
    @JsProperty
    public boolean baseLayerPicker;
    /**
     * If set to false, the FullscreenButton widget will not be created. Default: true.
     */
    @JsProperty
    public boolean fullscreenButton;
    /**
     * If set to true, the VRButton widget will be created. Default: false.
     */
    @JsProperty
    public boolean vrButton;
    /**
     * If set to false, the Geocoder widget will not be created. Default: true.
     */
    @JsProperty
    public Object geocoder;
    /**
     * If set to false, the HomeButton widget will not be created. Default: true.
     */
    @JsProperty
    public boolean homeButton;
    /**
     * If set to false, the InfoBox widget will not be created. Default: true.
     */
    @JsProperty
    public boolean infoBox;
    /**
     * If set to false, the SceneModePicker widget will not be created. Default: true.
     */
    @JsProperty
    public boolean sceneModePicker;
    /**
     * If set to false, the SelectionIndicator widget will not be created. Default: true.
     */
    @JsProperty
    public boolean selectionIndicator;
    /**
     * If set to false, the Timeline widget will not be created. Default: true.
     */
    @JsProperty
    public boolean timeline;
    /**
     * If set to false, the navigation help button will not be created. Default: true.
     */
    @JsProperty
    public boolean navigationHelpButton;
    /**
     * True if the navigation instructions should initially be visible, or false if the should not be shown until the
     * user explicitly clicks the button. Default: true.
     */
    @JsProperty
    public boolean navigationInstructionsInitiallyVisible;
    /**
     * When true, each geometry instance will only be rendered in 3D to save GPU memory. Default: false.
     */
    @JsProperty
    public boolean scene3DOnly;
    /**
     * 	The clock to use to control current time. Default: new Clock().
     * 	@deprecated Passing options.clock when creating a new Viewer instance has been deprecated and will be removed in Cesium 1.37, pass options.clockViewModel instead.
     */
    @Deprecated
    @JsProperty
    public Clock clock;
    /**
     * The clock view model to use to control current time. Optional.
     * Default: new ClockViewModel(options.clock)
     */
    @JsProperty
    public ClockViewModel clockViewModel;
    /**
     * The view model for the current base imagery layer, if not supplied the first available base layer is used. This value is only valid if options.baseLayerPicker is set to true.
     */
    @JsProperty
    public ProviderViewModel selectedImageryProviderViewModel;
    /**
     * The array of ProviderViewModels to be selectable from the BaseLayerPicker.
     * This value is only valid if options.baseLayerPicker is set to true.
     * Default: createDefaultImageryProviderViewModels()
     */
    public ProviderViewModel[] imageryProviderViewModels;
    /**
     * The view model for the current base terrain layer, if not supplied the first available base layer is used.
     * This value is only valid if options.baseLayerPicker is set to true.
     */
    public ProviderViewModel selectedTerrainProviderViewModel;
    /**
     * The array of ProviderViewModels to be selectable from the BaseLayerPicker.
     * This value is only valid if options.baseLayerPicker is set to true.
     * Default: createDefaultTerrainProviderViewModels()
     */
    public ProviderViewModel[] terrainProviderViewModels;
    /**
     * The imagery provider to use. This value is only valid if options.baseLayerPicker is set to false.
     * Default: new BingMapsImageryProvider()
     */
    public ImageryProvider imageryProvider;
    /**
     * The terrain provider to use
     * Default: new EllipsoidTerrainProvider()
     */
    public TerrainProvider terrainProvider;
    /**
     * The skybox used to render the stars. When undefined, the default stars are used.
     */
    public SkyBox skyBox;
    /**
     * 	Blue sky, and the glow around the Earth's limb. Set to false to turn it off.
     */
    public SkyAtmosphere skyAtmosphere;
    /**
     * The element or id to be placed into fullscreen mode when the full screen button is pressed.
     * Default: document.body
     */
    public Element fullscreenElement;
    /**
     * True if this widget should control the render loop, false otherwise.
     * Default: true
     */
    public boolean useDefaultRenderLoop;
    /**
     * The target frame rate when using the default render loop.
     */
    public double targetFrameRate;
    /**
     * If true, this widget will automatically display an HTML panel to the user containing the error, if a render loop error occurs.
     * Default: true
     */
    public boolean showRenderLoopErrors;
    /**
     * If true, this widget will automatically track the clock settings of newly added DataSources, updating
     * if the DataSource's clock changes. Set this to false if you want to configure the clock independently.
     */
    public boolean automaticallyTrackDataSourceClocks;
    /**
     * Context and WebGL creation properties corresponding to options passed to Scene.
     */
    public Object contextOptions;
    /**
     * 	SceneMode	SceneMode.SCENE3D	optional The initial scene mode.
     * 	Default: {@link SceneMode#SCENE3D()}
     */
    public Number sceneMode;
    /**
     * The map projection to use in 2D and Columbus View modes.
     * Default: new GeographicProjection()
     */
    public MapProjection mapProjection;
    /**
     * 	The globe to use in the scene. If set to false, no globe will be added.
     * 	Default: new Globe(mapProjection.ellipsoid)
     */
    public Globe globe;
    /**
     * 	If true and the configuration supports it, use order independent translucency.
     * 	Default: true
     */
    public boolean orderIndependentTranslucency;
    /**
     * The DOM element or ID that will contain the CreditDisplay.
     * If not specified, the credits are added to the bottom of the widget itself.
     */
    public Element creditContainer;
    /**
     * The collection of data sources visualized by the widget. If this parameter is provided, the instance is assumed to be owned by the caller and will not be destroyed when the viewer is destroyed.
     * Default: new DataSourceCollection()
     */
    public DataSourceCollection dataSources;
    /**
     * A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
     * Default: 1.0
     */
    public double terrainExaggeration;
    /**
     * Determines if shadows are cast by the sun.
     */
    public boolean shadows;
    /**
     * Determines if the terrain casts or receives shadows from the sun.
     * Default: {@link ShadowMode#RECEIVE_ONLY()}
     */
    public Number terrainShadows;
    /**
     * Determines if the 2D map is rotatable or can be scrolled infinitely in the horizontal direction.
     * Default: {@link MapMode2D#INFINITE_SCROLL()}
     */
    public int mapMode2D;
    /**
     * If set to true, the ProjectionPicker widget will be created.
     * Default: false
     */
    public boolean projectionPicker;

    @JsConstructor
    public ViewerOptions() {}
}
