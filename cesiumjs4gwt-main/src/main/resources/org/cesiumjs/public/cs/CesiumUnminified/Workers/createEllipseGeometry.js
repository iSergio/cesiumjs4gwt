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

define(['./Matrix2-cae5ed62', './defaultValue-50f7432c', './EllipseGeometry-700562a3', './RuntimeError-6b9130a9', './ComponentDatatype-0b8ce457', './WebGLConstants-58abc51a', './Transforms-318b929f', './combine-8462e002', './EllipseGeometryLibrary-9214016d', './GeometryAttribute-a14260ea', './GeometryAttributes-8bab1b25', './GeometryInstance-ef91d372', './GeometryOffsetAttribute-490bc2c9', './GeometryPipeline-58a6c637', './AttributeCompression-b61f6b08', './EncodedCartesian3-a8cb9052', './IndexDatatype-3480a65d', './IntersectionTests-77ed1e84', './Plane-a03160e2', './VertexFormat-29aad777'], (function (Matrix2, defaultValue, EllipseGeometry, RuntimeError, ComponentDatatype, WebGLConstants, Transforms, combine, EllipseGeometryLibrary, GeometryAttribute, GeometryAttributes, GeometryInstance, GeometryOffsetAttribute, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, VertexFormat) { 'use strict';

  function createEllipseGeometry(ellipseGeometry, offset) {
    if (defaultValue.defined(offset)) {
      ellipseGeometry = EllipseGeometry.EllipseGeometry.unpack(ellipseGeometry, offset);
    }
    ellipseGeometry._center = Matrix2.Cartesian3.clone(ellipseGeometry._center);
    ellipseGeometry._ellipsoid = Matrix2.Ellipsoid.clone(ellipseGeometry._ellipsoid);
    return EllipseGeometry.EllipseGeometry.createGeometry(ellipseGeometry);
  }

  return createEllipseGeometry;

}));
