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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.datasources.KmlDataSource;
import org.cesiumjs.cs.datasources.KmlTour;
import org.cesiumjs.cs.datasources.KmlTourEntry;
import org.cesiumjs.cs.datasources.KmlTourFlyTo;
import org.cesiumjs.cs.datasources.KmlTourWait;
import org.cesiumjs.cs.datasources.options.KmlDataSourceOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class KMLTours extends AbstractExample {
    @Inject
    public KMLTours(ShowcaseExampleStore store) {
        super("KML Tours",
                "A simple KML example.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "KMLTours", "KML", "Tours"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        KmlTour[] tour = new KmlTour[1];
        csVPanel.getViewer().dataSources().add(new KmlDataSource(KmlDataSourceOptions
                .create(csVPanel.getViewer().camera, csVPanel.getViewer().canvas()))
                .load(GWT.getModuleBaseURL() + "SampleData/kml/eiffel-tower-flyto.kml"))
                        .then(dataSource -> {
                            tour[0] = ((KmlDataSource) dataSource).kmlTours[0];
                            tour[0].tourStart.addEventListener(() -> Cesium.log("Start tour"));
                            tour[0].tourEnd.addEventListener(terminated -> Cesium.log((terminated ? "Terminate" : "End") + " tour"));
                            tour[0].entryStart.addEventListener(entry -> Cesium.log("Play " + getType(entry)));
                            tour[0].entryEnd.addEventListener((entry, terminated) -> Cesium.log((terminated ? "Terminate" : "End") + " " + getType(entry)));
                        });

        Button playBtn = new Button("Play");
        playBtn.addClickHandler(event -> tour[0].play(csVPanel.getViewer().cesiumWidget));

        Button terminateBtn = new Button("Terminate");
        terminateBtn.addClickHandler(event -> tour[0].stop());

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(5);
        hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        hPanel.add(playBtn);
        hPanel.add(terminateBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>A simple KML example.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "KMLTours.txt";
        return sourceCodeURLs;
    }

    private String getType(KmlTourEntry entry) {
        if (entry instanceof KmlTourWait) {
            return "KmlTourWait";
        } else if (entry instanceof KmlTourFlyTo) {
            return "KmlTourFlyTo";
        }
        return "";
    }
}
