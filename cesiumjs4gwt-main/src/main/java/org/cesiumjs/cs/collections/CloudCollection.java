/*
 * Copyright 2021 iserge.
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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.options.CloudCollectionOptions;
import org.cesiumjs.cs.collections.options.CumulusCloudAddOptions;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.CumulusCloud;

/**
 * A renderable collection of clouds in the 3D scene.
 *
 * Clouds are added and removed from the collection using {@link CloudCollection#add} and {@link CloudCollection#remove}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CloudCollection")
public class CloudCollection extends Collection<CumulusCloud> {
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Renders the billboards with one opaque color for the sake of debugging.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugBillboards;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the clouds as opaque, monochrome ellipsoids for the sake of debugging. If debugBillboards is also true,
     * then the ellipsoids will draw on top of the billboards.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugEllipsoids;
//    /**
//     * Returns the number of clouds in this collection.
//     */
//    @JsProperty
//    public int length;
    /**
     * Controls the amount of detail captured in the precomputed noise texture used to render the cumulus clouds.
     * In order for the texture to be tileable, this must be a power of two. For best results, set this to be a power
     * of two between 8.0 and 32.0 (inclusive).
     * Default: 16.0
     */
    @JsProperty
    public float noiseDetail;
    /**
     * Applies a translation to noise texture coordinates to generate different data. This can be modified if the
     * default noise does not generate good-looking clouds.
     * Default: Cartesian3.ZERO
     */
    @JsProperty
    public Cartesian3 noiseOffset;
    /**
     * Determines if billboards in this collection will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    @JsConstructor
    public CloudCollection() {}

    @JsConstructor
    public CloudCollection(CloudCollectionOptions options) {}

    /**
     * Creates and adds a cloud with the specified initial properties to the collection. The added cloud is returned so
     * it can be modified or removed from the collection later.
     * @return The cloud that was added to the collection.
     */
    @JsMethod
    public native CumulusCloud add();

    /**
     * Creates and adds a cloud with the specified initial properties to the collection. The added cloud is returned so
     * it can be modified or removed from the collection later.
     * @param options A template describing the cloud's properties as {@link CumulusCloudAddOptions}
     * @return The cloud that was added to the collection.
     */
    @JsMethod
    public native CumulusCloud add(CumulusCloudAddOptions options);
}
