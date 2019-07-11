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

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.options.*;
import org.cesiumjs.cs.js.JsBlob;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;

/**
 * A resource that includes the location and any other parameters we need to retrieve it or create derived resources.
 * It also provides the ability to retry requests.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
// TODO: examples
@JsType(isNative = true, namespace = "Cesium", name = "Resource")
public class Resource {
    /**
     * A resource instance initialized to the current browser location.
     */
    @JsProperty(name = "DEFAULT")
    public static native Resource DEFAULT();
    /**
     * Returns true if blobs are supported.
     */
    @JsProperty(name = "isBlobSupported")
    public static native boolean isBlobSupported();
    /**
     * The file extension of the resource.
     */
    @JsProperty(name = "extension")
    public native String extension();
    /**
     * True if the Resource has request headers. This is equivalent to checking if the headers property has any keys.
     */
    @JsProperty
    public boolean hasHeaders;
    /**
     * Additional HTTP headers that will be sent with the request.
     */
    @JsProperty
    public JsObject headers;
    /**
     * True if the Resource refers to a blob URI.
     */
    @JsProperty
    public boolean isBlobUri;
    /**
     * True if the Resource refers to a cross origin URL.
     */
    @JsProperty
    public boolean isCrossOriginUrl;
    /**
     * True if the Resource refers to a data URI.
     */
    @JsProperty
    public boolean isDataUri;
    /**
     * A proxy to be used when loading the resource.
     */
    @JsProperty
    public DefaultProxy proxy;
    /**
     * Query parameters appended to the url.
     */
    @JsProperty(name = "queryParameters")
    public native JsObject queryParameters();
    /**
     * A Request object that will be used. Intended for internal use only.
     */
    @JsProperty
    public Request request;
    /**
     * The number of times the retryCallback should be called before giving up.
     */
    @JsProperty
    public int retryAttempts;
    /**
     * Function to call when a request for this resource fails. If it returns true or a Promise that resolves to true,
     * the request will be retried.
     */
    @JsProperty
    public RetryCallback retryCallback;
    /**
     * The key/value pairs used to replace template parameters in the url.
     */
    @JsProperty
    public JsObject templateValues;
    /**
     * The url to the resource with template values replaced, query string appended and encoded by proxy if one was set.
     */
    @JsProperty
    public String url;

    @JsConstructor
    public Resource(ResourceOptions options) {}

    /**
     * Creates a Resource from a URL and calls delete() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle
     * is true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> delete(String url);

    /**
     * Creates a Resource from a URL and calls delete() on it.
     * @param options {@link ResourceHttpOptions}.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle
     * is true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> delete(ResourceHttpOptions options);

    /**
     * Creates a Resource from a URL and calls fetch() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetch(String url);

    /**
     * Creates a Resource from a URL and calls fetch() on it.
     * @param options {@link RequestOptions}.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetch(ResourceHttpOptions options);

    /**
     * Creates a Resource and calls fetchArrayBuffer() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<ArrayBuffer, Void> fetchArrayBuffer(String url);

    /**
     * Creates a Resource and calls fetchArrayBuffer() on it.
     * @param options {@link RequestOptions}.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<ArrayBuffer, Void> fetchArrayBuffer(ResourceOptions options);

    // TODO: fetchBlob

    /**
     * Creates a Resource and calls fetchImage() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsImage, Void> fetchImage(String url);

    /**
     * Creates a Resource and calls fetchImage() on it.
     * @param options {@link ResourceImageOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsImage, Void> fetchImage(ResourceImageOptions options);

    /**
     * Creates a Resource and calls fetchJson() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchJson(String url);

    /**
     * Creates a Resource and calls fetchJson() on it.
     * @param options {@link RequestOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchJson(ResourceOptions options);

    /**
     * Creates a Resource from a URL and calls fetchJsonp() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchJsonp(String url);

    /**
     * Creates a Resource from a URL and calls fetchJsonp() on it.
     * @param options {@link ResourceJsonpOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchJsonp(ResourceJsonpOptions options);

    /**
     * Creates a Resource and calls fetchText() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchText(String url);

    /**
     * Creates a Resource and calls fetchText() on it.
     * @param options {@link ResourceOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchText(ResourceOptions options);

    /**
     * Creates a Resource and calls fetchXML() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchXML(String url);

    /**
     * Creates a Resource and calls fetchXML() on it.
     * @param options {@link ResourceOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> fetchXML(ResourceOptions options);

    /**
     * Creates a Resource from a URL and calls patch() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> patch(String url);

    /**
     * Creates a Resource from a URL and calls patch() on it.
     * @param options {@link ResourcePathOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> patch(ResourcePathOptions options);

    /**
     * Creates a Resource from a URL and calls fetch() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> post(String url);

    /**
     * Creates a Resource from a URL and calls fetch() on it.
     * @param options {@link ResourceHttpOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> post(ResourceHttpOptions options);

    /**
     * Creates a Resource from a URL and calls put() on it.
     * @param url The url of the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true and
     * the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> put(String url);

    /**
     * Creates a Resource from a URL and calls put() on it.
     * @param options {@link ResourcePutOptions} opbject.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true and
     * the request does not have high enough priority.
     */
    @JsMethod
    public static native Promise<JsObject, Void> put(ResourcePutOptions options);

    /**
     * Appends a forward slash to the URL.
     */
    @JsMethod
    public native void appendForwardSlash();

    /**
     * Combines the specified object and the existing query parameters. This allows you to add many parameters at once,
     * as opposed to adding them one at a time to the queryParameters property.
     * @param params The query parameters
     */
    @JsMethod
    public native void appendQueryParameters(JsObject params);

    /**
     * Duplicates a Resource instance.
     * @return The modified result parameter or a new Resource instance if one was not provided.
     */
    @JsMethod
    public native Resource clone();

    /**
     * Duplicates a Resource instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Resource instance if one was not provided.
     */
    @JsMethod
    public native Resource clone(Resource result);

    //TODO: fetch

    /**
     * Asynchronously loads the resource as raw binary data. Returns a promise that will resolve to an ArrayBuffer once
     * loaded, or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means
     * that in order to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS)
     * headers enabled.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<ArrayBuffer, Void> fetchArrayBuffer();

    /**
     * Creates a Resource and calls fetchBlob() on it.
     * @param url url
     * @return resource
     */
    @JsMethod
    public static native Promise<JsBlob, Void> fetchBlob(String url);

    /**
     * Creates a Resource and calls fetchBlob() on it.
     * @param options {@link ResourceOptions}
     * @return resource
     */
    @JsMethod
    public static native Promise<JsBlob, Void> fetchBlob(ResourceOptions options);

    /**
     * Asynchronously loads the given image resource. Returns a promise that will resolve to an Image once loaded, or
     * reject if the image failed to load.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsImage, Void> fetchImage();

    /**
     * Asynchronously loads the given image resource. Returns a promise that will resolve to an Image once loaded, or
     * reject if the image failed to load.
     * @param preferBlob If true, we will load the image via a blob.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsImage, Void> fetchImage(boolean preferBlob);

    /**
     * Asynchronously loads the given resource as JSON. Returns a promise that will resolve to a JSON object once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in
     * order to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * This function adds 'Accept: application/json,*\/*;q=0.01' to the request headers, if not already specified.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> fetchJson();

    /**
     * Requests a resource using JSONP.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> fetchJsonp();

    /**
     * Requests a resource using JSONP.
     * @param callbackParameterName The callback parameter name that the server expects.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod(name = "fetchJsonp")
    public native Promise<JsObject, Void> fetchJsonpCallback(String callbackParameterName);

    /**
     * Asynchronously loads the given resource as text. Returns a promise that will resolve to a String once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order
     * to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<String, Void> fetchText();

    // TODO: fetchXML

    /**
     * Returns the base path of the Resource.
     * @return The base URI of the resource
     */
    @JsMethod
    public native String getBaseUri();

    /**
     * Returns the base path of the Resource.
     * @param includeQuery Whether or not to include the query string and fragment form the uri
     * @return The base URI of the resource
     */
    @JsMethod
    public native String getBaseUri(boolean includeQuery);

    /**
     * Returns a resource relative to the current instance. All properties remain the same as the current instance
     * unless overridden in options.
     * @return The resource derived from the current one.
     */
    @JsMethod
    public native Resource getDerivedResource();

    /**
     * Returns a resource relative to the current instance. All properties remain the same as the current instance
     * unless overridden in options.
     * @param options {@link ResourceOptions} object.
     * @return The resource derived from the current one.
     */
    @JsMethod
    public native Resource getDerivedResource(DerivedResourceOptions options);

    /**
     * Returns the url, optional with the query string and processed by a proxy.
     * @return The url with all the requested components.
     */
    @JsMethod
    public native String getUrlComponent();

    /**
     * Returns the url, optional with the query string and processed by a proxy.
     * @param query If true, the query string is included.
     * @return The url with all the requested components.
     */
    @JsMethod
    public native String getUrlComponent(boolean query);

    /**
     * Returns the url, optional with the query string and processed by a proxy.
     * @param query If true, the query string is included.
     * @param proxy If true, the url is processed the proxy object if defined.
     * @return The url with all the requested components.
     */
    @JsMethod
    public native String getUrlComponent(boolean query, boolean proxy);

    /**
     * Asynchronously gets headers the given resource. Returns a promise that will resolve to the result once loaded, or
     * reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order to
     * make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true
     * and the request does not have high enough priority.
     * @see <a href="http://www.w3.org/TR/cors/">Cross-Origin Resource Sharing</a>
     * @see <a href="http://wiki.commonjs.org/wiki/Promises/A">CommonJS Promises/A</a>
     */
    @JsMethod
    public native Promise<JsObject, Void> head();

    /**
     * Asynchronously gets headers the given resource. Returns a promise that will resolve to the result once loaded, or
     * reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order to
     * make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @param options {@link ResourceHttpOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true
     * and the request does not have high enough priority.
     * @see <a href="http://www.w3.org/TR/cors/">Cross-Origin Resource Sharing</a>
     * @see <a href="http://wiki.commonjs.org/wiki/Promises/A">CommonJS Promises/A</a>
     */
    @JsMethod
    public native Promise<JsObject, Void> head(ResourceHttpOptions options);

    /**
     * Asynchronously gets options the given resource. Returns a promise that will resolve to the result once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order
     * to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true
     * and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> options();

    /**
     * Asynchronously gets options the given resource. Returns a promise that will resolve to the result once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order
     * to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @param options {@link ResourceHttpOptions} object.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is true
     * and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> options(ResourceHttpOptions options);

    /**
     * Asynchronously posts data the given resource. Returns a promise that will resolve to the result once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order
     * to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @param data Data that is posted with the resource.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> post(JsObject data);

    /**
     * Asynchronously posts data the given resource. Returns a promise that will resolve to the result once loaded,
     * or reject if the resource failed to load. The data is loaded using XMLHttpRequest, which means that in order
     * to make requests to another origin, the server must have Cross-Origin Resource Sharing (CORS) headers enabled.
     * @param data Data that is posted with the resource.
     * @param options Object with the following properties: {@link ResourceHttpOptions}.
     * @return a promise that will resolve to the requested data when loaded. Returns undefined if request.throttle is
     * true and the request does not have high enough priority.
     */
    @JsMethod
    public native Promise<JsObject, Void> post(JsObject data, ResourceHttpOptions options);

    /**
     * Called when a resource fails to load. This will call the retryCallback function if defined until retryAttempts is reached.
     * @return A promise to a boolean, that if true will cause the resource request to be retried.
     */
    @JsMethod
    public native Promise<Boolean, Void> retryOnError();

    /**
     * Called when a resource fails to load. This will call the retryCallback function if defined until retryAttempts is reached.
     * @param error The error that was encountered.
     * @return A promise to a boolean, that if true will cause the resource request to be retried.
     */
    @JsMethod
    public native Promise<Boolean, Void> retryOnError(JsObject error);

    /**
     * Combines the specified object and the existing query parameters. This allows you to add many parameters at once,
     * as opposed to adding them one at a time to the queryParameters property. If a value is already set,
     * it will be replaced with the new value.
     * @param params The query parameters
     */
    @JsMethod
    public native void setQueryParameters(JsObject params);

    /**
     * Combines the specified object and the existing query parameters. This allows you to add many parameters at once,
     * as opposed to adding them one at a time to the queryParameters property. If a value is already set,
     * it will be replaced with the new value.
     * @param params The query parameters
     * @param useAsDefault If true the params will be used as the default values, so they will only be set if they are undefined.
     */
    @JsMethod
    public native void setQueryParameters(JsObject params, boolean useAsDefault);

    /**
     * A function that returns the value of the property.
     */
    @JsFunction
    public interface RetryCallback {
        /**
         *
         * @param resource The resource that failed to load.
         * @param error The error that occurred during the loading of the resource.
         * @return If true or a promise that resolved to true, the resource will be retried. Otherwise the
         * failure will be returned.
         */
        Promise<Boolean, Void> function(Resource resource, String error);
    }
}
