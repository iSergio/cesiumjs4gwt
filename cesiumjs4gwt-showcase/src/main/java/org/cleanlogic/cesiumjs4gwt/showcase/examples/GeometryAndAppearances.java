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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.options.ColorRandomOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.*;
import org.cesiumjs.cs.datasources.graphics.options.*;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.*;
import org.cesiumjs.cs.datasources.properties.options.CheckerboardMaterialPropertyOptions;
import org.cesiumjs.cs.datasources.properties.options.PolylineGlowMaterialPropertyOptions;
import org.cesiumjs.cs.datasources.properties.options.StripeMaterialPropertyOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio
 */
public class GeometryAndAppearances extends AbstractExample {
    @Inject
    public GeometryAndAppearances(ShowcaseExampleStore store) {
        super("Geometry and Appearances", "Demonstrates the wide variety of available geometry and appearances",
                new String[]{"Showcase", "cesium", "3d", "graphics", "materials"}, store);
    }

    private Cartesian2[] startPositions(int arms, double rOuter, double rInner) {
        double angle = Math.PI() / arms;
        List<Cartesian2> pos = new ArrayList<>();
        for (int i = 0; i < 2 * arms; i++) {
            double r = (i % 2) == 0 ? rOuter : rInner;
            Cartesian2 p = new Cartesian2(java.lang.Math.cos(i * angle) * r, java.lang.Math.sin(i * angle) * r);
            pos.add(p);
        }
        return pos.toArray(new Cartesian2[pos.size()]);
    }

    private Cartesian2[] computeCircle(double radius) {
        List<Cartesian2> pos = new ArrayList<>();
        for (int i = 0; i < 360; i++) {
            double radians = Math.toRadians(i);
            pos.add(new Cartesian2(radius * java.lang.Math.cos(radians), radius * java.lang.Math.sin(radians)));
        }
        return pos.toArray(new Cartesian2[pos.size()]);
    }

    @Override
    public void buildPanel() {
        Math.setRandomNumberSeed(1234);

        ViewerPanel csVPanel = new ViewerPanel();

        StripeMaterialPropertyOptions stripeMaterialPropertyOptions = new StripeMaterialPropertyOptions();
        stripeMaterialPropertyOptions.evenColor = new ConstantProperty<>(Color.WHITE().withAlpha(0.5f));
        stripeMaterialPropertyOptions.oddColor = new ConstantProperty<>(Color.BLUE().withAlpha(0.5f));
        stripeMaterialPropertyOptions.repeat = new ConstantProperty<>(5.0);
        StripeMaterialProperty stripeMaterialProperty = new StripeMaterialProperty(stripeMaterialPropertyOptions);

        RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-92.0, 20.0, -86.0, 27.0));
        rectangleGraphicsOptions.outline = new ConstantProperty<>(true);
        rectangleGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        rectangleGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        rectangleGraphicsOptions.stRotation = new ConstantProperty<>(Math.toRadians(45));
        rectangleGraphicsOptions.material = stripeMaterialProperty;
        RectangleGraphics rectangleGraphics = new RectangleGraphics(rectangleGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.rectangle = rectangleGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(Cartesian3
                .fromDegreesArray(new double[]{-107.0, 27.0, -107.0, 22.0, -102.0, 23.0, -97.0, 21.0, -97.0, 25.0})));
        polygonGraphicsOptions.outline = new ConstantProperty<>(true);
        polygonGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        polygonGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        polygonGraphicsOptions.material = stripeMaterialProperty;
        PolygonGraphics polygonGraphics = new PolygonGraphics(polygonGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polygon = polygonGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        EllipseGraphicsOptions ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(300000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(500000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(-40.0));
        ellipseGraphicsOptions.outline = new ConstantProperty<>(true);
        ellipseGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        ellipseGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        ellipseGraphicsOptions.stRotation = new ConstantProperty<>(Math.toRadians(22));
        ellipseGraphicsOptions.material = stripeMaterialProperty;
        EllipseGraphics ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-80.0, 25.0));
        entityOptions.ellipse = ellipseGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(250000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(250000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(-40.0));
        ellipseGraphicsOptions.outline = new ConstantProperty<>(true);
        ellipseGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        ellipseGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        ellipseGraphicsOptions.stRotation = new ConstantProperty<>(Math.toRadians(90));
        ellipseGraphicsOptions.material = stripeMaterialProperty;
        ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-72.0, 25.0));
        entityOptions.ellipse = ellipseGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-118.0, 38.0, -116.0, 40.0));
        rectangleGraphicsOptions.extrudedHeight = new ConstantProperty<>(500000.0);
        rectangleGraphicsOptions.outline = new ConstantProperty<>(true);
        rectangleGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        rectangleGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        rectangleGraphicsOptions.stRotation = new ConstantProperty<>(Math.toRadians(45));
        ColorRandomOptions colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        rectangleGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        rectangleGraphics = new RectangleGraphics(rectangleGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.rectangle = rectangleGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(100000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.height = new ConstantProperty<>(100000.0);
        ellipseGraphicsOptions.extrudedHeight = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(90.0));
        ellipseGraphicsOptions.outline = new ConstantProperty<>(true);
        ellipseGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        ellipseGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        ellipseGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-117.0, 35.0));
        entityOptions.ellipse = ellipseGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(
                Cartesian3.fromDegreesArray(new double[]{-118.0, 30.0, -115.0, 30.0, -117.1, 31.1, -118.0, 33.0})));
        polygonGraphicsOptions.height = new ConstantProperty<>(300000.0);
        polygonGraphicsOptions.extrudedHeight = new ConstantProperty<>(700000.0);
        polygonGraphicsOptions.outline = new ConstantProperty<>(true);
        polygonGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        polygonGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        polygonGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        polygonGraphics = new PolygonGraphics(polygonGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polygon = polygonGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        CylinderGraphicsOptions cylinderGraphicsOptions = new CylinderGraphicsOptions();
        cylinderGraphicsOptions.length = new ConstantProperty<>(200000.0);
        cylinderGraphicsOptions.topRadius = new ConstantProperty<>(150000.0);
        cylinderGraphicsOptions.bottomRadius = new ConstantProperty<>(150000.0);
        cylinderGraphicsOptions.outline = new ConstantProperty<>(true);
        cylinderGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        cylinderGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        cylinderGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        CylinderGraphics cylinderGraphics = new CylinderGraphics(cylinderGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-70.0, 45.0, 100000.0));
        entityOptions.cylinder = cylinderGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        for (int i = 0; i < 5; ++i) {
            double height = 100000.0 + (200000.0 * i);
            BoxGraphicsOptions boxGraphicsOptions = new BoxGraphicsOptions();
            boxGraphicsOptions.dimensions = new ConstantPositionProperty(new Cartesian3(90000.0, 90000.0, 90000.0));
            boxGraphicsOptions.outline = new ConstantProperty<>(true);
            boxGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 0.5f;
            boxGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            BoxGraphics boxGraphics = new BoxGraphics(boxGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-106.0, 45.0, height));
            entityOptions.box = boxGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));

            EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
            ellipsoidGraphicsOptions.radii = new ConstantPositionProperty(new Cartesian3(45000.0, 45000.0, 90000.0));
            ellipsoidGraphicsOptions.outline = new ConstantProperty<>(true);
            ellipsoidGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
            ellipsoidGraphicsOptions.outlineWidth = new ConstantProperty<>(2);
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 0.5f;
            ellipsoidGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            EllipsoidGraphics ellipsoidGraphics = new EllipsoidGraphics(ellipsoidGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-102.0, 45.0, height));
            entityOptions.ellipsoid = ellipsoidGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));

            ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
            ellipsoidGraphicsOptions.radii = new ConstantPositionProperty(new Cartesian3(67500.0, 67500.0, 67500.0));
            ellipsoidGraphicsOptions.outline = new ConstantProperty<>(true);
            ellipsoidGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
            ellipsoidGraphicsOptions.outlineWidth = new ConstantProperty<>(2);
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 0.5f;
            ellipsoidGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            ellipsoidGraphics = new EllipsoidGraphics(ellipsoidGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-98.0, 45.0, height));
            entityOptions.ellipsoid = ellipsoidGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));
        }

        WallGraphicsOptions wallGraphicsOptions = new WallGraphicsOptions();
        wallGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-95.0, 50.0, -85.0, 50.0, -75.0, 50.0}));
        wallGraphicsOptions.maximumHeights = new ConstantProperty<>(new double[]{500000, 1000000, 500000});
        wallGraphicsOptions.minimumHeights = new ConstantProperty<>(new double[]{0, 500000, 0});
        wallGraphicsOptions.outline = new ConstantProperty<>(true);
        wallGraphicsOptions.outlineColor = new ConstantProperty<>(Color.LIGHTGRAY());
        wallGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 0.7f;
        wallGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        WallGraphics wallGraphics = new WallGraphics(wallGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.wall = wallGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-92.0, 30.0, -85.0, 40.0));
        rectangleGraphicsOptions.material = stripeMaterialProperty;
        entityOptions = new EntityOptions();
        entityOptions.rectangle = rectangleGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        polygonGraphicsOptions = new PolygonGraphicsOptions();
        PolygonHierarchy polygonHierarchy = new PolygonHierarchy(
                Cartesian3.fromDegreesArray(new double[]{-109.0, 30.0, -95.0, 30.0, -95.0, 40.0, -109.0, 40.0}),
                new PolygonHierarchy[]{new PolygonHierarchy(
                        Cartesian3.fromDegreesArray(new double[]{-107.0, 31.0, -107.0, 39.0, -97.0, 39.0, -97.0, 31.0}),
                        new PolygonHierarchy[]{new PolygonHierarchy(
                                Cartesian3.fromDegreesArray(new double[]{-105.0, 33.0, -99.0, 33.0, -99.0, 37.0, -105.0, 37.0}),
                                new PolygonHierarchy[]{new PolygonHierarchy(Cartesian3.fromDegreesArray(
                                        new double[]{-103.0, 34.0, -101.0, 34.0, -101.0, 36.0, -103.0, 36.0}))})})});
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(polygonHierarchy);
        polygonGraphicsOptions.material = stripeMaterialProperty;
        polygonGraphics = new PolygonGraphics(polygonGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polygon = polygonGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(500000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(30.0));
        ellipseGraphicsOptions.material = stripeMaterialProperty;
        ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.ellipse = ellipseGraphics;
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-80.0, 35.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(30.0));
        ellipseGraphicsOptions.material = stripeMaterialProperty;
        ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.ellipse = ellipseGraphics;
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-72.0, 35.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-110.0, 38.0, -107.0, 40.0));
        rectangleGraphicsOptions.height = new ConstantProperty<>(700000.0);
        rectangleGraphicsOptions.extrudedHeight = new ConstantProperty<>(1000000.0);
        rectangleGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(45));
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        rectangleGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        rectangleGraphics = new RectangleGraphics(rectangleGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.rectangle = rectangleGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        ellipseGraphicsOptions = new EllipseGraphicsOptions();
        ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(100000.0);
        ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(200000.0);
        ellipseGraphicsOptions.height = new ConstantProperty<>(300000.0);
        ellipseGraphicsOptions.extrudedHeight = new ConstantProperty<>(700000.0);
        ellipseGraphicsOptions.rotation = new ConstantProperty<>(Math.toRadians(-40.0));
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        ellipseGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.ellipse = ellipseGraphics;
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-110.0, 35.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(Cartesian3
                .fromDegreesArray(new double[]{-113.0, 30.0, -110.0, 30.0, -110.0, 33.0, -111.5, 31.0, -113.0, 33.0})));
        polygonGraphicsOptions.extrudedHeight = new ConstantProperty<>(300000.0);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        polygonGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        polygonGraphics = new PolygonGraphics(polygonGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polygon = polygonGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        cylinderGraphicsOptions = new CylinderGraphicsOptions();
        cylinderGraphicsOptions.length = new ConstantProperty<>(400000.0);
        cylinderGraphicsOptions.topRadius = new ConstantProperty<>(0.0);
        cylinderGraphicsOptions.bottomRadius = new ConstantProperty<>(200000.0);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        cylinderGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        cylinderGraphics = new CylinderGraphics(cylinderGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-70.0, 40.0, 200000.0));
        entityOptions.cylinder = cylinderGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        for (int i = 0; i < 5; ++i) {
            double height = 200000.0 * i;
            ellipseGraphicsOptions = new EllipseGraphicsOptions();
            ellipseGraphicsOptions.semiMinorAxis = new ConstantProperty<>(200000.0);
            ellipseGraphicsOptions.semiMajorAxis = new ConstantProperty<>(200000.0);
            ellipseGraphicsOptions.height = new ConstantProperty<>(height);
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 0.5f;
            ellipseGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            ellipseGraphics = new EllipseGraphics(ellipseGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.ellipse = ellipseGraphics;
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-65.0, 35.0));
            csVPanel.getViewer().entities().add(new Entity(entityOptions));

            rectangleGraphicsOptions = new RectangleGraphicsOptions();
            rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-67.0, 27.0, -63.0, 32.0));
            rectangleGraphicsOptions.height = new ConstantProperty<>(height);
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 0.5f;
            rectangleGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            rectangleGraphics = new RectangleGraphics(rectangleGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.rectangle = rectangleGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));
        }

        for (int i = 0; i < 5; ++i) {
            double height = 100000.0 + (200000.0 * i);
            BoxGraphicsOptions boxGraphicsOptions = new BoxGraphicsOptions();
            boxGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian3(90000.0, 90000.0, 90000.0));
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 1.0f;
            boxGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            BoxGraphics boxGraphics = new BoxGraphics(boxGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-108.0, 45.0, height));
            entityOptions.box = boxGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));

            EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
            ellipsoidGraphicsOptions.radii = new ConstantPositionProperty(new Cartesian3(45000.0, 45000.0, 90000.0));
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 1.0f;
            ellipsoidGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            EllipsoidGraphics ellipsoidGraphics = new EllipsoidGraphics(ellipsoidGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-104.0, 45.0, height));
            entityOptions.ellipsoid = ellipsoidGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));

            ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
            ellipsoidGraphicsOptions.radii = new ConstantPositionProperty(new Cartesian3(67500.0, 67500.0, 67500.0));
            colorRandomOptions = new ColorRandomOptions();
            colorRandomOptions.alpha = 1.0f;
            ellipsoidGraphicsOptions.material = new ColorMaterialProperty(
                    new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
            ellipsoidGraphics = new EllipsoidGraphics(ellipsoidGraphicsOptions);
            entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-100.0, 45.0, height));
            entityOptions.ellipsoid = ellipsoidGraphics;
            csVPanel.getViewer().entities().add(new Entity(entityOptions));
        }

        Cartesian3[] positions = new Cartesian3[40];
        for (int i = 0; i < 40; ++i) {
            positions[i] = Cartesian3.fromDegrees(-100.0 + i, 15.0);
        }
        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions = new ConstantProperty<>(positions);
        polylineGraphicsOptions.width = new ConstantProperty<>(10.0);
        PolylineGlowMaterialPropertyOptions polylineGlowMaterialPropertyOptions = new PolylineGlowMaterialPropertyOptions();
        polylineGlowMaterialPropertyOptions.color = new ConstantProperty<>(Color.DEEPSKYBLUE());
        polylineGlowMaterialPropertyOptions.glowPower = new ConstantProperty<>(0.25);
        polylineGraphicsOptions.material = new PolylineGlowMaterialProperty(polylineGlowMaterialPropertyOptions);
        PolylineGraphics polylineGraphics = new PolylineGraphics(polylineGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polyline = polylineGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        positions = new Cartesian3[40];
        for (int i = 0; i < 40; ++i) {
            positions[i] = Cartesian3.fromDegrees(-100.0 + i, 9.0);
        }
        wallGraphicsOptions = new WallGraphicsOptions();
        wallGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(new double[]{-90.0,
                43.0, 100000.0, -87.5, 45.0, 100000.0, -85.0, 43.0, 100000.0, -87.5, 41.0, 100000.0, -90.0, 43.0, 100000.0}));
        CheckerboardMaterialPropertyOptions checkerboardMaterialPropertyOptions = new CheckerboardMaterialPropertyOptions();
        checkerboardMaterialPropertyOptions.repeat = new ConstantProperty<>(new Cartesian2(20.0, 6.0));
        wallGraphicsOptions.material = new CheckerboardMaterialProperty(checkerboardMaterialPropertyOptions);
        wallGraphics = new WallGraphics(wallGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.wall = wallGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        CorridorGraphicsOptions corridorGraphicsOptions = new CorridorGraphicsOptions();
        corridorGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-120.0, 45.0, -125.0, 50.0, -125.0, 55.0}));
        corridorGraphicsOptions.width = new ConstantProperty<>(100000);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        corridorGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        CorridorGraphics corridorGraphics = new CorridorGraphics(corridorGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.corridor = corridorGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        corridorGraphicsOptions = new CorridorGraphicsOptions();
        corridorGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-120.0, 45.0, -125.0, 50.0, -125.0, 55.0}));
        corridorGraphicsOptions.width = new ConstantProperty<>(100000);
        corridorGraphicsOptions.height = new ConstantProperty<>(300000);
        corridorGraphicsOptions.extrudedHeight = new ConstantProperty<>(400000);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 0.7f;
        corridorGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        corridorGraphics = new CorridorGraphics(corridorGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.corridor = corridorGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        corridorGraphicsOptions = new CorridorGraphicsOptions();
        corridorGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-120.0, 45.0, -125.0, 50.0, -125.0, 55.0}));
        corridorGraphicsOptions.width = new ConstantProperty<>(100000);
        corridorGraphicsOptions.height = new ConstantProperty<>(700000.0);
        corridorGraphicsOptions.outline = new ConstantProperty<>(true);
        corridorGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        corridorGraphicsOptions.outlineWidth = new ConstantProperty<>(4);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 0.7f;
        corridorGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        corridorGraphics = new CorridorGraphics(corridorGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.corridor = corridorGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        PolylineVolumeGraphicsOptions polylineVolumeGraphicsOptions = new PolylineVolumeGraphicsOptions();
        polylineVolumeGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArrayHeights(
                new double[]{-102.0, 15.0, 100000.0, -105.0, 20.0, 200000.0, -110.0, 20.0, 100000.0}));
        polylineVolumeGraphicsOptions.outline = new ConstantProperty<>(true);
        polylineVolumeGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());
        polylineVolumeGraphicsOptions.outlineWidth = new ConstantProperty<>(1);
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        polylineVolumeGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        polylineVolumeGraphicsOptions.shape = new ConstantProperty<>(startPositions(7, 30000.0, 20000.0));
        PolylineVolumeGraphics polylineVolumeGraphics = new PolylineVolumeGraphics(polylineVolumeGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polylineVolume = polylineVolumeGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        polylineVolumeGraphicsOptions = new PolylineVolumeGraphicsOptions();
        polylineVolumeGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-102.0, 15.0, -105.0, 20.0, -110.0, 20.0}));
        colorRandomOptions = new ColorRandomOptions();
        colorRandomOptions.alpha = 1.0f;
        polylineVolumeGraphicsOptions.material = new ColorMaterialProperty(
                new ConstantProperty<>(Color.fromRandom(colorRandomOptions)));
        polylineVolumeGraphicsOptions.shape = new ConstantProperty<>(startPositions(7, 30000.0, 20000.0));
        polylineVolumeGraphics = new PolylineVolumeGraphics(polylineVolumeGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polylineVolume = polylineVolumeGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        polylineVolumeGraphicsOptions = new PolylineVolumeGraphicsOptions();
        polylineVolumeGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-104.0, 13.0, -107.0, 18.0, -112.0, 18.0}));
        polylineVolumeGraphicsOptions.material = new ColorMaterialProperty(new ConstantProperty<>(Color.WHITE()));
        polylineVolumeGraphicsOptions.shape = new ConstantProperty<>(computeCircle(40000));
        polylineVolumeGraphics = new PolylineVolumeGraphics(polylineVolumeGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.polylineVolume = polylineVolumeGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        contentPanel.add(new HTML("<p>Demonstrates the wide variety of available geometry and appearances.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GeometryAndAppearances.txt";
        return sourceCodeURLs;
    }
}
