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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.options.BillboardOptions;
import org.cesiumjs.cs.scene.options.LabelOptions;
import org.cesiumjs.cs.scene.options.PointPrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EntityClusterObject {
    /**
     * Billboard options
     */
    @JsProperty(name = "billboard")
    public BillboardOptions billboard;
    /**
     * Label options
     */
    @JsProperty(name = "label")
    public LabelOptions label;
    /**
     * Point options
     */
    @JsProperty(name = "point")
    public PointPrimitiveOptions point;
}
