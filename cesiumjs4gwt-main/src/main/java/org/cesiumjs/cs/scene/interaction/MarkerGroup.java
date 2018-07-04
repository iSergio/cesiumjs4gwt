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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.collections.PointPrimitiveCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Billboard;
import org.cesiumjs.cs.scene.PointPrimitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.scene.interaction.options.DrawInteractionOptions;
import org.cesiumjs.cs.scene.options.BillboardOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class MarkerGroup {
    private final Scene scene;
    private final MarkerType type;
    private final DrawInteractionOptions options;

    private PointPrimitiveCollection points;
    private List<PointPrimitive> orderedPoints;

    private BillboardCollection billboards = new BillboardCollection();
    private List<Billboard> orderedBillboards;

    public MarkerGroup(final Scene scene, DrawInteractionOptions options) {
        this.scene = scene;
        this.type = options.markerType;
        this.options = options;

        if (type == MarkerType.POINT_PRIMITIVE) {
            points = new PointPrimitiveCollection();
            scene.primitives().add(points);

            orderedPoints = new ArrayList<>();
        } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
            billboards = BillboardCollection.create(scene);
            scene.primitives().add(billboards);

            orderedBillboards = new ArrayList<>();
        }

        // We need change HeightReference if SceneMode not line SCENE3D
        scene.morphComplete.addEventListener(new Event.Listener() {
            @Override
            public void function(Object... o) {
                if (!Cesium.defined(billboards)) {
                    return;
                }
                for (int i = 0; i < billboards.length(); i++) {
                    billboards.get(i).heightReference = (scene.mode.equals(SceneMode.SCENE3D())) ? HeightReference.CLAMP_TO_GROUND() : HeightReference.NONE();
                }
            }
        });
    }

    public static PointPrimitive createPoint(DrawInteractionOptions options) {
        PointPrimitive pointPrimitive = new PointPrimitive();
        pointPrimitive.color = options.color;
        pointPrimitive.pixelSize = options.pixelSize;
        pointPrimitive.outlineColor = options.outlineColor;
        pointPrimitive.outlineWidth = options.outlineWidth;
        return pointPrimitive;
    }

    public static BillboardOptions createBillboard(DrawInteractionOptions options) {
        Canvas canvas = Canvas.createIfSupported();
        Context2d context = canvas.getContext2d();

        context.setFillStyle(options.color.toCssColorString());
        context.setStrokeStyle(options.outlineColor.toCssColorString());
        context.setLineWidth(options.outlineWidth);

        context.translate(canvas.getCoordinateSpaceWidth() / 2, canvas.getCoordinateSpaceHeight() / 2);
        context.beginPath();
        context.arc(0, 0, options.pixelSize, 0, Math.PI * 2, true);
        context.closePath();
        context.stroke();
        context.fill();

        BillboardOptions billboard = new BillboardOptions();
        billboard.horizontalOrigin = HorizontalOrigin.CENTER();
        billboard.verticalOrigin = VerticalOrigin.CENTER();
        billboard.imageCanvas = canvas.getCanvasElement();
        return billboard;
    }

    public PointPrimitive createPoint(Cartesian3 position) {
        PointPrimitive pointPrimitive = createPoint(options);
        pointPrimitive.position = position;
        return pointPrimitive;
    }

    public Billboard createBillboard(Cartesian3 position) {
        Billboard billboard = billboards.add(createBillboard(options));
        billboard.position = position;
        // We need change HeightReference if SceneMode not line SCENE3D
        billboard.heightReference = (scene.mode.equals(SceneMode.SCENE3D())) ? HeightReference.CLAMP_TO_GROUND() : HeightReference.NONE();
        return billboard;
    }

    public void add(Cartesian3 position) {
        if (type == MarkerType.POINT_PRIMITIVE) {
            orderedPoints.add(createPoint(position));
        } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
            orderedBillboards.add(createBillboard(position));
        }
    }

    public void add(Cartesian3[] positions) {
        for (Cartesian3 position : positions) {
            add(position);
        }
    }

    public PointPrimitive getPoint(int index) {
        return orderedPoints.get(index);
    }

    public Billboard getBillboard(int index) {
        return orderedBillboards.get(index);
    }

    public void insertPoint(int index, Cartesian3 pos) {
        if (type == MarkerType.POINT_PRIMITIVE) {
            orderedPoints.add(index, createPoint(pos));
        } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
            orderedBillboards.add(index, createBillboard(pos));
        }
    }

    public void update(Cartesian3[] positions) {
        for (int i = 0; i < positions.length; i++) {
            if (type == MarkerType.POINT_PRIMITIVE) {
                getPoint(i).position = positions[i];
            } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
                getBillboard(i).position = positions[i];
            }
        }
    }

    public int count() {
        if (type == MarkerType.POINT_PRIMITIVE) {
            return orderedPoints.size();
        } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
            return orderedBillboards.size();
        }
        return 0;
    }

    public void remove(int index) {
        if (type == MarkerType.POINT_PRIMITIVE) {
            points.remove(getPoint(index));
            orderedPoints.remove(index);
        } else if (type == MarkerType.BILLBOARD_GRAPHIC) {
            billboards.remove(getBillboard(index));
            orderedBillboards.remove(index);
        }
    }

    public void remove() {
        if (points != null) {
            points.removeAll();
            points = (PointPrimitiveCollection) JsObject.undefined();
        }
        if (billboards != null) {
            billboards.removeAll();
            billboards = (BillboardCollection) JsObject.undefined();
        }
    }
}
