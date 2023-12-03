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
  EllipseGeometry_default
} from "./chunk-6JRDO2JP.js";
import "./chunk-AEADHPUM.js";
import "./chunk-DD2PDL6D.js";
import "./chunk-TIEL2RYB.js";
import "./chunk-4EXWKTY2.js";
import "./chunk-EEL3YC6V.js";
import "./chunk-ZERWARDV.js";
import "./chunk-N7FIYNQV.js";
import "./chunk-R5NOUYKW.js";
import "./chunk-PNAD2XAN.js";
import "./chunk-CKOGHQ6J.js";
import "./chunk-EH2PEDWL.js";
import "./chunk-3R5RPSYS.js";
import "./chunk-XKGSTUQO.js";
import "./chunk-DNCKFFNR.js";
import "./chunk-IQCBK4CE.js";
import "./chunk-UJ76JVUZ.js";
import {
  Cartesian3_default,
  Ellipsoid_default
} from "./chunk-54GSYZWT.js";
import "./chunk-A3TYRSRJ.js";
import "./chunk-XNRYWRVT.js";
import "./chunk-YK5RU5AO.js";
import "./chunk-N73NY3KY.js";
import "./chunk-WYMW5NZB.js";
import {
  defined_default
} from "./chunk-FMN2NHBU.js";

// packages/engine/Source/Workers/createEllipseGeometry.js
function createEllipseGeometry(ellipseGeometry, offset) {
  if (defined_default(offset)) {
    ellipseGeometry = EllipseGeometry_default.unpack(ellipseGeometry, offset);
  }
  ellipseGeometry._center = Cartesian3_default.clone(ellipseGeometry._center);
  ellipseGeometry._ellipsoid = Ellipsoid_default.clone(ellipseGeometry._ellipsoid);
  return EllipseGeometry_default.createGeometry(ellipseGeometry);
}
var createEllipseGeometry_default = createEllipseGeometry;
export {
  createEllipseGeometry_default as default
};
