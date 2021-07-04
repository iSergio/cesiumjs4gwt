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
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.providers.TerrainProvider;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Globe")
public class Globe {
    /**
     * The brightness shift to apply to the atmosphere. Defaults to 0.0 (no shift).
     * A brightness shift of -1.0 is complete darkness, which will let space show
     * through. Default: 0.0
     */
    @JsProperty
    public double atmosphereBrightnessShift;
    /**
     * The hue shift to apply to the atmosphere. Defaults to 0.0 (no shift). A hue
     * shift of 1.0 indicates a complete rotation of the hues available. Default:
     * 0.0
     */
    @JsProperty
    public double atmosphereHueShift;
    /**
     * The saturation shift to apply to the atmosphere. Defaults to 0.0 (no shift).
     * A saturation shift of -1.0 is monochrome. Default: 0.0
     */
    @JsProperty
    public double atmosphereSaturationShift;
    /**
     * Whether to cull back-facing terrain. Set this to false when viewing terrain
     * from below the surface. Default: true
     */
    @JsProperty
    public boolean backFaceCulling;
    /**
     * Gets or sets the color of the globe when no imagery is available.
     */
    @JsProperty
    public Color baseColor;
    /**
     * The {@link ClippingPlaneCollection} used to selectively disable rendering the
     * tileset. Clipping planes are not currently supported in Internet Explorer.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * Use this to limit terrain and imagery to a specific Rectangle area.
     */
    @JsProperty
    public Rectangle cartographicLimitRectangle;
    /**
     * True if primitives such as billboards, polylines, labels, etc. should be
     * depth-tested against the terrain surface, or false if such primitives should
     * always be drawn on top of terrain unless they're on the opposite side of the
     * globe. The disadvantage of depth testing primitives against terrain is that
     * slight numerical noise or terrain level-of-detail switched can sometimes make
     * a primitive that should be on the surface disappear underneath it. Default:
     * false.
     */
    @JsProperty
    public boolean depthTestAgainstTerrain;
    /**
     * Enable dynamic lighting effects on atmosphere and fog. This only takes effect
     * when enableLighting is true. Defaut: true
     */
    @JsProperty
    public boolean dynamicAtmosphereLighting;
    /**
     * Whether dynamic atmosphere lighting uses the sun direction instead of the
     * scene's light direction. This only takes effect when enableLighting and
     * dynamicAtmosphereLighting are true. Default: false
     */
    @JsProperty
    public boolean dynamicAtmosphereLightingFromSun;
    /**
     * Gets an ellipsoid describing the shape of this globe.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * Enable lighting the globe with the sun as a light source. Default: false
     */
    @JsProperty
    public boolean enableLighting;
    /**
     * Gets the collection of imagery layers that will be rendered on this globe.
     */
    @JsProperty
    public ImageryLayerCollection imageryLayers;
    /**
     * The distance where lighting resumes. This only takes effect when
     * enableLighting is true. Default: 9000000.0
     */
    @JsProperty
    public double lightingFadeInDistance;
    /**
     * The distance where everything becomes lit. This only takes effect when
     * enableLighting is true. Default: 6500000.0
     */
    @JsProperty
    public double lightingFadeOutDistance;
    /**
     * Gets or sets the material appearance of the Globe. This can be one of several
     * built-in Material objects or a custom material, scripted with Fabric.
     */
    @JsProperty
    public Material material;
    /**
     * The maximum screen-space error used to drive level-of-detail refinement.
     * Higher values will provide better performance but lower visual quality.
     * Default Value: 2
     */
    @JsProperty
    public double maximumScreenSpaceError;
    /**
     * The distance where the darkness of night from the ground atmosphere fades in
     * to an unlit ground atmosphere. This only takes effect when
     * showGroundAtmosphere and enableLighting are true. Default: 50000000.0
     */
    @JsProperty
    public double nightFadeInDistance;
    /**
     * The distance where the darkness of night from the ground atmosphere fades out
     * to a lit ground atmosphere. This only takes effect when showGroundAtmosphere
     * and enableLighting are true. Default: 10000000.0
     */
    @JsProperty
    public double nightFadeOutDistance;
    /**
     * The normal map to use for rendering waves in the ocean. Setting this property
     * will only have an effect if the configured terrain provider includes a water
     * mask. Default: buildModuleUrl('Assets/Textures/waterNormalsSmall.jpg')
     */
    @JsProperty
    public String oceanNormalMapUrl;
    /**
     * Determines whether the globe casts or receives shadows from each light
     * source. Setting the globe to cast shadows may impact performance since the
     * terrain is rendered again from the light's perspective. Currently only
     * terrain that is in view casts shadows. By default the globe does not cast
     * shadows. Default: ShadowMode.RECEIVE_ONLY
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the globe will be shown. Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Enable the ground atmosphere. Default: true
     */
    @JsProperty
    public boolean showGroundAtmosphere;
    /**
     * Whether to show terrain skirts. Terrain skirts are geometry extending
     * downwards from a tile's edges used to hide seams between neighboring tiles.
     * It may be desirable to hide terrain skirts if terrain is translucent or when
     * viewing terrain from below the surface.
     */
    @JsProperty
    public boolean showSkirts;
    /**
     * True if an animated wave effect should be shown in areas of the globe covered
     * by water; otherwise, false. This property is ignored if the terrainProvider
     * does not provide a water mask. Default: true
     */
    @JsProperty
    public boolean showWaterEffect;
    /**
     * A scalar used to exaggerate the terrain. Defaults to 1.0 (no exaggeration). A value of 2.0 scales the
     * terrain by 2x. A value of 0.0 makes the terrain completely flat. Note that terrain exaggeration will not modify
     * any other primitive as they are positioned relative to the ellipsoid.
     * Default: 1.0
     */
    @JsProperty
    public Number terrainExaggeration;
    /**
     * The height from which terrain is exaggerated. Defaults to 0.0 (scaled relative to ellipsoid surface).
     * Terrain that is above this height will scale upwards and terrain that is below this height will scale downwards.
     * Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
     * If Globe#terrainExaggeration is 1.0 this value will have no effect.
     * Default: 0.0
     */
    @JsProperty
    public Number terrainExaggerationRelativeHeight;
    /**
     * The terrain provider providing surface geometry for this globe.
     */
    @JsProperty
    public TerrainProvider terrainProvider;
    /**
     * The size of the terrain tile cache, expressed as a number of tiles. Any
     * additional tiles beyond this number will be freed, as long as they aren't
     * needed for rendering this frame. A larger number will consume more memory but
     * will show detail faster when, for example, zooming out and then back in.
     * Default: 100
     */
    @JsProperty
    public int tileCacheSize;
    /**
     * Gets an event that's raised when the length of the tile load queue has
     * changed since the last render frame. When the load queue is empty, all
     * terrain and imagery for the current view have been loaded. The event passes
     * the new length of the tile load queue.
     */
    @JsProperty
    public Event tileLoadProgressEvent;

    @JsConstructor
    public Globe() {
    }

    @JsConstructor
    public Globe(Ellipsoid ellipsoid) {
    }

    /**
     * Gets an event that's raised when an imagery layer is added, shown, hidden,
     * moved, or removed.
     */
    @JsProperty(name = "imageryLayersUpdatedEvent")
    public native Event imageryLayersUpdatedEvent();

    /**
     * Gets an event that's raised when the terrain provider is changed
     */
    @JsProperty(name = "terrainProviderChanged")
    public native Event terrainProviderChanged();

    /**
     * Returns true when the tile load queue is empty, false otherwise. When the
     * load queue is empty, all terrain and imagery for the current view have been
     * loaded.
     */
    @JsMethod(name = "tilesLoaded")
    public native boolean tilesLoaded();

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows
     * for deterministic release of WebGL resources, instead of relying on the
     * garbage collector to destroy this object.
     * <p>
     * Once an object is destroyed, it should not be used; calling any function
     * other than isDestroyed will result in a DeveloperError exception. Therefore,
     * assign the return value (undefined) to the object as done in the example.
     *
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Get the height of the surface at a given cartographic.
     *
     * @param cartographic
     * @return The cartographic for which to find the height.
     */
    @JsMethod
    public native double getHeight(Cartographic cartographic);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * <p>
     * If this object was destroyed, it should not be used; calling any function
     * other than isDestroyed will result in a DeveloperError exception.
     *
     * @return True if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Find an intersection between a ray and the globe surface that was rendered.
     * The ray must be given in world coordinates.
     *
     * <pre>
     * {
     *   &#64;code
     *   // find intersection of ray through a pixel and the globe
     *   Ray ray = viewer.camera.getPickRay(windowCoordinates);
     *   Cartesian3 intersection = globe.pick(ray, scene);
     * }
     * </pre>
     *
     * @param ray   The ray to test for intersection.
     * @param scene The scene.
     * @return The intersection or undefined if none was found.
     */
    @JsMethod
    public native Cartesian3 pick(Ray ray, Scene scene);

    /**
     * Find an intersection between a ray and the globe surface that was rendered.
     * The ray must be given in world coordinates.
     *
     * <pre>
     * {
     *   &#64;code
     *   // find intersection of ray through a pixel and the globe
     *   Ray ray = viewer.camera.getPickRay(windowCoordinates);
     *   Cartesian3 intersection = globe.pick(ray, scene);
     * }
     * </pre>
     *
     * @param ray    The ray to test for intersection.
     * @param scene  The scene.
     * @param result The object onto which to store the result.
     * @return The intersection or undefined if none was found.
     */
    @JsMethod
    public native Cartesian3 pick(Ray ray, Scene scene, Cartesian3 result);
}
