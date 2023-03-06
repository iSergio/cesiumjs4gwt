/*
 * Copyright 2023 iSergio, Gis4Fun.
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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.VoxelPrimitive;

/**
 * The view model for VoxelInspector.
 */
@JsType(isNative = true, namespace = "Cesium", name = "VoxelInspectorViewModel")
public class VoxelInspectorViewModel {
    /**
     * Gets the scene
     */
    @JsProperty(name = "scene")
    public native Scene scene();
    /**
     * Gets or sets the primitive of the view model.
     */
    @JsProperty
    public VoxelPrimitive voxelPrimitive;

    @JsConstructor
    public VoxelInspectorViewModel(Scene scene) {}

    /**
     * Compiles the shader in the shader editor.
     */
    @JsMethod
    public native void compileShader();

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * true if the object has been destroyed, false otherwise.
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Handles key press events on the shader editor.
     */
    @JsMethod
    public native void shaderEditorKeyPress();

    /**
     * Toggles the visibility of the bounds section
     */
    @JsMethod
    public native void toggleBounds();

    /**
     * Toggles the visibility of the clipping section
     */
    @JsMethod
    public native void toggleClipping();

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
     * Toggles the visibility of the shader section
     */
    @JsMethod
    public native void toggleShader();

    /**
     * Toggles the visibility of the transform section
     */
    @JsMethod
    public native void toggleTransform();
}
