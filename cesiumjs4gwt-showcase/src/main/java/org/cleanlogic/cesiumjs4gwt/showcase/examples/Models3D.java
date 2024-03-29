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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.FeatureDetection;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class Models3D extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public Models3D(ShowcaseExampleStore store) {
        super("3D Models", "Create 3D models using glTF",
                new String[]{"Showcase", "Cesium", "3d", "gltf", "glb", "models"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions csViewerOptions = new ViewerOptions();
        csViewerOptions.infoBox = false;
        csViewerOptions.selectionIndicator = false;
        csViewerOptions.shadows = true;
        csViewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(csViewerOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb");
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
        ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 5000.0);
        double heading = Math.toRadians(135);
        double pitch = 0;
        double roll = 0;
        Quaternion orientation = Transforms.headingPitchRollQuaternion(position,
                new org.cesiumjs.cs.core.HeadingPitchRoll(heading, pitch, roll));
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb";
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.orientation = new ConstantProperty<>(orientation);
        entityOptions.model = modelGraphics;
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);

        final ListBox modelsLBox = new ListBox();
        modelsLBox.addItem("Aircraft", "0");
        modelsLBox.addItem("Drone", "1");
        modelsLBox.addItem("Ground vehicle", "2");
        modelsLBox.addItem("Hot Air Balloon", "3");
        modelsLBox.addItem("Milk truck", "4");
        modelsLBox.addItem("Skinned character", "5");
        modelsLBox.addItem("Unlit Box", "6");
        modelsLBox.addItem("Draco Compressed Model", "7");
        modelsLBox.addItem("KTX2 Compressed Balloon", "8");
        modelsLBox.addItem("Instanced Box", "9");
        modelsLBox.addChangeHandler(this::onChange);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(modelsLBox, 20, 20);

        contentPanel.add(new HTML("<p>Create 3D models using glTF.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Models3D.txt";
        return sourceCodeURLs;
    }

    private void onChange(ChangeEvent event) {
        csVPanel.getViewer().entities().removeAll();
        ListBox source = (ListBox) event.getSource();
        switch (source.getSelectedValue()) {
            case "0":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb", 5000.0);
                break;
            case "1":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumDrone/CesiumDrone.glb", 150.0);
                break;
            case "2":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/GroundVehicle/GroundVehicle.glb", 0);
                break;
            case "3":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 1000.0);
                break;
            case "4":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.glb", 0);
                break;
            case "5":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb", 0);
                break;
            case "6":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/BoxUnlit/BoxUnlit.gltf", 10.0);
                break;
            case "7":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/DracoCompressed/CesiumMilkTruck.gltf", 0);
                break;
            case "8":
                if (!FeatureDetection.supportsBasis(csVPanel.getViewer().scene())) {
                    Window.alert("This browser does not support Basis Universal compressed textures");
                }
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloonKTX2/CesiumBalloonKTX2.glb", 1000.0);
                break;
            case "9":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/BoxInstanced/BoxInstanced.gltf", 15);
                break;
            default:
                break;
        }
    }

    private void createModel(String url, double height) {
        csVPanel.getViewer().entities().removeAll();

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(url);
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
        ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
        double heading = Math.toRadians(135);
        double pitch = 0;
        double roll = 0;
        Quaternion orientation = Transforms.headingPitchRollQuaternion(position,
                new org.cesiumjs.cs.core.HeadingPitchRoll(heading, pitch, roll));
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = url;
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.orientation = new ConstantProperty<>(orientation);
        entityOptions.model = modelGraphics;
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
    }
}
