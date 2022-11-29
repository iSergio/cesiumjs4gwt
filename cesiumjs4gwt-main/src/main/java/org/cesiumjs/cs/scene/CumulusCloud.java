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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.CloudCollection;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;

/**
 * A cumulus cloud billboard positioned in the 3D scene, that is created and rendered using a CloudCollection.
 * A cloud is created and its initial properties are set by calling {@link CloudCollection#add} and {@link CloudCollection#remove}.
 *
 * Performance:
 * Similar to Billboard, reading a property, e.g., {@link CumulusCloud#show}, takes constant time. Assigning to a property is
 * constant time but results in CPU to GPU traffic when {@link CloudCollection#update} is called. The per-cloud traffic is
 * the same regardless of how many properties were updated. If most clouds in a collection need to be updated,
 * it may be more efficient to clear the collection with {@link CloudCollection#removeAll} and add new clouds instead
 * of modifying each one.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CumulusCloud")
public class CumulusCloud {
    /**
     * Gets or sets the brightness of the cloud. This can be used to give clouds a darker, grayer appearance.
     * Default: 1.0
     */
    @JsProperty
    public float brightness;
    /**
     * Sets the color of the cloud.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Color color;
    /**
     * Gets or sets the maximum size of the cumulus cloud rendered on the billboard. This defines a maximum ellipsoid
     * volume that the cloud can appear in. Rather than guaranteeing a specific size, this specifies a boundary for
     * the cloud to appear in, and changing it can affect the shape of the cloud.
     *
     * Changing the z-value of maximumSize has the most dramatic effect on the cloud's appearance because it changes
     * the depth of the cloud, and thus the positions at which the cloud-shaping texture is sampled.
     *
     * To modify the billboard's actual size, modify the cloud's scale property.
     *
     * @see CumulusCloud#scale
     */
    @JsProperty
    public Cartesian3 maximumSize;
    /**
     * Gets or sets the Cartesian position of this cumulus cloud.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets or sets the scale of the cumulus cloud billboard in meters. The scale property will affect the size of the billboard, but not the cloud's actual appearance.
     *
     * To modify the cloud's appearance, modify its maximumSize and slice properties.
     *
     * @see CumulusCloud#maximumSize
     * @see CumulusCloud#slice
     */
    @JsProperty
    public Cartesian2 scale;
    /**
     * Determines if this cumulus cloud will be shown. Use this to hide or show a cloud, instead of removing it
     * and re-adding it to the collection.
     * Default: true
     */
    @JsProperty
    public boolean show;

    /**
     * Gets or sets the "slice" of the cloud that is rendered on the billboard, i.e. the specific cross-section of the
     * cloud chosen for the billboard's appearance. Given a value between 0 and 1, the slice specifies how deeply
     * into the cloud to intersect based on its maximum size in the z-direction.
     *
     * Default: -1.0
     */
    @JsProperty
    public float slice;
}
