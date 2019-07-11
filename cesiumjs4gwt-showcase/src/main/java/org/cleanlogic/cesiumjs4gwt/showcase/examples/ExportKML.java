/*
 * Copyright 2019 iserge.
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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.datasources.CzmlDataSource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.js.JsBlob;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ExportKML extends AbstractExample {
    private Viewer viewer;
    private Promise<CzmlDataSource, Void> dataSourcePromise;
    private String filenameToSave;

    @Inject
    public ExportKML(ShowcaseExampleStore store) {
        super("Export KML", "How to export a subset of a CesiumJS scene as a KML/KMZ file.", new String[]{"Export", "KML"}, store);
    }

    @Override
    public void buildPanel() {
        // We fetch the resources that will be embedded in the KMZ file.
        final Promise<JsBlob, Void> daeModelPromise = Resource.fetchBlob(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.dae");
        final Promise<JsBlob, Void> texturePromise = Resource.fetchBlob(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.png");

        // This callback allows us to set the URL of the model to use
        // a COLLADA version of the model instead of the glTF version.
        // It also lets us specify the files that will be embedded in the exported KMZ.
        final Cesium.ExportKmlOptions.ModelCallback modelCallback = new Cesium.ExportKmlOptions.ModelCallback() {
            @Override
            public String Callback(ModelGraphics model, JulianDate time, JsObject externalFiles) {
                Resource resource = (Resource) model.uri.getValue(time);

                if (resource.url.indexOf("CesiumMilkTruck") != -1) {
                    externalFiles.setProperty("model/CesiumMilkTruck.dae", daeModelPromise);
                    externalFiles.setProperty("model/CesiumMilkTruck.png", texturePromise);

                    return "model/CesiumMilkTruck.dae";
                }

                return "";
            }
        };

        final JsObject[] modelCzml = new JsObject[2];
        JsObject descriptionCzml = JsObject.create();
        descriptionCzml.setProperty("id", "document");
        descriptionCzml.setProperty("name", "CZML Model");
        descriptionCzml.setProperty("version", "1.0");
        modelCzml[0] = descriptionCzml;

        JsObject bodyCzml = JsObject.create();
        bodyCzml.setProperty("id", "aircraft model");
        bodyCzml.setProperty("name", "Cesium Air");

        JsObject positionCzml = JsObject.create();
        positionCzml.setProperty("cartographicDegrees", new double[] {-77, 37, 0});
        bodyCzml.setProperty("position", positionCzml);

        JsObject gltfCzml = JsObject.create();
        gltfCzml.setProperty("gltf", GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.glb");
        bodyCzml.setProperty("model", gltfCzml);
        modelCzml[1] = bodyCzml;

        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.shouldAnimate = true;

        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);
        viewer = csVPanel.getViewer();

        ListBox sourceLBox = new ListBox();
        sourceLBox.addItem("Satellites", "0");
        sourceLBox.addItem("Model", "1");
        sourceLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ListBox source = (ListBox) event.getSource();
                reset();
                if (source.getSelectedValue().equalsIgnoreCase("0")) {
                    filenameToSave = "Satellites.kmz";
                    dataSourcePromise = CzmlDataSource.load(GWT.getModuleBaseURL() + "SampleData/simple.czml");
                    viewer.dataSources().add(dataSourcePromise);

                    viewer.camera.flyHome(0);
                } else if (source.getSelectedValue().equalsIgnoreCase("1")) {
                    filenameToSave = "Model.kmz";
                    dataSourcePromise = CzmlDataSource.load(modelCzml);
                    viewer.dataSources().add(dataSourcePromise).then(new Fulfill<CzmlDataSource>() {
                        @Override
                        public void onFulfilled(CzmlDataSource dataSource) {
                            viewer.trackedEntity = dataSource.entities.getById("aircraft model");
                        }
                    });
                }
            }
        });

        Button downloadBtn = new Button("Download");
        downloadBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                dataSourcePromise.then(new Fulfill<CzmlDataSource>() {
                    @Override
                    public void onFulfilled(CzmlDataSource dataSource) {
                        Cesium.ExportKmlOptions options = Cesium.ExportKmlOptions.create(dataSource.entities);
                        options.kmz = true;
                        options.modelCallback = modelCallback;
                        Cesium.exportKml(options).then(new Fulfill<JsObject>() {
                            @Override
                            public void onFulfilled(JsObject value) {
                                downloadBlob(filenameToSave, (JsBlob) value.getObject("kmz"));
                            }
                        });
                    }
                });
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setCellSpacing(1);
        flexTable.setCellPadding(1);
        flexTable.setWidget(0, 0, sourceLBox);
        flexTable.setWidget(1, 0, downloadBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>How to export a subset of a CesiumJS scene as a KML/KMZ file.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        // Initial
        filenameToSave = "Satellites.kmz";
        dataSourcePromise = CzmlDataSource.load(GWT.getModuleBaseURL() + "SampleData/simple.czml");
        viewer.dataSources().add(dataSourcePromise);

        viewer.camera.flyHome(0);
    }

    private native void downloadBlob(String filename, JsBlob blob) /*-{
        if ($wnd.navigator.msSaveOrOpenBlob) {
            $wnd.navigator.msSaveBlob(blob, filename);
        } else {
            var elem = $wnd.document.createElement('a');
            elem.href = $wnd.URL.createObjectURL(blob);
            elem.download = filename;
            document.body.appendChild(elem);
            elem.click();
            document.body.removeChild(elem);
        }
    }-*/;

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ExportKML.txt";
        return sourceCodeURLs;
    }

    private void reset() {
        viewer.trackedEntity = (Entity) JsObject.undefined();
        viewer.dataSources().removeAll();
    }
}
