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

package org.cleanlogic.showcase.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.PointPrimitiveCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.ColorGeometryInstanceAttribute;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.datasources.graphics.RectangleGraphics;
import org.cesiumjs.cs.datasources.graphics.options.RectangleGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.GroundPrimitive;
import org.cesiumjs.cs.scene.PointPrimitive;
import org.cesiumjs.cs.scene.interaction.*;
import org.cesiumjs.cs.scene.interaction.options.DrawInteractionOptions;
import org.cesiumjs.cs.scene.options.GroundPrimitiveOptions;
import org.cesiumjs.cs.scene.options.PointPrimitiveOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Drawing extends AbstractExample {

    private ViewerPanel csVPanel;

    private DrawInteraction drawInteraction;

    private ToggleButton drawPointTBtn;
    private ToggleButton drawLineTBtn;
    private ToggleButton drawExtentTBtn;
    private ToggleButton drawPolygonTBtn;
    private ToggleButton drawCircleTBtn;

    @Inject
    public Drawing(ShowcaseExampleStore store) {
        super("Drawing", "Example to usage drawing interactions", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Drawing"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

        Image image = new Image(GWT.getModuleBaseURL() + "images/point.png");
        image.setPixelSize(22, 22);
        drawPointTBtn = new ToggleButton(image);
        drawPointTBtn.setPixelSize(22, 22);
        drawPointTBtn.getElement().getStyle().setBackgroundImage("none");
        drawPointTBtn.getElement().getStyle().setBorderColor("rgba(63,66,70,1)");
        drawPointTBtn.getElement().getStyle().setBackgroundColor("rgba(63,66,70,0.7)");
        drawPointTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                drawExtentTBtn.setValue(false, false);
                drawPolygonTBtn.setValue(false, false);
                drawCircleTBtn.setValue(false, false);
                if (drawInteraction != null) {
                    drawInteraction.destroy();
                    drawInteraction = null;
                }
                if (event.getValue()) {
                    DrawInteractionOptions options = new DrawInteractionOptions();
                    options.type = PrimitiveType.POINT;
                    options.markerType = MarkerType.BILLBOARD_GRAPHIC;
                    drawInteraction = new DrawInteraction(csVPanel.getViewer().scene(), options);
                    drawInteraction.addDrawListener(new DrawInteractionListener(), DrawInteraction.EventType.DRAW_END);
                }
            }
        });

        image = new Image(GWT.getModuleBaseURL() + "images/line.png");
        image.setPixelSize(22, 22);
        drawLineTBtn = new ToggleButton(image);
        drawLineTBtn.setPixelSize(22, 22);
        drawLineTBtn.getElement().getStyle().setBackgroundImage("none");
        drawLineTBtn.getElement().getStyle().setBorderColor("rgba(63,66,70,1)");
        drawLineTBtn.getElement().getStyle().setBackgroundColor("rgba(63,66,70,0.7)");
        drawLineTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                drawExtentTBtn.setValue(false, false);
                drawPolygonTBtn.setValue(false, false);
                drawCircleTBtn.setValue(false, false);
                if (drawInteraction != null) {
                    drawInteraction.destroy();
                    drawInteraction = null;
                }
                if (event.getValue()) {
                    DrawInteractionOptions options = new DrawInteractionOptions();
                    options.type = PrimitiveType.CORRIDOR;
                    options.markerType = MarkerType.BILLBOARD_GRAPHIC;
                    drawInteraction = new DrawInteraction(csVPanel.getViewer().scene(), options);
                    drawInteraction.addDrawListener(new DrawInteractionListener(), DrawInteraction.EventType.DRAW_END);
                }
            }
        });

        image = new Image(GWT.getModuleBaseURL() + "images/rect.png");
        image.setPixelSize(22, 22);
        drawExtentTBtn = new ToggleButton(image);
        drawExtentTBtn.setPixelSize(22, 22);
        drawExtentTBtn.getElement().getStyle().setBackgroundImage("none");
        drawExtentTBtn.getElement().getStyle().setBorderColor("rgba(63,66,70,1)");
        drawExtentTBtn.getElement().getStyle().setBackgroundColor("rgba(63,66,70,0.7)");
        drawExtentTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                drawLineTBtn.setValue(false, false);
                drawPolygonTBtn.setValue(false, false);
                drawCircleTBtn.setValue(false, false);
                if (drawInteraction != null) {
                    drawInteraction.destroy();
                    drawInteraction = null;
                }
                if (event.getValue()) {
                    DrawInteractionOptions options = new DrawInteractionOptions();
                    options.markerType = MarkerType.BILLBOARD_GRAPHIC;
                    options.outlineColor = Color.RED();
                    options.outlineWidth = 1;
                    drawInteraction = new DrawInteraction(csVPanel.getViewer().scene(), options);
                    drawInteraction.addDrawListener(new DrawInteractionListener(), DrawInteraction.EventType.DRAW_END);
                    // As Entity
//                    drawInteraction.addDrawListener(new DrawInteraction.Listener() {
//                        @Override
//                        public void onDraw(DrawInteraction.Event event) {
//                            if (!(event.getPrimitive() instanceof RectanglePrimitive)) {
//                                return;
//                            }
//                            RectanglePrimitive primitive = ((RectanglePrimitive) event.getPrimitive());
//                            Rectangle rectangle = primitive.getRectangle();
//
//                            RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
//                            rectangleGraphicsOptions.coordinates = new ConstantProperty<>(rectangle);
//                            rectangleGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.5f));
//
//                            EntityOptions entityOptions = new EntityOptions();
//                            entityOptions.rectangle = new RectangleGraphics(rectangleGraphicsOptions);
//
//                            csVPanel.getViewer().entities().add(entityOptions);
//                        }
//                    }, DrawInteraction.EventType.DRAW_END);
                }
            }
        });

        image = new Image(GWT.getModuleBaseURL() + "images/polygon.png");
        image.setPixelSize(22, 22);
        drawPolygonTBtn = new ToggleButton(image);
        drawPolygonTBtn.setPixelSize(22, 22);
        drawPolygonTBtn.getElement().getStyle().setBackgroundImage("none");
        drawPolygonTBtn.getElement().getStyle().setBorderColor("rgba(63,66,70,1)");
        drawPolygonTBtn.getElement().getStyle().setBackgroundColor("rgba(63,66,70,0.7)");
        drawPolygonTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                drawLineTBtn.setValue(false, false);
                drawExtentTBtn.setValue(false, false);
                drawCircleTBtn.setValue(false, false);
                if (drawInteraction != null) {
                    drawInteraction.destroy();
                    drawInteraction = null;
                }
                if (event.getValue()) {
                    DrawInteractionOptions options = new DrawInteractionOptions();
                    options.type = PrimitiveType.POLYGON;
                    options.markerType = MarkerType.BILLBOARD_GRAPHIC;
                    options.color = Color.BLUE().withAlpha(0.5f);
                    drawInteraction = new DrawInteraction(csVPanel.getViewer().scene(), options);
                    // As GroundPrimitive
                    drawInteraction.addDrawListener(new DrawInteractionListener(), DrawInteraction.EventType.DRAW_END);
                }
            }
        });

        image = new Image(GWT.getModuleBaseURL() + "images/circle.png");
        image.setPixelSize(22, 22);
        drawCircleTBtn = new ToggleButton(image);
        drawCircleTBtn.setPixelSize(22, 22);
        drawCircleTBtn.getElement().getStyle().setBackgroundImage("none");
        drawCircleTBtn.getElement().getStyle().setBorderColor("rgba(63,66,70,1)");
        drawCircleTBtn.getElement().getStyle().setBackgroundColor("rgba(63,66,70,0.7)");
        drawCircleTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                drawLineTBtn.setValue(false, false);
                drawExtentTBtn.setValue(false, false);
                drawPolygonTBtn.setValue(false, false);
                if (drawInteraction != null) {
                    drawInteraction.destroy();
                    drawInteraction = null;
                }
                if (event.getValue()) {
                    DrawInteractionOptions options = new DrawInteractionOptions();
                    options.type = PrimitiveType.CIRCLE;
                    options.markerType = MarkerType.BILLBOARD_GRAPHIC;
                    drawInteraction = new DrawInteraction(csVPanel.getViewer().scene(), options);
                    // As GroundPrimitive
                    drawInteraction.addDrawListener(new DrawInteractionListener(), DrawInteraction.EventType.DRAW_END);
                }
            }
        });

        final FlexTable flexTable = new FlexTable();
        flexTable.setWidget(1, 0, drawPointTBtn);
        flexTable.setWidget(2, 0, drawLineTBtn);
        flexTable.setWidget(3, 0, drawExtentTBtn);
        flexTable.setWidget(4, 0, drawPolygonTBtn);
        flexTable.setWidget(5, 0, drawCircleTBtn);

        final AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable,RootPanel.get().getOffsetWidth() - 74, 42);

        contentPanel.add(new HTML("<p>Use Viewer to start building new applications or easily embed Cesium into existing applications.</p>"));
        contentPanel.add(aPanel);

        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent resizeEvent) {
                aPanel.setWidgetPosition(flexTable, RootPanel.get().getOffsetWidth() - 74, 42);
            }
        });

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Drawing.txt";
        return sourceCodeURLs;
    }

    private class DrawInteractionListener implements DrawInteraction.Listener {
        @Override
        public void onDraw(DrawInteraction.Event event) {
            Cartesian3[] positions = null;
            if (event.getPrimitive() instanceof PolygonPrimitive) {
                positions = ((PolygonPrimitive) event.getPrimitive()).getPositions();
            } else if (event.getPrimitive() instanceof RectanglePrimitive) {
                positions = ((RectanglePrimitive) event.getPrimitive()).getPositions();
            } else if (event.getPrimitive() instanceof CorridorPrimitive) {
                positions = ((CorridorPrimitive) event.getPrimitive()).getPositions();
            } else if (event.getPrimitive() instanceof CirclePrimitive) {
                positions = ((CirclePrimitive) event.getPrimitive()).getPositions();
            } else if (event.getPrimitive() instanceof org.cesiumjs.cs.scene.interaction.PointPrimitive) {
                positions = ((org.cesiumjs.cs.scene.interaction.PointPrimitive) event.getPrimitive()).getPositions();
            }
            if (positions != null) {
                Cesium.log(positions);
            }

            if (event.getPrimitive() instanceof org.cesiumjs.cs.scene.interaction.PointPrimitive) {
                PointPrimitiveOptions pointPrimitiveOptions = new PointPrimitiveOptions();
                pointPrimitiveOptions.color = Color.RED().withAlpha(0.5f);
                pointPrimitiveOptions.pixelSize = 10;
                pointPrimitiveOptions.position = positions[0];
                pointPrimitiveOptions.show = true;

                PointPrimitiveCollection pointPrimitiveCollection = (PointPrimitiveCollection) csVPanel.getViewer().scene().primitives().add(new PointPrimitiveCollection());
                pointPrimitiveCollection.add(pointPrimitiveOptions);
            } else {
                GeometryInstanceOptions geometryInstanceOptions = new GeometryInstanceOptions();
                geometryInstanceOptions.geometry = event.getPrimitive().getGeometry();
                geometryInstanceOptions.attributes = new Object();
                JsObject.setProperty(geometryInstanceOptions.attributes, "color", ColorGeometryInstanceAttribute.fromColor(Color.RED().withAlpha(0.5f)));

                GroundPrimitiveOptions options = new GroundPrimitiveOptions();
                options.geometryInstances = new GeometryInstance[]{new GeometryInstance(geometryInstanceOptions)};
                csVPanel.getViewer().scene().groundPrimitives().add(new GroundPrimitive(options));
            }
        }
    }
}
