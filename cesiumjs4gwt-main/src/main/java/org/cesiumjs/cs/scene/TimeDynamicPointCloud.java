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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.options.TimeDynamicPointCloudOptions;

/**
 * Provides playback of time-dynamic point cloud data.
 * Point cloud frames are prefetched in intervals determined by the average frame load time and the current clock speed.
 * If intermediate frames cannot be loaded in time to meet playback speed, they will be skipped. If frames are
 * sufficiently small or the clock is sufficiently slow then no frames will be skipped.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeDynamicPointCloud")
public class TimeDynamicPointCloud {
    /**
     * The bounding sphere of the frame being rendered. Returns undefined if no frame is being rendered.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();
    /**
     * The ClippingPlaneCollection used to selectively disable rendering the point cloud.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * The event fired to indicate that a new frame was rendered.
     * The time dynamic point cloud TimeDynamicPointCloud is passed to the event listener.
     * Default: new Event()
     */
    @JsProperty
    public Event frameChanged;
    /**
     * The event fired to indicate that a frame failed to load. A frame may fail to load if the request for its uri
     * fails or processing fails due to invalid content.
     * If there are no event listeners, error messages will be logged to the console.
     *
     * The error object passed to the listener contains two properties:
     * uri: the uri of the failed frame.
     * message: the error message.
     *
     * Default: new Event()
     */
    @JsProperty
    public Event frameFailed;
    /**
     * The maximum amount of GPU memory (in MB) that may be used to cache point cloud frames.
     * Frames that are not being loaded or rendered are unloaded to enforce this.
     *
     * If decreasing this value results in unloading tiles, the tiles are unloaded the next frame.
     *
     * Default: 256
     */
    @JsProperty
    public int maximumMemoryUsage;
    /**
     * A 4x4 transformation matrix that transforms the point cloud.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Gets the promise that will be resolved when the point cloud renders a frame for the first time.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<TimeDynamicPointCloud, Void> readyPromise();
    /**
     * Options for controlling point size based on geometric error and eye dome lighting.
     */
    @JsProperty
    public PointCloudShading shading;
    /**
     * Determines whether the point cloud casts or receives shadows from each light source.
     * Enabling shadows has a performance impact. A point cloud that casts shadows must be rendered twice,
     * once from the camera and again from the light's point of view.
     *
     * Shadows are rendered only when Viewer#shadows is true.
     *
     * Default: {@link ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the point cloud will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The style, defined using the 3D Tiles Styling language, applied to each point in the point cloud.
     * Assign undefined to remove the style, which will restore the visual appearance of the point cloud to
     * its default when no style was applied.
     */
    @JsProperty
    public Cesium3DTileStyle style;
    /**
     * The total amount of GPU memory in bytes used by the point cloud.
     */
    @JsProperty(name = "totalMemoryUsageInBytes")
    public native int totalMemoryUsageInBytes();

    @JsConstructor
    public TimeDynamicPointCloud(TimeDynamicPointCloudOptions options) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of
     * WebGL resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Marks the point cloud's TimeDynamicPointCloud#style as dirty, which forces all points to re-evaluate the style in the next frame.
     */
    @JsMethod
    public native void makeStyleDirty();
}
