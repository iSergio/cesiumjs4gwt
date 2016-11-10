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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Configuration;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.options.ColorRandomOptions;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.GeoJsonDataSource;
import org.cesiumjs.cs.datasources.options.GeoJsonDataSourceOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.promise.Reject;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanelAbstract;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class GeoJSONAndTopoJSON extends AbstractExample {
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
                        Viewer csViewer = new Viewer(element);
                        csViewer.dataSources().removeAll();
                        csViewer.camera.lookAt(Cartesian3.fromDegrees(-98.0, 40.0), new Cartesian3(0.0, -4790000.0, 3930000.0));
                        csViewer.camera.lookAtTransform(Matrix4.IDENTITY());
                        return csViewer;
                    }
                };
            }
            return _csPanelAbstract;
        }

        public void reset() {
            _csPanelAbstract.getViewer().dataSources().removeAll();
            _csPanelAbstract.getViewer().camera.lookAt(Cartesian3.fromDegrees(-98.0, 40.0), new Cartesian3(0.0, -4790000.0, 3930000.0));
            _csPanelAbstract.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
        }
    }

    @Inject
    public GeoJSONAndTopoJSON(ShowcaseExampleStore store) {
        super("GeoJSON and TopoJSON", "Simple Cesium hello world application", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(5);
        hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        Button defaultStylingBtn = new Button("Default styling");
        defaultStylingBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                csVPanel.reset();
                csVPanel._csPanelAbstract.getViewer().dataSources().add(GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson"));
            }
        });

        Button basicStylingBtn = new Button("Basic styling");
        basicStylingBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                csVPanel.reset();
                GeoJsonDataSourceOptions options = new GeoJsonDataSourceOptions();
                options.stroke = Color.HOTPINK();
                options.fill = Color.DEEPPINK().withAlpha(0.5f);
                options.strokeWidth = 3;
                csVPanel._csPanelAbstract.getViewer().dataSources().add(GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson", options));
            }
        });

        Button customStylingBtn = new Button("Custom styling");
        customStylingBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Math.setRandomNumberSeed(0);

                Promise<GeoJsonDataSource, String> promise = GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/ne_10m_us_states.topojson");
                promise.then(new Fulfill<GeoJsonDataSource>() {
                    @Override
                    public void onFulfilled(GeoJsonDataSource dataSource) {
                        csVPanel.reset();
                        csVPanel._csPanelAbstract.getViewer().dataSources().add(dataSource);

                        Entity[] entities = dataSource.entities.values();
                        HashMap<String, Color> colorHash = new HashMap<>();
                        for (int i = 0; i < entities.length; i++) {
                            Entity entity = entities[i];
                            String name = entity.name;
                            Color color = colorHash.get(name);
                            if (color == null) {
                                ColorRandomOptions options = new ColorRandomOptions();
                                options.alpha = 1.0f;
                                color = Color.fromRandom(options);
                                colorHash.put(name, color);
                            }

                            entity.polygon.material = new ColorMaterialProperty(new ConstantProperty<>(color));
                            entity.polygon.outline = new ConstantProperty<>(false);
                            entity.polygon.extrudedHeight = new ConstantProperty<>((double)entity.properties.getInt("Population") /50.);
                        }
                    }
                }, new Reject<String>() {
                    @Override
                    public void onRejected(String value) {
                        Window.alert(value);
                    }
                });
            }
        });

        hPanel.add(defaultStylingBtn);
        hPanel.add(basicStylingBtn);
        hPanel.add(customStylingBtn);

        contentPanel.add(new HTML("<p>This example shows simple Cesium application</p>"));
        contentPanel.add(hPanel);
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GeoJSONAndTopoJSON.txt";
        return sourceCodeURLs;
    }
}
