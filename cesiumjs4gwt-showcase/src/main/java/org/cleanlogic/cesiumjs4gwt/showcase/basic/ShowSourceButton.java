/**
 * Copyright 2015 sourceforge.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cleanlogic.cesiumjs4gwt.showcase.basic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.DialogBoxWithCloseButton;
import org.cleanlogic.cesiumjs4gwt.showcase.components.ShowcaseSearchPanel;

/**
 * @author Frank Wynants
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class ShowSourceButton extends AbstractSourceButton {

    private final String source;

    public ShowSourceButton(String source) {
        super(source);
        this.source = source;
    }

    protected void showSourceCode(String sourceCode) {
        sourceCode = sourceCode.replaceAll("<", "&lt,").replace(">", "&gt;");

        final String html = "<pre><code class=\"java\">" + sourceCode + "</code></pre>";
        ScrollPanel sp = new ScrollPanel();
        sp.setSize((Window.getClientWidth() * 0.6) + "px", (Window.getClientHeight() * 0.7) + "px");
        sp.add(new HTML(html));

        DialogBoxWithCloseButton dialogBox = new DialogBoxWithCloseButton(false);
        dialogBox.setWidget(sp);
        dialogBox.setText(ShowcaseSearchPanel.I18N.viewSource(source));
        dialogBox.center();

        super.doFormat();
    }

}
