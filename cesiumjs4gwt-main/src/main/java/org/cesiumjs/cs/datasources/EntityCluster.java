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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.options.EntityClusterOptions;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "EntityCluster")
public class EntityCluster {
    /**
     * Gets the event that will be raised when a new cluster will be displayed. The
     * signature of the event listener is EntityCluster~newClusterCallback.
     */
    @JsProperty
    public Event clusterEvent;
    /**
     * Gets or sets whether clustering is enabled.
     */
    @JsProperty
    public boolean enabled;
    /**
     * Gets or sets the minimum number of screen space objects that can be
     * clustered.
     */
    @JsProperty
    public int minimumClusterSize;
    /**
     * Gets or sets the pixel range to extend the screen space bounding box.
     */
    @JsProperty
    public int pixelRange;
    /**
     * Whether or not to cluster the billboards of an entity.
     * Default: true
     */
    @JsProperty
    public boolean clusterBillboards;
    /**
     * Whether or not to cluster the labels of an entity.
     * Default: true
     */
    @JsProperty
    public boolean clusterLabels;
    /**
     * Whether or not to cluster the points of an entity.
     * Default: true
     */
    @JsProperty
    public boolean clusterPoints;
    /**
     * Determines if the entities in the cluster will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    /**
     * Defines how screen space objects (billboards, points, labels) are clustered.
     */
    @JsConstructor
    public EntityCluster() {
    }

    /**
     * Defines how screen space objects (billboards, points, labels) are clustered.
     *
     * @param options {@link EntityClusterOptions}.
     */
    @JsConstructor
    public EntityCluster(EntityClusterOptions options) {
    }

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows
     * for deterministic release of WebGL resources, instead of relying on the
     * garbage collector to destroy this object.
     * <p>
     * Unlike other objects that use WebGL resources, this object can be reused. For
     * example, if a data source is removed from a data source collection and added
     * to another.
     */
    @JsMethod
    public native void destroy();

    // TODO: Example
    @JsFunction
    public interface newClusterCallback {
        /**
         * A event listener function used to style clusters.
         *
         * @param clusteredEntities An array of the entities contained in the cluster.
         * @param cluster           An object containing billboard, label, and point
         *                          properties. The values are the same as billboard,
         *                          label and point entities, but must be the values of
         *                          the ConstantProperty.
         */
        void function(Entity[] clusteredEntities, EntityClusterObject cluster);
    }
}
