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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.options.ColorRandomOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.GeoJsonDataSource;
import org.cesiumjs.cs.datasources.options.GeoJsonDataSourceOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.HashMap;

/**
 * @author Serge Silaev aka iSergio
 */
public class GeoJSONAndTopoJSON extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public GeoJSONAndTopoJSON(ShowcaseExampleStore store) {
        super("GeoJSON and TopoJSON", "Load GeoJSON or TopoJSON data and apply custom styling",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "GeoJSON", "TopoJSON", "JSON", "Promise"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        csVPanel.getViewer().dataSources().removeAll();
        csVPanel.getViewer().camera.lookAt(Cartesian3.fromDegrees(-98.0, 40.0), new Cartesian3(0.0, -4790000.0, 3930000.0));
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());

        Button defaultStylingBtn = new Button("Default styling");
        defaultStylingBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                reset();
                csVPanel.getViewer().dataSources()
                        .add(GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson"));
            }
        });

        Button basicStylingBtn = new Button("Basic styling");
        basicStylingBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                reset();
                GeoJsonDataSourceOptions options = new GeoJsonDataSourceOptions();
                options.stroke = Color.HOTPINK();
                options.fill = Color.DEEPPINK().withAlpha(0.5f);
                options.strokeWidth = 3;
                csVPanel.getViewer().dataSources()
                        .add(GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson", options));
            }
        });

        Button customStylingBtn = new Button("Custom styling");
        customStylingBtn.addClickHandler(clickEvent -> {
            Math.setRandomNumberSeed(0);

            GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson")
                    .then(this::generateEntitys, error -> /*Window::alert not worked in lambda function*/Window.alert(error));
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(5);
        hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        hPanel.add(defaultStylingBtn);
        hPanel.add(basicStylingBtn);
        hPanel.add(customStylingBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML("<p>Load GeoJSON or TopoJSON data and apply custom styling.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GeoJSONAndTopoJSON.txt";
        return sourceCodeURLs;
    }

    public void reset() {
        csVPanel.getViewer().dataSources().removeAll();
        csVPanel.getViewer().camera.lookAt(Cartesian3.fromDegrees(-98.0, 40.0), new Cartesian3(0.0, -4790000.0, 3930000.0));
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
    }

    public void generateEntitys(GeoJsonDataSource dataSource) {
        Window.alert("!!!!");
        reset();
        csVPanel.getViewer().dataSources().add(dataSource);

        Entity[] entities = dataSource.entities.values();
        HashMap<String, Color> colorHash = new HashMap<>();
        for (Entity entity : entities) {
            String name = entity.name;
            Color color = colorHash.get(name);
            if (!Cesium.defined(color)) {
                ColorRandomOptions options = new ColorRandomOptions();
                options.alpha = 1.0f;
                color = Color.fromRandom(options);
                colorHash.put(name, color);
            }

            ConstantProperty<Number> populationProperty = (ConstantProperty<Number>) (Object) JsObject.getObject(entity.properties, "Population");

            entity.polygon.material = new ColorMaterialProperty(new ConstantProperty<>(color));
            entity.polygon.outline = new ConstantProperty<>(false);
            entity.polygon.extrudedHeight = new ConstantProperty<>(populationProperty.getValue().intValue() / 50.);
        }
    }
}
