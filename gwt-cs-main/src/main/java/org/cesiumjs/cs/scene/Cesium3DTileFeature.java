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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.PickedObject;
import org.cesiumjs.cs.js.JsObject;

/**
 * A feature of a {@link Cesium3DTileset}.
 * Provides access to a feature's properties stored in the tile's batch table, as well as the ability to show/hide a
 * feature and change its highlight color via {@link Cesium3DTileset#show} and {@link Cesium3DTileFeature#color}, respectively.
 *
 * Modifications to a Cesium3DTileFeature object have the lifetime of the tile's content. If the tile's c
 * ontent is unloaded, e.g., due to it going out of view and needing to free space in the cache for visible tiles,
 * listen to the {@link Cesium3DTileset#tileUnload} event to save any modifications. Also listen to the {@link Cesium3DTileset#tileVisible}
 * event to reapply any modifications.
 *
 * Do not construct this directly. Access it through {@link Cesium3DTileContent#getFeature} or picking using Scene#pick and {@link Scene#pickPosition}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileFeature")
public class Cesium3DTileFeature extends PickedObject {
    /**
     * Gets or sets the highlight color multiplied with the feature's color. When this is white, the feature's color is not changed.
     * This is set for all features when a style's color is evaluated.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Color color;
    /**
     * All objects returned by Scene#pick have a primitive property. This returns the tileset containing the feature.
     */
    @JsProperty(name = "primitive")
    public native Cesium3DTileset primitive();
    /**
     * Gets or sets if the feature will be shown. This is set for all features when a style's show is evaluated.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Gets the tileset containing the feature.
     */
    @JsProperty(name = "tileset")
    public native Cesium3DTileset tileset();

//    @JsConstructor
//    private Cesium3DTileFeature() {}

    /**
     * Returns a copy of the value of the feature's property with the given name. This includes properties from this
     * feature's class and inherited classes when using a batch table hierarchy.
     * @param name The case-sensitive name of the property.
     * @return The value of the property or undefined if the property does not exist.
     * @see <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/TileFormats/BatchTable#batch-table-hierarchy">link</a>
     */
    @JsMethod
    public native JsObject getProperty(String name);

    /**
     * Returns an array of property names for the feature. This includes properties from this feature's
     * class and inherited classes when using a batch table hierarchy.
     * @return The names of the feature's properties.
     * @see <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/TileFormats/BatchTable#batch-table-hierarchy">link</a>
     */
    @JsMethod
    public native String[] getPropertyNames();

    /**
     * Returns an array of property names for the feature. This includes properties from this feature's
     * class and inherited classes when using a batch table hierarchy.
     * @param results An array into which to store the results.
     * @return The names of the feature's properties.
     * @see <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/TileFormats/BatchTable#batch-table-hierarchy">link</a>
     */
    @JsMethod
    public native String[] getPropertyNames(String[] results);

    /**
     * Returns whether the feature contains this property. This includes properties from this feature's class and inherited
     * classes when using a batch table hierarchy.
     * @param name The case-sensitive name of the property.
     * @return Whether the feature contains this property.
     */
    @JsMethod
    public native boolean hasProperty(String name);

    /**
     * Sets the value of the feature's property with the given name.
     * If a property with the given name doesn't exist, it is created.
     * @param name The case-sensitive name of the property.
     * @param value The value of the property that will be copied.
     */
    @JsMethod
    public native void setProperty(String name, JsObject value);
}
