/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.97
 *
 * Copyright 2011-2022 Cesium Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Columbus View (Pat. Pend.)
 *
 * Portions licensed separately.
 * See https://github.com/CesiumGS/cesium/blob/main/LICENSE.md for full licensing details.
 */

define(['./defaultValue-a6eb9f34', './PrimitivePipeline-c8fc30b4', './createTaskProcessorWorker', './Transforms-c78c4637', './Matrix2-ab676047', './RuntimeError-1088cc64', './ComponentDatatype-e06f4e16', './WebGLConstants-d81b330d', './_commonjsHelpers-89c9b271', './combine-7cf28d88', './GeometryAttribute-4f02e2ad', './GeometryAttributes-aff51037', './GeometryPipeline-5a61c463', './AttributeCompression-8033f934', './EncodedCartesian3-7959a913', './IndexDatatype-c2232ebd', './IntersectionTests-f96cd46d', './Plane-c985a1d2', './WebMercatorProjection-0d64470e'], (function (defaultValue, PrimitivePipeline, createTaskProcessorWorker, Transforms, Matrix2, RuntimeError, ComponentDatatype, WebGLConstants, _commonjsHelpers, combine, GeometryAttribute, GeometryAttributes, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, WebMercatorProjection) { 'use strict';

  /* global require */

  const moduleCache = {};

  function getModule(moduleName) {
    let module = moduleCache[moduleName];
    if (!defaultValue.defined(module)) {
      if (typeof exports === "object") {
        // Use CommonJS-style require.
        moduleCache[module] = module = require(`Workers/${moduleName}`);
      } else {
        // Use AMD-style require.
        // in web workers, require is synchronous
        require([`Workers/${moduleName}`], function (f) {
          module = f;
          moduleCache[module] = f;
        });
      }
    }
    return module;
  }

  function createGeometry(parameters, transferableObjects) {
    const subTasks = parameters.subTasks;
    const length = subTasks.length;
    const resultsOrPromises = new Array(length);

    for (let i = 0; i < length; i++) {
      const task = subTasks[i];
      const geometry = task.geometry;
      const moduleName = task.moduleName;

      if (defaultValue.defined(moduleName)) {
        const createFunction = getModule(moduleName);
        resultsOrPromises[i] = createFunction(geometry, task.offset);
      } else {
        //Already created geometry
        resultsOrPromises[i] = geometry;
      }
    }

    return Promise.all(resultsOrPromises).then(function (results) {
      return PrimitivePipeline.PrimitivePipeline.packCreateGeometryResults(
        results,
        transferableObjects
      );
    });
  }
  var createGeometry$1 = createTaskProcessorWorker(createGeometry);

  return createGeometry$1;

}));
