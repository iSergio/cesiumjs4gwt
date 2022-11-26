/*
 * Copyright 2022 iSergio, Gis4Fun.
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

package org.cleanlogic.cesiumjs4gwt.showcase.examples.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.shared.HandlerRegistration;

import java.util.UUID;

public class SliderBox extends SliderBoxBase {
    public SliderBox() {
        this(Document.get().createElement("input"), "gwt-RangeBox");
    }

    public SliderBox(double min, double value, double max, double step) {
        this();
        setMin(min);
        setValue(value);
        setMax(max);
        setStep(step);
    }

    protected SliderBox(Element element) {
        super(element);
        assert InputElement.as(element).getType().equalsIgnoreCase("range");
    }

    SliderBox(Element element, String styleName) {
        super(element);
        super.getElement().setAttribute("type", "range");
//        super.getElement().setId("gwt-rangebox-" + UUID.randomUUID());
    }

    public HandlerRegistration addInputHandler(InputHandler handler) {
        return addDomHandler(handler, InputEvent.getType());
    }

    public void setValue(double value) {
        super.getElement().setPropertyString("value", String.valueOf(value));
    }

    @Override
    public String getValue() {
        return super.getElement().getPropertyString("value");
    }

    public double getMin() {
        return Double.parseDouble(super.getElement().getAttribute("min"));
    }

    public void setMin(double min) {
        super.getElement().setAttribute("min", String.valueOf(min));
    }

    public double getMax() {
        return Double.parseDouble(super.getElement().getAttribute("max"));
    }

    public void setMax(double max) {
        super.getElement().setAttribute("max", String.valueOf(max));
    }

    public double getStep() {
        return Double.parseDouble(super.getElement().getAttribute("step"));
    }

    public void setStep(double step) {
        super.getElement().setAttribute("step", String.valueOf(step));
    }
}
