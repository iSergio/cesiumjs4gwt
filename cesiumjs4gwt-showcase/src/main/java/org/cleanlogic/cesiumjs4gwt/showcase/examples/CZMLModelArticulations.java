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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.datasources.CzmlDataSource;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class CZMLModelArticulations extends AbstractExample {

    @Inject
    public CZMLModelArticulations(ShowcaseExampleStore store) {
        super("CZML Model Articulations", "CZML Model Articulations", new String[]{"CZML", "Model", "Articulations"},
                store);
    }

    @Override
    public void buildPanel() {
        JsObject clockCZML = JsObject.create();
        clockCZML.setProperty("interval", "2019-06-01T16:00:00Z/2019-06-01T16:10:00Z");
        clockCZML.setProperty("currentTime", "2019-06-01T16:00:00Z");
        clockCZML.setProperty("multiplier", 60.0);
        clockCZML.setProperty("range", "LOOP_STOP");
        clockCZML.setProperty("step", "SYSTEM_CLOCK_MULTIPLIER");

        JsObject firstCZML = JsObject.create();
        firstCZML.setProperty("id", "document");
        firstCZML.setProperty("name", "CZML Model");
        firstCZML.setProperty("version", "1.0");
        firstCZML.setProperty("clock", clockCZML);

        JsObject positionCZML = JsObject.create();
        positionCZML.setProperty("cartographicDegrees", new double[]{-77, 37, 10000});

        JsObject fairingOpenCZML = JsObject.create();
        fairingOpenCZML.setProperty("epoch", "2019-06-01T16:00:00Z");
        fairingOpenCZML.setProperty("number", new double[]{0, 0, 600, 120});

        JsObject fairingSeparateCZML = JsObject.create();
        fairingSeparateCZML.setProperty("epoch", "2019-06-01T16:00:00Z");
        fairingSeparateCZML.setProperty("number", new double[]{0, 0, 400, -50});

        JsObject fairingDropCZML = JsObject.create();
        fairingDropCZML.setProperty("epoch", "2019-06-01T16:00:00Z");
        fairingDropCZML.setProperty("interpolationAlgorithm", "LAGRANGE");
        fairingDropCZML.setProperty("interpolationDegree", 2);
        fairingDropCZML.setProperty("number", new double[]{0, 0, 80, 0, 100, 0, 120, -1, 600, -120});

        JsObject articulationsCZML = JsObject.create();
        articulationsCZML.setProperty("Fairing Open", fairingOpenCZML);
        articulationsCZML.setProperty("Fairing Separate", fairingSeparateCZML);
        articulationsCZML.setProperty("Fairing Drop", fairingDropCZML);

        JsObject modelCZML = JsObject.create();
        modelCZML.setProperty("gltf", "https://assets.agi.com/models/launchvehicle.glb");
        modelCZML.setProperty("scale", 2.0);
        modelCZML.setProperty("minimumPixelSize", 128);
        modelCZML.setProperty("runAnimations", false);
        modelCZML.setProperty("articulations", articulationsCZML);

        JsObject secondCZML = JsObject.create();
        secondCZML.setProperty("id", "test model");
        secondCZML.setProperty("name", "Cesium Air");
        secondCZML.setProperty("position", positionCZML);
        secondCZML.setProperty("model", modelCZML);

        ViewerOptions options = new ViewerOptions();
        options.shouldAnimate = true;
        final ViewerPanel csVPanel = new ViewerPanel(options);

        Promise<CzmlDataSource, Void> dataSourcePromise = csVPanel.getViewer().dataSources()
                .add(CzmlDataSource.load(new JsObject[]{firstCZML, secondCZML}));

        dataSourcePromise.then(new Fulfill<CzmlDataSource>() {
            @Override
            public void onFulfilled(CzmlDataSource dataSource) {
                csVPanel.getViewer().trackedEntity = dataSource.entities.getById("test model");
            }
        });

        contentPanel.add(new HTML("<p>CZML Model Articulations</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CZMLModelArticulations.txt";
        return sourceCodeURLs;
    }
}
