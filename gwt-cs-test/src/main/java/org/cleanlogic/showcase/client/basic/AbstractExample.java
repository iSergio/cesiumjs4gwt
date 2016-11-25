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
package org.cleanlogic.showcase.client.basic;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.cleanlogic.showcase.client.ExampleBean;
import org.cleanlogic.showcase.client.components.store.ExampleStore;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The abstract base for each Example
 *
 * @author Frank Wynants
 *
 */
public abstract class AbstractExample extends Composite {
    public static final Logger LOGGER = Logger.getLogger(AbstractExample.class.getName());
    protected VerticalPanel contentPanel = new VerticalPanel();
    protected HorizontalPanel horizontalPanel = new HorizontalPanel();
    private final List<ShowSourceButton> showSourceButtons = new ArrayList<ShowSourceButton>();
    protected ExampleBean example;

    public AbstractExample(String name, String description, String[] tags, ExampleStore store) {
        this(name, description, tags);
        store.addExample(example);
    }

    /**
     * The constructor.
     *
     */
    public AbstractExample(String name, String description, String[] tags) {
        for (String sourceCodeUrl : getSourceCodeURLs()) {
            ShowSourceButton butShowSource = new ShowSourceButton("");
            butShowSource.setSourceCodeURL(sourceCodeUrl);
            showSourceButtons.add(butShowSource);
        }
        setTitle(name);
        this.example = new ExampleBean(name, description, tags, this);
    }

    public abstract void buildPanel();
    
    public abstract String[] getSourceCodeURLs();

    /**
     * @param title the title to set
     */
    @Override
    public void setTitle(String title) {
        for (ShowSourceButton butShowSource : showSourceButtons) {
            horizontalPanel.add(butShowSource);
        }
        contentPanel.setSpacing(5);
        contentPanel.getElement().getStyle().setPadding(10, Unit.PX);
        contentPanel.setWidth("100%");
        contentPanel.add(new HTML("<H1>" + title + "</H1>"));
        contentPanel.add(horizontalPanel);
    }

    /**
     * @return the example
     */
    public ExampleBean getExample() {
        return example;
    }

    public static native void log(Object object) /*-{
        console.log(object);
    }-*/;
}