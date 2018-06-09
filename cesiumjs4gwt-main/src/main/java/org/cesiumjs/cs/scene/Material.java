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
import org.cesiumjs.cs.scene.options.MaterialOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Material")
public class Material {
    /**
     * Gets the name of the alpha map material.
     */
    @JsProperty(name = "AlphaMapType")
    public static native String AlphaMapType();
    /**
     * Gets the name of the bump map material.
     */
    @JsProperty(name = "BumpMapType")
    public static native String BumpMapType();
    /**
     * Gets the name of the checkerboard material.
     */
    @JsProperty(name = "CheckerboardType")
    public static native String CheckerboardType();
    /**
     * Gets the name of the color material.
     */
    @JsProperty(name = "ColorType")
    public static native String ColorType();
    /**
     * Gets or sets the default cube map texture uniform value.
     */
    @JsProperty(name = "DefaultCubeMapId")
    public static native String DefaultCubeMapId();
    /**
     * Gets or sets the default texture uniform value.
     */
    @JsProperty(name = "DefaultImageId")
    public static native String DefaultImageId();
    /**
     * Gets the name of the diffuce map material.
     */
    @JsProperty(name = "DiffuseMapType")
    public static native String DiffuseMapType();
    /**
     * Gets the name of the dot material.
     */
    @JsProperty(name = "DotType")
    public static native String DotType();
    /**
     * Gets the name of the emmision map material.
     */
    @JsProperty(name = "EmissionMapType")
    public static native String EmissionMapType();
    /**
     * Gets the name of the fade material.
     */
    @JsProperty(name = "FadeType")
    public static native String FadeType();
    /**
     * Gets the name of the grid material.
     */
    @JsProperty(name = "GridType")
    public static native String GridType();
    /**
     * Gets the name of the imagery material.
     */
    @JsProperty(name = "ImageType")
    public static native String ImageType();
    /**
     * Gets the name of the normal map material.
     */
    @JsProperty(name = "NormalMapType")
    public static native String NormalMapType();
    /**
     * Gets the name of the polyline arrow material.
     */
    @JsProperty(name = "PolylineArrowType")
    public static native String PolylineArrowType();
    /**
     * Gets the name of the polyline dash material.
     */
    @JsProperty(name = "PolylineDashType")
    public static native String PolylineDashType();
    /**
     * Gets the name of the polyline glow material.
     */
    @JsProperty(name = "PolylineGlowType")
    public static native String PolylineGlowType();
    /**
     * Gets the name of the polyline outline material.
     */
    @JsProperty(name = "PolylineOutlineType")
    public static native String PolylineOutlineType();
    /**
     * Gets the name of the rim lighting material.
     */
    @JsProperty(name = "RimLightingType")
    public static native String RimLightingType();
    /**
     * Gets the name of the specular map material.
     */
    @JsProperty(name = "SpecularMapType")
    public static native String SpecularMapType();
    /**
     * Gets the name of the stripe material.
     */
    @JsProperty(name = "StripeType")
    public static native String StripeType();
    /**
     * Gets the name of the water material.
     */
    @JsProperty(name = "WaterType")
    public static native String WaterType();
    /**
     * Maps sub-material names to Material objects.
     */
    @JsProperty
    public Object materials;
    /**
     * The glsl shader source for this material.
     */
    @JsProperty
    public String shaderSource;
    /**
     * When true or a function that returns true, the geometry is expected to appear translucent.
     */
    @JsProperty
    public boolean translucent;
    /**
     * The material type. Can be an existing type or a new type. If no type is specified in fabric, type is a GUID.
     */
    @JsProperty
    public String type;
    /**
     * Maps uniform names to their values.
     */
    @JsProperty
    public Object uniforms;
    
    /**
     * A Material defines surface appearance through a combination of diffuse, specular, normal, emission, and alpha components.
     * These values are specified using a JSON schema called Fabric which gets parsed and assembled into
     * glsl shader code behind-the-scenes. Check out the wiki page for more details on Fabric.
     */
    @JsConstructor
    public Material() {}

    /**
     * A Material defines surface appearance through a combination of diffuse, specular, normal, emission, and alpha components.
     * These values are specified using a JSON schema called Fabric which gets parsed and assembled into
     * glsl shader code behind-the-scenes. Check out the wiki page for more details on Fabric.
     * @param options Options
     */
    @JsConstructor
    public Material(MaterialOptions options) {}

    /**
     * Creates a new material using an existing material type.
     * @param type The base material type.
     * @return New material object.
     */
    //TODO: Examples
    @JsMethod
    public static native Material fromType(String type);

    /**
     * Creates a new material using an existing material type.
     * @param type The base material type.
     * @param uniforms Overrides for the default uniforms.
     * @return New material object.
     */
    //TODO: Examples
    @JsMethod
    public static native Material fromType(String type, Object uniforms);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed
     * will result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return True if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Gets whether or not this material is translucent.
     * @return true if this material is translucent, false otherwise.
     */
    @JsMethod
    public native boolean isTranslucent();
}
