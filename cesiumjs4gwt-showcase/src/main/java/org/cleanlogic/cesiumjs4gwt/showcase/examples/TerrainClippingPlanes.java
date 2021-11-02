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
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.collections.options.ClippingPlaneCollectionOptions;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BoxGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BoxGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.ClippingPlane;
import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio
 */
public class TerrainClippingPlanes extends AbstractExample {
    private ViewerPanel csVPanel;
    private Cesium3DTileset tileset;
    private boolean edgeStylingEnabled = true;
    private boolean clippingPlanesEnabled = true;

    @Inject
    public TerrainClippingPlanes(ShowcaseExampleStore store) {
        super("Terrain Clipping Planes", "User-defined clipping planes applied to terrain.",
                new String[]{"Showcase", "3D Tiles"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.skyAtmosphere = null;
        csVPanel = new ViewerPanel(viewerOptions);

        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain();

        loadCesiumMan();

        ListBox listBox = new ListBox();
        listBox.addItem("Cesium Man", "0");
        listBox.addItem("St. Helens", "1");
        listBox.addItem("Grand Canyon Isolated", "2");
        listBox.addChangeHandler(event -> {
            ListBox source = (ListBox) event.getSource();
            int value = Integer.parseInt(source.getSelectedValue());
            reset();
            if (value == 0) {
                loadCesiumMan();
            } else if (value == 1) {
                loadStHelens();
            } else if (value == 2) {
                loadGrandCanyon();
            }
        });

        CheckBox globeClippingCBox = new CheckBox("Globe clipping planes enabled");
        globeClippingCBox.setValue(true);
        globeClippingCBox.getElement().getStyle().setColor("white");
        globeClippingCBox.addValueChangeHandler(event -> {
            clippingPlanesEnabled = event.getValue();
            csVPanel.getViewer().scene().globe.clippingPlanes.enabled = event.getValue();
        });

        CheckBox edgeStylingCBox = new CheckBox("Edge styling enabled");
        edgeStylingCBox.setValue(true);
        edgeStylingCBox.getElement().getStyle().setColor("white");
        edgeStylingCBox.addValueChangeHandler(event -> {
            edgeStylingEnabled = event.getValue();
            csVPanel.getViewer().scene().globe.clippingPlanes.edgeWidth = edgeStylingEnabled ? 1.0 : 0.0;
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(listBox);
        hPanel.add(globeClippingCBox);
        hPanel.add(edgeStylingCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML("<p>User-defined clipping planes applied to terrain.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "TerrainClippingPlanes.txt";
        return sourceCodeURLs;
    }

    private void loadCesiumMan() {
        Cartesian3 position = Cartesian3.fromRadians(-2.0862979473351286, 0.6586620013036164, 1400.0);

        BoxGraphicsOptions boxGraphicsOptions = new BoxGraphicsOptions();
        boxGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian3(1400.0, 1400.0, 2800.0));
        boxGraphicsOptions.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.3f));
        boxGraphicsOptions.outline = new ConstantProperty<>(true);
        boxGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.box = new BoxGraphics(boxGraphicsOptions);
        Entity entity = csVPanel.getViewer().entities().add(entityOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(800);

        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);

        ClippingPlaneCollectionOptions clippingPlaneCollectionOptions = new ClippingPlaneCollectionOptions();
        clippingPlaneCollectionOptions.modelMatrix = entity.computeModelMatrix(JulianDate.now());
        clippingPlaneCollectionOptions.planes = new ClippingPlane[]{
                new ClippingPlane(new Cartesian3(1.0, 0.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(-1.0, 0.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(0.0, 1.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(0.0, -1.0, 0.0), -700.0)};
        clippingPlaneCollectionOptions.edgeWidth = 1.0;
        clippingPlaneCollectionOptions.edgeColor = Color.WHITE();

        final Globe globe = csVPanel.getViewer().scene().globe;
        globe.depthTestAgainstTerrain = true;
        globe.clippingPlanes = new ClippingPlaneCollection(clippingPlaneCollectionOptions);

        csVPanel.getViewer().trackedEntity = entity;
    }

    private Promise<Cesium3DTileset, Void> loadStHelens() {
        // Create clipping planes for polygon around area to be clipped.
        Cartesian3[] points = new Cartesian3[] {
                new Cartesian3(-2358434.3501556474, -3743554.5012105294, 4581080.771684084),
                new Cartesian3(-2357886.4482675144, -3744467.562778789, 4581020.9199767085),
                new Cartesian3(-2357299.84353055, -3744954.0879047974, 4581080.992360969),
                new Cartesian3(-2356412.05169956, -3745385.3013702347, 4580893.4737207815),
                new Cartesian3(-2355472.889436636, -3745256.5725702164, 4581252.3128526565),
                new Cartesian3(-2354385.7458722834, -3744319.3823686405, 4582372.770031389),
                new Cartesian3(-2353758.788158616, -3743051.0128084184, 4583356.453176038),
                new Cartesian3(-2353663.8128999653, -3741847.9126874236, 4584079.428665509),
                new Cartesian3(-2354213.667592133, -3740784.50946316, 4584502.428203525),
                new Cartesian3(-2355596.239450013, -3739901.0226732804, 4584515.9652557485),
                new Cartesian3(-2356942.4170108805, -3740342.454698685, 4583686.690694482),
                new Cartesian3(-2357529.554838029, -3740766.995076834, 4583145.055348843),
                new Cartesian3(-2358106.017822064, -3741439.438418052, 4582452.293605261),
                new Cartesian3(-2358539.5426236596, -3742680.720902901, 4581692.0260975715)
        };

        int pointsLength = points.length;

        // Create center points for each clipping plane
        List<ClippingPlane> clippingPlanes = new ArrayList<>();
        for (int i = 0; i < pointsLength; i++) {
            int nextIndex = (i + 1) % pointsLength;
            Cartesian3 midpoint = Cartesian3.add(points[i], points[nextIndex], new Cartesian3());
            midpoint = Cartesian3.multiplyByScalar(midpoint, 0.5, midpoint);

            Cartesian3 up = Cartesian3.normalize(midpoint, new Cartesian3());

            Cartesian3 right = Cartesian3.subtract(points[nextIndex], midpoint, new Cartesian3());
            right = Cartesian3.normalize(right, right);

            Cartesian3 normal = Cartesian3.cross(right, up, new Cartesian3());
            normal = Cartesian3.normalize(normal, normal);

            // Compute distance by pretending the plane is at the origin
            Plane originCenteredPlane = new Plane(normal, 0.0);
            double distance = Plane.getPointDistance(originCenteredPlane, midpoint);

            clippingPlanes.add(new ClippingPlane(normal, distance));
        }
        ClippingPlaneCollectionOptions options = new ClippingPlaneCollectionOptions();
        options.planes = clippingPlanes.toArray(new ClippingPlane[0]);
        options.edgeWidth = edgeStylingEnabled ? 1.0 : 0.0;
        options.edgeColor = Color.WHITE();
        options.enabled = clippingPlanesEnabled;

        Globe globe = csVPanel.getViewer().scene().globe;

        globe.clippingPlanes = new ClippingPlaneCollection(options);
        globe.backFaceCulling = true;
        globe.showSkirts = true;

        // Load tileset
        tileset = Cesium3DTileset.create(IonResource.fromAssetId(5713));
        return tileset.readyPromise().then(t -> {
            tileset.pointCloudShading.attenuation = true;

            // Adjust height so tileset is in terrain
            Cartographic cartographic = Cartographic.fromCartesian(tileset.boundingSphere().center);
            Cartesian3 surface = Cartesian3.fromRadians(cartographic.longitude, cartographic.latitude, 0.0);
            Cartesian3 offset = Cartesian3.fromRadians(cartographic.longitude, cartographic.latitude, -20.0);
            Cartesian3 translation = Cartesian3.subtract(offset, surface, new Cartesian3());
            tileset.modelMatrix = Matrix4.fromTranslation(translation);

            tileset.style = new Cesium3DTileStyle();
            JsObject.setProperty(tileset.style, "color", "rgb(207, 255, 207)");

            csVPanel.getViewer().scene().primitives().add(tileset);

            BoundingSphere boundingSphere = tileset.boundingSphere();

            double radius = boundingSphere.radius;
            csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere,
                    new HeadingPitchRange(0.5, -0.2, radius * 4.0));
            csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
        }).otherwise(v -> {Cesium.log("!!!!!");});
    }

    private void loadGrandCanyon() {
        // Pick a position at the Grand Canyon
        Cartesian3 position = Cartographic.toCartesian(Cartographic.fromDegrees(-113.2665534, 36.0939345, 100));
        double distance = 3000.0;
        BoundingSphere boundingSphere = new BoundingSphere(position, distance);

        Globe globe = csVPanel.getViewer().scene().globe;

        ClippingPlaneCollectionOptions options = new ClippingPlaneCollectionOptions();
        options.modelMatrix = Transforms.eastNorthUpToFixedFrame(position);
        options.planes = new ClippingPlane[] {
            new ClippingPlane(new Cartesian3(1.0, 0.0, 0.0), distance),
            new ClippingPlane(new Cartesian3(-1.0, 0.0, 0.0), distance),
            new ClippingPlane(new Cartesian3(0.0, 1.0, 0.0), distance),
            new ClippingPlane(new Cartesian3(0.0, -1.0, 0.0), distance)};
        options.unionClippingRegions = true;
        options.edgeWidth = edgeStylingEnabled ? 1.0 : 0.0;
        options.edgeColor = Color.WHITE();
        options.enabled = clippingPlanesEnabled;

        globe.clippingPlanes = new ClippingPlaneCollection(options);
        globe.backFaceCulling = false;
        globe.showSkirts = false;

        csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere,
                new HeadingPitchRange(0.5, -0.5, boundingSphere.radius * 5.0));
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
    }

    private void reset() {
        csVPanel.getViewer().entities().removeAll();
        csVPanel.getViewer().scene().primitives().remove(tileset);
    }
}
