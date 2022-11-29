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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.RectangleGraphics;
import org.cesiumjs.cs.datasources.graphics.options.RectangleGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.DebugModelMatrixPrimitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.scene.options.DebugModelMatrixPrimitiveOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Serge Silaev aka iSergio
 */
public class Camera extends AbstractExample {
    private ViewerPanel csVPanel;
    private int _i = 0;
    private Label _eventsLbl;
    private Label _changesLbl;

    private Scene.Listener _icrf;
    private Event.RemoveCallback _removeStart;
    private Event.RemoveCallback _removeEnd;
    private Event.RemoveCallback _removeChanged;

    @Inject
    public Camera(ShowcaseExampleStore store) {
        super("Camera", "Fly to a specified location or view a geographic rectangle",
                new String[]{"Showcase", "Cesium", "3d", "flyTo"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        _eventsLbl = new Label("View Changed");
        _eventsLbl.getElement().getStyle().setColor("red");
        _eventsLbl.setVisible(false);

        _changesLbl = new Label();
        _changesLbl.getElement().getStyle().setColor("red");
        _changesLbl.setVisible(false);

        ListBox listBox = new ListBox();
        listBox.addItem("Camera Options", "0");
        listBox.addItem("Fly in a city", "1");
        listBox.addItem("Fly to San Diego", "2");
        listBox.addItem("Fly to Location with heading, pitch and roll", "3");
        listBox.addItem("Fly to My Location", "4");
        listBox.addItem("Fly to Rectangle", "5");
        listBox.addItem("View a Rectangle", "6");
        listBox.addItem("Set camera reference frame", "7");
        listBox.addItem("Set camera with heading, pitch, and roll", "8");
        listBox.addItem("View in ICRF", "9");
        listBox.addItem("Move events", "10");
        listBox.addItem("Camera changed event", "11");
        listBox.addItem("Fly from Los Angeles to Tokyo via Europe", "12");
        listBox.addItem("Look down during exaggerated flight", "13");
        listBox.addChangeHandler(changeEvent -> {
            reset();
            ListBox source = (ListBox) changeEvent.getSource();
            switch (source.getSelectedValue()) {
                case "1":
                    flyInACity();
                    break;
                case "2":
                    flyToSanDiego();
                    break;
                case "3":
                    flyToHeadingPitchRoll();
                    break;
                case "5":
                    flyToRectangle();
                    break;
                case "6":
                    viewRectangle();
                    break;
                case "7":
                    setReferenceFrame();
                    break;
                case "8":
                    setHeadingPitchRoll();
                    break;
                case "9":
                    viewInICRF();
                    break;
                case "10":
                    cameraEvents();
                    break;
                case "11":
                    cameraChanges();
                    break;
                case "12":
                    flyOverLongitude(false);
                    break;
                case "13":
                    flyOverLongitude(true);
                    break;
                default:
                    break;
            }
        });

        Button completeFlightBtn = new Button("Complete flight");
        completeFlightBtn.addClickHandler(event -> csVPanel.getViewer().camera.completeFlight());

        Button cancelFlightBtn = new Button("Cancel flight");
        cancelFlightBtn.addClickHandler(event -> csVPanel.getViewer().camera.cancelFlight());

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(listBox);
        hPanel.add(completeFlightBtn);
        hPanel.add(cancelFlightBtn);

        AbsolutePanel absPanel = new AbsolutePanel();
        absPanel.add(csVPanel);
        absPanel.add(hPanel, 20, 20);

        contentPanel.add(
                new HTML("<p>Fly to a specified location or view a geographic rectangle.</p>"));
        contentPanel.add(_eventsLbl);
        contentPanel.add(_changesLbl);
        contentPanel.add(absPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Camera.txt";
        return sourceCodeURLs;
    }

    private void flyInACity() {
        final CameraFlyToOptions cameraFlyToOptions = new CameraFlyToOptions();
        cameraFlyToOptions.destinationPos = Cartesian3.fromDegrees(-73.98580932617188,
                40.74843406689482, 363.34038727246224);
        cameraFlyToOptions.complete = () -> Utils.setTimeout(() -> {
            CameraFlyToOptions flyToOptions = new CameraFlyToOptions();
            flyToOptions.destinationPos = Cartesian3.fromDegrees(-73.98585975679403,
                    40.75759944127251, 186.50838555841779);
            flyToOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(
                    Math.toRadians(200.0), Math.toRadians(-50.0));
            flyToOptions.easingFunction = EasingFunction.LINEAR_NONE();
            csVPanel.getViewer().camera.flyTo(flyToOptions);
        }, 1000);
        csVPanel.getViewer().camera.flyTo(cameraFlyToOptions);
    }

    private void flyToSanDiego() {
        CameraFlyToOptions cameraFlyToOptions = new CameraFlyToOptions();
        cameraFlyToOptions.destinationPos = Cartesian3.fromDegrees(-117.16, 32.71, 15000.0);
        csVPanel.getViewer().camera.flyTo(cameraFlyToOptions);
    }

    private void flyToHeadingPitchRoll() {
        CameraFlyToOptions cameraFlyToOptions = new CameraFlyToOptions();
        cameraFlyToOptions.destinationPos = Cartesian3.fromDegrees(-122.22, 46.12, 5000.0);
        cameraFlyToOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(Math.toRadians(20.0),
                Math.toRadians(-35.0), 0.0);
        csVPanel.getViewer().camera.flyTo(cameraFlyToOptions);
    }

    private void flyToRectangle() {
        double west = -90.0;
        double south = 38.0;
        double east = -87.0;
        double north = 40.0;
        Rectangle rectangle = Rectangle.fromDegrees(west, south, east, north);

        CameraFlyToOptions cameraFlyToOptions = new CameraFlyToOptions();
        cameraFlyToOptions.destinationRec = rectangle;
        csVPanel.getViewer().camera.flyTo(cameraFlyToOptions);

        RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(rectangle);
        rectangleGraphicsOptions.fill = new ConstantProperty<>(false);
        rectangleGraphicsOptions.outline = new ConstantProperty<>(true);
        rectangleGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.rectangle = new RectangleGraphics(rectangleGraphicsOptions);
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void viewRectangle() {
        double west = -77.0;
        double south = 38.0;
        double east = -72.0;
        double north = 42.0;
        Rectangle rectangle = Rectangle.fromDegrees(west, south, east, north);

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationRec = rectangle;
        csVPanel.getViewer().camera.setView(viewOptions);

        RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(rectangle);
        rectangleGraphicsOptions.fill = new ConstantProperty<>(false);
        rectangleGraphicsOptions.outline = new ConstantProperty<>(true);
        rectangleGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.rectangle = new RectangleGraphics(rectangleGraphicsOptions);
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void setReferenceFrame() {
        Cartesian3 center = Cartesian3.fromDegrees(-75.59777, 40.03883);
        Matrix4 transform = Transforms.eastNorthUpToFixedFrame(center);

        csVPanel.getViewer().camera.constrainedAxis = Cartesian3.UNIT_Z();
        csVPanel.getViewer().camera.lookAtTransform(transform, new Cartesian3(-120000.0, -120000.0,
                120000.0));

        DebugModelMatrixPrimitiveOptions debugModelMatrixPrimitiveOptions = new DebugModelMatrixPrimitiveOptions();
        debugModelMatrixPrimitiveOptions.modelMatrix = transform;
        debugModelMatrixPrimitiveOptions.length = 100000.0;
        csVPanel.getViewer().scene().primitives().add(
                new DebugModelMatrixPrimitive(debugModelMatrixPrimitiveOptions));
    }

    private void setHeadingPitchRoll() {
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = Cartesian3.fromDegrees(-75.5847, 40.0397, 1000.0);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(-Math.PI_OVER_TWO(),
                -Math.PI_OVER_FOUR(), 0.0);
        csVPanel.getViewer().camera.setView(viewOptions);
    }

    private void viewInICRF() {
        _icrf = (scene, time) -> {
            if (scene.mode != SceneMode.SCENE3D()) {
                return;
            }
            Matrix3 icrfToFixed = Transforms.computeIcrfToFixedMatrix(time);
            if (icrfToFixed != null) {
                Cartesian3 offset = Cartesian3.clone(csVPanel.getViewer().camera.position, null);
                Matrix4 transform = Matrix4.fromRotationTranslation(icrfToFixed);
                csVPanel.getViewer().camera.lookAtTransform(transform, offset);
            }
        };
        csVPanel.getViewer().camera.flyHome(0);

        csVPanel.getViewer().clock().multiplier = 3 * 60 * 60;
        csVPanel.getViewer().scene().preRender().addEventListener(_icrf);
        csVPanel.getViewer().scene().globe.enableLighting = true;
    }

    public void cameraEvents() {
        _removeStart = csVPanel.getViewer().camera.moveStart()
                .addEventListener((org.cesiumjs.cs.scene.Camera.MoveListener) () -> _eventsLbl.setVisible(true));
        _removeEnd = csVPanel.getViewer().camera.moveEnd()
                .addEventListener((org.cesiumjs.cs.scene.Camera.MoveListener) () -> _eventsLbl.setVisible(false));
    }

    private void cameraChanges() {
        _removeChanged = csVPanel.getViewer().camera.changed()
                .addEventListener((org.cesiumjs.cs.scene.Camera.ChangedListener) percentage -> {
                    ++_i;
                    _changesLbl.setText("Camera Changed: " + _i + ", "
                            + new BigDecimal(percentage).setScale(6, RoundingMode.HALF_EVEN).toString());
                    _changesLbl.setVisible(true);
                });
    }

    private void flyOverLongitude(boolean adjustPitch) {
        org.cesiumjs.cs.scene.Camera camera = csVPanel.getViewer().scene().camera();

        CameraFlyToOptions tokyoOptions = new CameraFlyToOptions()
                .setDestination(Cartesian3.fromDegrees(139.8148, 35.7142, 20000.0))
                .setOrientation(new HeadingPitchRoll(Math.toRadians(15.0), Math.toRadians(-60), 0.0))
                .setDuration(20.).setFlyOverLongitude(Math.toRadians(60.0));

        CameraFlyToOptions laOptions = new CameraFlyToOptions()
                .setDestination(Cartesian3.fromDegrees(-117.729, 34.457, 10000.0))
                .setOrientation(new HeadingPitchRoll(Math.toRadians(-15.0), -Math.PI_OVER_FOUR(), 0.0))
                .setDuration(5);
        laOptions.complete = () -> Utils.setTimeout(() -> camera.flyTo(tokyoOptions), 1000);

        if (adjustPitch) {
            tokyoOptions.pitchAdjustHeight = 1000;
            laOptions.pitchAdjustHeight = 1000;
        }

        camera.flyTo(laOptions);
    }

    private void reset() {
        csVPanel.getViewer().scene().completeMorph();
        csVPanel.getViewer().entities().removeAll();
//        csVPanel.getViewer().scene().primitives().remove(referenceFramePrimitive);
//         csVPanel.getViewer().scene().tweens().removeAll();

        if (_removeStart != null) {
            _removeStart.function();
            _removeEnd.function();

            _removeStart = null;
            _removeEnd = null;

            _eventsLbl.setVisible(false);
        }

        if (_removeChanged != null) {
            _removeChanged.function();
            _removeChanged = null;

            _changesLbl.setVisible(false);
        }

        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());

        csVPanel.getViewer().clock().multiplier = 1.0;
        if (_icrf != null) {
            csVPanel.getViewer().scene().preRender().removeEventListener(_icrf);
            _icrf = null;
        }
        csVPanel.getViewer().scene().globe.enableLighting = false;
    }
}
