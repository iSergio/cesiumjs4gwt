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

define(['./PrimitivePipeline-100c2689', './createTaskProcessorWorker', './Transforms-318b929f', './Matrix2-cae5ed62', './RuntimeError-6b9130a9', './defaultValue-50f7432c', './ComponentDatatype-0b8ce457', './WebGLConstants-58abc51a', './combine-8462e002', './GeometryAttribute-a14260ea', './GeometryAttributes-8bab1b25', './GeometryPipeline-58a6c637', './AttributeCompression-b61f6b08', './EncodedCartesian3-a8cb9052', './IndexDatatype-3480a65d', './IntersectionTests-77ed1e84', './Plane-a03160e2', './WebMercatorProjection-0197b2e8'], (function (PrimitivePipeline, createTaskProcessorWorker, Transforms, Matrix2, RuntimeError, defaultValue, ComponentDatatype, WebGLConstants, combine, GeometryAttribute, GeometryAttributes, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, WebMercatorProjection) { 'use strict';

  function combineGeometry(packedParameters, transferableObjects) {
    const parameters = PrimitivePipeline.PrimitivePipeline.unpackCombineGeometryParameters(
      packedParameters
    );
    const results = PrimitivePipeline.PrimitivePipeline.combineGeometry(parameters);
    return PrimitivePipeline.PrimitivePipeline.packCombineGeometryResults(
      results,
      transferableObjects
    );
  }
  var combineGeometry$1 = createTaskProcessorWorker(combineGeometry);

  return combineGeometry$1;

}));
