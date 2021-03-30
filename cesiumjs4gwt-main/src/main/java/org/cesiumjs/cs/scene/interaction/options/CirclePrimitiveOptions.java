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

import org.cesiumjs.cs.core.Cartesian3;

/**
 * @author Serge Silaev aka iSergio
 */
public class CirclePrimitiveOptions extends AbstractPrimitiveOptions {
    /**
     * Center of start drawing
     */
    public Cartesian3 center;
    /**
     * Radius of circle
     */
    public double radius;

    /**
     * Default constructor
     */
    public CirclePrimitiveOptions() {
        super();
    }

    /**
     * Construct {@link CirclePrimitiveOptions} instance from
     * {@link DrawInteractionOptions}
     *
     * @param options {@link DrawInteractionOptions}
     */
    public CirclePrimitiveOptions(DrawInteractionOptions options) {
        super();

        super.color = options.color;
        super.outlineColor = options.outlineColor;
        super.outlineWidth = options.outlineWidth;
    }
}
