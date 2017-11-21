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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class LoadImages extends AbstractExample {
    private ViewerPanel csVPanel;
    @Inject
    public LoadImages(ShowcaseExampleStore store) {
        super("LoadImages", "Load images into base64 string and set as image on BillboardGraphics", new String[]{"Showcase", "Cesium", "3d", "Base64"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);

        org.cesiumjs.cs.core.PinBuilder pinBuilder = new org.cesiumjs.cs.core.PinBuilder();
        pinBuilder.fromUrlPromise(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color_Overlay.png", Color.WHITE().withAlpha(0.0f), 256).then(new Fulfill<CanvasElement>() {
            @Override
            public void onFulfilled(CanvasElement value) {
                BillboardGraphicsOptions billboardOptions = new BillboardGraphicsOptions();
                billboardOptions.image = new ConstantProperty<>(value.toDataUrl());
                EntityOptions entityOptions = new EntityOptions();
                entityOptions.name = "Pin billboard through fromUrl";
                entityOptions.billboard = new BillboardGraphics(billboardOptions);
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(35, 35));
                csVPanel.getViewer().entities().add(new Entity(entityOptions));
            }
        });

        Cesium.loadImage(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color_Overlay.png", true).then(new Fulfill<JsImage>() {
            @Override
            public void onFulfilled(JsImage value) {
                Canvas canvas = Canvas.createIfSupported();
                canvas.setWidth(value.width + "px");
                canvas.setHeight(value.height + "px");
                Context2d context = canvas.getContext2d();
                context.scale(0.1, 0.1);
                context.drawImage((ImageElement) (Object) value, 0, 0);

                BillboardGraphicsOptions billboardOptions = new BillboardGraphicsOptions();
                billboardOptions.image = new ConstantProperty<>(canvas.toDataUrl());
                EntityOptions entityOptions = new EntityOptions();
                entityOptions.name = "Pin billboard through canvas";
                entityOptions.billboard = new BillboardGraphics(billboardOptions);
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(45, 45));
                csVPanel.getViewer().entities().add(new Entity(entityOptions));
            }
        });

        // CORS not loaded
        Cesium.loadImage("https://www.linux.org.ru/tango/img/games-logo.png", false).then(new Fulfill<JsImage>() {
            @Override
            public void onFulfilled(JsImage value) {
                Canvas canvas = Canvas.createIfSupported();
                canvas.setWidth(value.width + "px");
                canvas.setHeight(value.height + "px");
                Context2d context = canvas.getContext2d();
                context.scale(0.1, 0.1);
                context.drawImage((ImageElement) (Object) value, 0, 0);

                BillboardGraphicsOptions billboardOptions = new BillboardGraphicsOptions();
                billboardOptions.image = new ConstantProperty<>(canvas.toDataUrl());
                EntityOptions entityOptions = new EntityOptions();
                entityOptions.name = "Pin billboard CORS";
                entityOptions.billboard = new BillboardGraphics(billboardOptions);
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(55, 55));
                csVPanel.getViewer().entities().add(new Entity(entityOptions));
            }
        });

        // Cors not loaded!
        final JsImage imageAmz = new JsImage();
        imageAmz.crossOrigin = "*";
        imageAmz.onload = new JsImage.Listener() {
            @Override
            public void function() {
                Cesium.log(imageAmz);
                /*Canvas canvas = Canvas.createIfSupported();
                canvas.setWidth(imageAmz.width + "px");
                canvas.setHeight(imageAmz.height + "px");
                Context2d context = canvas.getContext2d();
                context.scale(0.1, 0.1);
                context.drawImage((ImageElement) (Object) imageAmz, 0, 0);*/
                BillboardGraphicsOptions billboardOptions = new BillboardGraphicsOptions();
                billboardOptions.image = new ConstantProperty<>(imageAmz);
                //billboardOptions.image = new ConstantProperty<>(canvas.toDataUrl("image/png"));
                EntityOptions entityOptions = new EntityOptions();
                entityOptions.name = "Pin billboard CORS";
                entityOptions.billboard = new BillboardGraphics(billboardOptions);
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(65, 65));
                csVPanel.getViewer().entities().add(new Entity(entityOptions));
            }
        };
        imageAmz.src = "https://d1.awsstatic.com/products/cloudfront/cloudfront-100_PoP_600x400.4a1edd6022833c54c41370ad9f615ae818350a23.png";

        // Worked, have Access-Control-Allow-Origin: *
        final JsImage imageWiki = new JsImage();
        imageWiki.crossOrigin = "*";
        imageWiki.onload = new JsImage.Listener() {
            @Override
            public void function() {
                Cesium.log(imageWiki);
                Canvas canvas = Canvas.createIfSupported();
                canvas.setWidth(imageWiki.width + "px");
                canvas.setHeight(imageWiki.height + "px");
                Context2d context = canvas.getContext2d();
                context.drawImage((ImageElement) (Object) imageWiki, 0, 0);
                BillboardGraphicsOptions billboardOptions = new BillboardGraphicsOptions();
                billboardOptions.image = new ConstantProperty<>(canvas.toDataUrl("image/png"));
                EntityOptions entityOptions = new EntityOptions();
                entityOptions.name = "Pin billboard CORS";
                entityOptions.billboard = new BillboardGraphics(billboardOptions);
                entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(75, 75));
                csVPanel.getViewer().entities().add(new Entity(entityOptions));
            }
        };
        imageWiki.src = "https://ru.wikipedia.org/static/images/project-logos/ruwiki-2x.png";

        contentPanel.add(new HTML("<p>Cluster labels, billboards and points.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "LoadImages.txt";
        return sourceCodeURLs;
    }
}
