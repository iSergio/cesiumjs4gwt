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

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.cesiumjs.cs.Cesium;
import org.cleanlogic.cesiumjs4gwt.showcase.ExampleBean;
import org.cleanlogic.cesiumjs4gwt.showcase.Resources;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ExampleStore;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The abstract base for each Example
 *
 * @author Frank Wynants
 */
public abstract class AbstractExample extends Composite {
    public static final Logger LOGGER = Logger.getLogger(AbstractExample.class.getName());
    private final List<ShowSourceButton> showSourceButtons = new ArrayList<ShowSourceButton>();
    protected VerticalPanel contentPanel = new VerticalPanel();
    protected HorizontalPanel horizontalPanel = new HorizontalPanel();
    protected ExampleBean example;
    protected final String version;

    public AbstractExample(String name, String description, String[] tags, ExampleStore store) {
        this(name, description, tags, "");
        store.addExample(example);
    }

    public AbstractExample(String name, String description, String[] tags, ExampleStore store, String version) {
        this(name, description, tags, version);
        store.addExample(example);
    }

    /**
     * The constructor.
     */
    public AbstractExample(String name, String description, String[] tags, String version) {
        this.version = version;
        for (String sourceCodeUrl : getSourceCodeURLs()) {
            ShowSourceButton butShowSource = new ShowSourceButton("");
            butShowSource.setSourceCodeURL(sourceCodeUrl);
            showSourceButtons.add(butShowSource);
        }
        setTitle(name);
        this.example = new ExampleBean(name, description, tags, this);
    }

    public static native void log(Object object) /*-{
        console.log(object);
    }-*/;

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
        contentPanel.add(new HTML("<H1>" + title + (isNew() ? " New" : "") + "</H1>"));
        contentPanel.add(horizontalPanel);
    }

    public boolean isNew() {
        return Cesium.version().equals(this.version);
    }

    public String getVersion() {
        return this.version;
    }

    /**
     * @return the example
     */
    public ExampleBean getExample() {
        return example;
    }
}