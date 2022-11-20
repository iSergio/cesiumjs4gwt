/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;

import java.util.List;

/**
 * This class implements an I3S Node. In CesiumJS each I3SNode creates a Cesium3DTile.
 * Do not construct this directly, instead access tiles through {@link I3SLayer}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SNode")
public class I3SNode {
    /**
     * Gets the children nodes.
     */
    @JsProperty(name = "children")
    public native List<I3SNode> children();

    /**
     * Gets the I3S data for this object.
     */
    @JsProperty(name = "data")
    public native JsObject data();

    /**
     * Gets the collection of features.
     */
    @JsProperty(name = "featureData")
    public native List<I3SFeature> featureData();

    /**
     * Gets the collection of fields.
      */
    @JsProperty(name = "fields")
    public native I3SField fields();

    /**
     * Gets the collection of geometries.
     */
    @JsProperty(name = "geometryData")
    public native List<I3SGeometry> geometryData();

    /**
     * Gets the parent layer.
     */
    @JsProperty(name = "layer")
    public native I3SLayer layer();

    /**
     * Gets the parent node.
     */
    @JsProperty(name = "parent")
    public native I3SNode parent();

    /**
     * Gets the resource for the node.
     */
    @JsProperty(name = "resource")
    public native Resource resource();

    /**
     * Gets the Cesium3DTile for this node.
     */
    @JsProperty(name = "tile")
    public native Cesium3DTile tile();

    @JsConstructor
    private I3SNode() {}

    /**
     * Returns the fields for a given feature.
     * @param featureIndex Index of the feature whose attributes we want to get
     * @return Object containing field names and their values
     */
    @JsMethod
    public native JsObject getFieldsForFeature(int featureIndex);

    /**
     * Returns the fields for a given picked position.
     * @param pickedPosition The picked position
     * @return Object containing field names and their values
     */
    @JsMethod
    public native JsObject getFieldsForPickedPosition(Cartesian3 pickedPosition);

    /**
     * Loads the node fields.
     * @return A promise that is resolved when the I3S Node fields are loaded
     */
    @JsMethod
    public native Promise<Void, Void> loadFields();
}
