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

package org.cesiumjs.cs.widgets;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.Configuration;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public abstract class ViewerPanelAbstract extends SimplePanel {
    private Configuration _configuration;
    protected Viewer _viewer;

    public ViewerPanelAbstract(Configuration configuration) {
        _configuration = configuration;
        super.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent attachEvent) {
                if (attachEvent.isAttached()) {
                    inject(getElement());
                } else {
                    _viewer.destroy();
                }
            }
        });
    }

    protected void inject(final Element element) {
        Cesium.initialize(_configuration.getPath(), element.getOwnerDocument(), new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception e) {
                Window.alert("Error: Failed to inject Cesium scripts from " + _configuration.getPath());
            }

            @Override
            public void onSuccess(Void aVoid) {
                _viewer = createViewer(element);
            }
        });
    }

    public abstract Viewer createViewer(Element element);

    public Viewer getViewer() {
        return _viewer;
    }
}
