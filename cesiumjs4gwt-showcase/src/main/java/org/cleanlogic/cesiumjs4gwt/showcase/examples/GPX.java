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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.collections.DataSourceCollection;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.PinBuilder;
import org.cesiumjs.cs.datasources.GpxDataSource;
import org.cesiumjs.cs.datasources.options.GpxDataSourceOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class GPX extends AbstractExample {
    private ViewerPanel csVPanel;
    private PinBuilder pinBuilder;
    @Inject
    public GPX(ShowcaseExampleStore store) {
        super("GPX",
                "A simple GPX example.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "GPX"}, store, "1.91");
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        pinBuilder = new PinBuilder();

        ListBox modelLBox = new ListBox();
        modelLBox.addItem("Track with Waypoints", "0");
        modelLBox.addItem("Route", "1");
        modelLBox.addItem("Waypoints", "2");
        modelLBox.addItem("Multiple Tracks with Waypoints", "3");
        modelLBox.addItem("Symbology Options", "4");
        modelLBox.addChangeHandler(this::setModel);

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(modelLBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>A simple GPX example.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), modelLBox);
    }

    @SuppressWarnings("unchecked")
    private void setModel(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        int value = Integer.parseInt(source.getSelectedValue());

        DataSourceCollection dataSources = csVPanel.getViewer().dataSources();
        if (value == 0) {
            dataSources.add(GpxDataSource.load(GWT.getModuleBaseURL() + "SampleData/gpx/lamina.gpx",
                            new GpxDataSourceOptions().setClampToGround(true))
            ).then(dataSource -> csVPanel.getViewer().flyTo(((GpxDataSource) dataSource).entities));
        } if (value == 1) {
            dataSources.add(GpxDataSource.load(GWT.getModuleBaseURL() + "SampleData/gpx/route.gpx",
                            new GpxDataSourceOptions().setClampToGround(true))
            ).then(dataSource -> csVPanel.getViewer().flyTo(((GpxDataSource) dataSource).entities));
        } if (value == 2) {
            dataSources.add(GpxDataSource.load(GWT.getModuleBaseURL() + "SampleData/gpx/wpt.gpx",
                    new GpxDataSourceOptions().setClampToGround(true))
            ).then(dataSource -> csVPanel.getViewer().flyTo(((GpxDataSource) dataSource).entities));
        } if (value == 3) {
            dataSources.add(GpxDataSource.load(GWT.getModuleBaseURL() + "SampleData/gpx/complexTrk.gpx",
                    new GpxDataSourceOptions().setClampToGround(true))
            ).then(dataSource -> csVPanel.getViewer().flyTo(((GpxDataSource) dataSource).entities));
        } if (value == 4) {
            dataSources.add(GpxDataSource.load(GWT.getModuleBaseURL() + "SampleData/gpx/lamina.gpx",
                    new GpxDataSourceOptions()
                            .setClampToGround(true)
                            .setTrackColor(Color.YELLOW())
                            .setWaypointImage(pinBuilder.fromMakiIconId("bicycle", Color.BLUE(), 48))
            )).then(dataSource -> csVPanel.getViewer().flyTo(((GpxDataSource) dataSource).entities));
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GPX.txt";
        return sourceCodeURLs;
    }
}
