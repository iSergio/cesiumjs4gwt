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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSConstructor;
import org.cesiumjs.cs.core.Resource;

/**
 * Options for {@link org.cesiumjs.cs.core.IonResource#fromAssetId(int, FromAssetIdOptions)} method.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromAssetIdOptions {
    /**
     * The access token to use.
     * Default: {@link org.cesiumjs.cs.core.Ion#defaultAccessToken}.
     */
    @JsProperty
    public String accessToken;
    /**
     * The resource to the Cesium ion API server.
     * Default: {@link org.cesiumjs.cs.core.Ion#defaultServer}.
     */
    @JsProperty
    public String server;
    /**
     * The resource to the Cesium ion API server.
     */
    @JsProperty(name = "server")
    public Resource serverResource;

    @JSConstructor
    public FromAssetIdOptions() {}
}
