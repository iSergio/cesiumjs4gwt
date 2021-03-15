package org.cesiumjs.cs.core;

import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ElevationBandMaterialBand {
    /**
     * A list of elevation entries. They will automatically be sorted from lowest to highest.
     * If there is only one entry and extendsDownards and extendUpwards are both false, they will both be set to true.
     */
    @JsProperty
    public ElevationBandMaterialEntry[] entries;
    /**
     * If true, the band's minimum elevation color will extend infinitely downwards.
     * Default: false
     */
    @JsProperty
    public boolean extendDownwards;
    /**
     * If true, the band's maximum elevation color will extend infinitely upwards.
     * Default: false
     */
    @JsProperty
    public boolean extendUpwards;

    @JsConstructor
    protected ElevationBandMaterialBand() {
    }

    @JsOverlay
    public static ElevationBandMaterialBand create(ElevationBandMaterialEntry[] entries) {
        ElevationBandMaterialBand band = new ElevationBandMaterialBand();
        band.entries = entries;
        return band;
    }
}
