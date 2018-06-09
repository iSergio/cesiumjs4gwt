package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * A material Property that maps to PolylineArrow {@link org.cesiumjs.cs.scene.Material} uniforms.
 */
@JsType(isNative = true, name = "PolylineArrowMaterialProperty", namespace = "Cesium")
public class PolylineArrowMaterialProperty  extends MaterialProperty {

    /**
     * Gets or sets the {@link org.cesiumjs.cs.core.Color} {@link Property}.
     */
    @JsProperty
    public Property color;


    /**
     * A {@link MaterialProperty} that maps to PolylineArrow {@link org.cesiumjs.cs.scene.Material} uniforms.
     * @param color - The {@link org.cesiumjs.cs.core.Color} Property to be used.  Optional.
     */
    @JsConstructor
    public PolylineArrowMaterialProperty(Property color) {}

}
