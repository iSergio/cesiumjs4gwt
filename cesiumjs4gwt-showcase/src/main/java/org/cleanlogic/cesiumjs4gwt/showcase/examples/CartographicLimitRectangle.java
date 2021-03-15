/*
 * Copyright 2018 iserge.
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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.RectangleGraphics;
import org.cesiumjs.cs.datasources.graphics.options.RectangleGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio
 */
public class CartographicLimitRectangle extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public CartographicLimitRectangle(ShowcaseExampleStore store) {
        super("Cartographic Limit Rectangle", "Limit terrain and imagery to a cartographic Rectangle area.",
                new String[]{"Terrain", "Cartographic", "Limit", "Rectangle"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.terrainProvider = Cesium.createWorldTerrain();
        csVPanel = new ViewerPanel(viewerOptions);

        // Tropics of Cancer and Capricorn
        final Rectangle coffeeBeltRectangle = Rectangle.fromDegrees(-180.0, -23.43687, 180.0, 23.43687);

        csVPanel.getViewer().scene().globe.cartographicLimitRectangle = coffeeBeltRectangle;
        csVPanel.getViewer().scene().skyAtmosphere.show = false;

        // Add rectangles to show bounds
        final List<Entity> rectangles = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
            rectangleGraphicsOptions.coordinates = new ConstantProperty<>(coffeeBeltRectangle);
            rectangleGraphicsOptions.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.0f));
            rectangleGraphicsOptions.height = new ConstantProperty<>(i * 5000.0);
            rectangleGraphicsOptions.outline = new ConstantProperty<>(true);
            rectangleGraphicsOptions.outlineWidth = new ConstantProperty<>(4.0);
            rectangleGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

            EntityOptions entityOptions = new EntityOptions();
            entityOptions.rectangle = new RectangleGraphics(rectangleGraphicsOptions);

            rectangles.add(csVPanel.getViewer().entities().add(entityOptions));
        }

        CheckBox enableLimitCBox = new CheckBox();
        enableLimitCBox.setWidth("100px");
        enableLimitCBox.setValue(true);
        enableLimitCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                csVPanel.getViewer().scene().globe.cartographicLimitRectangle = event.getValue() ? coffeeBeltRectangle
                        : Rectangle.MAX_VALUE();
            }
        });

        CheckBox showBoundsBox = new CheckBox();
        showBoundsBox.setWidth("100px");
        showBoundsBox.setValue(true);
        showBoundsBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                for (Entity rectangle : rectangles) {
                    rectangle.show = event.getValue();
                }
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Limit Enabled</font>");
        flexTable.setWidget(1, 1, enableLimitCBox);
        flexTable.setHTML(2, 0, "<font color=\"white\">Show Bounds</font>");
        flexTable.setWidget(2, 1, showBoundsBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Limit terrain and imagery to a cartographic Rectangle area.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CartographicLimitRectangle.txt";
        return sourceCodeURLs;
    }
}
