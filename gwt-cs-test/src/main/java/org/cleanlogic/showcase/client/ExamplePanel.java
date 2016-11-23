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
package org.cleanlogic.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.cleanlogic.showcase.client.i18n.I18NMessages;

/**
 * A clickable example panel.
 *
 * @author Frank Wynants
 *
 */
public class ExamplePanel extends Composite {

    public static final I18NMessages I18N = (I18NMessages) GWT.create(
            I18NMessages.class);

    /**
     * Constructs the ExamplePanel using an Example
     *
     * @param example
     */
    public ExamplePanel(final ExampleBean example) {
        final VerticalPanel vp = new VerticalPanel();
        vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        vp.setSpacing(5);

        final ScrollPanel sp = new ScrollPanel();
        sp.addDomHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent mouseOverEvent) {
                sp.getElement().getStyle().setOverflowX(Overflow.AUTO);
                sp.getElement().getStyle().setOverflowY(Overflow.AUTO);
            }
        }, MouseOverEvent.getType());
        sp.addDomHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent mouseOutEvent) {
                sp.getElement().getStyle().setOverflowX(Overflow.HIDDEN);
                sp.getElement().getStyle().setOverflowY(Overflow.HIDDEN);
            }
        }, MouseOutEvent.getType());
        sp.getElement().getStyle().setOverflowX(Overflow.HIDDEN);
        sp.getElement().getStyle().setOverflowY(Overflow.HIDDEN);
//        sp.setSize("350px", "100px");
        sp.setWidth("250px");
        sp.setHeight("250px");
        sp.setWidget(vp);

        final Label lblName = new Label(example.getName());
        final Image lblImage = new Image(GWT.getModuleBaseURL() + "examples/" + example.getName() + ".jpg");
        final Label lblDescription = new Label(example.getDescription());
        final StringBuffer sb = new StringBuffer();
        final String[] tags = example.getTags();
        for (String tag : tags) {
            sb.append(tag).append(", ");
        }
        final Label lblTags = new Label(I18N.tags(
                sb.toString().substring(0, sb.toString().length() - 2)));
        lblTags.setStyleName("exampletags");

        lblName.setStyleName("examplename");
        vp.add(lblName);
        vp.add(lblImage);
        vp.add(lblDescription);
        vp.add(lblTags);

        final FocusPanel fp = new FocusPanel(sp);
        this.initWidget(fp);
        this.setStyleName("examplepanel");

        fp.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (Window.Location.getHref().contains("?")) {
                    Window.open(
                            Window.Location.getHref() + "&example=" + example.getName(),
                                "_BLANK", null);
                } else {
                    Window.open(
                            Window.Location.getHref() + "?example=" + example.getName(),
                                "_BLANK", null);
                }
            }
        });
    }
}