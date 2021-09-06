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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.CumulusCloud;

/**
 * Options object for {@link org.cesiumjs.cs.collections.CloudCollection#CloudCollection(CloudCollectionOptions)}.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CloudCollectionOptions {
    /**
     * Whether to display the clouds.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Desired amount of detail in the noise texture.
     * Default: 16.0
     */
    @JsProperty
    public double noiseDetail;
    /**
     * Desired translation of data in noise texture.
     * Default: Cartesian3.ZERO
     */
    @JsProperty
    public Cartesian3 noiseOffset;
    /**
     * For debugging only. Determines if the billboards are rendered with an opaque color.
     * Default: false
     */
    public boolean debugBillboards;
    /**
     * For debugging only. Determines if the clouds will be rendered as opaque ellipsoids.
     * Default: false
     */
    public boolean debugEllipsoids;

    @JsConstructor
    public CloudCollectionOptions() {}

    /**
     * Creates and adds a cloud with the specified initial properties to the collection. The added cloud is returned so it can be modified or removed from the collection later.
     * Performance:
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten - an O(n) operation that also incurs CPU to GPU overhead. For best performance, add as many clouds as possible before calling update.
     *
     * @return The cloud that was added to the collection.
     */
    @JsMethod
    public native CumulusCloud add();

    /**
     * Creates and adds a cloud with the specified initial properties to the collection. The added cloud is returned so it can be modified or removed from the collection later.
     * Performance:
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten - an O(n) operation that also incurs CPU to GPU overhead. For best performance, add as many clouds as possible before calling update.
     *
     * @param options A template describing the cloud's properties {@link CumulusCloudAddOptions}
     * @return The cloud that was added to the collection.
     */
    @JsMethod
    public native CumulusCloud add(CumulusCloudAddOptions options);
}
