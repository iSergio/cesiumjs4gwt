define(['./Matrix3-fa806b97', './defaultValue-fe22d8c0', './EllipseGeometry-a49f8449', './Check-6ede7e26', './Math-dad82b4d', './Transforms-9e9df299', './Matrix2-1e403d0e', './RuntimeError-ef395448', './combine-d9581036', './ComponentDatatype-cf1fa08e', './WebGLConstants-0b1ce7ba', './EllipseGeometryLibrary-cba7edde', './GeometryAttribute-780af4fa', './GeometryAttributes-ad136444', './GeometryInstance-3fb607b7', './GeometryOffsetAttribute-9ad0019c', './GeometryPipeline-36b61c99', './AttributeCompression-8a5a065e', './EncodedCartesian3-e8bbca36', './IndexDatatype-b8f3e09d', './IntersectionTests-e889fcf0', './Plane-c27e1ac6', './VertexFormat-030f11ff'], (function (Matrix3, defaultValue, EllipseGeometry, Check, Math, Transforms, Matrix2, RuntimeError, combine, ComponentDatatype, WebGLConstants, EllipseGeometryLibrary, GeometryAttribute, GeometryAttributes, GeometryInstance, GeometryOffsetAttribute, GeometryPipeline, AttributeCompression, EncodedCartesian3, IndexDatatype, IntersectionTests, Plane, VertexFormat) { 'use strict';

  function createEllipseGeometry(ellipseGeometry, offset) {
    if (defaultValue.defined(offset)) {
      ellipseGeometry = EllipseGeometry.EllipseGeometry.unpack(ellipseGeometry, offset);
    }
    ellipseGeometry._center = Matrix3.Cartesian3.clone(ellipseGeometry._center);
    ellipseGeometry._ellipsoid = Matrix3.Ellipsoid.clone(ellipseGeometry._ellipsoid);
    return EllipseGeometry.EllipseGeometry.createGeometry(ellipseGeometry);
  }

  return createEllipseGeometry;

}));
