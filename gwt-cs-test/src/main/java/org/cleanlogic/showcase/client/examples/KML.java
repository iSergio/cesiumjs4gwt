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
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.core.enums.ClockStep;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.KmlDataSource;
import org.cesiumjs.cs.datasources.options.KmlDataSourceOptions;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class KML extends AbstractExample {
    private ViewerPanel csVPanel;
    @Inject
    public KML(ShowcaseExampleStore store) {
        super("KML", "A simple KML example", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        ListBox kmlLBox = new ListBox();
        kmlLBox.addItem("KML - Global Science Facilities", GWT.getModuleBaseURL() + "SampleData/kml/facilities/facilities.kml");
        kmlLBox.addItem("KMZ with embedded data - GDP per capita", GWT.getModuleBaseURL() + "SampleData/kml/gdpPerCapita2008.kmz");
        kmlLBox.addItem("gx KML extensions - Bike Ride", GWT.getModuleBaseURL() + "SampleData/kml/bikeRide.kml");
        kmlLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                reset();
                ListBox source = (ListBox) changeEvent.getSource();
                final Viewer viewer = csVPanel.getViewer();
                org.cesiumjs.cs.scene.Camera camera = viewer.camera;
                CanvasElement canvas = viewer.canvas();
                camera.flyHome(0);
                KmlDataSourceOptions kmlDataSourceOptions = new KmlDataSourceOptions();//camera, canvas);
                kmlDataSourceOptions.canvas = canvas;
                kmlDataSourceOptions.camera = camera;
                if (!source.getSelectedValue().contains("bikeRide")) {
                    csVPanel.getViewer().dataSources().add(KmlDataSource.load(source.getSelectedValue(), kmlDataSourceOptions));
                } else {
                    csVPanel.getViewer().dataSources().add(KmlDataSource.load(source.getSelectedValue(), kmlDataSourceOptions)).then(new Fulfill<KmlDataSource>() {
                        @Override
                        public void onFulfilled(KmlDataSource dataSource) {
                            viewer.clock().shouldAnimate = false;
                            final Entity rider = dataSource.entities.getById("tour");
                            viewer.flyTo(rider).then(new Fulfill<Boolean>() {
                                @Override
                                public void onFulfilled(Boolean value) {
                                    viewer.trackedEntity = rider;
                                    viewer.selectedEntity = viewer.trackedEntity;
                                    viewer.clock().multiplier = 30;
                                    viewer.clock().shouldAnimate = true;
                                }
                            });
                        }
                    });
                }
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(kmlLBox, 20, 20);

        contentPanel.add(new HTML("<p>A simple KML example.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "KML.txt";
        return sourceCodeURLs;
    }

    public void reset() {
        csVPanel.getViewer().dataSources().removeAll();
        csVPanel.getViewer().clock().clockRange = ClockRange.UNBOUNDED();
        csVPanel.getViewer().clock().clockStep = ClockStep.SYSTEM_CLOCK();
    }
}