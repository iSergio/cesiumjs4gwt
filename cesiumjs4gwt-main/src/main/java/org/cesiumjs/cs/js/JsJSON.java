package org.cesiumjs.cs.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "JSON" )
public class JsJSON {
    @JsMethod
    native static public <T> T parse(String json);
}
