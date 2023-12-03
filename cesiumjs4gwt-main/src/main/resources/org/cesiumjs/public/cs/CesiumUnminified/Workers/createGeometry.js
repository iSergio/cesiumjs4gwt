/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.111
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

import {
  PrimitivePipeline_default
} from "./chunk-CZFGXAMG.js";
import {
  createTaskProcessorWorker_default
} from "./chunk-MMNPUV23.js";
import "./chunk-BLXANKPB.js";
import "./chunk-TIEL2RYB.js";
import "./chunk-4EXWKTY2.js";
import "./chunk-EEL3YC6V.js";
import "./chunk-R5NOUYKW.js";
import "./chunk-PNAD2XAN.js";
import "./chunk-CKOGHQ6J.js";
import "./chunk-EH2PEDWL.js";
import "./chunk-3R5RPSYS.js";
import "./chunk-XKGSTUQO.js";
import "./chunk-DNCKFFNR.js";
import "./chunk-IQCBK4CE.js";
import "./chunk-UJ76JVUZ.js";
import "./chunk-54GSYZWT.js";
import "./chunk-A3TYRSRJ.js";
import "./chunk-XNRYWRVT.js";
import "./chunk-YK5RU5AO.js";
import "./chunk-N73NY3KY.js";
import "./chunk-WYMW5NZB.js";
import {
  __glob,
  __require,
  defined_default
} from "./chunk-FMN2NHBU.js";

// import("./**/*.js") in packages/engine/Source/Workers/createGeometry.js
var globImport_js = __glob({
  "./combineGeometry.js": () => import("./combineGeometry.js"),
  "./createBoxGeometry.js": () => import("./createBoxGeometry.js"),
  "./createBoxOutlineGeometry.js": () => import("./createBoxOutlineGeometry.js"),
  "./createCircleGeometry.js": () => import("./createCircleGeometry.js"),
  "./createCircleOutlineGeometry.js": () => import("./createCircleOutlineGeometry.js"),
  "./createCoplanarPolygonGeometry.js": () => import("./createCoplanarPolygonGeometry.js"),
  "./createCoplanarPolygonOutlineGeometry.js": () => import("./createCoplanarPolygonOutlineGeometry.js"),
  "./createCorridorGeometry.js": () => import("./createCorridorGeometry.js"),
  "./createCorridorOutlineGeometry.js": () => import("./createCorridorOutlineGeometry.js"),
  "./createCylinderGeometry.js": () => import("./createCylinderGeometry.js"),
  "./createCylinderOutlineGeometry.js": () => import("./createCylinderOutlineGeometry.js"),
  "./createEllipseGeometry.js": () => import("./createEllipseGeometry.js"),
  "./createEllipseOutlineGeometry.js": () => import("./createEllipseOutlineGeometry.js"),
  "./createEllipsoidGeometry.js": () => import("./createEllipsoidGeometry.js"),
  "./createEllipsoidOutlineGeometry.js": () => import("./createEllipsoidOutlineGeometry.js"),
  "./createFrustumGeometry.js": () => import("./createFrustumGeometry.js"),
  "./createFrustumOutlineGeometry.js": () => import("./createFrustumOutlineGeometry.js"),
  "./createGeometry.js": () => import("./createGeometry.js"),
  "./createGroundPolylineGeometry.js": () => import("./createGroundPolylineGeometry.js"),
  "./createPlaneGeometry.js": () => import("./createPlaneGeometry.js"),
  "./createPlaneOutlineGeometry.js": () => import("./createPlaneOutlineGeometry.js"),
  "./createPolygonGeometry.js": () => import("./createPolygonGeometry.js"),
  "./createPolygonOutlineGeometry.js": () => import("./createPolygonOutlineGeometry.js"),
  "./createPolylineGeometry.js": () => import("./createPolylineGeometry.js"),
  "./createPolylineVolumeGeometry.js": () => import("./createPolylineVolumeGeometry.js"),
  "./createPolylineVolumeOutlineGeometry.js": () => import("./createPolylineVolumeOutlineGeometry.js"),
  "./createRectangleGeometry.js": () => import("./createRectangleGeometry.js"),
  "./createRectangleOutlineGeometry.js": () => import("./createRectangleOutlineGeometry.js"),
  "./createSimplePolylineGeometry.js": () => import("./createSimplePolylineGeometry.js"),
  "./createSphereGeometry.js": () => import("./createSphereGeometry.js"),
  "./createSphereOutlineGeometry.js": () => import("./createSphereOutlineGeometry.js"),
  "./createTaskProcessorWorker.js": () => import("./createTaskProcessorWorker.js"),
  "./createVectorTileClampedPolylines.js": () => import("./createVectorTileClampedPolylines.js"),
  "./createVectorTileGeometries.js": () => import("./createVectorTileGeometries.js"),
  "./createVectorTilePoints.js": () => import("./createVectorTilePoints.js"),
  "./createVectorTilePolygons.js": () => import("./createVectorTilePolygons.js"),
  "./createVectorTilePolylines.js": () => import("./createVectorTilePolylines.js"),
  "./createVerticesFromGoogleEarthEnterpriseBuffer.js": () => import("./createVerticesFromGoogleEarthEnterpriseBuffer.js"),
  "./createVerticesFromHeightmap.js": () => import("./createVerticesFromHeightmap.js"),
  "./createVerticesFromQuantizedTerrainMesh.js": () => import("./createVerticesFromQuantizedTerrainMesh.js"),
  "./createWallGeometry.js": () => import("./createWallGeometry.js"),
  "./createWallOutlineGeometry.js": () => import("./createWallOutlineGeometry.js"),
  "./decodeDraco.js": () => import("./decodeDraco.js"),
  "./decodeGoogleEarthEnterprisePacket.js": () => import("./decodeGoogleEarthEnterprisePacket.js"),
  "./decodeI3S.js": () => import("./decodeI3S.js"),
  "./transcodeKTX2.js": () => import("./transcodeKTX2.js"),
  "./transferTypedArrayTest.js": () => import("./transferTypedArrayTest.js"),
  "./upsampleQuantizedTerrainMesh.js": () => import("./upsampleQuantizedTerrainMesh.js")
});

// packages/engine/Source/Workers/createGeometry.js
var moduleCache = {};
async function getModule(moduleName) {
  let module = moduleCache[moduleName];
  if (!defined_default(module)) {
    if (typeof exports === "object") {
      moduleCache[module] = module = __require(`Workers/${moduleName}`);
    } else {
      const result = await globImport_js(`./${moduleName}.js`);
      module = result.default;
      moduleCache[module] = module;
    }
  }
  return module;
}
async function createGeometry(parameters, transferableObjects) {
  const subTasks = parameters.subTasks;
  const length = subTasks.length;
  const resultsOrPromises = new Array(length);
  for (let i = 0; i < length; i++) {
    const task = subTasks[i];
    const geometry = task.geometry;
    const moduleName = task.moduleName;
    if (defined_default(moduleName)) {
      resultsOrPromises[i] = getModule(moduleName).then(
        (createFunction) => createFunction(geometry, task.offset)
      );
    } else {
      resultsOrPromises[i] = geometry;
    }
  }
  return Promise.all(resultsOrPromises).then(function(results) {
    return PrimitivePipeline_default.packCreateGeometryResults(
      results,
      transferableObjects
    );
  });
}
var createGeometry_default = createTaskProcessorWorker_default(createGeometry);
export {
  createGeometry_default as default
};
