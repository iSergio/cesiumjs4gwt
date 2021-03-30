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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.core.OpenCageGeocoderService}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OpenCageGeocoderServiceOptions {
    /**
     * When set to 1 we attempt to abbreviate and shorten the formatted string we
     * return.
     */
    @JsProperty
    public int abbrv;
    /**
     * When set to 1 the various request parameters are added to the response for
     * ease of debugging.
     */
    @JsProperty
    public int add_request;
    /**
     * Provides the geocoder with a hint to the region that the query resides in.
     */
    @JsProperty
    public String bounds;
    /**
     * Restricts the results to the specified country or countries (as defined by
     * the ISO 3166-1 Alpha 2 standard).
     */
    @JsProperty
    public String countrycode;
    /**
     * Wraps the returned JSON with a function name.
     */
    @JsProperty
    public String jsonp;
    /**
     * An IETF format language code.
     */
    @JsProperty
    public String language;
    /**
     * The maximum number of results we should return.
     */
    @JsProperty
    public int limiе;
    /**
     * An integer from 1-10. Only results with at least this confidence will be
     * returned.
     */
    @JsProperty
    public int min_confidence;
    /**
     * When set to 1 results will not contain annotations.
     */
    @JsProperty
    public int no_annotations;
    /**
     * When set to 1 results will not be deduplicated.
     */
    @JsProperty
    public int no_dedupe;
    /**
     * When set to 1 the query contents are not logged.
     */
    @JsProperty
    public int no_record;
    /**
     * When set to 1 results are 'pretty' printed for easier reading. Useful for
     * debugging.
     */
    @JsProperty
    public int pretty;
    /**
     * Provides the geocoder with a hint to bias results in favour of those closer
     * to the specified location (For example: 41.40139,2.12870).
     */
    @JsProperty
    public String proximity;

    @JsConstructor
    public OpenCageGeocoderServiceOptions() {
    }
}
