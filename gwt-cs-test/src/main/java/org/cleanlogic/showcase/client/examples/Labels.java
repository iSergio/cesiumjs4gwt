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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.NearFarScalar;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.LabelStyle;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Labels extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public Labels(ShowcaseExampleStore store) {
        super("Labels", "Create labels on scene", new String[]{"Showcase", "Cesium", "3d", "labels"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        addLabel();

        ListBox labelsLBox = new ListBox();
        labelsLBox.addItem("Add label", "0");
        labelsLBox.addItem("Set font", "1");
        labelsLBox.addItem("Set properties", "2");
        labelsLBox.addItem("Offset label by distance", "3");
        labelsLBox.addItem("Fade label by distance", "4");
        labelsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ListBox source = (ListBox) event.getSource();
                reset();
                switch (source.getSelectedValue()) {
                    case "0": addLabel(); break;
                    case "1": setFont(); break;
                    case "2": setProperties(); break;
                    case "3": offsetByDistance(); break;
                    case "4": fadeByDistance(); break;
                    default: break;
                }
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(labelsLBox, 20, 20);

        contentPanel.add(new HTML("<p>Create Labels</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Labels.txt";
        return sourceCodeURLs;
    }

    private void reset() {
        csVPanel.getViewer().entities().removeAll();
    }

    private void addLabel() {
        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("Philadelphia");

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.1641667, 39.9522222));
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);
    }

    private void setFont() {
        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("Philadelphia");
        labelGraphicsOptions.font = new ConstantProperty<>("24px Helvetica");
        labelGraphicsOptions.fillColor = new ConstantProperty<>(Color.SKYBLUE());
        labelGraphicsOptions.outlineColor = new ConstantProperty<>(Color.BLACK());
        labelGraphicsOptions.outlineWidth = new ConstantProperty<>(2);
        labelGraphicsOptions.style = new ConstantProperty<>(LabelStyle.FILL_AND_OUTLINE());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.1641667, 39.9522222));
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);
    }

    private void setProperties() {
        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("Philadelphia");

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.1641667, 39.9522222, 300000.0));
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        Entity entity = csVPanel.getViewer().entities().add(entityOptions);

        entity.label.scale = new ConstantProperty<>(2.0);
        entity.label.showBackground = new ConstantProperty<>(true);
    }

    private void offsetByDistance() {
        final JsImage image = new JsImage();
        image.onload = new JsImage.Listener() {
            @Override
            public void function(Object... o) {
                BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
                billboardGraphicsOptions.scaleByDistance = new ConstantProperty<>(new NearFarScalar(1.5e2, 5.0, 1.5e7, 0.5));
                billboardGraphicsOptions.image = new ConstantProperty<>(image);

                LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
                labelGraphicsOptions.text = new ConstantProperty<>("Label on top of scaling billboard");
                labelGraphicsOptions.font = new ConstantProperty<>("20px sans-serif");
                labelGraphicsOptions.showBackground = new ConstantProperty<>(true);
                labelGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.CENTER());
                labelGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(0.0, -image.height));
                labelGraphicsOptions.pixelOffsetScaleByDistance = new ConstantProperty<>(new NearFarScalar(1.5e2, 3.0, 1.5e7, 0.5));

                EntityOptions entityOptions = new EntityOptions();
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.1641667, 39.9522222));
                entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
                entityOptions.label = new LabelGraphics(labelGraphicsOptions);
                csVPanel.getViewer().entities().add(entityOptions);
            }
        };
        image.src = GWT.getModuleBaseURL() + "images/facility.gif";
    }

    private void fadeByDistance() {
        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("New York");
        labelGraphicsOptions.translucencyByDistance = new ConstantProperty<>(new NearFarScalar(1.5e2, 1.0, 1.5e8, 0.0));

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-73.94, 40.67));
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);

        labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("'Atlanta'");
        labelGraphicsOptions.translucencyByDistance = new ConstantProperty<>(new NearFarScalar(1.5e5, 1.0, 1.5e7, 0.0));

        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-84.39, 33.75));
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);
    }
}
