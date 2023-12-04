/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.112
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
  FrustumGeometry_default
} from "./chunk-N7TYCDTR.js";
import "./chunk-ZTYE74E2.js";
import "./chunk-4EYB62WJ.js";
import "./chunk-SJDXMQSP.js";
import "./chunk-OTBRPBCC.js";
import "./chunk-D4YHO4NZ.js";
import "./chunk-HSW63JN4.js";
import "./chunk-RSWBNJPT.js";
import "./chunk-Z6LPXA7S.js";
import "./chunk-PHQVHDVI.js";
import "./chunk-IZED7ODV.js";
import "./chunk-VNRUVNIK.js";
import "./chunk-66CXKODF.js";
import "./chunk-C53JYYKX.js";
import "./chunk-7FEGZO3D.js";
import {
  defined_default
} from "./chunk-YS4KPNLC.js";

// packages/engine/Source/Workers/createFrustumGeometry.js
function createFrustumGeometry(frustumGeometry, offset) {
  if (defined_default(offset)) {
    frustumGeometry = FrustumGeometry_default.unpack(frustumGeometry, offset);
  }
  return FrustumGeometry_default.createGeometry(frustumGeometry);
}
var createFrustumGeometry_default = createFrustumGeometry;
export {
  createFrustumGeometry_default as default
};
