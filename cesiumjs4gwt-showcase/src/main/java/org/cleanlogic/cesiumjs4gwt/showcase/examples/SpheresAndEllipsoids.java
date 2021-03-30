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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics;
import org.cesiumjs.cs.datasources.graphics.options.EllipsoidGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class SpheresAndEllipsoids extends AbstractExample {

    @Inject
    public SpheresAndEllipsoids(ShowcaseExampleStore store) {
        super("Spheres and Ellipsoids", "Draw spheres and ellipsoids",
                new String[]{"Showcase", "Cesium", "3d", "Ellipsoid", "Spheres"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(200000.0, 200000.0, 300000.0));
        ellipsoidGraphicsOptions.material = new ColorMaterialProperty(new ConstantProperty<>(Color.BLUE()));
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = "Blue ellipsoid";
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-114.0, 40.0, 300000.0));
        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
        Entity blueEllpsoid = csVPanel.getViewer().entities().add(entityOptions);

        ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(300000.0, 300000.0, 300000.0));
        ellipsoidGraphicsOptions.material = new ColorMaterialProperty(new ConstantProperty<>(Color.RED().withAlpha(0.5f)));
        ellipsoidGraphicsOptions.outline = new ConstantProperty<>(true);
        ellipsoidGraphicsOptions.outlineColor = new ConstantProperty<>(Color.BLACK());
        entityOptions = new EntityOptions();
        entityOptions.name = "Red sphere with black outline";
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-107.0, 40.0, 300000.0));
        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
        Entity redSphere = csVPanel.getViewer().entities().add(entityOptions);

        ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(200000.0, 200000.0, 300000.0));
        ellipsoidGraphicsOptions.outline = new ConstantProperty<>(true);
        ellipsoidGraphicsOptions.outlineColor = new ConstantProperty<>(Color.YELLOW());
        ellipsoidGraphicsOptions.fill = new ConstantProperty<>(false);
        ellipsoidGraphicsOptions.slicePartitions = new ConstantProperty<>(24);
        ellipsoidGraphicsOptions.stackPartitions = new ConstantProperty<>(36);
        entityOptions = new EntityOptions();
        entityOptions.name = "Yellow ellipsoid outline";
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-100.0, 40.0, 300000.0));
        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
        Entity outlineOnly = csVPanel.getViewer().entities().add(entityOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities());

        contentPanel.add(new HTML("<p>Draw spheres and ellipsoids.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "SpheresAndEllipsoids.txt";
        return sourceCodeURLs;
    }
}
