/*
 * Copyright 2016 iserge.
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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Configuration;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.options.CesiumTerrainProviderOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BoxGraphics;
import org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BoxGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.EllipsoidGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.CheckerboardMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.options.CheckerboardMaterialPropertyOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.ShadowMap;
import org.cesiumjs.cs.scene.ShadowMode;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanelAbstract;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Shadows extends AbstractExample {
    ShadowMap shadowMap;

    Entity cesiumAir;
    Entity groundVehicle;
    Entity cesiumMan;
    Entity woodTower;
    Entity simpleCity;
    Entity boxEntity;
    Entity checkerEntity;
    Entity sphereEntity;
    private class Location {
        String name;
        double lon;
        double lat;
        double height;
        double date;

        public Location(String name, double lon, double lat, double height, double date) {
            this.name = name;
            this.lon = lon;
            this.lat = lat;
            this.height = height;
            this.date = date;
        }
    }
    private List<Location> locations = new ArrayList<Location>() {{
        add(new Location("Exton", -1.31968, 0.698874, 74.14210186070714, 2457522.154792));
        add(new Location("HalfDome", -2.086267733294987, 0.6587491773830219, 2640.716312584986, 2457507.247512));
        add(new Location("Everest", 1.517132688, 0.4884844964, 8773.17824498951, 2457507.620845));
        add(new Location("PinnaclePA", -1.3324415110874286, 0.6954224325279967, 179.14276256241743, 2457523.041620));
        add(new Location("SenecaRocks", -1.3851775172879768, 0.6778211831093554, 682.5893300695776, 2457522.097512));
        add(new Location("Space", -1.31968, 0.698874, 2000000.0, 2457522.154792));
    }};


    private class ViewerPanel implements IsWidget {
        private ViewerPanelAbstract _csPanelAbstract;

        private ViewerPanel() {
            super();
            asWidget();
        }

        @Override
        public Widget asWidget() {
            if (_csPanelAbstract == null) {
                final Configuration csConfiguration = new Configuration();
                csConfiguration.setPath(GWT.getModuleBaseURL() + "JavaScript/Cesium");
                _csPanelAbstract = new ViewerPanelAbstract(csConfiguration) {
                    @Override
                    public Viewer createViewer(Element element) {

                        ViewerOptions viewerOptions = new ViewerOptions();
                        viewerOptions.infoBox = false;
                        viewerOptions.selectionIndicator = false;
                        viewerOptions.shadows = true;
                        viewerOptions.terrainShadows = ShadowMode.ENABLED();
                        _viewer = new Viewer(element, viewerOptions);

                        CesiumTerrainProviderOptions cesiumTerrainProviderOptions = new CesiumTerrainProviderOptions();
                        cesiumTerrainProviderOptions.url = "https://assets.agi.com/stk-terrain/world";
                        cesiumTerrainProviderOptions.requestVertexNormals = true;
                        cesiumTerrainProviderOptions.requestWaterMask = true;
                        _viewer.terrainProvider = new CesiumTerrainProvider(cesiumTerrainProviderOptions);

                        shadowMap = _viewer.shadowMap();
                        shadowMap.maximumDistance = 10000.0;

                        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb");
                        EntityOptions entityOptions = new EntityOptions();
                        entityOptions.name = "Cesium Air";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 20.0);
                        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
                        cesiumAir = _viewer.entities().add(entityOptions);

                        modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumGround/Cesium_Ground.glb");
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Ground Vehicle";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 0.0);
                        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
                        groundVehicle = _viewer.entities().add(entityOptions);

                        modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Cesium Man";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 0.0);
                        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
                        cesiumMan = _viewer.entities().add(entityOptions);

                        modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/WoodTower/Wood_Tower.gltf");
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Wood Tower";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 0.0);
                        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
                        woodTower = _viewer.entities().add(entityOptions);

                        modelGraphicsOptions = new ModelGraphicsOptions();
                        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/ShadowTester/Shadow_Tester_4.gltf");
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Simple City";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 0.0);
                        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
                        simpleCity = _viewer.entities().add(entityOptions);

                        BoxGraphicsOptions boxGraphicsOptions = new BoxGraphicsOptions();
                        boxGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian3(10.0, 10.0, 10.0));
                        boxGraphicsOptions.material = new ColorMaterialProperty(Color.RED());
                        boxGraphicsOptions.shadows = new ConstantProperty<>(ShadowMode.ENABLED());
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Box";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 10.0);
                        entityOptions.box = new BoxGraphics(boxGraphicsOptions);
                        boxEntity = _viewer.entities().add(entityOptions);

                        CheckerboardMaterialPropertyOptions checkerboardMaterialPropertyOptions = new CheckerboardMaterialPropertyOptions();
                        checkerboardMaterialPropertyOptions.evenColor = new ConstantProperty<>(Color.RED().withAlpha(0.5f));
                        checkerboardMaterialPropertyOptions.oddColor = new ConstantProperty<>(Color.RED().withAlpha(0.0f));
                        checkerboardMaterialPropertyOptions.repeat = new ConstantProperty<>(new Cartesian2(5.0, 10.0));
                        CheckerboardMaterialProperty checkerMaterial = new CheckerboardMaterialProperty(checkerboardMaterialPropertyOptions);

                        boxGraphicsOptions = new BoxGraphicsOptions();
                        boxGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian3(10.0, 10.0, 10.0));
                        boxGraphicsOptions.material = checkerMaterial;
                        boxGraphicsOptions.outline = new ConstantProperty<>(true);
                        boxGraphicsOptions.outlineColor = new ConstantProperty<>(Color.RED());
                        boxGraphicsOptions.shadows = new ConstantProperty<>(ShadowMode.ENABLED());
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Checkered Box";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 10.0);
                        entityOptions.box = new BoxGraphics(boxGraphicsOptions);
                        checkerEntity = _viewer.entities().add(entityOptions);

                        EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
                        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(15.0, 15.0, 15.0));
                        ellipsoidGraphicsOptions.material = new ColorMaterialProperty(Color.BLUE().withAlpha(0.5f));
                        ellipsoidGraphicsOptions.slicePartitions = new ConstantProperty<>(24);
                        ellipsoidGraphicsOptions.stackPartitions = new ConstantProperty<>(36);
                        ellipsoidGraphicsOptions.shadows = new ConstantProperty<>(ShadowMode.ENABLED());
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Sphere";
                        entityOptions.properties = JsObject.create();
                        entityOptions.properties.setNumber("height", 20.0);
                        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
                        sphereEntity = _viewer.entities().add(entityOptions);

                        setLocation(locations.get(0));
                        setEntity(cesiumAir);

                        return _viewer;
                    }
                };
            }
            return _csPanelAbstract;
        }

        public void setEntity(Entity entity) {
            for (int i = 0; i < _csPanelAbstract.getViewer().entities().values().length; ++i) {
                _csPanelAbstract.getViewer().entities().values()[i].show = false;
            }
            entity.show = true;
            _csPanelAbstract.getViewer().trackedEntity = entity;
        }

        public void setLocation(Location location) {
            double lon = location.lon;
            double lat = location.lat;
            double height = location.height;

            for (int i = 0; i < _csPanelAbstract.getViewer().entities().values().length; ++i) {
                Entity entity = _csPanelAbstract.getViewer().entities().values()[i];
                entity.position = new ConstantPositionProperty(Cartesian3.fromRadians(lon, lat, height + entity.properties.getNumber("height").doubleValue()));
            }
            _csPanelAbstract.getViewer().clock().currentTime = new JulianDate(location.date);
            _csPanelAbstract.getViewer().clock().multiplier = 1.0;
        }
    }

    @Inject
    public Shadows(ShowcaseExampleStore store) {
        super("Shadows", "Cesium shadows example (configure shadows, terrain shadows)", new String[]{"Showcase", "Cesium", "3d", "Shadows", "Models"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        ListBox locationLBox = new ListBox();
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            locationLBox.addItem(location.name, i + "");
        }
        locationLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                csVPanel.setLocation(locations.get(Integer.parseInt(source.getSelectedValue())));
            }
        });

        ListBox entitiList = new ListBox();
        entitiList.addItem("Cesium Air");
        entitiList.addItem("Ground Vehicle");
        entitiList.addItem("Cesium Man");
        entitiList.addItem("Wood Tower");
        entitiList.addItem("Simple City");
        entitiList.addItem("Box");
        entitiList.addItem("Checkered Box");
        entitiList.addItem("Sphere");
        entitiList.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                switch (source.getSelectedIndex()) {
                    case 0: csVPanel.setEntity(cesiumAir); break;
                    case 1: csVPanel.setEntity(groundVehicle); break;
                    case 2: csVPanel.setEntity(cesiumMan); break;
                    case 3: csVPanel.setEntity(woodTower); break;
                    case 4: csVPanel.setEntity(simpleCity); break;
                    case 5: csVPanel.setEntity(boxEntity); break;
                    case 6: csVPanel.setEntity(checkerEntity); break;
                    case 7: csVPanel.setEntity(sphereEntity); break;
                    default: break;
                }
            }
        });

        CheckBox shadowsCBox = new CheckBox("Shadows");
        shadowsCBox.setValue(true);
        shadowsCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel._csPanelAbstract.getViewer().shadows = !csVPanel._csPanelAbstract.getViewer().shadows;
            }
        });

        CheckBox entitiShadowsCBox = new CheckBox("Entity Shadows");
        entitiShadowsCBox.setValue(true);
        entitiShadowsCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                Integer entityShadows = valueChangeEvent.getValue() ? ShadowMode.ENABLED() : ShadowMode.DISABLED();
                for (int i = 0; i < csVPanel._csPanelAbstract.getViewer().entities().values().length; i++) {
                    Entity entity = csVPanel._csPanelAbstract.getViewer().entities().values()[i];
                    if (entity.model != null) {
                        entity.model.shadows = new ConstantProperty<>(entityShadows);
                    }
                    else if (entity.box != null) {
                        entity.box.shadows = new ConstantProperty<>(entityShadows);
                    }
                    else if (entity.ellipsoid != null) {
                        entity.ellipsoid.shadows = new ConstantProperty<>(entityShadows);
                    }
                }
            }
        });

        CheckBox terrainShadowsCBox = new CheckBox("Terrain Shadows");
        terrainShadowsCBox.setValue(true);
        terrainShadowsCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel._csPanelAbstract.getViewer().terrainShadows = valueChangeEvent.getValue() ? ShadowMode.ENABLED() : ShadowMode.DISABLED();
            }
        });

        CheckBox softShadowsCBox = new CheckBox("Soft Shadows");
        softShadowsCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                shadowMap.softShadows = valueChangeEvent.getValue();
            }
        });

        ListBox sizeLBox = new ListBox();
        sizeLBox.addItem("Size: 2048", "2048");
        sizeLBox.addItem("Size: 1024", "1024");
        sizeLBox.addItem("Size: 512", "512");
        sizeLBox.addItem("Size: 256", "256");
        sizeLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                shadowMap.size = Integer.parseInt(source.getSelectedValue());
            }
        });

        VerticalPanel vPanel = new VerticalPanel();

        vPanel.add(locationLBox);
        vPanel.add(entitiList);
        vPanel.add(shadowsCBox);
        vPanel.add(entitiShadowsCBox);
        vPanel.add(terrainShadowsCBox);
        vPanel.add(softShadowsCBox);
        vPanel.add(sizeLBox);

        FlowPanel fPanel = new FlowPanel();

        AbsolutePanel aPanel = new AbsolutePanel();

        aPanel.add(csVPanel);
        aPanel.add(vPanel, 20, 20);

        fPanel.add(aPanel);

        contentPanel.add(new HTML("<p>Cesium shadows example (configure shadows, terrain shadows)</p>"));
        contentPanel.add(fPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Shadows.txt";
        return sourceCodeURLs;
    }
}
