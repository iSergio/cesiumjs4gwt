/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.98
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

define(['./defaultValue-50f7432c', './PrimitivePipeline-100c2689', './createTaskProcessorWorker', './Transforms-318b929f', './Matrix2-cae5ed62', './RuntimeError-6b9130a9', './ComponentDatatype-0b8ce457', './WebGLConstants-58abc51a', './combine-8462e002', './GeometryAttribute-a14260ea', './GeometryAttributes-8bab1b25', './GeometryPipeline-58a6c637', './AttributeCompression-b61f6b08', './EncodedCartesian3-a8cb9052', './IndexDatatype-3480a65d', './IntersectionTests-77ed1e84', './Plane-a03160e2', './WebMercatorProjection-0197b2e8'], (function (defaultValue, PrimitivePipeline, createTaskProcessorWorker, Transforms, Matrix2, RuntimeError, ComponentDatatype, WebGLConstants, combine, GeometryAttribute, GeometryAttributes, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, WebMercatorProjection) { 'use strict';

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
