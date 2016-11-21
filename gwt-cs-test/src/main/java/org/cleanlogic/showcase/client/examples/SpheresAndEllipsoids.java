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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.cesiumjs.cs.Configuration;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics;
import org.cesiumjs.cs.datasources.graphics.options.EllipsoidGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanelAbstract;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class SpheresAndEllipsoids extends AbstractExample {
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
                        Viewer csViewer = new Viewer(element);

                        EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
                        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(200000.0, 200000.0, 300000.0));
                        ellipsoidGraphicsOptions.material = new ColorMaterialProperty(new ConstantProperty<>(Color.BLUE()));
                        EntityOptions entityOptions = new EntityOptions();
                        entityOptions.name = "Blue ellipsoid";
                        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-114.0, 40.0, 300000.0));
                        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
                        Entity blueEllpsoid = csViewer.entities().add(new Entity(entityOptions));

                        ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
                        ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(300000.0, 300000.0, 300000.0));
                        ellipsoidGraphicsOptions.material = new ColorMaterialProperty(new ConstantProperty<>(Color.RED().withAlpha(0.5f)));
                        ellipsoidGraphicsOptions.outline = new ConstantProperty<>(true);
                        ellipsoidGraphicsOptions.outlineColor = new ConstantProperty<>(Color.BLACK());
                        entityOptions = new EntityOptions();
                        entityOptions.name = "Red sphere with black outline";
                        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-107.0, 40.0, 300000.0));
                        entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);
                        Entity redSphere = csViewer.entities().add(new Entity(entityOptions));

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
                        Entity outlineOnly = csViewer.entities().add(new Entity(entityOptions));

                        csViewer.zoomTo(csViewer.entities());

                        return csViewer;
                    }
                };
            }
            return _csPanelAbstract;
        }
    }

    @Inject
    public SpheresAndEllipsoids(ShowcaseExampleStore store) {
        super("Spheres and Ellipsoids", "Example draw spheres and ellipsoids", new String[]{"Showcase", "Cesium", "3d", "Ellipsoid", "Spheres"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        contentPanel.add(new HTML("<p>Example draw spheres and ellipsoids</p>"));
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
