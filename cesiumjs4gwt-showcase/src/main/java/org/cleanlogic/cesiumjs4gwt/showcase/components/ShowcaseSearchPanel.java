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
package org.cleanlogic.cesiumjs4gwt.showcase.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import org.cleanlogic.cesiumjs4gwt.showcase.i18n.I18NMessages;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBus;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.event.ExamplePanelBuildEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.handler.ExampleNumberHandler;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseSearchPanel extends HorizontalPanel implements ExampleNumberHandler {

    public static final I18NMessages I18N = GWT.create(I18NMessages.class);
    private final TextBox txtSearch = new TextBox();
    private final Label lblNumberOfExamples = new Label("(0)");
    private final ShowcaseEventBus bus;
    private final ExamplePanelBuildEvent buildEvent = new ExamplePanelBuildEvent();

    @Inject
    public ShowcaseSearchPanel(ShowcaseEventBus theBus) {
        super.setSpacing(3);
        this.addComponents();
        this.bus = theBus;

        this.bus.addHandler(ExampleNumberHandler.TYPE, this);
    }

    private void setTxtSearchProperties() {
        txtSearch.setText(I18N.filterByKeywords());
        txtSearch.setStyleName("emptytextbox");

        txtSearch.addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                if (event.getSource() == txtSearch) {
                    if (txtSearch.getText().equals(I18N.filterByKeywords())) {
                        txtSearch.setText("");
                        txtSearch.removeStyleName("emptytextbox");
                    }
                }
            }
        });

        txtSearch.addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {
                if (event.getSource() == txtSearch) {
                    if (txtSearch.getText().trim().equals("")) {
                        txtSearch.setText(I18N.filterByKeywords());
                        txtSearch.addStyleName("emptytextbox");
                    }
                }
            }
        });
        txtSearch.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (event.getSource() == txtSearch) {
                    buildEvent.setFilter(txtSearch.getText());
                    bus.fireEvent(buildEvent);
                }
            }
        });
    }

    private void addComponents() {
        super.add(txtSearch);
        super.add(lblNumberOfExamples);

        this.setTxtSearchProperties();
    }

    public void updateExampleNumber(int number) {
        lblNumberOfExamples.setText("(" + number + ")");
    }
}
