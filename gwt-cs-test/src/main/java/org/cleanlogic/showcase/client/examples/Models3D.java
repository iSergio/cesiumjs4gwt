/*
 * Copyright 2016 iserge.
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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Configuration;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.HeightReference;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanelAbstract;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Models3D extends AbstractExample {
    private class ViewerPanel implements IsWidget {
        private ViewerPanelAbstract _csPanelAbstract;

        private ViewerPanel() {
            super();
            asWidget();
        }

        @Override
        public Widget asWidget() {
            if (_csPanelAbstract == null) {
                final Configuration csConfiguration = new Configuration();
                csConfiguration.setPath(GWT.getModuleBaseURL() + "JavaScript/Cesium");
                _csPanelAbstract = new ViewerPanelAbstract(csConfiguration) {
                    @Override
                    public Viewer createViewer(Element element) {
                        ViewerOptions csViewerOptions = new ViewerOptions();
                        csViewerOptions.infoBox = false;
                        csViewerOptions.selectionIndicator = false;
                        csViewerOptions.shadows = false;
                        Viewer csViewer = new Viewer(element, csViewerOptions);

                        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb");
                        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
                        modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
                        ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

                        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 5000.0);
                        double heading = Math.toRadians(135);
                        double pitch = 0;
                        double roll = 0;
                        Quaternion orientation = Transforms.headingPitchRollQuaternion(position, heading, pitch, roll);
                        EntityOptions entityOptions = new EntityOptions();
                        entityOptions.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb";
                        entityOptions.position = new ConstantPositionProperty(position);
                        entityOptions.orientation = new ConstantProperty<>(orientation);
                        entityOptions.model = modelGraphics;
                        csViewer.trackedEntity = csViewer.entities().add(entityOptions);

                        return csViewer;
                    }
                };
            }
            return _csPanelAbstract;
        }

        private Viewer getViewer() {
            return _csPanelAbstract.getViewer();
        }

        private void createModel(String url, double height) {
            _csPanelAbstract.getViewer().entities().removeAll();

            ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
            modelGraphicsOptions.uri = new ConstantProperty<>(url);
            modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
            modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
            ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

            Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
            double heading = Math.toRadians(135);
            double pitch = 0;
            double roll = 0;
            Quaternion orientation = Transforms.headingPitchRollQuaternion(position, heading, pitch, roll);
            EntityOptions entityOptions = new EntityOptions();
            entityOptions.name = url;
            entityOptions.position = new ConstantPositionProperty(position);
            entityOptions.orientation = new ConstantProperty<>(orientation);
            entityOptions.model = modelGraphics;
            _csPanelAbstract.getViewer().trackedEntity = _csPanelAbstract.getViewer().entities().add(entityOptions);;
        }
    }

    @Inject
    public Models3D(ShowcaseExampleStore store) {
        super("3D Models", "Cesium GLTF models integration", new String[]{"Showcase", "Cesium", "3d", "gltf", "glb", "models"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        final ListBox modelsLBox = new ListBox();
        modelsLBox.addItem("Aircraft", "0");
        modelsLBox.addItem("Ground vehicle", "1");
        modelsLBox.addItem("Hot Air Balloon", "2");
        modelsLBox.addItem("Milk truck", "3");
        modelsLBox.addItem("Skinned character", "4");
        modelsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                csVPanel.getViewer().entities().removeAll();
                switch (modelsLBox.getSelectedValue()) {
                    case "0": csVPanel.createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb", 5000.0); break;
                    case "1": csVPanel.createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumGround/Cesium_Ground.glb", 0); break;
                    case "2": csVPanel.createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 1000.0); break;
                    case "3": csVPanel.createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck-kmc.glb", 0); break;
                    case "4": csVPanel.createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb", 0); break;
                    default: break;
                }
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(modelsLBox, 20, 20);

        contentPanel.add(new HTML("<p>Cesium GLTF models integration</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Models3D.txt";
        return sourceCodeURLs;
    }
}
