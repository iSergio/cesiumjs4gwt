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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.PickedObject;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.*;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class PerFeaturePostProcessing extends AbstractExample {
    private ViewerPanel csVPanel;
    private ScreenSpaceEventHandler handler;
    @Inject
    public PerFeaturePostProcessing(ShowcaseExampleStore store) {
        super("Per-Feature Post Processing", "Post processing effects.", new String[]{"Post process"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(viewerOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        EntityOptions options = new EntityOptions();
        options.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb";
        options.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-123.0744619, 44.0503706));
        options.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(options);

        if (!PostProcessStageLibrary.isSilhouetteSupported(csVPanel.getViewer().scene())) {
            Cesium.log("This browser does not support the silhouette post process.");
        }

        PostProcessStageCollection stages = csVPanel.getViewer().scene().postProcessStages;
        PostProcessStageComposite postProcessStageComposite = PostProcessStageLibrary.createSilhouetteStage();
        postProcessStageComposite.uniforms = JsObject.create();
        postProcessStageComposite.uniforms.setProperty("color", Color.LIME());
        final PostProcessStageComposite silhouette = stages.add(postProcessStageComposite);

        PostProcessStage postProcessStage = PostProcessStageLibrary.createBlackAndWhiteStage();
        postProcessStage.uniforms().setProperty("gradations", 5.0);
        final PostProcessStage blackAndWhite = stages.add(PostProcessStageLibrary.createBlackAndWhiteStage());

        ListBox selectionLBox = new ListBox();
        selectionLBox.addItem("Mouse-over Black and White", "0");
        selectionLBox.addItem("Mouse-over Silhouette", "1");
        selectionLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ListBox source = (ListBox) event.getSource();
                if (source.getSelectedValue().equalsIgnoreCase("0")) {
                    blackAndWhite.enabled = true;
                    silhouette.enabled = false;

                    removeMouseOver(silhouette);
                    addMouseOver(blackAndWhite);
                } else if (source.getSelectedValue().equalsIgnoreCase("1")) {
                    blackAndWhite.enabled = false;
                    silhouette.enabled = true;

                    removeMouseOver(blackAndWhite);
                    addMouseOver(silhouette);
                }
            }
        });
        selectionLBox.setSelectedIndex(0);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(selectionLBox, 20, 20);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        blackAndWhite.enabled = true;
        silhouette.enabled = false;

        removeMouseOver(silhouette);
        addMouseOver(blackAndWhite);
    }

    private void addMouseOver(final PostProcess stage) {
        handler = new ScreenSpaceEventHandler(csVPanel.getViewer().scene().canvas());
        handler.setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseMoveEvent mouseMoveEvent = (MouseMoveEvent) event;
                PickedObject pickedObject = csVPanel.getViewer().scene().pick(mouseMoveEvent.endPosition);
                if (pickedObject != null) {
                    JsObject.setProperty(stage, "selected", new Primitive[] {pickedObject.primitive});
                } else {
                    JsObject.setProperty(stage, "selected", new Primitive[0]);
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    void removeMouseOver(PostProcess stage) {
        if (handler != null) {
            handler.destroy();
            handler = null;
        }
        JsObject.setProperty(stage, "selected", new Primitive[0]);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "PerFeaturePostProcessing.txt";
        return sourceCodeURLs;
    }
}
