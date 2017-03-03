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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.enums.CameraEventType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ScreenSpaceCameraController")
public class ScreenSpaceCameraController {
    /**
     * Sets the duration, in seconds, of the bounce back animations in 2D and Columbus view.
     * Default: 3.0
     */
    @JsProperty
    public Number bounceAnimationTime;
    /**
     * Enables or disables camera collision detection with terrain.
     * Default: true
     */
    @JsProperty
    public Boolean enableCollisionDetection;
    /**
     * If true, inputs are allowed conditionally with the flags enableTranslate, enableZoom, enableRotate, enableTilt, and enableLook.
     * If false, all inputs are disabled. NOTE: This setting is for temporary use cases, such as camera flights and drag-selection
     * of regions (see Picking demo). It is typically set to false at the start of such events, and set true on completion.
     * To keep inputs disabled past the end of camera flights, you must use the other booleans (enableTranslate, enableZoom,
     * enableRotate, enableTilt, and enableLook).
     * Default: true
     */
    @JsProperty
    public Boolean enableInputs;
    /**
     * If true, allows the user to use free-look. If false, the camera view direction can only be changed through translating or rotating.
     * This flag only applies in 3D and Columbus view modes.
     * Default: true
     */
    @JsProperty
    public Boolean enableLook;
    /**
     * If true, allows the user to rotate the camera. If false, the camera is locked to the current heading.
     * This flag only applies in 2D and 3D.
     * Default: true
     */
    @JsProperty
    public Boolean enableRotate;
    /**
     * If true, allows the user to tilt the camera. If false, the camera is locked to the current heading.
     * This flag only applies in 3D and Columbus view.
     * Default: true
     */
    @JsProperty
    public Boolean enableTilt;
    /**
     * If true, allows the user to pan around the map. If false, the camera stays locked at the current position.
     * This flag only applies in 2D and Columbus view modes.
     * Default: true
     */
    @JsProperty
    public Boolean enableTranslate;
    /**
     * If true, allows the user to zoom in and out. If false, the camera is locked to the current distance from the ellipsoid.
     * Default: true
     */
    @JsProperty
    public Boolean enableZoom;
    /**
     * A parameter in the range [0, 1) used to determine how long the camera will continue to spin because of inertia.
     * With value of zero, the camera will have no inertia.
     * Default: 0.9
     */
    @JsProperty
    public Number inertiaSpin;
    /**
     * A parameter in the range [0, 1) used to determine how long the camera will continue to translate because of inertia.
     * With value of zero, the camera will have no inertia.
     * Default: 0.9
     */
    @JsProperty
    public Number inertiaTranslate;
    /**
     * A parameter in the range [0, 1) used to determine how long the camera will continue to zoom because of inertia.
     * With value of zero, the camera will have no inertia.
     Default: 0.8
     */
    @JsProperty
    public Number inertiaZoom;
    /**
     * The input that allows the user to change the direction the camera is viewing. This only applies in 3D and Columbus view modes.
     * The type came be a CameraEventType, undefined, an object with eventType and modifier properties with types
     * CameraEventType and KeyboardEventModifier, or an array of any of the preceding.
     *
     * Default: { eventType : CameraEventType.LEFT_DRAG, modifier : KeyboardEventModifier.SHIFT }
     */
    @JsProperty
    public CameraEventType[] lookEventTypes;
    /**
     * A parameter in the range [0, 1) used to limit the range of various user inputs to a percentage of the window
     * width/height per animation frame. This helps keep the camera under control in low-frame-rate situations.
     * Default: 0.1
     */
    @JsProperty
    public Number maximumMovementRatio;
    /**
     * The maximum magnitude, in meters, of the camera position when zooming. Defaults to positive infinity.
     * Default: Number.POSITIVE_INFINITY
     */
    @JsProperty
    public Number maximumZoomDistance;
    /**
     * The minimum height the camera must be before testing for collision with terrain.
     * Default: 10000.0
     */
    @JsProperty
    public Number minimumCollisionTerrainHeight;
    /**
     * The minimum height the camera must be before picking the terrain instead of the ellipsoid.
     * Default: 150000.0
     */
    @JsProperty
    public Number minimumPickingTerrainHeight;
    /**
     * The minimum height the camera must be before switching from rotating a track ball to free look when clicks
     * originate on the sky on in space.
     * Default: 7500000.0
     */
    @JsProperty
    public Number minimumTrackBallHeight;
    /**
     * The minimum magnitude, in meters, of the camera position when zooming. Defaults to 20.0.
     * Default: 20.0
     */
    @JsProperty
    public Number minimumZoomDistance;
    /**
     * The input that allows the user to rotate around the globe or another object. This only applies in 3D and Columbus view modes.
     * The type came be a CameraEventType, undefined, an object with eventType and modifier properties with types
     * CameraEventType and KeyboardEventModifier, or an array of any of the preceding.
     *
     * Default: {@link CameraEventType#LEFT_DRAG}
     */
    @JsProperty
    public CameraEventType[] rotateEventTypes;
    /**
     * The input that allows the user to tilt in 3D and Columbus view or twist in 2D.
     * The type came be a CameraEventType, undefined, an object with eventType and modifier properties with types
     * CameraEventType and KeyboardEventModifier, or an array of any of the preceding.
     *
     * Default: [CameraEventType.MIDDLE_DRAG, CameraEventType.PINCH, {
     * eventType : CameraEventType.LEFT_DRAG,
     * modifier : KeyboardEventModifier.CTRL
     * }, {
     * eventType : CameraEventType.RIGHT_DRAG,
     * modifier : KeyboardEventModifier.CTRL
     * }]
     */
    @JsProperty
    public CameraEventType[] tiltEventTypes;
    /**
     * The input that allows the user to pan around the map. This only applies in 2D and Columbus view modes.
     * The type came be a CameraEventType, undefined, an object with eventType and modifier properties with types
     * CameraEventType and KeyboardEventModifier, or an array of any of the preceding.
     *
     * Default: CameraEventType.LEFT_DRAG
     */
    @JsProperty
    public CameraEventType[] translateEventTypes;
    /**
     * The input that allows the user to zoom in/out.
     * The type came be a CameraEventType, undefined, an object with eventType and modifier properties with types
     * CameraEventType and KeyboardEventModifier, or an array of any of the preceding.
     *
     * Default: [CameraEventType.RIGHT_DRAG, CameraEventType.WHEEL, CameraEventType.PINCH]
     */
    @JsProperty
    public CameraEventType[] zoomEventTypes;

    /**
     * Modifies the camera position and orientation based on mouse input to a canvas.
     * @param scene The scene.
     */
    @JsConstructor
    public ScreenSpaceCameraController(Scene scene) {}

    /**
     * Removes mouse listeners held by this object.
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see ScreenSpaceCameraController#isDestroyed
     */
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see ScreenSpaceCameraController#destroy
     */
    public native Boolean isDestroyed();
}
