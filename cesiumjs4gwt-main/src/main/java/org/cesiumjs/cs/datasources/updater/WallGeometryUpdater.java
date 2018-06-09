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

package org.cesiumjs.cs.datasources.updater;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.Scene;

/**
 * A {@link GeometryUpdater} for walls. Clients do not normally create this class directly,
 * but instead rely on {@link org.cesiumjs.cs.datasources.DataSourceDisplay}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "WallGeometryUpdater")
public class WallGeometryUpdater extends GeometryUpdater {
    /**
     * Gets the property specifying whether the geometry casts or receives shadows from each light source.
     */
    @JsProperty(name = "shadowsProperty")
    public native Property shadowsProperty();

    /**
     * A {@link GeometryUpdater} for walls. Clients do not normally create this class directly,
     * but instead rely on {@link org.cesiumjs.cs.datasources.DataSourceDisplay}.
     * @param entity The entity containing the geometry to be visualized.
     * @param scene The scene where visualization is taking place.
     */
    @JsConstructor
    public WallGeometryUpdater(Entity entity, Scene scene) {
        super(entity, scene);
    }
}
