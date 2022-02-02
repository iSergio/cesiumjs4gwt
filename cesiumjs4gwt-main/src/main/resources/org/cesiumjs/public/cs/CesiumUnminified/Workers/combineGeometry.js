/**
 * Cesium - https://github.com/CesiumGS/cesium
 *
 * Copyright 2011-2020 Cesium Contributors
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

define(['./PrimitivePipeline-99d9f158', './createTaskProcessorWorker', './Transforms-f5d400d6', './Matrix2-57f130bc', './RuntimeError-1349fdaf', './when-4bbc8319', './ComponentDatatype-17ffa790', './WebGLConstants-508b9636', './combine-e9466e32', './GeometryAttribute-48d0e89b', './GeometryAttributes-7827a6c2', './GeometryPipeline-1af7af2b', './AttributeCompression-dae39175', './EncodedCartesian3-7b753db7', './IndexDatatype-4ae6decc', './IntersectionTests-e14e2851', './Plane-0f8ffca6', './WebMercatorProjection-3b4197b5'], (function (PrimitivePipeline, createTaskProcessorWorker, Transforms, Matrix2, RuntimeError, when, ComponentDatatype, WebGLConstants, combine, GeometryAttribute, GeometryAttributes, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, WebMercatorProjection) { 'use strict';

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
//# sourceMappingURL=combineGeometry.js.map
