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
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.options.WebAssemblyOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;

/**
 * A wrapper around a web worker that allows scheduling tasks for a given
 * worker, returning results asynchronously via a promise. The Worker is not
 * constructed until a task is scheduled.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "TaskProcessor")
public class TaskProcessor {
    /**
     * A wrapper around a web worker that allows scheduling tasks for a given
     * worker, returning results asynchronously via a promise. The Worker is not
     * constructed until a task is scheduled.
     *
     * @param workerName The name of the worker. This is expected to be a script in
     *                   the Workers folder.
     */
    @JsConstructor
    public TaskProcessor(String workerName) {
    }

    /**
     * A wrapper around a web worker that allows scheduling tasks for a given
     * worker, returning results asynchronously via a promise. The Worker is not
     * constructed until a task is scheduled.
     *
     * @param workerName         The name of the worker. This is expected to be a
     *                           script in the Workers folder.
     * @param maximumActiveTasks The maximum number of active tasks. Once exceeded,
     *                           scheduleTask will not queue any more tasks,
     *                           allowing work to be rescheduled in future frames.
     */
    @JsConstructor
    public TaskProcessor(String workerName, int maximumActiveTasks) {
    }

    /**
     * Destroys this object. This will immediately terminate the Worker. Once an
     * object is destroyed, it should not be used; calling any function other than
     * isDestroyed will result in a DeveloperError exception.
     */
    @JsMethod
    public native void destroy();

    /**
     * Posts a message to a web worker with configuration to initialize loading and
     * compiling a web assembly module asychronously, as well as an optional
     * fallback JavaScript module to use if Web Assembly is not supported.
     *
     * @return A promise that resolves to the result when the web worker has loaded
     * and compiled the web assembly module and is ready to process tasks.
     */
    @JsMethod
    public native Promise<Object, Void> initWebAssemblyModule();

    /**
     * Posts a message to a web worker with configuration to initialize loading and
     * compiling a web assembly module asychronously, as well as an optional
     * fallback JavaScript module to use if Web Assembly is not supported.
     *
     * @param options {@link WebAssemblyOptions} object.
     * @return A promise that resolves to the result when the web worker has loaded
     * and compiled the web assembly module and is ready to process tasks.
     */
    @JsMethod
    public native Promise<Object, Void> initWebAssemblyModule(WebAssemblyOptions options);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * <p>
     * If this object was destroyed, it should not be used; calling any function
     * other than isDestroyed will result in a DeveloperError exception.
     *
     * @return True if this object was destroyed; otherwise, false.
     * @see TaskProcessor#destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    // TODO: examples usage scheduleTask

    /**
     * Schedule a task to be processed by the web worker asynchronously. If there
     * are currently more tasks active than the maximum set by the constructor, will
     * immediately return undefined. Otherwise, returns a promise that will resolve
     * to the result posted back by the worker when finished.
     *
     * @param parameters Any input data that will be posted to the worker.
     * @return Either a promise that will resolve to the result when available, or
     * undefined if there are too many active tasks,
     */
    @JsMethod
    public native Promise<Object, Void> scheduleTask(JsObject parameters);

    // TODO: examples usage scheduleTask

    /**
     * Schedule a task to be processed by the web worker asynchronously. If there
     * are currently more tasks active than the maximum set by the constructor, will
     * immediately return undefined. Otherwise, returns a promise that will resolve
     * to the result posted back by the worker when finished.
     *
     * @param parameters          Any input data that will be posted to the worker.
     * @param transferableObjects An array of objects contained in parameters that
     *                            should be transferred to the worker instead of
     *                            copied.
     * @return Either a promise that will resolve to the result when available, or
     * undefined if there are too many active tasks,
     */
    @JsMethod
    public native Promise<Object, Void> scheduleTask(JsObject parameters, Object[] transferableObjects);
}
