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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.PolygonHierarchy;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PolygonGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PolygonGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class GooglePhotorealistic3DTilesWithBuildingInsert  extends AbstractExample {
    @Inject
    public GooglePhotorealistic3DTilesWithBuildingInsert(ShowcaseExampleStore store) {
        super("Google Photorealistic 3D Tiles with Building Insert",
                "Google Photorealistic 3D Tiles with Building Insert",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Google"}, store, "1.106");
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.timeline = false;
        viewerOptions.animation = false;
        viewerOptions.sceneModePicker = false;
        viewerOptions.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);

        // The globe does not need to be displayed,
        // since the Photorealistic 3D Tiles include terrain
        csVPanel.getViewer().scene().globe.show = false;

        Promise<Cesium3DTileset, Void> promise = Cesium.createGooglePhotorealistic3DTileset();
        promise.then(value -> csVPanel.getViewer().scene().primitives().add(value));

        // Add highlight of target lot for development
        PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(
                new PolygonHierarchy(Cartesian3.fromDegreesArray(new double[] {
                        -105.0077102972673, 39.75198671798765,
                        -105.0095858062031, 39.75049417970743,
                        -105.00969000114443, 39.75035082687128,
                        -105.00972838875393, 39.75013579705808,
                        -105.00971742086537, 39.74997136204101,
                        -105.00962967775735, 39.749768979944236,
                        -105.00932806082336, 39.74928832007956,
                        -105.00887837739427, 39.749444324087904,
                        -105.00854934073887, 39.749663572365904,
                        -105.00822578802776, 39.749967145754084,
                        -105.00715641889735, 39.751312128419926,
                        -105.00715641889735, 39.75135429046085,
                        -105.0077102972673, 39.75198671798765}))
        );
        polygonGraphicsOptions.material = new ColorMaterialProperty(Color.YELLOW().withAlpha(0.6f));
        polygonGraphicsOptions.classificationType = new ConstantProperty<>(ClassificationType.CESIUM_3D_TILE());
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);
        Entity targetHighlight = new Entity(entityOptions);

        // Zoom to the new building location
        org.cesiumjs.cs.core.HeadingPitchRange cameraOffset = new org.cesiumjs.cs.core.HeadingPitchRange(
                Math.toRadians(95.0),
                Math.toRadians(-18.0),
                600.0);

        Cesium3DTileset[] buildingTileset = new Cesium3DTileset[1];
        // Add tileset of proposed new building
        Cesium3DTileset.fromIonAssetId(1670818).then(value -> {
            buildingTileset[0] = (Cesium3DTileset) csVPanel.getViewer().scene().primitives().add(value);
            csVPanel.getViewer().zoomTo(value, cameraOffset);
            csVPanel.getViewer().entities().add(targetHighlight);
        });

        CheckBox showBuildingCBox = new CheckBox("Show proposed building");
        showBuildingCBox.getElement().getStyle().setColor("white");
        showBuildingCBox.setWidth("100px");
        showBuildingCBox.setValue(true);
        showBuildingCBox.addValueChangeHandler(event -> buildingTileset[0].show = event.getValue());

        CheckBox highlightLocationCBox = new CheckBox("Highlight target location");
        highlightLocationCBox.getElement().getStyle().setColor("white");
        highlightLocationCBox.setWidth("100px");
        highlightLocationCBox.setValue(true);
        highlightLocationCBox.addValueChangeHandler(event -> targetHighlight.show = event.getValue());


        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(showBuildingCBox);
        hPanel.add(highlightLocationCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Google Photorealistic 3D Tiles with Building Insert.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GooglePhotorealistic3DTilesWithBuildingInsert.txt";
        return sourceCodeURLs;
    }
}
