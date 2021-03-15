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
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.collections.options.FromIso8601DateArrayOptions;
import org.cesiumjs.cs.collections.options.FromIso8601OptionsAbstract;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.HeadingPitchRange;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.TimeInterval;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.options.TimeDynamicPointCloudOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class TimeDynamicPointCloud extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public TimeDynamicPointCloud(ShowcaseExampleStore store) {
        super("Time Dynamic Point Cloud",
                "Render a time dynamic point cloud from a set of Point Cloud tiles and timestamps",
                new String[]{"Point cloud", "real time"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(viewerOptions);

        String[] dates = new String[]{"2018-07-19T15:18:00Z", "2018-07-19T15:18:00.5Z", "2018-07-19T15:18:01Z",
                "2018-07-19T15:18:01.5Z", "2018-07-19T15:18:02Z", "2018-07-19T15:18:02.5Z"};

        final String[] uris = new String[]{
                GWT.getModuleBaseURL() + "SampleData/Cesium3DTiles/PointCloud/PointCloudTimeDynamic/0.pnts",
                GWT.getModuleBaseURL() + "SampleData/Cesium3DTiles/PointCloud/PointCloudTimeDynamic/1.pnts",
                GWT.getModuleBaseURL() + "SampleData/Cesium3DTiles/PointCloud/PointCloudTimeDynamic/2.pnts",
                GWT.getModuleBaseURL() + "SampleData/Cesium3DTiles/PointCloud/PointCloudTimeDynamic/3.pnts",
                GWT.getModuleBaseURL() + "SampleData/Cesium3DTiles/PointCloud/PointCloudTimeDynamic/4.pnts",};

        FromIso8601DateArrayOptions<JsObject> dateArrayOptions = FromIso8601DateArrayOptions.create(dates);
        dateArrayOptions.dataCallback = new FromIso8601OptionsAbstract.DataCallback<JsObject>() {
            @Override
            public JsObject function(TimeInterval interval, int index) {
                JsObject result = JsObject.create();
                result.setProperty("uri", uris[index]);
                return result;
            }
        };
        TimeIntervalCollection timeIntervalCollection = TimeIntervalCollection.fromIso8601DateArray(dateArrayOptions);

        TimeDynamicPointCloudOptions timeDynamicPointCloudOptions = TimeDynamicPointCloudOptions
                .create(csVPanel.getViewer().clock(), timeIntervalCollection);
        timeDynamicPointCloudOptions.style = new Cesium3DTileStyle();
        timeDynamicPointCloudOptions.style.pointSizeDouble = 5.0;
        org.cesiumjs.cs.scene.TimeDynamicPointCloud pointCloud = new org.cesiumjs.cs.scene.TimeDynamicPointCloud(
                timeDynamicPointCloudOptions);

        csVPanel.getViewer().scene().primitives().add(pointCloud);

        JulianDate start = JulianDate.fromIso8601(dates[0]);
        JulianDate stop = JulianDate.fromIso8601(dates[dates.length - 1]);

        csVPanel.getViewer().timeline().zoomTo(start, stop);

        Clock clock = csVPanel.getViewer().clock();
        clock.startTime = start;
        clock.currentTime = start;
        clock.stopTime = stop;
        clock.clockRange = ClockRange.LOOP_STOP();

        csVPanel.getViewer().zoomTo(pointCloud, new HeadingPitchRange(0.0, -0.5, 50.0));

        contentPanel
                .add(new HTML("<p>Render a time dynamic point cloud from a set of Point Cloud tiles and timestamps.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "TimeDynamicPointCloud.txt";
        return sourceCodeURLs;
    }
}