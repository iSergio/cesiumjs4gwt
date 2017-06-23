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
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PathGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PathGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.PolylineGlowMaterialProperty;
import org.cesiumjs.cs.datasources.properties.SampledPositionProperty;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.Model;
import org.cesiumjs.cs.scene.PerspectiveFrustum;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.ScreenSpaceCameraController;
import org.cesiumjs.cs.scene.enums.ModelAnimationLoop;
import org.cesiumjs.cs.scene.options.FromGltfOptions;
import org.cesiumjs.cs.scene.options.ModelAnimationOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class HeadingPitchRoll extends AbstractExample {
    double deltaRadians = Math.toRadians(3.0);
    SampledPositionProperty pathPosition;
    double speed = 10;
    double r = 0;
    Cartesian3 position;
    Cartesian3 speedVector;
    Model planePrimitive;

    CheckBox fromBehind;
    @Inject
    public HeadingPitchRoll(ShowcaseExampleStore store) {
        super("HeadingPitchRoll", "Use HeadingPitchRoll", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Heading", "Pitch", "Roll"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        pathPosition = new SampledPositionProperty();

        PathGraphicsOptions pathGraphicsOptions = new PathGraphicsOptions();
        pathGraphicsOptions.show = new ConstantProperty<>(true);
        pathGraphicsOptions.leadTime = new ConstantProperty<>(0);
        pathGraphicsOptions.trailTime = new ConstantProperty<>(60);
        pathGraphicsOptions.width = new ConstantProperty<>(10);
        pathGraphicsOptions.resolution = new ConstantProperty<>(1);
        pathGraphicsOptions.material = PolylineGlowMaterialProperty.create(Color.PALEGOLDENROD(), 0.3);

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = pathPosition;
        entityOptions.name = "path";
        entityOptions.path = new PathGraphics(pathGraphicsOptions);
        Entity entityPath = csVPanel.getViewer().entities().add(entityOptions);

        final org.cesiumjs.cs.scene.Camera camera = csVPanel.getViewer().camera;
        final ScreenSpaceCameraController controller = csVPanel.getViewer().scene().screenSpaceCameraController();
        final Cartesian3 center = new Cartesian3();

        final org.cesiumjs.cs.core.HeadingPitchRoll hpRoll = new org.cesiumjs.cs.core.HeadingPitchRoll();
        final HeadingPitchRange hpRange = new HeadingPitchRange();

        position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 5000.0);
        speedVector = new Cartesian3();
        final Transforms.LocalFrameToFixedFrame fixedFrameTransform = Transforms.localFrameToFixedFrameGenerator("north", "west");

        FromGltfOptions fromGltfOptions = new FromGltfOptions();
        fromGltfOptions.url = GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb";
        fromGltfOptions.modelMatrix = Transforms.headingPitchRollToFixedFrame(position, hpRoll, Ellipsoid.WGS84());//, fixedFrameTransform);
        fromGltfOptions.minimumPixelSize = 128;
        planePrimitive = csVPanel.getViewer().scene().primitives().add(Model.fromGltf(fromGltfOptions));
        planePrimitive.readyPromise().then(new Fulfill<Model>() {
            @Override
            public void onFulfilled(Model model) {
                ModelAnimationOptions modelAnimationOptions = new ModelAnimationOptions();
                modelAnimationOptions.speedup = 0.5;
                modelAnimationOptions.loop = ModelAnimationLoop.REPEAT();
                model.activeAnimations.addAll(modelAnimationOptions);
                // Zoom to model
                r = 2.0 * max(model.boundingSphere().radius, ((PerspectiveFrustum)camera.frustum).near);
                controller.minimumZoomDistance = r * 0.5;
                Matrix4.multiplyByPoint(model.modelMatrix, model.boundingSphere().center, center);
                double heading = Math.toRadians(230.0);
                double pitch = Math.toRadians(-20.0);
                hpRange.heading = heading;
                hpRange.pitch = pitch;
                hpRange.range = r * 50.0;
                camera.lookAt(center, hpRange);
            }
        });

        fromBehind = new CheckBox();
        fromBehind.getElement().getStyle().setColor("white");
        fromBehind.setWidth("100px");
        fromBehind.setValue(false);

        final com.google.gwt.user.client.ui.Label headingLabel = new Label();
        headingLabel.getElement().getStyle().setColor("white");
        headingLabel.setText("Heading:°");

        final com.google.gwt.user.client.ui.Label pitchLabel = new Label();
        pitchLabel.getElement().getStyle().setColor("white");
        pitchLabel.setText("Pitch:°");

        final com.google.gwt.user.client.ui.Label rollLabel = new Label();
        rollLabel.getElement().getStyle().setColor("white");
        rollLabel.setText("Roll:°");

        final com.google.gwt.user.client.ui.Label speedLabel = new Label();
        speedLabel.getElement().getStyle().setColor("white");
        speedLabel.setText("Speed:m/s");

        FlexTable flexTable = new FlexTable();
        flexTable.setWidget(0, 0, headingLabel);
        flexTable.setHTML(1, 0, "<font color=\"white\">← to left/→ to right</font>");
        flexTable.setWidget(2, 0, pitchLabel);
        flexTable.setHTML(3, 0, "<font color=\"white\">↑ to up/↓ to down</font>");
        flexTable.setWidget(4, 0, rollLabel);
        flexTable.setHTML(5, 0, "<font color=\"white\">← + ⇧ left/→ + ⇧ right</font>");
        flexTable.setWidget(6, 0, speedLabel);
        flexTable.setHTML(7, 0, "<font color=\"white\">↑ + ⇧ to speed up/↓ + ⇧ to speed down</font>");
        flexTable.setHTML(8, 0, "<font color=\"white\">Following aircraft</font>");
        flexTable.setWidget(8, 1, fromBehind);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Click on the 3D window then use the keyboard to change settings.</p>"));
        contentPanel.add(aPanel);

        csVPanel.getViewer().scene().preRender().addEventListener(new Scene.Listener() {
            @Override
            public void function(Scene scene, JulianDate time) {
                headingLabel.setText("Heading:" + Math.toDegrees(hpRoll.heading) + "°");
                pitchLabel.setText("Pitch:" + Math.toDegrees(hpRoll.pitch) + "°");
                rollLabel.setText("Roll:" + Math.toDegrees(hpRoll.roll) + "°");
                speedLabel.setText("Speed:" + speed + "m/s");

                speedVector = Cartesian3.multiplyByScalar(Cartesian3.UNIT_X(), speed / 10, speedVector);
                position = Matrix4.multiplyByPoint(planePrimitive.modelMatrix, speedVector, position);
                pathPosition.addSample(JulianDate.now(), position);
                Transforms.headingPitchRollToFixedFrame(position, hpRoll, Ellipsoid.WGS84(), fixedFrameTransform, planePrimitive.modelMatrix);

                if (fromBehind.getValue()) {
                    // Zoom to model
                    Matrix4.multiplyByPoint(planePrimitive.modelMatrix, planePrimitive.boundingSphere().center, center);
                    hpRange.heading = hpRoll.heading;
                    hpRange.pitch = hpRoll.pitch;
                    camera.lookAt(center, hpRange);
                }
            }
        });

        RootPanel.get().addDomHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent keyDownEvent) {
                switch (keyDownEvent.getNativeKeyCode()) {
                    case 40:
                        if (keyDownEvent.getNativeEvent().getShiftKey()) {
                            speed = max(--speed, 1);
                        } else {
                            hpRoll.pitch -= deltaRadians;
                            if (hpRoll.pitch < -Math.TWO_PI()) {
                                hpRoll.pitch += Math.TWO_PI();
                            }
                        }
                        break;
                    case 38:
                        if (keyDownEvent.getNativeEvent().getShiftKey()) {
                            // speed up
                            speed = min(++speed, 100);
                        } else {
                            // pitch up
                            hpRoll.pitch += deltaRadians;
                            if (hpRoll.pitch > Math.TWO_PI()) {
                                hpRoll.pitch -= Math.TWO_PI();
                            }
                        }
                        break;
                    case 39:
                        if (keyDownEvent.getNativeEvent().getShiftKey()) {
                            // roll right
                            hpRoll.roll += deltaRadians;
                            if (hpRoll.roll > Math.TWO_PI()) {
                                hpRoll.roll -= Math.TWO_PI();
                            }
                        } else {
                            // turn right
                            hpRoll.heading += deltaRadians;
                            if (hpRoll.heading > Math.TWO_PI()) {
                                hpRoll.heading -= Math.TWO_PI();
                            }
                        }
                        break;
                    case 37:
                        if (keyDownEvent.getNativeEvent().getShiftKey()) {
                            // roll left until
                            hpRoll.roll -= deltaRadians;
                            if (hpRoll.roll < 0.0) {
                                hpRoll.roll += Math.TWO_PI();
                            }
                        } else {
                            // turn left
                            hpRoll.heading -= deltaRadians;
                            if (hpRoll.heading < 0.0) {
                                hpRoll.heading += Math.TWO_PI();
                            }
                        }
                        break;
                    default: break;
                }
            }
        }, KeyDownEvent.getType());

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "HeadingPitchRoll.txt";
        return sourceCodeURLs;
    }
}