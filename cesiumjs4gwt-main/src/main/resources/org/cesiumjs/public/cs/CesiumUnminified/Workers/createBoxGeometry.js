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

define(['./BoxGeometry-863653d7', './defaultValue-81eec7ed', './GeometryOffsetAttribute-2bff0974', './RuntimeError-8952249c', './Transforms-4ee811db', './Matrix2-c430e55a', './ComponentDatatype-9e86ac8f', './WebGLConstants-508b9636', './_commonjsHelpers-3aae1032-26891ab7', './combine-3c023bda', './GeometryAttribute-51ed9bde', './GeometryAttributes-32b29525', './VertexFormat-7df34ea5'], (function (BoxGeometry, defaultValue, GeometryOffsetAttribute, RuntimeError, Transforms, Matrix2, ComponentDatatype, WebGLConstants, _commonjsHelpers3aae1032, combine, GeometryAttribute, GeometryAttributes, VertexFormat) { 'use strict';

  function createBoxGeometry(boxGeometry, offset) {
    if (defaultValue.defined(offset)) {
      boxGeometry = BoxGeometry.BoxGeometry.unpack(boxGeometry, offset);
    }
    return BoxGeometry.BoxGeometry.createGeometry(boxGeometry);
  }

  return createBoxGeometry;

}));
//# sourceMappingURL=createBoxGeometry.js.map
