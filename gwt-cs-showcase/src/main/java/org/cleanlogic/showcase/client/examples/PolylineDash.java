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
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.PolylineDashMaterialProperty;
import org.cesiumjs.cs.datasources.properties.options.PolylineDashMaterialPropertyOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class PolylineDash extends AbstractExample {

    @Inject
    public PolylineDash(ShowcaseExampleStore store) {
        super("Polyline Dash", "Draw dashed polylines.", new String[]{"Showcase", "Cesium", "3d", "polyline", "PolylineDashMaterialProperty"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        PolylineDashMaterialPropertyOptions materialPropertyOptions;
        PolylineGraphicsOptions polylineGraphicsOptions;
        EntityOptions entityOptions;

        materialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        materialPropertyOptions.color = new ConstantProperty<>(Color.RED());
        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(5);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(materialPropertyOptions);
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[] {-75, 38, 250000, -125, 38, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Red dashed line";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity redLine = csVPanel.getViewer().entities().add(entityOptions);

        materialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        materialPropertyOptions.color = new ConstantProperty<>(Color.BLUE());
        materialPropertyOptions.gapColor = new ConstantProperty<>(Color.YELLOW());
        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(30);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(materialPropertyOptions);
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[] {-75, 40, 250000, -125, 40, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Wide blue dashed line with a gap color";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity blueLine = csVPanel.getViewer().entities().add(entityOptions);

        materialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        materialPropertyOptions.color = new ConstantProperty<>(Color.ORANGE());
        materialPropertyOptions.dashLength = new ConstantProperty<>(8.0);
        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(5);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(materialPropertyOptions);
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[] {75, 42, 250000, -125, 42, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Orange dashed line with a short dash length";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity orangeLine = csVPanel.getViewer().entities().add(entityOptions);

        materialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        materialPropertyOptions.color = new ConstantProperty<>(Color.CYAN());
        materialPropertyOptions.dashPattern = new ConstantProperty<>(Integer.parseInt("110000001111", 2));
        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(10);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(materialPropertyOptions);
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[] {-75, 44, 250000, -125, 44, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Cyan dashed line with a dash pattern.";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity cyanLine = csVPanel.getViewer().entities().add(entityOptions);

        materialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        materialPropertyOptions.color = new ConstantProperty<>(Color.YELLOW());
        materialPropertyOptions.dashPattern = new ConstantProperty<>(Integer.parseInt("1010101010101010", 2));
        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(10);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(materialPropertyOptions);
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[] {-75, 46, 250000, -125, 46, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Yellow dashed line with a dash pattern.";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity yellowLine = csVPanel.getViewer().entities().add(entityOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities());

        contentPanel.add(new HTML("<p>Draw dashed polylines.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "PolylineDash.txt";
        return sourceCodeURLs;
    }
}
