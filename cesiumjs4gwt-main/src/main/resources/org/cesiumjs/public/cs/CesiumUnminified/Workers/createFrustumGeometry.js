define(['./defaultValue-fe22d8c0', './FrustumGeometry-b62db3e3', './Transforms-9e9df299', './Matrix3-fa806b97', './Check-6ede7e26', './Math-dad82b4d', './Matrix2-1e403d0e', './RuntimeError-ef395448', './combine-d9581036', './ComponentDatatype-cf1fa08e', './WebGLConstants-0b1ce7ba', './GeometryAttribute-780af4fa', './GeometryAttributes-ad136444', './Plane-c27e1ac6', './VertexFormat-030f11ff'], (function (defaultValue, FrustumGeometry, Transforms, Matrix3, Check, Math, Matrix2, RuntimeError, combine, ComponentDatatype, WebGLConstants, GeometryAttribute, GeometryAttributes, Plane, VertexFormat) { 'use strict';

  function createFrustumGeometry(frustumGeometry, offset) {
    if (defaultValue.defined(offset)) {
      frustumGeometry = FrustumGeometry.FrustumGeometry.unpack(frustumGeometry, offset);
    }
    return FrustumGeometry.FrustumGeometry.createGeometry(frustumGeometry);
  }

  return createFrustumGeometry;

}));
