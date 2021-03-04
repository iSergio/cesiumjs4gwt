package org.cesiumjs.cs.core;

import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ElevationBandMaterialEntry {
    /**
     * The height.
     */
    @JsProperty
    public Number height;
    /**
     * The color at this height.
     */
    @JsProperty
    public Color color;

    @JsConstructor
    private ElevationBandMaterialEntry() {}

    @JsOverlay
    public static ElevationBandMaterialEntry create(Number height, Color color) {
        ElevationBandMaterialEntry entry = new ElevationBandMaterialEntry();
        entry.height = height;
        entry.color = color;
        return entry;
    }
}
