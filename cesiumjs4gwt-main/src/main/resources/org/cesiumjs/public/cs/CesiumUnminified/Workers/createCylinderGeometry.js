/**
 * @license
 * Cesium - https://github.com/CesiumGS/cesium
 * Version 1.117
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
  CylinderGeometry_default
} from "./chunk-POLFRINT.js";
import "./chunk-ZC4AGBZK.js";
import "./chunk-S4XDCPKD.js";
import "./chunk-4KIUON73.js";
import "./chunk-WWP3I7R5.js";
import "./chunk-RL73GOEF.js";
import "./chunk-34DGOKCO.js";
import "./chunk-NI2R52QD.js";
import "./chunk-I5TDPPC4.js";
import "./chunk-TMMOULW3.js";
import "./chunk-C5CE4OG6.js";
import "./chunk-4PHPQRSH.js";
import "./chunk-PEABJLCK.js";
import "./chunk-WFICTTOE.js";
import "./chunk-UCPPWV64.js";
import "./chunk-U4IMCOF5.js";
import {
  defined_default
} from "./chunk-BDUJXBVF.js";

// packages/engine/Source/Workers/createCylinderGeometry.js
function createCylinderGeometry(cylinderGeometry, offset) {
  if (defined_default(offset)) {
    cylinderGeometry = CylinderGeometry_default.unpack(cylinderGeometry, offset);
  }
  return CylinderGeometry_default.createGeometry(cylinderGeometry);
}
var createCylinderGeometry_default = createCylinderGeometry;
export {
  createCylinderGeometry_default as default
};
