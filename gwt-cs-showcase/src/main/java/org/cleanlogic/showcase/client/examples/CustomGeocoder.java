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
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.GeocoderResult;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CustomGeocoder extends AbstractExample {
    private ViewerPanel csVPanel;
    @Inject
    public CustomGeocoder(ShowcaseExampleStore store) {
        super("Custom Geocoder", "Example of a custom geocoder. It provides geocoding through the OpenStreetMap Nominatim service.", new String[]{"Showcase", "Cesium", "3d", "Custom Geocoder", "OpenStreetMap", "osm"}, store);
    }

    @Override
    public void buildPanel() {
        OpenStreetMapNominatimGeocoder openStreetMapNominatimGeocoder = new OpenStreetMapNominatimGeocoder();
        openStreetMapNominatimGeocoder.geocode = new OpenStreetMapNominatimGeocoder.Geocode() {
            @Override
            public Promise<JsObject, String> function(String input) {
                String endpoint = "http://nominatim.openstreetmap.org/search?";
                String query = "format=json&q=" + input;
                String requestString = endpoint + query;
                Promise<JsObject, String> promise = Cesium.loadJson(requestString);
                promise.then(new Fulfill<JsObject>() {
                    @Override
                    public void onFulfilled(JsObject value) {
                        JSONArray jsonArray = new JSONArray(value);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject jsonObject = jsonArray.get(i).isObject();
                            JSONArray bboxDegrees = jsonObject.get("boundingbox").isArray();
                            Rectangle destination = Rectangle.fromDegrees(
                                    Double.parseDouble(bboxDegrees.get(2).isString().toString().replace("\"", "")),
                                    Double.parseDouble(bboxDegrees.get(0).isString().toString().replace("\"", "")),
                                    Double.parseDouble(bboxDegrees.get(3).isString().toString().replace("\"", "")),
                                    Double.parseDouble(bboxDegrees.get(1).isString().toString().replace("\"", "")));

                            GeocoderResult geocoderResult = new GeocoderResult();
                            geocoderResult.displayName = jsonObject.get("display_name").isString().toString();
                            geocoderResult.destinationRectangle = destination;
                            jsonArray.set(i, new JSONObject((JsObject) (Object) geocoderResult));
                        }
                    }
                });
                return promise;
            }
        };
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.geocoder = openStreetMapNominatimGeocoder;
        csVPanel = new ViewerPanel(viewerOptions);
        contentPanel.add(new HTML("<p>Example of a custom geocoder.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomGeocoder.txt";
        return sourceCodeURLs;
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    private static class OpenStreetMapNominatimGeocoder {
        @JsProperty(name = "geocode")
        public Geocode geocode;

        @JsFunction
        public interface Geocode {
            Promise<JsObject, String> function(String input);
        }
    }
}
