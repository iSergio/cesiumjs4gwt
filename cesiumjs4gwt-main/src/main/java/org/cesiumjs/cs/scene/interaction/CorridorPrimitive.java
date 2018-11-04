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

package org.cesiumjs.cs.scene.interaction;

import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.geometry.CorridorGeometry;
import org.cesiumjs.cs.core.geometry.Geometry;
import org.cesiumjs.cs.core.geometry.options.CorridorGeometryOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.apperances.PolylineMaterialAppearance;
import org.cesiumjs.cs.scene.interaction.options.CorridorPrimitiveOptions;

import java.util.Date;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CorridorPrimitive extends AbstractPrimitive {
    private Date lastUpdate = new Date();

    public CorridorPrimitive(final Scene scene, final CorridorPrimitiveOptions options) {
        super(options);
        super.options = options;

        setWidth(options.width);

        ellipsoid = Ellipsoid.WGS84();
        show = true;
        debugShowBoundingVolume = false;
        JsObject.setProperty(this, "asynchronous", true);

        appearance = new PolylineMaterialAppearance();
//        material = Material.fromType(Material.ColorType());
//        JsObject.setProperty(material.uniforms, "color",  options.color);

        getGeometry = new GetGeometry() {
            @Override
            public Geometry function() {
                if (!Cesium.defined(getPositions()) || getPositions().length < 2) {
                    return null;
                }

                CorridorGeometryOptions options = new CorridorGeometryOptions();
                options.positions = getPositions();
                options.width = getWidth() < 1 ? 1 : getWidth();
                options.vertexFormat = PolylineMaterialAppearance.VERTEX_FORMAT();
                options.ellipsoid = ellipsoid;
                return new CorridorGeometry(options);
            }
        };

        // Need for scale CorridorPrimitive and convert pixel width to metres width
        scene.preRender().addEventListener(new Event.Listener() {
            @Override
            public void function(Object... o) {
                if (!Cesium.defined(scene.canvas())) {
                    return;
                }

                if (new Date().getTime() < lastUpdate.getTime() + 250) {
                    return;
                }
                lastUpdate = new Date();

                // May be bug, without this not worked access to canvas().getClientWidth/Height
                scene.canvas().getWidth();
                scene.canvas().getHeight();

                int width = scene.canvas().getClientWidth();
                int height = scene.canvas().getClientHeight();

                Ray left = scene.camera().getPickRay(new Cartesian2((width / 2), height - 1));
                Ray right = scene.camera().getPickRay(new Cartesian2(1 + (width / 2), height - 1));

                Globe globe = scene.globe;
                Cartesian3 leftPosition = globe.pick(left, scene);
                Cartesian3 rightPosition = globe.pick(right, scene);

                if (leftPosition == null || rightPosition == null) {
                    return;
                }

                Cartographic leftCartographic = globe.ellipsoid.cartesianToCartographic(leftPosition);
                Cartographic rightCartographic = globe.ellipsoid.cartesianToCartographic(rightPosition);

                EllipsoidGeodesic geodesic = new EllipsoidGeodesic();
                geodesic.setEndPoints(leftCartographic, rightCartographic);
                double pixelDistance = geodesic.surfaceDistance();
//
                setWidth(pixelDistance * options.width * 2);
            }
        });

        super.initialize();
    }

    public Cartesian3[] getPositions() {
        return (Cartesian3[]) getAttribute("positions");
    }

    public void setPositions(Cartesian3[] positions) {
        setAttribute("positions", positions);
    }

    public double getWidth() {
        return (double) getAttribute("width");
    }

    public void setWidth(double width) {
        setAttribute("width", width);
    }

    public boolean getGeodesic() {
        return (boolean) getAttribute("geodesic");
    }

    public void setGeodesic(boolean geodesic) {
        setAttribute("geodesic", geodesic);
    }
}
