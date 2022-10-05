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

define(['./CylinderGeometry-67cf2f61', './defaultValue-50f7432c', './Transforms-318b929f', './Matrix2-cae5ed62', './RuntimeError-6b9130a9', './ComponentDatatype-0b8ce457', './WebGLConstants-58abc51a', './combine-8462e002', './CylinderGeometryLibrary-c59008db', './GeometryAttribute-a14260ea', './GeometryAttributes-8bab1b25', './GeometryOffsetAttribute-490bc2c9', './IndexDatatype-3480a65d', './VertexFormat-29aad777'], (function (CylinderGeometry, defaultValue, Transforms, Matrix2, RuntimeError, ComponentDatatype, WebGLConstants, combine, CylinderGeometryLibrary, GeometryAttribute, GeometryAttributes, GeometryOffsetAttribute, IndexDatatype, VertexFormat) { 'use strict';

  function createCylinderGeometry(cylinderGeometry, offset) {
    if (defaultValue.defined(offset)) {
      cylinderGeometry = CylinderGeometry.CylinderGeometry.unpack(cylinderGeometry, offset);
    }
    return CylinderGeometry.CylinderGeometry.createGeometry(cylinderGeometry);
  }

  return createCylinderGeometry;

}));
