/*
 * Copyright 2017 iserge.
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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Callback
@JsType(isNative = true, namespace = "Cesium", name = "GetFeatureInfoFormat")
public class GetFeatureInfoFormat {
    /**
     * Describes the format in which to request GetFeatureInfo from a Web Map Service (WMS) server.
     * @param type The type of response to expect from a GetFeatureInfo request. Valid values are 'json', 'xml', 'html', or 'text'.
     */
    @JsConstructor
    public GetFeatureInfoFormat(String type) {}

    /**
     * Describes the format in which to request GetFeatureInfo from a Web Map Service (WMS) server.
     * @param type The type of response to expect from a GetFeatureInfo request. Valid values are 'json', 'xml', 'html', or 'text'.
     * @param format The info format to request from the WMS server.
     *               This is usually a MIME type such as 'application/json' or text/xml'.
     *               If this parameter is not specified, the provider will request 'json' using 'application/json',
     *               'xml' using 'text/xml', 'html' using 'text/html', and 'text' using 'text/plain'.
     */
    @JsConstructor
    public GetFeatureInfoFormat(String type, String format) {}
}
