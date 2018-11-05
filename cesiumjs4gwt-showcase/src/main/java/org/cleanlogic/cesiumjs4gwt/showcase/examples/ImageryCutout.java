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
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.scene.providers.IonImageryProvider;
import org.cesiumjs.cs.scene.providers.SingleTileImageryProvider;
import org.cesiumjs.cs.scene.providers.options.IonImageryProviderOptions;
import org.cesiumjs.cs.scene.providers.options.SingleTileImageryProviderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ImageryCutout extends AbstractExample {

    private class Flags {
        boolean moveEast = false;
        boolean moveWest = false;
        boolean moveNorth = false;
        boolean moveSouth = false;

        public Flags() {}
    }

    private ViewerPanel csVPanel;
    private Flags flags = new Flags();

    @Inject
    public ImageryCutout(ShowcaseExampleStore store) {
        super("Imagery Cutout", "Demonstration of imagery layers with rectangular cutouts.", new String[]{"ImageryLayer", "Cutouts"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.imageryProvider = Cesium.createTileMapServiceImageryProvider(Cesium.buildModuleUrl("Assets/Textures/NaturalEarthII"));
        viewerOptions.baseLayerPicker = false;

        csVPanel = new ViewerPanel(viewerOptions);

        csVPanel.addHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                csVPanel.getViewer().canvas().focus();
            }
        }, ClickEvent.getType());

        csVPanel.getViewer().canvas().setAttribute("tabindex", "0");

        Rectangle defaultImageryLayerCutout = Rectangle.fromDegrees(-90, 20, -70, 40);

        // Cut a rectangle out of the base layer
        ImageryLayerCollection layers = csVPanel.getViewer().imageryLayers();
        ImageryLayer imageryBaseLayer = layers.get(0);

        imageryBaseLayer.cutoutRectangle = defaultImageryLayerCutout;

        // Fit a SingleTileImageryProvider inside the cutout on the lowest layer
        SingleTileImageryProviderOptions singleTileImageryProviderOptions = new SingleTileImageryProviderOptions();
        singleTileImageryProviderOptions.url = GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png";
        singleTileImageryProviderOptions.rectangle = defaultImageryLayerCutout;
        layers.addImageryProvider(new SingleTileImageryProvider(singleTileImageryProviderOptions));

        // Add an Earth at Night layer and a "traveling" cutout
        ImageryLayer earthAtNight = layers.addImageryProvider(new IonImageryProvider(IonImageryProviderOptions.create(3812)));
        earthAtNight.cutoutRectangle = Rectangle.fromDegrees(-100, 10, -60, 50);
        earthAtNight.alpha = 0.9f;

        RootPanel.get().addDomHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent keyDownEvent) {
                setFlag(keyDownEvent.getNativeKeyCode(), true);
            }
        }, KeyDownEvent.getType());

        RootPanel.get().addDomHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                setFlag(keyUpEvent.getNativeKeyCode(), false);
            }
        }, KeyUpEvent.getType());

        double moveIncrement = 0.05;
        csVPanel.getViewer().clock().onTick.addEventListener(new Event.Listener() {
            @Override
            public void function(Object... o) {
                Rectangle travelingRectangle = earthAtNight.cutoutRectangle;
                if (flags.moveNorth && travelingRectangle.north + moveIncrement < Math.PI_OVER_TWO()) {
                    travelingRectangle.north += moveIncrement;
                    travelingRectangle.south += moveIncrement;
                }
                if (flags.moveSouth && travelingRectangle.south - moveIncrement > -Math.PI_OVER_TWO()) {
                    travelingRectangle.north -= moveIncrement;
                    travelingRectangle.south -= moveIncrement;
                }
                if (flags.moveEast) {
                    travelingRectangle.east += moveIncrement;
                    travelingRectangle.west += moveIncrement;
                }
                if (flags.moveWest) {
                    travelingRectangle.east -= moveIncrement;
                    travelingRectangle.west -= moveIncrement;
                }
                travelingRectangle.east = wrapLongitude(travelingRectangle.east);
                travelingRectangle.west = wrapLongitude(travelingRectangle.west);
            }
        });

        HTML html = new HTML();
        html.setHTML("<div id=\"toolbar\">\n" +
                "    <table class=\"infoPanel\">\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <td>Click on the Cesium display to start.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>w/s - move cutout north/south</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>a/d - move cutout west/east</td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>");
        html.getElement().getStyle().setColor("white");

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(html, 20, 20);

        contentPanel.add(new HTML("<p>Demonstration of imagery layers with rectangular cutouts.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryCutout.txt";
        return sourceCodeURLs;
    }

    private String getFlagForKeyCode(int keyCode) {
        if ("W".codePointAt(0) == keyCode) {
            return "moveNorth";
        } else if ("S".codePointAt(0) == keyCode) {
            return "moveSouth";
        } else if ("D".codePointAt(0) == keyCode) {
            return "moveEast";
        } else if ("A".codePointAt(0) == keyCode) {
            return "moveWest";
        } else {
            return null;
        }
    }

    private void setFlag(int keyCode, boolean flag) {
        String flagName = getFlagForKeyCode(keyCode);
        if (flagName != null) {
            if (flagName.equalsIgnoreCase("moveNorth")) {
                flags.moveNorth = flag;
            } else if (flagName.equalsIgnoreCase("moveSouth")) {
                flags.moveSouth = flag;
            } else if (flagName.equalsIgnoreCase("moveEast")) {
                flags.moveEast = flag;
            } else if (flagName.equalsIgnoreCase("moveWest")) {
                flags.moveWest = flag;
            }
        }
    }

    private double wrapLongitude(double value) {
        if (value < -Math.PI()) {
            return value + Math.TWO_PI();
        }
        if (value > Math.PI()) {
            return value - Math.TWO_PI();
        }
        return value;
    }
}