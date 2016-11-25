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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class HelloWorldStatic extends AbstractExample {
    @Inject
    public HelloWorldStatic(ShowcaseExampleStore store) {
        super("Hello World Static", "Simple Cesium hello world application", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Static"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel viewerPanel = new ViewerPanel();

        contentPanel.add(new HTML("<p>This example shows how create HelloWord as direct inject CesiumJS in HTML header</p>"));
        contentPanel.add(viewerPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "HelloWorldStatic.txt";
        return sourceCodeURLs;
    }
}