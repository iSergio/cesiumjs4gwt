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

import org.cesiumjs.cs.core.Color;

/**
 * Abstract options for Primitives.
 *
 * @author Serge Silaev aka iSergio
 */
public abstract class AbstractPrimitiveOptions {
    /**
     * {@link org.cesiumjs.cs.scene.interaction.AbstractPrimitive} and
     * {@link org.cesiumjs.cs.scene.interaction.MarkerGroup} fill color.
     */
    public Color color = Color.YELLOW().withAlpha(0.5f);
    /**
     * {@link org.cesiumjs.cs.scene.interaction.MarkerGroup} outline color.
     */
    public Color outlineColor = Color.YELLOW();
    /**
     * {@link org.cesiumjs.cs.scene.interaction.MarkerGroup} outline width.
     */
    public int outlineWidth = 1;
    /**
     * Minimum points of primitive
     */
    public int minPoints = 3;
    /**
     * Maximum points of primitive.
     */
    public int maxPoints = Integer.MAX_VALUE;

    public AbstractPrimitiveOptions() {
        //
    }
}
