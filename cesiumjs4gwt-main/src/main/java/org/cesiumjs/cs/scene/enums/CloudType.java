/*
 * Copyright 2021 iserge.
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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.CloudCollection;

/**
 * Specifies the type of the cloud that is added to a {@link CloudCollection} in {@link CloudCollection#add}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CloudType")
public class CloudType {
    /**
     * Cumulus cloud.
     */
    @JsProperty(name = "CUMULUS")
    public static native Number CUMULUS();
}
