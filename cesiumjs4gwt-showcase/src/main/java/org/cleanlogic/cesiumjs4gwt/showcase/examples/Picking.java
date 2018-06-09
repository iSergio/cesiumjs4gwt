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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.PolygonGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PolygonGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.*;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Picking extends AbstractExample {
    private final static Logger LOGGER = Logger.getLogger(Picking.class.getName());
    private EntityCollection _pickedEntities;
    private Color _pickColor;
    private ViewerPanel viewerPanel;
    private ScreenSpaceEventHandler _handler;

    ToggleButton _showPosOnMouseOverTBtn;
    ToggleButton _pickEntityTBtn;
    ToggleButton _drillDownPickingTBtn;
    ToggleButton _pickPositionTBtn;

    @Inject
    public Picking(ShowcaseExampleStore store) {
        super("Picking", "Use the mouse to select and manipulate objects in the scene", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        viewerPanel = new ViewerPanel();
        showCartographicPositionOnMouseOver();

        _showPosOnMouseOverTBtn = new ToggleButton("Show Cartographic Position on Mouse Over");
        _showPosOnMouseOverTBtn.setValue(true);
        _showPosOnMouseOverTBtn.addValueChangeHandler(new MValueChangeHandler());

        _pickEntityTBtn = new ToggleButton("Pick Entity");
        _pickEntityTBtn.addValueChangeHandler(new MValueChangeHandler());

        _drillDownPickingTBtn = new ToggleButton("Drill-Down Picking");
        _drillDownPickingTBtn.addValueChangeHandler(new MValueChangeHandler());

        _pickPositionTBtn = new ToggleButton("Pick position");
        _pickPositionTBtn.addValueChangeHandler(new MValueChangeHandler());

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(_showPosOnMouseOverTBtn);
        hPanel.add(_pickEntityTBtn);
        hPanel.add(_drillDownPickingTBtn);
        hPanel.add(_pickPositionTBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(viewerPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML("<p>Use the mouse to select and manipulate objects in the scene.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Picking.txt";
        return sourceCodeURLs;
    }

    private class MValueChangeHandler implements ValueChangeHandler<Boolean> {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
            ToggleButton source = (ToggleButton) valueChangeEvent.getSource();
            reset();
            if (source.equals(_showPosOnMouseOverTBtn)) {
                showCartographicPositionOnMouseOver();

                _pickEntityTBtn.setValue(false);
                _drillDownPickingTBtn.setValue(false);
                _pickPositionTBtn.setValue(false);
            }
            else if (source.equals(_pickEntityTBtn)) {
                pickEntity();

                _showPosOnMouseOverTBtn.setValue(false);
                _drillDownPickingTBtn.setValue(false);
                _pickPositionTBtn.setValue(false);
            }
            else if (source.equals(_drillDownPickingTBtn)) {
                drillDownPicking();

                _showPosOnMouseOverTBtn.setValue(false);
                _pickEntityTBtn.setValue(false);
                _pickPositionTBtn.setValue(false);
            }
            else if (source.equals(_pickPositionTBtn)) {
                pickPosition();

                _showPosOnMouseOverTBtn.setValue(false);
                _pickEntityTBtn.setValue(false);
                _drillDownPickingTBtn.setValue(false);
            }
        }
    }

    public void showCartographicPositionOnMouseOver() {
        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.show = new ConstantProperty<>(true);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        final Entity entity = viewerPanel.getViewer().entities().add(new Entity(entityOptions));

        _handler = new ScreenSpaceEventHandler(viewerPanel.getViewer().scene().canvas());
        _handler.setInputAction(new ScreenSpaceEventHandler.Listener<MouseMoveEvent>() {
            @Override
            public void function(MouseMoveEvent event) {
                Cartesian3 cartesian = viewerPanel.getViewer().camera.pickEllipsoid(event.endPosition, viewerPanel.getViewer().scene().globe.ellipsoid);
                if (cartesian != null) {
                    Cartographic cartographic = Cartographic.fromCartesian(cartesian);
                    String lon = new BigDecimal(Math.toDegrees(cartographic.longitude)).setScale(2, RoundingMode.HALF_EVEN).toString();
                    String lat = new BigDecimal(Math.toDegrees(cartographic.latitude)).setScale(2, RoundingMode.HALF_EVEN).toString();

                    entity.position = new ConstantPositionProperty(cartesian);
                    entity.label.show = new ConstantProperty<>(true);
                    entity.label.text = new ConstantProperty<>("(" + lon + ", " + lat + ")");
                } else {
                    entity.label.show = new ConstantProperty<>(false);
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    private void pickEntity() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png");
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        final Entity entity = viewerPanel.getViewer().entities().add(new Entity(entityOptions));

        _handler = new ScreenSpaceEventHandler(viewerPanel.getViewer().scene().canvas());
        _handler.setInputAction(new ScreenSpaceEventHandler.Listener<MouseMoveEvent>() {
            @Override
            public void function(MouseMoveEvent event) {
                PickedObject pickedObject = viewerPanel.getViewer().scene().pick(event.endPosition);
                if (pickedObject != null && pickedObject.id == entity) {
                    entity.billboard.scale = new ConstantProperty<>(2.0);
                    entity.billboard.color = new ConstantProperty<>(Color.YELLOW());
                } else {
                    entity.billboard.scale = new ConstantProperty<>(1.0);
                    entity.billboard.color = new ConstantProperty<>(Color.WHITE());
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    private void makeProperty(final Entity entity, final Color color) {
        Property<Color> colorProperty = new org.cesiumjs.cs.datasources.properties.CallbackProperty<>(new org.cesiumjs.cs.datasources.properties.CallbackProperty.Callback<Color>() {
            @Override
            public Color function(JulianDate time, Color result) {
                if (_pickedEntities.contains(entity)) {
                    return _pickColor.clone(result);
                }
                return color.clone(result);
            }
        }, false);
        entity.polygon.material = new ColorMaterialProperty(colorProperty);
    }

    private void drillDownPicking() {
        _pickedEntities = new EntityCollection();
        _pickColor = Color.YELLOW().withAlpha(0.5f);

        PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(Cartesian3.fromDegreesArray(new double[] {-70.0, 30.0, -60.0, 30.0, -60.0, 40.0, -70.0, 40.0})));
        polygonGraphicsOptions.height = new ConstantProperty<>(0);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        Entity red = viewerPanel.getViewer().entities().add(new Entity(entityOptions));
        makeProperty(red, Color.RED().withAlpha(0.5f));

        polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(Cartesian3.fromDegreesArray(new double[] {-75.0, 34.0, -63.0, 34.0, -63.0, 40.0, -75.0, 40.0})));
        polygonGraphicsOptions.height = new ConstantProperty<>(0);
        entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        Entity blue = viewerPanel.getViewer().entities().add(new Entity(entityOptions));
        makeProperty(blue, Color.BLUE().withAlpha(0.5f));

        polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(Cartesian3.fromDegreesArray(new double[] {-67.0, 36.0, -55.0, 36.0, -55.0, 30.0, -67.0, 30.0})));
        polygonGraphicsOptions.height = new ConstantProperty<>(0);
        entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        Entity green = viewerPanel.getViewer().entities().add(new Entity(entityOptions));
        makeProperty(green, Color.GREEN().withAlpha(0.5f));

        // Move the primitive that the mouse is over to the top.
        _handler = new ScreenSpaceEventHandler(viewerPanel.getViewer().scene().canvas());
        _handler.setInputAction(new ScreenSpaceEventHandler.Listener<MouseMoveEvent>() {
            @Override
            public void function(MouseMoveEvent event) {
                PickedObject[] pickedObjects = viewerPanel.getViewer().scene().drillPick(event.endPosition);
                if (pickedObjects != null) {
                    _pickedEntities.removeAll();
                    for (PickedObject pickedObject : pickedObjects) {
                        Entity entity = (Entity)pickedObject.id;
                        _pickedEntities.add(entity);
                    }
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    private void pickPosition() {
        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck-kmc.gltf");
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-123.0744619, 44.0503706));
        entityOptions.name = "milktruck";
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
        final Entity modelEntity = viewerPanel.getViewer().entities().add(new Entity(entityOptions));
        viewerPanel.getViewer().zoomTo(modelEntity);

        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.show = new ConstantProperty<>(false);
        labelGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.LEFT());
        entityOptions = new EntityOptions();
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        final Entity labelEntity = viewerPanel.getViewer().entities().add(new Entity(entityOptions));
        _handler = new ScreenSpaceEventHandler(viewerPanel.getViewer().scene().canvas());
        _handler.setInputAction(new ScreenSpaceEventHandler.Listener<MouseMoveEvent>() {
            @Override
            public void function(MouseMoveEvent event) {
                boolean foundPosition = false;

                Scene scene = viewerPanel.getViewer().scene();
                PickedObject pickedObject = scene.pick(event.endPosition);
                if (scene.pickPositionSupported() && pickedObject != null && pickedObject.id == modelEntity) {
                    Cartesian3 cartesian = viewerPanel.getViewer().scene().pickPosition(event.endPosition);

                    if (cartesian != null) {
                        Cartographic cartographic = Cartographic.fromCartesian(cartesian);
                        String lon = new BigDecimal(Math.toDegrees(cartographic.longitude)).setScale(2, RoundingMode.HALF_EVEN).toString();
                        String lat = new BigDecimal(Math.toDegrees(cartographic.latitude)).setScale(2, RoundingMode.HALF_EVEN).toString();
                        String height = new BigDecimal(cartographic.height).setScale(2, RoundingMode.HALF_EVEN).toString();

                        labelEntity.position = new ConstantPositionProperty(cartesian);
                        labelEntity.label.show = new ConstantProperty<>(true);
                        labelEntity.label.text = new ConstantProperty<>("(" + lon + ", " + lat + ", " + height + ")");

                        Camera camera = scene.camera();
                        labelEntity.label.eyeOffset = new ConstantProperty<>(new Cartesian3(0.0, 0.0, ((PerspectiveFrustum)camera.frustum).near * 1.5 - (double)Cartesian3.distance(cartesian, camera.position)));

                        foundPosition = true;
                    }
                }

                if (!foundPosition) {
                    labelEntity.label.show = new ConstantProperty<>(false);
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    public void reset() {
        viewerPanel.getViewer().entities().removeAll();
        _handler.destroy();
        _handler = null;
    }
}
