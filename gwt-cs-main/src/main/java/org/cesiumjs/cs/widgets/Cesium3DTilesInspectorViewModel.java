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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Cesium3DTile;
import org.cesiumjs.cs.scene.Cesium3DTileFeature;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.Cesium3DTileColorBlendMode;

/**
 * The view model for {@link Cesium3DTilesInspector}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTilesInspectorViewModel")
public class Cesium3DTilesInspectorViewModel {
    /**
     * Generates an HTML string of the statistics
     */
    @JsProperty
    public static String getStatistics;
    /**
     * Gets or sets the screen space error that must be reached before skipping levels of detail. This property is observable.
     * Default: 1024
     */
    @JsProperty
    public int baseScreenSpaceError;
    /**
     * Gets or sets the color blend mode. This property is observable.
     * Default: {@link Cesium3DTileColorBlendMode#HIGHLIGHT()}
     */
    @JsProperty
    public Number colorBlendMode;
    /**
     * Gets the available blend modes
     */
    @JsProperty(name = "colorBlendModes")
    public native Object[] colorBlendModes();
    /**
     * Gets or sets the flag to colorize tiles. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean colorize;
    /**
     * Gets or sets the flag to show the display section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean displayVisible;
    /**
     * Gets or sets the flag to enable dynamic screen space error. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean dynamicScreenSpaceError;
    /**
     * Gets or sets the dynamic screen space error density. This property is observable.
     * Default: 0.00278
     */
    @JsProperty
    public double dynamicScreenSpaceErrorDensity;
    /**
     * Gets or sets the dynamic screen space error density slider value. This allows the slider to be exponential because values tend to be closer to 0 than 1. This property is observable.
     * Default: 0.00278
     */
    @JsProperty
    public double dynamicScreenSpaceErrorDensitySliderValue;
    /**
     * Gets or sets the dynamic screen space error factor. This property is observable.
     * Default: 4.0
     */
    @JsProperty(name = "dynamicScreenSpaceErrorFactor")
    public native double dynamicScreenSpaceErrorFactor();
    /**
     * Gets the editor error message
     */
    @JsProperty(name = "editorError")
    public native String editorError();
    /**
     * Gets the current feature of the view model.
     */
    @JsProperty
    public Cesium3DTileFeature feature;
    /**
     * Gets or sets the flag to suspend updates. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean freezeFrame;
    /**
     * Gets or sets the flag which, when true, only tiles that meet the maximum screen space error will ever be downloaded.
     * This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean immediatelyLoadDesiredLevelOfDetail;
    /**
     * Gets or sets the flag to show the inspector. This property is observable.
     * Default: true
     */
    @JsProperty
    public boolean inspectorVisible;
    /**
     * Gets or sets the flag which determines whether siblings of visible tiles are always downloaded during traversal.
     * This property is observable
     * Default: false
     */
    @JsProperty
    public boolean loadSiblings;
    /**
     * Gets or sets the flag to show the logging section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean loggingVisible;
    /**
     * Gets or sets the maximum screen space error. This property is observable.
     * Default: 16
     */
    @JsProperty
    public int maximumScreenSpaceError;
    /**
     * Gets or sets the flag to show the optimization info section. This property is observable.
     * Default: false;
     */
    @JsProperty
    public boolean optimizationVisible;
    /**
     * Gets or sets the flag to enable performance display. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean performance;
    /**
     * Gets the performance container
     */
    @JsProperty(name = "performanceContainer")
    public native Element performanceContainer();
    /**
     * Gets or sets the pick state
     * Default: false
     */
    @JsProperty
    public boolean pickActive;
    /**
     * Gets or sets the flag to enable picking. This property is observable.
     * Default: true
     */
    @JsProperty
    public boolean picking;
    /**
     * Gets the pick statistics text. This property is observable.
     */
    @JsProperty(name = "pickStatisticsText")
    public native String pickStatisticsText();
    /**
     * Gets the names of the properties in the tileset. This property is observable.
     */
    @JsProperty(name = "properties")
    public native String[] properties();
    /**
     * Gets the scene
     */
    @JsProperty(name = "scene")
    public native Scene scene();
    /**
     * Gets or sets the flag to show bounding volumes. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showBoundingVolumes;
    /**
     * Gets or sets the flag to show content volumes. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showContentBoundingVolumes;
    /**
     * Gets or sets the flag to show tile geometric error. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showGeometricError;
    /**
     * Gets or sets the flag to show debug labels only for the currently picked tile. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showOnlyPickedTileDebugLabel;
    /**
     * Gets or sets the flag to show pick statistics. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showPickStatistics;
    /**
     * Gets or sets the flag to show request volumes. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showRequestVolumes;
    /**
     * Gets or sets the flag to show statistics. This property is observable.
     * Default: true
     */
    @JsProperty
    public boolean showStatistics;
    /**
     * Gets or sets the flag to determine if level of detail skipping should be applied during the traversal. This property is observable.
     * Default: true
     */
    @JsProperty
    public boolean skipLevelOfDetail;
    /**
     * Gets or sets the constant defining the minimum number of levels to skip when loading tiles. This property is observable.
     * Default: 1
     */
    @JsProperty
    public int skipLevels;
    /**
     * Gets or sets the multiplier defining the minimum screen space error to skip. This property is observable.
     * Default: 16
     */
    @JsProperty
    public int skipScreenSpaceErrorFactor;
    /**
     * Gets the statistics text. This property is observable.
     */
    @JsProperty(name = "statisticsText")
    public native String statisticsText();
    /**
     * Gets or sets the JSON for the tileset style. This property is observable.
     * Default: '{}'
     */
    @JsProperty
    public String styleString;
    /**
     * Gets or sets the flag to show the style section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean styleVisible;
    /**
     * Gets the current tile of the view model
     */
    @JsProperty
    public Cesium3DTile tile;
    /**
     * Gets or sets the flag to show the tile info section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean tileDebugLabelsVisible;
    /**
     * Gets or sets the tileset of the view model.
     */
    @JsProperty
    public Cesium3DTileset tileset;
    /**
     * Gets or sets the flag to show the tileset section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean tilesetVisible;
    /**
     * Gets or sets the flag to show the update section. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean updateVisible;
    /**
     * Gets or sets the flag to draw with wireframe. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean wireframe;

    /**
     * The view model for {@link Cesium3DTilesInspector}.
     * @param scene The scene instance to use.
     * @param element The container for the performance display
     */
    @JsConstructor
    public Cesium3DTilesInspectorViewModel(Scene scene, Element element) {}

    /**
     * Compiles the style in the style editor.
     */
    @JsMethod
    public native void compileStyle();

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     *
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Handles key press events on the style editor.
     */
    @JsMethod
    public native void styleEditorKeyPress();

    /**
     * Toggles the visibility of the display section
     */
    @JsMethod
    public native void toggleDisplay();

    /**
     * Toggles the inspector visibility
     */
    @JsMethod
    public native void toggleInspector();

    /**
     * Toggles the visibility of the logging section
     */
    @JsMethod
    public native void toggleLogging();

    /**
     * Toggles the visibility of the optimization section
     */
    @JsMethod
    public native void toggleOptimization();

    /**
     * Toggles the pick tileset mode
     */
    @JsMethod
    public native void togglePickTileset();

    /**
     * Toggles the visibility of the style section
     */
    @JsMethod
    public native void toggleStyle();

    /**
     * Toggles the visibility of the tile Debug Info section
     */
    @JsMethod
    public native void toggleTileDebugLabels();

    /**
     * Toggles the visibility of the tileset section
     */
    @JsMethod
    public native void toggleTileset();

    /**
     * Toggles the visibility of the update section
     */
    @JsMethod
    public native void toggleUpdate();

    /**
     * Trims tile cache
     */
    @JsMethod
    public native void trimTilesCache();
}
