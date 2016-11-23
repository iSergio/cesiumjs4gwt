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

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * This class uses if You inject Cesium.js in HTML main file through <script></script>
 * See static examples
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ViewerPanel extends SimplePanel {
    private Viewer _viewer;

    public ViewerPanel() {
        super();
        super.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent attachEvent) {
                _viewer = new Viewer(getElement());
            }
        });
    }

    public Viewer getViewer() {
        return _viewer;
    }
}
