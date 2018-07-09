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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PointGraphics;
import org.cesiumjs.cs.datasources.graphics.PolygonGraphics;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PointGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PolygonGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.*;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class DrawingOnTerrain extends AbstractExample {

    private enum SHAPE {
        LINE,
        POLYGON
    }

    private ViewerPanel csVPanel;
    private List<Cartesian3> shapePoints = new ArrayList<>();
    private Entity currentPoint = null;
    private Entity currentShape = null;

    private SHAPE shape = SHAPE.LINE;

    @Inject
    public DrawingOnTerrain(ShowcaseExampleStore store) {
        super("Drawing on Terrain", "Draw lines and polygons on terrain with mouse clicks.", new String[]{"drawing", "event", "callback"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.selectionIndicator = false;
        viewerOptions.infoBox = false;
        viewerOptions.terrainProvider = Cesium.createWorldTerrain();

        csVPanel = new ViewerPanel(viewerOptions);

        csVPanel.getViewer().cesiumWidget.screenSpaceEventHandler.removeInputAction(ScreenSpaceEventType.LEFT_DOUBLE_CLICK());

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(csVPanel.getViewer().canvas());
        handler.setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseClickEvent mouseClickEvent = (MouseClickEvent) event;
                if (mouseClickEvent.position == null) {
                    return;
                }
                Cartesian3 position = csVPanel.getViewer().scene().pickPosition(mouseClickEvent.position);
                if (position == null) {
                    return;
                }
                if (shapePoints.size() == 0) {
                    currentPoint = createPoint(position);
                    shapePoints.add(position);
                    CallbackProperty<Cartesian3[]> callbackProperty = new CallbackProperty<>(new CallbackProperty.Callback<Cartesian3[]>() {
                        @Override
                        public Cartesian3[] function(JulianDate time, Cartesian3[] result) {
                            return shapePoints.toArray(new Cartesian3[0]);
                        }
                    }, false);
                    currentShape = drawShape(callbackProperty);
                }
                shapePoints.add(position);
                createPoint(position);
            }
        }, ScreenSpaceEventType.LEFT_CLICK());
        handler.setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                if (currentPoint == null) {
                    return;
                }
                MouseMoveEvent mouseMoveEvent = (MouseMoveEvent) event;
                if (mouseMoveEvent.endPosition == null) {
                    return;
                }
                Cartesian3 position = csVPanel.getViewer().scene().pickPosition(mouseMoveEvent.endPosition);
                if (position == null) {
                    return;
                }
                ((ConstantPositionProperty) currentPoint.position).setValue(position);
                shapePoints.remove(shapePoints.size() - 1);
                shapePoints.add(position);
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
        handler.setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                terminateShape();
            }
        }, ScreenSpaceEventType.LEFT_DOUBLE_CLICK());

        ListBox shapesLBox = new ListBox();
        shapesLBox.addItem("Lines", "0");
        shapesLBox.addItem("Polygons", "1");
        shapesLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ListBox source = (ListBox) event.getSource();
                if (source.getSelectedValue().equalsIgnoreCase("0")) {
                    shape = SHAPE.LINE;
                } else if (source.getSelectedValue().equalsIgnoreCase("1")) {
                    shape = SHAPE.POLYGON;
                }
                terminateShape();
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Draw</font>");
        flexTable.setWidget(1, 1, shapesLBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Draw lines and polygons on terrain with mouse clicks.</p><p>Left click to add a vertex.</p><p>Double left click to start new shape.</p>"));
        contentPanel.add(aPanel);

        csVPanel.getViewer().camera.lookAt(Cartesian3.fromDegrees(-122.2058, 46.1955, 1000.0), new Cartesian3(5000.0, 5000.0, 5000.0));
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());

        initWidget(contentPanel);
    }

    private Entity createPoint(Cartesian3 position) {
        PointGraphicsOptions pointGraphicsOptions = new PointGraphicsOptions();
        pointGraphicsOptions.color = new ConstantProperty<>(Color.RED());
        pointGraphicsOptions.pixelSize = new ConstantProperty<>(5);
        pointGraphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.point = new PointGraphics(pointGraphicsOptions);

        return csVPanel.getViewer().entities().add(entityOptions);
    }

    private Entity drawShape(CallbackProperty<Cartesian3[]> callbackProperty) {
        EntityOptions entityOptions = new EntityOptions();
        if (shape == SHAPE.LINE) {
            PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
            polylineGraphicsOptions.positions = callbackProperty;
            polylineGraphicsOptions.clampToGround = new ConstantProperty<>(true);
            polylineGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.7f));
            polylineGraphicsOptions.width = new ConstantProperty<>(3);

            entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        } else if (shape == SHAPE.POLYGON) {
            PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
            polygonGraphicsOptions.hierarchy = callbackProperty;
            polygonGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.7f));
            entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        }
        return csVPanel.getViewer().entities().add(entityOptions);
    }

    private Entity drawShape(List<Cartesian3> positions) {
        EntityOptions entityOptions = new EntityOptions();
        if (shape == SHAPE.LINE) {
            PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
            polylineGraphicsOptions.positions = new ConstantProperty<>(positions.toArray(new Cartesian3[0]));
            polylineGraphicsOptions.clampToGround = new ConstantProperty<>(true);
            polylineGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.7f));
            polylineGraphicsOptions.width = new ConstantProperty<>(3);

            entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        } else if (shape == SHAPE.POLYGON) {
            PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
            polygonGraphicsOptions.hierarchy = new ConstantProperty<>(positions.toArray(new Cartesian3[0]));
            polygonGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.7f));
            entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        }
        return csVPanel.getViewer().entities().add(entityOptions);
    }

    private void terminateShape() {
        shapePoints.remove(shapePoints.size() - 1);
        drawShape(shapePoints);
        csVPanel.getViewer().entities().remove(currentPoint);
        csVPanel.getViewer().entities().remove(currentShape);
        currentPoint = null;
        currentShape = null;
        shapePoints.clear();
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "DrawingOnTerrain.txt";
        return sourceCodeURLs;
    }
}
