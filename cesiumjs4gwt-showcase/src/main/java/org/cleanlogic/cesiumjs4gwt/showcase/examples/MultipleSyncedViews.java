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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.widgets.ClockViewModel;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class MultipleSyncedViews extends AbstractExample {
    private ViewerPanel view3D;
    private ViewerPanel view2D;

    private Cartesian3 worldPosition;
    private double distance;

    @Inject
    public MultipleSyncedViews(ShowcaseExampleStore store) {
        super("Multiple Synced Views", "Multiple views synced across time and space", new String[]{"sync"}, store);
    }

    @Override
    public void buildPanel() {
        ClockViewModel clockViewModel = new ClockViewModel();

        ViewerOptions viewer3dOptions = new ViewerOptions();
        viewer3dOptions.fullscreenButton = false;
        viewer3dOptions.sceneModePicker = false;
        viewer3dOptions.clockViewModel = clockViewModel;
        view3D = new ViewerPanel(viewer3dOptions);
        view3D.setWidth("500px");
        view3D.getViewer().camera.changed().addEventListener(new Event.Listener() {
            @Override
            public void function(Object... o) {
                sync2DView();
            }
        });
        view3D.getViewer().camera.percentageChanged = 0.01f;

        ViewerOptions viewer2dOptions = new ViewerOptions();
        viewer2dOptions.homeButton = false;
        viewer2dOptions.fullscreenButton = false;
        viewer2dOptions.sceneModePicker = false;
        viewer2dOptions.clockViewModel = clockViewModel;
        viewer2dOptions.infoBox = false;
        viewer2dOptions.geocoder = false;
        viewer2dOptions.sceneMode = SceneMode.SCENE2D();
        viewer2dOptions.navigationHelpButton = false;
        viewer2dOptions.animation = false;
        view2D = new ViewerPanel(viewer2dOptions);
        view2D.setWidth("500px");
        view2D.getViewer().scene().screenSpaceCameraController().enableRotate = false;
        view2D.getViewer().scene().screenSpaceCameraController().enableTranslate = false;
        view2D.getViewer().scene().screenSpaceCameraController().enableZoom = false;
        view2D.getViewer().scene().screenSpaceCameraController().enableTilt = false;
        view2D.getViewer().scene().screenSpaceCameraController().enableLook = false;

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(view3D);
        hPanel.add(view2D);

        contentPanel.add(new HTML("<p>Multiple views synced across time and space.</p>"));
        contentPanel.add(hPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "MultipleSyncedViews.txt";
        return sourceCodeURLs;
    }

    private void sync2DView() {
        // The center of the view is the point that the 3D camera is focusing on
        Cartesian2 viewCenter = new Cartesian2(Math.floor(view3D.getViewer().canvas().getClientWidth() / 2),
                Math.floor(view3D.getViewer().canvas().getClientHeight() / 2));
        // Given the pixel in the center, get the world position
        Cartesian3 newWorldPosition = view3D.getViewer().scene().camera().pickEllipsoid(viewCenter);
        if (newWorldPosition != null) {
            // Guard against the case where the center of the screen
            // does not fall on a position on the globe
            worldPosition = newWorldPosition;
        }
        // Get the distance between the world position of the point the camera is
        // focusing on, and the camera's world position
        distance = Cartesian3.distance(worldPosition, view3D.getViewer().scene().camera().positionWC());
        // Tell the 2D camera to look at the point of focus. The distance controls how
        // zoomed in the 2D view is
        // (try replacing `distance` in the line below with `1e7`. The view will still
        // sync, but will have a constant zoom)
        view2D.getViewer().scene().camera().lookAt(worldPosition, new Cartesian3(0.0, 0.0, distance));
    }
}
