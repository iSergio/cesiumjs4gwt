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

package org.cesiumjs.cs.scene.interaction;

import jsinterop.annotations.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.ColorGeometryInstanceAttribute;
import org.cesiumjs.cs.core.DeveloperError;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.geometry.Geometry;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.GroundPrimitive;
import org.cesiumjs.cs.scene.interaction.options.AbstractPrimitiveOptions;
import org.cesiumjs.cs.scene.options.GroundPrimitiveOptions;

/**
 * Abstract class used for override Primitive.prototype.update function through @JsFunction
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class AbstractPrimitive extends GroundPrimitive {
    @JsProperty
    public Ellipsoid ellipsoid;
    @JsProperty
    public double granularity;
    @JsProperty
    public AbstractPrimitiveOptions options;

    @JsProperty
    private Ellipsoid _ellipsoid;
    @JsProperty
    private double _granularity;

    @JsProperty
    private GroundPrimitive _primitive;

    /**
     * Flag for we ned create primitive
     */
    @JsProperty
    protected boolean createPrimitive;

    /**
     * Override {@link GroundPrimitive#update(Object)}
     */
    @JsProperty
    protected Update update;
    /**
     * Get geometry function to access pure java functional
     */
    @JsProperty
    protected GetGeometry getGeometry;
    /**
     * Override {@link GroundPrimitive#destroy()}
     */
    @JsProperty
    protected Destroy destroy;

    @JsConstructor
    public AbstractPrimitive(AbstractPrimitiveOptions options) {}

    @JsOverlay
    public final void initialize() {
        createPrimitive = true;

        _ellipsoid = (Ellipsoid) JsObject.undefined();
        _granularity = Double.MAX_VALUE;
        _primitive = (GroundPrimitive) JsObject.undefined();

        update = new Update() {
            @Override
            public void function(Object frameState) {
                if (!Cesium.defined(ellipsoid)) {
                    throw new DeveloperError("ellipsoid is required option and must be defined.");
                }
                if (!Cesium.defined(appearance)) {
                    throw new DeveloperError("appearance is required option and myst be defined");
                }
                if (granularity < 0.0) {
                    throw new DeveloperError("granularity and scene2D/scene3D overrides must be greater than zero.");
                }

                if (!show) {
                    return;
                }

                if (!createPrimitive && !Cesium.defined(_primitive)) {
                    return;
                }

                if (createPrimitive || same()) {
                    Geometry geometry = getGeometry.function();
                    if (geometry == null) {
                        return;
                    }

                    createPrimitive = false;
                    _ellipsoid = ellipsoid;
                    _granularity = granularity;

                    if (Cesium.defined(_primitive)) {
                        _primitive.destroy();
                        _primitive = (GroundPrimitive) JsObject.undefined();
                    }

                    GeometryInstanceOptions instanceOptions = new GeometryInstanceOptions();
                    instanceOptions.geometry = geometry;
                    instanceOptions.attributes = new Object();
                    JsObject.setProperty(instanceOptions.attributes, "color", ColorGeometryInstanceAttribute.fromColor(options.color));
                    GroundPrimitiveOptions primitiveOptions = new GroundPrimitiveOptions();
                    primitiveOptions.geometryInstances = new GeometryInstance[] {new GeometryInstance(instanceOptions)};
                    primitiveOptions.asynchronous = false;
                    _primitive = new GroundPrimitive(primitiveOptions);
                }
                GroundPrimitive primitive = _primitive;
                primitive.debugShowBoundingVolume = debugShowBoundingVolume;
                primitive.update(frameState);
            }
        };

        destroy = new Destroy() {
            @Override
            public void function() {
                if (Cesium.defined(_primitive)) {
                    _primitive.destroy();
                    _primitive = (GroundPrimitive) JsObject.undefined();
                }
                Cesium.destroyObject(this);
            }
        };
    }

    @JsOverlay
    public final void setAttribute(String name, Object value) {
        JsObject.setProperty(this, name, value);
        createPrimitive = true;
    }

    @JsOverlay
    public final Object getAttribute(String name) {
        return JsObject.getObject(this, name);
    }

    @JsOverlay
    public final boolean isDestroyer() {
        return false;
    }

    @JsOverlay
    public final Geometry getGeometry() {
        return getGeometry.function();
    }

    @JsOverlay
    public final boolean same() {
        return ((_ellipsoid != ellipsoid) ||
                (_granularity != granularity));
    }

    @JsFunction
    public interface Update {
        void function(Object frameState);
    }

    @JsFunction
    public interface GetGeometry {
        Geometry function();
    }

    @JsFunction
    public interface Destroy {
        void function();
    }
}
