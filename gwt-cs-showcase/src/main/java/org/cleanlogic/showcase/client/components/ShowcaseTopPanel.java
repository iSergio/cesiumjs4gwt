/**
 *
 *   Copyright 2015 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.cleanlogic.showcase.client.components;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.*;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseTopPanel extends HorizontalPanel {

    @Inject
    public ShowcaseTopPanel(Image logo, ShowcaseSearchPanel searchPanel) {
        super.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        super.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        super.setStyleName("top");
        
        super.setSpacing(1);

        logo.setSize("32px", "32px");
        super.add(logo);
        Anchor anchor = new Anchor();
        String text = "<div class=\"brand\"><a href=\"http://cesiumjs.org\">Cesium</a> on GWT Examples</div>";
        anchor.setHTML(SafeHtmlUtils.fromTrustedString(text));
        super.add(anchor);
        super.add(searchPanel);

        super.setCellWidth(logo, "10px");
    }
}
