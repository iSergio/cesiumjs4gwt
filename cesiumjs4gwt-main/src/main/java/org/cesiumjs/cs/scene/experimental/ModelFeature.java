/*
 * Copyright 2022 iserge, Gis4Fun.
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

package org.cesiumjs.cs.scene.experimental;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.scene.experimental.options.ModelFeatureOptions;

/**
 * A feature of a {@link ModelExperimental}.
 * Provides access to a feature's properties stored in the model's feature table.
 *
 * Modifications to a ModelFeature object have the lifetime of the model.
 *
 * Do not construct this directly. Access it through picking using {@link org.cesiumjs.cs.scene.Scene#pick}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelFeature")
public class ModelFeature {
    /**
     * Gets or sets the highlight color multiplied with the feature's color. When this is white, the feature's color
     * is not changed. This is set for all features when a style's color is evaluated.
     *
     * Default: {@link Color#WHITE()}
     */
    public Color color;
    /**
     * Get the feature ID associated with this feature. For 3D Tiles 1.0, the batch ID is returned.
     * For EXT_mesh_features, this is the feature ID from the selected feature ID set.
     *
     * <p>Experimental</p>
     * <p>This feature is using part of the 3D Tiles spec that is not final and is subject to change without Cesium's
     *     standard deprecation policy.</p>
     */
    @JsProperty(name = "featureId")
    public native double featureId();
    /**
     * Gets or sets if the feature will be shown. This is set for all features when a style's show is evaluated.
     * Default: true
     */
    @JsProperty
    public boolean show;

    private ModelFeature() {}

    @JsConstructor
    public ModelFeature(ModelFeatureOptions options) {}

    /**
     * Returns a copy of the value of the feature's property with the given name.
     *
     * @param name The case-sensitive name of the property.
     * @return The value of the property or undefined if the feature does not have this property.
     */
    @JsMethod
    public native Object getProperty(String name);

    /**
     * Returns a copy of the feature's property with the given name, examining all the metadata from the
     * EXT_mesh_features and legacy EXT_feature_metadata glTF extensions. Metadata is checked against name from
     * most specific to most general and the first match is returned. Metadata is checked in this order:
     * <p>
     * 1. Feature metadata property by semantic
     * 2. Feature metadata property by property ID
     * </p>
     * <p>See the EXT_mesh_features Extension as well as the previous EXT_feature_metadata Extension for glTF.</p>
     * @param name The semantic or property ID of the feature. Semantics are checked before property IDs in each granularity of metadata.
     * @return The value of the property or undefined if the feature does not have this property.
     */
    @JsMethod
    public native Object getPropertyInherited(String name);

    /**
     * Returns an array of property names for the feature.
     * @return The names of the feature's properties.
     */
    @JsMethod
    public native String[] getPropertyNames();

    /**
     * Returns an array of property names for the feature.
     * @param results An array into which to store the results.
     * @return The names of the feature's properties.
     */
    @JsMethod
    public native JsArray<String> getPropertyNames(JsArray<String> results);

    /**
     * Returns whether the feature contains this property.
     * @param name The case-sensitive name of the property.
     * @return Whether the feature contains this property.
     */
    @JsMethod
    public native boolean hasProperty(String name);

    /**
     * Sets the value of the feature's property with the given name.
     * @param name The case-sensitive name of the property.
     * @param value The value of the property that will be copied.
     * @return true if the property was set, false otherwise.
     */
    @JsMethod
    public native boolean setProperty(String name, Object value);
}
