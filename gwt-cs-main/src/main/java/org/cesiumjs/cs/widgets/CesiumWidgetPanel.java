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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.widgets.options.CesiumWidgetOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumWidgetPanel extends SimplePanel {
    private CesiumWidget _cesiumWidget;

    public CesiumWidgetPanel() {
        this((CesiumWidgetOptions) JsObject.undefined());
    }

    public CesiumWidgetPanel(CesiumWidgetOptions options) {
        super();
        Element element = getElement();
        RootPanel.getBodyElement().appendChild(element);
        _cesiumWidget = new CesiumWidget(element, options);
        super.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent attachEvent) {
                if (!attachEvent.isAttached()) {
                    _cesiumWidget.destroy();
                }
            }
        });
    }

    public CesiumWidget getCesiumWidget() {
        return _cesiumWidget;
    }
}
