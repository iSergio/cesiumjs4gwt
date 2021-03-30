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

package org.cesiumjs.cs.scene.interaction.options;

import org.cesiumjs.cs.collections.PrimitiveCollection;
import org.cesiumjs.cs.scene.interaction.MarkerType;
import org.cesiumjs.cs.scene.interaction.PrimitiveType;

/**
 * @author Serge Silaev aka iSergio
 */
public class DrawInteractionOptions extends AbstractPrimitiveOptions {
    public PrimitiveCollection collection;
    /**
     * Primitive type for drawing
     */
    public PrimitiveType type = PrimitiveType.RECTANGLE;
    /**
     * Marker type. May be {@link org.cesiumjs.cs.scene.PointPrimitive} or
     * {@link org.cesiumjs.cs.scene.Billboard}.
     */
    public MarkerType markerType = MarkerType.POINT_PRIMITIVE;
    /**
     * Marker primitive size. {@link org.cesiumjs.cs.scene.interaction.MarkerGroup}
     */
    public int pixelSize = 5;

    /**
     * Constructor of options
     */
    public DrawInteractionOptions() {
        super();
    }
}
