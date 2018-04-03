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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cesiumjs.cs.BaseTestCase;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ViewerPanelTest extends BaseTestCase {
    public void testRequestRenderMode() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                LinkElement linkElement = Document.get().createLinkElement();
                linkElement.setRel("stylesheet");
                linkElement.setHref("cs/CesiumUnminified/Widgets/widgets.css");
                Document.get().getElementsByTagName("head").getItem(0).appendChild(linkElement);

                DivElement divElement = RootPanel.get().getElement().getOwnerDocument().createDivElement();
                divElement.setId("cesium");
                RootPanel.get().getElement().appendChild(divElement);
                Element element = RootPanel.get().getElement().getOwnerDocument().getElementById("cesium");
                assertNotNull(element);
                ViewerOptions options = new ViewerOptions();
                assertNotNull(options);
                Viewer viewer = new Viewer(element, options);
//                assertNotNull(viewer);
                finishTest();
            }
        });
    }
}