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

package org.cesiumjs.cs.widgets.options;

import com.google.gwt.dom.client.Element;

import org.cesiumjs.cs.collections.DataSourceCollection;
import org.cesiumjs.cs.core.GeocoderService;
import org.cesiumjs.cs.core.SkyBox;
import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.SkyAtmosphere;
import org.cesiumjs.cs.scene.enums.MapMode2D;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.providers.ImageryProvider;
import org.cesiumjs.cs.widgets.ClockViewModel;
import org.cesiumjs.cs.widgets.ProviderViewModel;
import org.cesiumjs.cs.widgets.Viewer;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewerOptions {
  /**
   * If set to false, the Animation widget will not be created. Default: true.
   */
  @JsProperty
  public boolean animation;
  /**
   * If set to false, the BaseLayerPicker widget will not be created. Default:
   * true.
   */
  @JsProperty
  public boolean baseLayerPicker;
  /**
   * If set to false, the FullscreenButton widget will not be created. Default:
   * true.
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
  public boolean geocoder;
  @JsProperty(name = "geocoder")
  public GeocoderService[] geocoderServices;
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
   * If set to false, the SceneModePicker widget will not be created. Default:
   * true.
   */
  @JsProperty
  public boolean sceneModePicker;
  /**
   * If set to false, the SelectionIndicator widget will not be created. Default:
   * true.
   */
  @JsProperty
  public boolean selectionIndicator;
  /**
   * If set to false, the Timeline widget will not be created. Default: true.
   */
  @JsProperty
  public boolean timeline;
  /**
   * If set to false, the navigation help button will not be created. Default:
   * true.
   */
  @JsProperty
  public boolean navigationHelpButton;
  /**
   * True if the navigation instructions should initially be visible, or false if
   * the should not be shown until the user explicitly clicks the button. Default:
   * true.
   */
  @JsProperty
  public boolean navigationInstructionsInitiallyVisible;
  /**
   * When true, each geometry instance will only be rendered in 3D to save GPU
   * memory. Default: false.
   */
  @JsProperty
  public boolean scene3DOnly;
  /**
   * if the clock should attempt to advance simulation time by default, false
   * otherwise. This option takes precedence over setting
   * {@link Viewer#clockViewModel()}. Default: false
   */
  @JsProperty
  public boolean shouldAnimate;
  /**
   * The clock view model to use to control current time. Optional. Default: new
   * ClockViewModel(options.clock)
   */
  @JsProperty
  public ClockViewModel clockViewModel;
  /**
   * The view model for the current base imagery layer, if not supplied the first
   * available base layer is used. This value is only valid if
   * options.baseLayerPicker is set to true.
   */
  @JsProperty
  public ProviderViewModel selectedImageryProviderViewModel;
  /**
   * The array of ProviderViewModels to be selectable from the BaseLayerPicker.
   * This value is only valid if options.baseLayerPicker is set to true. Default:
   * createDefaultImageryProviderViewModels()
   */
  @JsProperty
  public ProviderViewModel[] imageryProviderViewModels;
  /**
   * The view model for the current base terrain layer, if not supplied the first
   * available base layer is used. This value is only valid if
   * options.baseLayerPicker is set to true.
   */
  @JsProperty
  public ProviderViewModel selectedTerrainProviderViewModel;
  /**
   * The array of ProviderViewModels to be selectable from the BaseLayerPicker.
   * This value is only valid if options.baseLayerPicker is set to true. Default:
   * createDefaultTerrainProviderViewModels()
   */
  @JsProperty
  public ProviderViewModel[] terrainProviderViewModels;
  /**
   * The imagery provider to use. This value is only valid if
   * options.baseLayerPicker is set to false. Default: new
   * BingMapsImageryProvider()
   */
  @JsProperty
  public ImageryProvider imageryProvider;
  /**
   * The terrain provider to use Default: new EllipsoidTerrainProvider()
   */
  @JsProperty
  public TerrainProvider terrainProvider;
  /**
   * The skybox used to render the stars. When undefined, the default stars are
   * used.
   */
  @JsProperty
  public SkyBox skyBox;
  /**
   * Blue sky, and the glow around the Earth's limb. Set to false to turn it off.
   */
  @JsProperty
  public SkyAtmosphere skyAtmosphere;
  /**
   * The element or id to be placed into fullscreen mode when the full screen
   * button is pressed. Default: document.body
   */
  @JsProperty
  public Element fullscreenElement;
  /**
   * True if this widget should control the render loop, false otherwise. Default:
   * true
   */
  @JsProperty
  public boolean useDefaultRenderLoop;
  /**
   * The target frame rate when using the default render loop.
   */
  @JsProperty
  public double targetFrameRate;
  /**
   * If true, this widget will automatically display an HTML panel to the user
   * containing the error, if a render loop error occurs. Default: true
   */
  @JsProperty
  public boolean showRenderLoopErrors;
  /**
   * If true, render at the browser's recommended resolution and ignore
   * window.devicePixelRatio. Default: false
   */
  @JsProperty
  public boolean useBrowserRecommendedResolution;
  /**
   * If true, this widget will automatically track the clock settings of newly
   * added DataSources, updating if the DataSource's clock changes. Set this to
   * false if you want to configure the clock independently.
   */
  @JsProperty
  public boolean automaticallyTrackDataSourceClocks;
  /**
   * Context and WebGL creation properties corresponding to options passed to
   * Scene.
   */
  @JsProperty
  public Object contextOptions;
  /**
   * SceneMode SceneMode.SCENE3D optional The initial scene mode. Default:
   * {@link SceneMode#SCENE3D()}
   */
  @JsProperty
  public Number sceneMode;
  /**
   * The map projection to use in 2D and Columbus View modes. Default: new
   * GeographicProjection()
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
   * If true and the configuration supports it, use order independent
   * translucency. Default: true
   */
  @JsProperty
  public boolean orderIndependentTranslucency;
  /**
   * The DOM element or ID that will contain the CreditDisplay. If not specified,
   * the credits are added to the bottom of the widget itself.
   */
  @JsProperty
  public Element creditContainer;
  /**
   * The collection of data sources visualized by the widget. If this parameter is
   * provided, the instance is assumed to be owned by the caller and will not be
   * destroyed when the viewer is destroyed. Default: new DataSourceCollection()
   */
  @JsProperty
  public DataSourceCollection dataSources;
  /**
   * A scalar used to exaggerate the terrain. Note that terrain exaggeration will
   * not modify any other primitive as they are positioned relative to the
   * ellipsoid. Default: 1.0
   */
  @JsProperty
  public double terrainExaggeration;
  /**
   * Determines if shadows are cast by the sun.
   */
  @JsProperty
  public boolean shadows;
  /**
   * Determines if the terrain casts or receives shadows from the sun. Default:
   * {@link ShadowMode#RECEIVE_ONLY()}
   */
  @JsProperty
  public Number terrainShadows;
  /**
   * Determines if the 2D map is rotatable or can be scrolled infinitely in the
   * horizontal direction. Default: {@link MapMode2D#INFINITE_SCROLL()}
   */
  @JsProperty
  public int mapMode2D;
  /**
   * If set to true, the ProjectionPicker widget will be created. Default: false
   */
  @JsProperty
  public boolean projectionPicker;
  /**
   * If true, rendering a frame will only occur when needed as determined by
   * changes within the scene. Enabling improves performance of the application,
   * but requires using {@link Scene#requestRender()} to render a new frame
   * explicitly in this mode. This will be necessary in many cases after making
   * changes to the scene in other parts of the API. See <a href=
   * "https://cesium.com/blog/2018/01/24/cesium-scene-rendering-performance/">Improving
   * Performance with Explicit Rendering</a>. Default: false
   */
  @JsProperty
  public boolean requestRenderMode;

  @JsConstructor
  public ViewerOptions() {
  }
}
