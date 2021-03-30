package org.cesiumjs.cs.promise;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface Progress<V> {
    void onProgress(V value);
}
