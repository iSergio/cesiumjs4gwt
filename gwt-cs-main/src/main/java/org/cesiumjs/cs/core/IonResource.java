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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.options.FromAssetIdOptions;
import org.cesiumjs.cs.core.options.ResourceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * A {@link Resource} instance that encapsulates Cesium ion asset access. This object is normally not instantiated directly,
 * use IonResource.fromAssetId.
 *
 * @see Ion
 * @see org.cesiumjs.cs.scene.providers.IonImageryProvider
 * @see <a href="https://cesium.com/">https://cesium.com</a>
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "IonResource")
public class IonResource extends Resource {
    /**
     * Gets the credits required for attribution of the asset.
     */
    @JsProperty
    public Credit[] credits;

    @JsConstructor
    private IonResource(ResourceOptions options) {
        super(options);
    }

    /**
     * Asynchronously creates an instance.
     * @param assetId The Cesium ion asset id.
     * @return A Promise to am instance representing the Cesium ion Asset.
     * <pre>
     * Examples:
     * <code>
     * IonResource.fromAssetId(3883).then(new Fulfill<IonResource>() {
     *    {@literal @}Override
     *     public void onFulfilled(IonResource value) {
     *         viewer.scene().primitives().add(value);
     *     }
     * }, new Reject<Void>() {
     *    {@literal @}Override
     *     public void onRejected(Void value) {
     *         Cesium.log("Request rejected");
     *     }
     * });
     * </code>
     * </pre>
     */
    @JsMethod
    public static native Promise<IonResource, Void> fromAssetId(int assetId);

    /**
     * Asynchronously creates an instance.
     * @param assetId The Cesium ion asset id.
     * @param options {@link FromAssetIdOptions} object.
     * @return A Promise to am instance representing the Cesium ion Asset.
     *
     * <pre>
     * Examples:
     * <code>
     * IonResource.fromAssetId(3883).then(new Fulfill<IonResource>() {
     *    {@literal @}Override
     *     public void onFulfilled(IonResource value) {
     *         viewer.scene().primitives().add(value);
     *     }
     * }, new Reject<Void>() {
     *    {@literal @}Override
     *     public void onRejected(Void value) {
     *         Cesium.log("Request rejected");
     *     }
     * });
     * </code>
     * </pre>
     */
    @JsMethod
    public static native Promise<IonResource, Void> fromAssetId(int assetId, FromAssetIdOptions options);


}
