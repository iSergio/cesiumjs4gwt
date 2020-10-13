/*
 * Copyright 2018 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cesiumjs.cs.datasources.properties;

import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.enums.ReferenceFrame;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A {@link TimeIntervalCollectionProperty} which is also a
 * {@link PositionProperty}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeIntervalCollectionPositionProperty")
public class TimeIntervalCollectionPositionProperty extends PositionProperty {
  /**
   * Gets the event that is raised whenever the definition of this property
   * changes. The definition is considered to have changed if a call to getValue
   * would return a different result for the same time.
   */
  @JsProperty
  public native Event definitionChanged();

  /**
   * Gets the interval collection.
   */
  @JsProperty
  public TimeIntervalCollection intervals;

  /**
   * Gets a value indicating if this property is constant. A property is
   * considered constant if getValue always returns the same result for the
   * current definition.
   */
  @JsProperty
  public native boolean isConstant();

  /**
   * Gets the reference frame in which the position is defined. Default:
   * {@link ReferenceFrame#FIXED()}
   */
  @JsProperty
  public ReferenceFrame referenceFrame;

  /**
   * A {@link TimeIntervalCollectionProperty} which is also a
   * {@link PositionProperty}.
   */
  @JsConstructor
  public TimeIntervalCollectionPositionProperty() {
  }

  /**
   * A {@link TimeIntervalCollectionProperty} which is also a
   * {@link PositionProperty}.
   * 
   * @param referenceFrame The reference frame in which the position is defined.
   */
  @JsConstructor
  public TimeIntervalCollectionPositionProperty(ReferenceFrame referenceFrame) {
  }

  /**
   * Compares this property to the provided property and returns true if they are
   * equal, false otherwise.
   * 
   * @param other The other property.
   * @return true if left and right are equal, false otherwise.
   */
  public native boolean equals(Property other);
}
