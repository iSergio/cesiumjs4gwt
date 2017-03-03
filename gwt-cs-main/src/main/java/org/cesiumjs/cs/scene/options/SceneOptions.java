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

package org.cesiumjs.cs.scene.options;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.scene.enums.MapMode2D;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SceneOptions {
    /**
     * The HTML canvas element to create the scene for.
     */
    public CanvasElement canvas;
    /**
     * Context and WebGL creation properties. See details above.
     */
    // TODO: make later simple class
    public Object contextOptions;
    /**
     * The HTML element in which the credits will be displayed.
     */
    public Element creditContainer;
    /**
     * The map projection to use in 2D and Columbus View modes.
     * Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     */
    public MapProjection mapProjection;
    /**
     * If true and the configuration supports it, use order independent translucency.
     * Default: true
     */
    public boolean orderIndependentTranslucency;
    /**
     * If true, optimizes memory use and performance for 3D mode but disables the ability to use 2D or Columbus View.
     * Default: false
     */
    public boolean scene3DOnly;
    /**
     * A scalar used to exaggerate the terrain. Note that terrain exaggeration will not modify any other primitive as they are positioned relative to the ellipsoid.
     * Default: 1.0
     */
    public double terrainExaggeration;
    /**
     * Determines if shadows are cast by the sun.
     * Default: false
     */
    public boolean shadows;
    /**
     * Determines if the 2D map is rotatable or can be scrolled infinitely in the horizontal direction.
     * Default: {@link MapMode2D#INFINITE_SCROLL()}
     */
    public int mapMode2D;
}
