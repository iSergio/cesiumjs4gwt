/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ContextOptions;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class MSAA extends AbstractExample {
    private ViewerPanel csVPanel;
    @Inject
    public MSAA(ShowcaseExampleStore store) {
        super("MSAA",
                "Add MSAA to the scene.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "MSAA"}, store, "1.91");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.terrainProvider = Cesium.createWorldTerrain();
        options.contextOptions = new ContextOptions();
        options.contextOptions.requestWebgl2 = true;
        csVPanel = new ViewerPanel(options);

        if (!csVPanel.getViewer().scene().msaaSupported()) {
            Window.alert("This browser does not support MSAA.");
        }

        ListBox modelLBox = new ListBox();
        modelLBox.addItem("Statue of Liberty", "0");
        modelLBox.addItem("3D Tiles BIM", "1");
        modelLBox.addItem("Hot Air Balloon", "2");
        modelLBox.addChangeHandler(this::setModel);

        ListBox msaaLBox = new ListBox();
        msaaLBox.addItem("MSAA off", "1");
        msaaLBox.addItem("MSAA 2x", "2");
        msaaLBox.addItem("MSAA 4x", "4");
        msaaLBox.addItem("MSAA 8x", "8");
        msaaLBox.addChangeHandler(this::setMsaa);

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(modelLBox);
        hPanel.add(msaaLBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Add MSAA to the scene.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), modelLBox);
    }

    private void setModel(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        int value = Integer.parseInt(source.getSelectedValue());

        Viewer viewer = csVPanel.getViewer();
        Scene scene = viewer.scene();
        viewer.entities().removeAll();
        scene.primitives().removeAll();
        Cartesian3 destination = new Cartesian3();
        HeadingPitchRoll orientation = new HeadingPitchRoll();
        Matrix4 endTransform = null;
        if (value == 0) {
            destination = new Cartesian3(1331419.302230775, -4656681.5022043325, 4136232.6465900405);
            orientation = new HeadingPitchRoll(6.032455545102689,
                    -0.056832496140112765,
                    6.282360923090216);
            endTransform = Matrix4.IDENTITY();

            scene.primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(75343)));
        } else if (value == 1) {
            destination = new Cartesian3(1234138.7804841248, -5086063.633843134, 3633284.606361642);
            orientation = new HeadingPitchRoll(0.4304630387656614, -0.16969316864215878,
                    6.283184816241989);

            scene.primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(8564)));
        } else if (value == 2) {
            createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 1000.0);
        }

        if (value != 2) {
            ViewOptions viewOptions = new ViewOptions();
            viewOptions.destinationPos = destination;
            viewOptions.orientation = orientation;
            if (endTransform != null) {
                viewOptions.endTransform = endTransform;
            }
            scene.camera().setView(viewOptions);
        }
    }

    private void setMsaa(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        csVPanel.getViewer().scene().msaaSamples = Integer.parseInt(source.getSelectedValue());
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "MSAA.txt";
        return sourceCodeURLs;
    }

    private void createModel(String url, double height) {
        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
        double heading = Math.toRadians(135);
        double pitch = 0;
        double roll = 0;
        HeadingPitchRoll hpr = new HeadingPitchRoll(heading, pitch, roll);
        Quaternion orientation = Transforms.headingPitchRollQuaternion(position, hpr);

        Viewer viewer = csVPanel.getViewer();

        ModelGraphicsOptions modelOptions = new ModelGraphicsOptions();
        modelOptions.uri = new ConstantProperty(url);
        modelOptions.minimumPixelSize = new ConstantProperty(128);
        modelOptions.maximumScale = new ConstantProperty(2000);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = url;
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.orientation = new ConstantProperty(orientation);
        entityOptions.model = new ModelGraphics(modelOptions);
        viewer.entities().add(entityOptions);

        Cartesian3 target = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height + 7.5);
        Cartesian3 offset = new Cartesian3(50.0, -15.0, 0.0);
        viewer.scene().camera().lookAt(target, offset);
    }
}
