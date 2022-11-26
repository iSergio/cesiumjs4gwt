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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.GregorianDate;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.PickedObject;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.CzmlDataSource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BoxGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BoxGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

public class SceneRenderingPerformance  extends AbstractExample {
    private ViewerPanel csVPanel;
    private Scene scene;
    private Cesium3DTileset tileset;
    private ScreenSpaceEventHandler handler;
    private CheckBox timeChangeEnabledCBox;
    private SliderBox maxDeltaTimeSlider;
    private Label maxDeltaTimeLbl;
    private Label autoRenderInfoLbl;
    private IntegerBox maxDeltaTimeIBox;

    @Inject
    public SceneRenderingPerformance(ShowcaseExampleStore store) {
        super("Scene Rendering Performance",
                "Use explicit rendering to improve app performance",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "performance", "render request"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.requestRenderMode = true;
        viewerOptions.maximumRenderTimeChange = Double.POSITIVE_INFINITY;
        viewerOptions.terrainProvider = Cesium.createWorldTerrain();
        csVPanel = new ViewerPanel(viewerOptions);

        scene = csVPanel.getViewer().scene();
        scene.debugShowFramesPerSecond = true;

        PushButton renderButton = new PushButton();
        renderButton.setHTML("<font color=\"white\">Render new frame</font>");
        renderButton.addClickHandler(clickHandler -> scene.requestRender());

        CheckBox requestRenderModeCBox = new CheckBox();
        requestRenderModeCBox.setHTML("<font color=\"white\">requestRenderMode enabled</font>");
        requestRenderModeCBox.setValue(true);
        requestRenderModeCBox.addValueChangeHandler(event -> {
            CheckBox source = (CheckBox) event.getSource();
            scene.requestRenderMode = source.getValue();
        });

        ListBox scenariosLBox = new ListBox();
        scenariosLBox.addItem("Default view", "0");
        scenariosLBox.addItem("Load a 3D tileset and set the view", "1");
        scenariosLBox.addItem("Mouseover picking", "2");
        scenariosLBox.addItem("Load time-dynamic CZML", "3");
        scenariosLBox.addItem("Animated model", "4");
        scenariosLBox.addItem("Scene changes with API", "5");
        scenariosLBox.addChangeHandler(this::setScenario);

        timeChangeEnabledCBox = new CheckBox();
        timeChangeEnabledCBox.setHTML("<font color=\"white\">Render when simulation time changes</font>");
        timeChangeEnabledCBox.setEnabled(false);
        timeChangeEnabledCBox.setVisible(false);

        maxDeltaTimeSlider = new SliderBox(0, 10, 20, 1);
        maxDeltaTimeSlider.setStep(1);
        maxDeltaTimeSlider.addInputHandler(this::setMaxDeltaTime);
        maxDeltaTimeSlider.setVisible(false);

        maxDeltaTimeIBox = new IntegerBox();
        maxDeltaTimeIBox.setWidth("22px");
        maxDeltaTimeIBox.setValue(10);
        maxDeltaTimeIBox.setVisible(false);

        maxDeltaTimeLbl = new Label();
        maxDeltaTimeLbl.getElement().setInnerHTML("<font color=\"white\">Max delta time</font>");

        autoRenderInfoLbl = new Label();
        autoRenderInfoLbl.getElement().setInnerHTML("<i><font size=\"-2\" color=\"white\">Automatically render when the simulation time<br> changes by \"Max delta time\". Adjust the<br> simulation time on the animation widget and<br> \"Max delta time\" value to see their relationship.</font></i>");

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\"></font>");
        flexTable.setHTML(2, 0, "<font color=\"white\">Simulation time at last render frame</font>");
        flexTable.setWidget(3, 0, renderButton);
        flexTable.setWidget(4, 0, requestRenderModeCBox);
        flexTable.setHTML(5, 0, "<i><font size=\"-2\" color=\"white\">When enabled, a new frame is only rendered<br> when scene updates occur, or a new frame is<br> explicitly rendered.</font></t>");
        flexTable.setWidget(6, 0, scenariosLBox);
        flexTable.setWidget(7, 0, timeChangeEnabledCBox);
        flexTable.setWidget(8, 0, autoRenderInfoLbl);
        flexTable.setWidget(9, 0, maxDeltaTimeLbl);
        flexTable.setWidget(10, 0, maxDeltaTimeSlider);
        flexTable.setWidget(10, 1, maxDeltaTimeIBox);

        maxDeltaTimeLbl.setVisible(false);
        autoRenderInfoLbl.setVisible(false);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>Use explicit rendering to improve app performance.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        scene.postRender().addEventListener((Event.Listener) o -> {
            GregorianDate time = JulianDate.toGregorianDate(scene.lastRenderTime());
            String value = time.hour + ":" + time.minute + ":" + time.second + ":" + NumberFormat.getFormat("0").format(time.millisecond);
            flexTable.setHTML(1, 0, "<font color=\"white\">" + value + "</font>");
        });
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "SceneRenderingPerformance.txt";
        return sourceCodeURLs;
    }

    private void setScenario(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        int value = Integer.parseInt(source.getSelectedValue());
        switch (value) {
            case 0: resetScene(); break;
            case 1: loadTilesetScenario(); break;
            case 2: pickingScenario(); break;
            case 3: loadCzmlScenario(); break;
            case 4: loadModelScenario(); break;
            case 5: setScenePropertiesScenario(); break;
            default: break;
        }

    }

    // Clear scene and set default view.
    private void resetScene() {
        csVPanel.getViewer().trackedEntity = (Entity) JsObject.undefined();
        csVPanel.getViewer().dataSources().removeAll();
        csVPanel.getViewer().entities().removeAll();
        csVPanel.getViewer().scene().primitives().remove(tileset);
        csVPanel.getViewer().clock().shouldAnimate = false;
        if (handler != null) {
            handler.destroy();
            handler = null;
        }
        scene.skyBox.show = true;
        scene.camera().flyHome(0.0);
        scene.requestRender();
        timeChangeEnabledCBox.setEnabled(false);
        timeChangeEnabledCBox.setValue(false);
        maxDeltaTimeSlider.setValue(0);

        timeChangeEnabledCBox.setVisible(false);
        maxDeltaTimeSlider.setVisible(false);
        maxDeltaTimeIBox.setVisible(false);
        maxDeltaTimeLbl.setVisible(false);
        autoRenderInfoLbl.setVisible(false);
    }

    // Load a tileset and set the view.
    // No need to call scene.requestRender()
    private void loadTilesetScenario() {
        resetScene();

        tileset = Cesium3DTileset.create(IonResource.fromAssetId(40866));
        csVPanel.getViewer().scene().primitives().add(tileset);
        csVPanel.getViewer().zoomTo(tileset);
    }

    // Load an animated model and set the view.
    // No need to call scene.requestRender()
    // Enable and adjust maximum simulation time change to see
    // animations at desired speed.
    private void loadModelScenario() {
        resetScene();
        timeChangeEnabledCBox.setEnabled(true);
        timeChangeEnabledCBox.setValue(true);
        maxDeltaTimeSlider.setValue(0);
        maxDeltaTimeLbl.setVisible(true);
        autoRenderInfoLbl.setVisible(true);
        maxDeltaTimeSlider.setVisible(true);
        maxDeltaTimeIBox.setVisible(true);
        maxDeltaTimeIBox.setValue(0);
        scene.maximumRenderTimeChange = 0;

        ModelGraphicsOptions modelOptions = new ModelGraphicsOptions();
        modelOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb");
        modelOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelOptions.maximumScale = new ConstantProperty<>(20000);

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = "Aircraft";
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-123.0744619, 44.0503706, 5000.0));
        entityOptions.model = new ModelGraphics(modelOptions);
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
        csVPanel.getViewer().clock().shouldAnimate = true;
    }

    // Load CZML DataSource with a model and set the trackedEntity.
    // No need to call scene.requestRender()
    // Enable and adjust maximum simulation time change to see
    // animations at desired speed.
    private void loadCzmlScenario() {
        resetScene();
        timeChangeEnabledCBox.setEnabled(true);
        timeChangeEnabledCBox.setValue(true);
        maxDeltaTimeSlider.setValue(10);
        maxDeltaTimeLbl.setVisible(true);
        autoRenderInfoLbl.setVisible(true);
        maxDeltaTimeSlider.setVisible(true);
        maxDeltaTimeIBox.setVisible(true);

        scene.maximumRenderTimeChange = 10.;

        csVPanel.getViewer().dataSources().add(CzmlDataSource.load(GWT.getModuleBaseURL() + "SampleData/simple.czml"));
        csVPanel.getViewer().clock().shouldAnimate = true;
    }

    // Pick an entity, only rendering when needed.
    private void pickingScenario() {
        resetScene();

        final Color[] color = {Color.CORNFLOWERBLUE()};

        CallbackProperty<Color> colorProperty = new CallbackProperty<>((time, result) -> color[0], false);
        BoxGraphicsOptions boxOptions = new BoxGraphicsOptions();
        boxOptions.dimensions = new ConstantPositionProperty(new Cartesian3(1000000.0, 1000000.0, 30000.0));
        boxOptions.material = new ColorMaterialProperty(colorProperty);


        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.box = new BoxGraphics(boxOptions);
        Entity entity = csVPanel.getViewer().entities().add(entityOptions);

        scene.requestRender();

        // If the mouse is over the box, change its scale and color,
        // then request a new render frame.
        final PickedObject<?>[] lastPicked = {null};
        handler = new ScreenSpaceEventHandler(scene.canvas());
        handler.setInputAction(event -> {
            MouseMoveEvent movement = (MouseMoveEvent) event;
            PickedObject<?> pickedObject = scene.pick(movement.endPosition);
            if (pickedObject != null && pickedObject.id == entity) {
                if (lastPicked[0] != null) {
                    return;
                }
                color[0] = Color.YELLOW();
                scene.requestRender();
                lastPicked[0] = pickedObject;
            } else if (lastPicked[0] != null) {
                color[0] = Color.CORNFLOWERBLUE();
                scene.requestRender();
                lastPicked[0] = null;
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());
    }

    // Changes to the scene with the API will require
    // calling requestRender() on change.
    private void setScenePropertiesScenario() {
        resetScene();

        scene.skyBox.show = false;
        scene.backgroundColor = Color.CORNFLOWERBLUE();
        scene.requestRender();
    }

    private void setMaxDeltaTime(InputEvent event) {
        double value = Double.parseDouble(((SliderBox) event.getSource()).getValue());
        maxDeltaTimeIBox.setValue((int) value);
        scene.maximumRenderTimeChange = value;
    }
}