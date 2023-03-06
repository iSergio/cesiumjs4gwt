/*
 * Copyright 2023 iSergio, Gis4Fun.
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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class AerometrexSanFrancisco extends AbstractExample {
    private Viewer viewer;

    @Inject
    public AerometrexSanFrancisco(ShowcaseExampleStore store) {
        super("Aerometrex San Francisco",
                "Aerometrex San Francisco High Resolution 3D Model with Street Level Enhanced 3D, available on ion until March 15, 2023.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store, "1.102");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.terrainProvider = Cesium.createWorldTerrain();
        ViewerPanel csVPanel = new ViewerPanel(options);

        viewer = csVPanel.getViewer();

        // Aerometrex San Francisco High Resolution 3D Model with Street Level Enhanced 3D
        Cesium3DTilesetOptions tilesetOptions = Cesium3DTilesetOptions.create(IonResource.fromAssetId(1415196));
        tilesetOptions.maximumScreenSpaceError = 4;
        Cesium3DTileset tileset = (Cesium3DTileset) viewer.scene().primitives().add(new Cesium3DTileset(tilesetOptions));

        ListBox lBox = new ListBox();
        lBox.addItem("Ferry Building");
        lBox.addItem("Pier 39");
        lBox.addItem("Skyline");
        lBox.addItem("Lombard Street");
        lBox.addChangeHandler(this::changeHandler);

        FlexTable flexTable = new FlexTable();
        flexTable.setWidget(1, 0, lBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>" + example.getDescription() + "</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        lBox.setItemSelected(0, true);
        DomEvent.fireNativeEvent(Document.get().createChangeEvent(), lBox);
    }

    private void changeHandler(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        switch (source.getSelectedIndex()) {
            case 0: viewFerryBuilding(); break;
            case 1: viewPier39(); break;
            case 2: viewSkyline(); break;
            case 3: viewLombardStreet(); break;
            default: break;
        }
    }

    // Ferry Building – Street Level Enhanced mesh with a resolution of ~6mm per pixel
    private void viewFerryBuilding() {
        CameraFlyToOptions options = new CameraFlyToOptions();
        options.destinationPos = new Cartesian3(-2703541.419456986, -4261164.971874713, 3887416.257562123);
        options.orientation = new HeadingPitchRoll(5.959123393581913, -0.03131876941215883, 0.0000033030489428043097);
        viewer.scene().camera().flyTo(options);
    }

    // Pier 39 - 2 cm/pixel resolution
    private void viewPier39() {
        CameraFlyToOptions options = new CameraFlyToOptions();
        options.destinationPos = new Cartesian3(-2704263.584923937, -4259336.981155519, 3888978.5732662966);
        options.orientation = new HeadingPitchRoll(2.4287691459386607, -0.49459905591668996, 0.0000029701571779838787);
        viewer.scene().camera().flyTo(options);
    }

    // Skyline - 2 cm/pixel resolution
    private void viewSkyline() {
        CameraFlyToOptions options = new CameraFlyToOptions();
        options.destinationPos = new Cartesian3(-2702979.5635104137, -4261981.190435306, 3887092.144148863);
        options.orientation = new HeadingPitchRoll(4.534265054628527, -0.08846186652294352, 0.0000075141499165098935);
        viewer.scene().camera().flyTo(options);
    }

    // Lombard Street - 2 cm/pixel resolution
    private void viewLombardStreet() {
        CameraFlyToOptions options = new CameraFlyToOptions();
        options.destinationPos = new Cartesian3(-2705631.6783492276, -4259449.36938678, 3887903.89229016);
        options.orientation = new HeadingPitchRoll(5.999439616451804, -0.20513082834763674, 4.7213266807233367e-7);
        viewer.scene().camera().flyTo(options);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "AerometrexSanFrancisco.txt";
        return sourceCodeURLs;
    }
}
