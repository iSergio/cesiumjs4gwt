/*
 * Copyright 2021 iserge, Gis4Fun.
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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.scene.experimental.ModelExperimental;
import org.cesiumjs.cs.scene.experimental.options.ModelExperimentalFromGltfOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.lang.Math;

public class ModelExperimental3DModels extends AbstractExample {
    private Viewer viewer;

    private final HeadingPitchRoll hpr = new HeadingPitchRoll(Math.toRadians(180), 0, 0);
    private final Transforms.LocalFrameToFixedFrame fixedFrameTransform = Transforms.localFrameToFixedFrameGenerator("north", "west");

    @Inject
    public ModelExperimental3DModels(ShowcaseExampleStore store) {
        super("Model Experimental 3D Models",
                "Load glTF models using Model Experimental",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "experimental"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        viewer = csVPanel.getViewer();

        csVPanel.getViewer().clock().currentTime = JulianDate.fromIso8601("2021-11-09T20:27:37.016064475348684937Z");

        ListBox listBox = new ListBox();
        listBox.addItem("Cesium Balloon");
        listBox.addItem("Skinned Character");
        listBox.addItem("Draco Compressed Model");
        listBox.addItem("Unlit Box");
        listBox.addItem("Drone");
        listBox.addItem("Ground Vehicle");
        listBox.addItem("Instanced Box");
        listBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            String prefix = GWT.getModuleBaseURL();
            switch (value) {
                case "Cesium Balloon": selectModel(prefix + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 15); break;
                case "Skinned Character": selectModel(prefix + "SampleData/models/CesiumMan/Cesium_Man.glb", 0); break;
                case "Draco Compressed Model": selectModel(prefix + "SampleData/models/DracoCompressed/CesiumMilkTruck.gltf", 0); break;
                case "Unlit Box": selectModel(prefix + "Specs/Data/Models/PBR/BoxUnlit/BoxUnlit.gltf", 0); break;
                case "Drone": selectModel(prefix + "SampleData/models/CesiumDrone/CesiumDrone.glb", 15); break;
                case "Ground Vehicle": selectModel(prefix + "SampleData/models/GroundVehicle/GroundVehicle.glb", 0); break;
                case "Instanced Box": selectModel(prefix + "Specs/Data/Models/GltfLoader/BoxInstanced/glTF/box-instanced.gltf", 15); break;
                default: break;
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(listBox, 20, 20);

        contentPanel.add(new HTML(
                "<p>Load glTF models using Model Experimental.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        selectModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 15);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ModelExperimental3DModels.txt";
        return sourceCodeURLs;
    }

    private void selectModel(String url, double height) {
        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);

        viewer.scene().primitives().removeAll();
        ModelExperimentalFromGltfOptions options = ModelExperimentalFromGltfOptions.create(url);
        options.modelMatrix = Transforms.headingPitchRollToFixedFrame(position, hpr, Ellipsoid.WGS84(), fixedFrameTransform);
        ModelExperimental model = (ModelExperimental) viewer.scene().primitives().add(ModelExperimental.fromGltf(options));

        model.readyPromise().then(nModel -> viewer.camera.lookAt(position,
                new HeadingPitchRange(Math.toRadians(45), Math.toRadians(-15), model.boundingSphere().radius * 5)));
    }
}
