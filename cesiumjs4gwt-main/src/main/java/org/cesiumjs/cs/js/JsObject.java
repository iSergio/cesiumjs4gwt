/*
 * Copyright 2018 iserge.
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

package org.cesiumjs.cs.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

/**
 * @author Serge Silaev aka iSergio
 */
public class JsObject extends JavaScriptObject {
    protected JsObject() {
    }

    public static native JsObject create() /*-{
        return {};
    }-*/;

    public static <O> O $(O base, Object... propertyValues) {
        String propertyName = null;

        for (Object propertyValue : propertyValues) {
            if (propertyName == null) {
                propertyName = (String) propertyValue;
            } else {
                if (propertyValue instanceof Number) {
                    setProperty(base, propertyName, (Number) propertyValue);
                } else if (propertyValue instanceof Boolean) {
                    setProperty(base, propertyName, (Boolean) propertyValue);
                } else {
                    setProperty(base, propertyName, propertyValue);
                }

                propertyName = null;
            }
        }
        return base;
    }

    public static native JsObject setProperty(Object target, String name, Number value) /*-{
        if (target === undefined) {
            target = {};
        }
        target[name] = value;
        return target;
    }-*/;

    public static native JsObject setProperty(Object target, String name, Boolean value) /*-{
        if (target === undefined) {
            target = {};
        }
        target[name] = value;
        return target;
    }-*/;

    public static native JsObject setProperty(Object target, String name, String value) /*-{
        if (target === undefined) {
            target = {};
        }
        target[name] = value;
        return target;
    }-*/;

    public static native JsObject setProperty(Object target, String name, Object value) /*-{
        if (target === undefined) {
            target = {};
        }
        target[name] = value;
        return target;
    }-*/;

    public static native JsObject setProperty(Object target, String name, JsObject value) /*-{
        if (target === undefined) {
            target = {};
        }
        target[name] = value;
        return target;
    }-*/;

    public final static native Number getNumber(Object target, String name) /*-{
        return target[name];
    }-*/;

    public final static native JsObject getObject(Object target, String name) /*-{
        return target[name];
    }-*/;

    public final static native String getString(Object target, String name) /*-{
        return target[name];
    }-*/;

    public static final native Number getNumber(JsArray<Number> array, int index) /*-{
        return array[index];
    }-*/;

    public static final native String getString(JsArray<String> array, int index) /*-{
        return array[index];
    }-*/;

    public static native boolean hasOwnProperty(Object object, String property) /*-{
        return object.hasOwnProperty(property);
    }-*/;

    /**
     * In JavaScript null not he same undefined. In example Interpolation, we set
     * trackedEntity to null, and this method not worked To correct this help
     * function below.
     *
     * @return undefined object
     */
    @JsProperty(namespace = JsPackage.GLOBAL, name = "undefined")
    public static native Object undefined();

    public final native JsObject setProperty(String name, Number value) /*-{
        this[name] = value;
        return this;
    }-*/;

    public final native JsObject setProperty(String name, Boolean value) /*-{
        this[name] = value;
        return this;
    }-*/;

    public final native JsObject setProperty(String name, String value) /*-{
        this[name] = value;
        return this;
    }-*/;

    public final native JsObject setProperty(String name, Object value) /*-{
        this[name] = value;
        return this;
    }-*/;

    public final native JsObject setProperty(String name, JsObject value) /*-{
        this[name] = value;
        return this;
    }-*/;

    public final native Number getNumber(String name) /*-{
        return this[name];
    }-*/;

    public final native Object getObject(String name) /*-{
        return this[name];
    }-*/;

    public final native String getString(String name) /*-{
        return this[name];
    }-*/;

    public final native JsObject getJsObject(String name) /*-{
        return this[name];
    }-*/;

    public static native JsArrayString keys(JsObject object) /*-{
        return Object.keys(object)
    }-*/;

    public final native boolean hasOwnProperty(String property) /*-{
        return this.hasOwnProperty(property);
    }-*/;
}
