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
  PrimitivePipeline_default
} from "./chunk-Y2ME2IJV.js";
import {
  createTaskProcessorWorker_default
} from "./chunk-3VAZEH7M.js";
import "./chunk-2UPKWTMJ.js";
import "./chunk-EG6PTBY2.js";
import "./chunk-Z3TIFFGF.js";
import "./chunk-ZT7KWISZ.js";
import "./chunk-2FRVPMCS.js";
import "./chunk-Y5UQJLYE.js";
import "./chunk-LPR3YNP2.js";
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
import "./chunk-YWTJ2B4B.js";

// packages/engine/Source/Workers/combineGeometry.js
function combineGeometry(packedParameters, transferableObjects) {
  const parameters = PrimitivePipeline_default.unpackCombineGeometryParameters(
    packedParameters
  );
  const results = PrimitivePipeline_default.combineGeometry(parameters);
  return PrimitivePipeline_default.packCombineGeometryResults(
    results,
    transferableObjects
  );
}
var combineGeometry_default = createTaskProcessorWorker_default(combineGeometry);
export {
  combineGeometry_default as default
};
