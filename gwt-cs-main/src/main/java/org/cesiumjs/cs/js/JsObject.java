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

package org.cesiumjs.cs.js;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class JsObject extends Object {
    public static <O> O $(O base, Object ...propertyValues) {
        String propertyName = null;

        for (Object propertyValue : propertyValues) {
            if (propertyName == null) {
                propertyName = (String) propertyValue;
            } else {
                if (propertyValue instanceof Number) {
                    setProperty(base, propertyName, (Number) propertyValue);
                }
                else if (propertyValue instanceof Boolean) {
                    setProperty(base, propertyName, (Boolean) propertyValue);
                }
                else {
                    setProperty(base, propertyName, propertyValue);
                }

                propertyName = null;
            }
        }
        return base;
    }

    public static native void setProperty(Object target, String name, Number value) /*-{
        target[name] = value;
    }-*/;

    public static native void setProperty(Object target, String name, Boolean value) /*-{
        target[name] = value;
    }-*/;

    public static native void setProperty(Object target, String name, String value) /*-{
        target[name] = value;
    }-*/;

    public static native void setProperty(Object target, String name, Object value) /*-{
        target[name] = value;
    }-*/;

    public native void setProperty(String name, Number value) /*-{
        this[name] = value;
    }-*/;

    public native void setProperty(String name, Boolean value) /*-{
        this[name] = value;
    }-*/;

    public native void setProperty(String name, String value) /*-{
        this[name] = value;
    }-*/;

    public native void setProperty(String name, Object value) /*-{
        this[name] = value;
    }-*/;

    public static native Number getNumber(Object target, String name) /*-{
        return target[name];
    }-*/;

    public static native Object getObject(Object target, String name) /*-{
        return target[name];
    }-*/;

    public static native String getString(Object target, String name) /*-{
        return target[name];
    }-*/;

    public native Number getNumber(String name) /*-{
        return this[name];
    }-*/;

    public native Object getObject(String name) /*-{
        return this[name];
    }-*/;

    public native String getString(String name) /*-{
        return this[name];
    }-*/;

    /**
     * In JavaScript null not he same undefined. In example Interpolation, we set trackedEntity to null, and this method not worked
     * To correct this help function below.
     * @return undefined object
     */
    @JsProperty(namespace = JsPackage.GLOBAL, name = "undefined")
    public static native Object undefined();
}
