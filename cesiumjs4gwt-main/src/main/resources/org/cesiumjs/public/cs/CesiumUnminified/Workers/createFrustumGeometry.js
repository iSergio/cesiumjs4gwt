/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.115
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
} from "./chunk-T3XIFPYR.js";
import "./chunk-2FWRMUTY.js";
import "./chunk-Y5UQJLYE.js";
import "./chunk-4H7PY4U5.js";
import "./chunk-7TC63SJW.js";
import "./chunk-FJKNFAKQ.js";
import "./chunk-TTUZP4BO.js";
import "./chunk-BG4UCVXN.js";
import "./chunk-YJEBABKH.js";
import "./chunk-PPH7OFP3.js";
import "./chunk-OGXZVPPM.js";
import "./chunk-5QULIR53.js";
import "./chunk-SOWMRMWA.js";
import "./chunk-STW2DGFI.js";
import "./chunk-BBWDMCVU.js";
import "./chunk-XGI5BXZY.js";
import {
  defined_default
} from "./chunk-YWTJ2B4B.js";

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
