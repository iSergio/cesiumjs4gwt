/*
 * Copyright 2017 iserge.
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

package org.cesiumjs.cs.widgets;

import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;

/**
 * A Command is a function with an extra canExecute observable property to determine whether the command can be executed.
 * When executed, a Command function will check the value of canExecute and throw if false. This type describes an
 * interface and is not intended to be instantiated directly. See {@link org.cesiumjs.cs.Cesium#createCommand} to create a command from a function.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Command")
public abstract class Command {
    public Event afterExecute;
    public Event beforeExecute;
    public Boolean canExecute;
}
