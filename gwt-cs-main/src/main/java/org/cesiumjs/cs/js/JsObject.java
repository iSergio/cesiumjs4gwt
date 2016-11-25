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
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class JsObject extends JavaScriptObject {
    protected JsObject() {}

    public static native JsObject create() /*-{
        return {};
    }-*/;

    public final native boolean isObject(String propertyName) /*-{
        return (typeof this[propertyName] === "object");
    }-*/;

    public final native JsObject getObject(String propertyName) /*-{
        return this[propertyName];
    }-*/;

    public final native Number getNumber(String propertyName) /*-{
        return this[propertyName];
    }-*/;

    public final native Number setNumber(String propertyName, Number propertyValue) /*-{
        this[propertyName] = propertyValue;
    }-*/;

//    public final native int getInt(String propertyName) /*-{
//        return this[propertyName];
//    }-*/;
//
//    public final native void setInt(String propertyName, int propertyValue) /*-{
//        this[propertyName] = propertyValue;
//    }-*/;
//
//    public final native double getDouble(String propertyName) /*-{
//        return this[propertyName];
//    }-*/;
//
//    public final native float getFloat(String propertyName) /*-{
//        return this[propertyName];
//    }-*/;

    public final native String getString(String propertyName) /*-{
        return this[propertyName];
    }-*/;

    /**
     * In JavaScript null not he same undefined. In example Interpolation, we set trackedEntity to null, and this method not worked
     * To correct this help function below.
     * @return undefined object
     */
    @JsProperty(namespace = JsPackage.GLOBAL, name = "undefined")
    public static native Object undefined();
}
