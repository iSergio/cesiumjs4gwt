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

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The Animation widget provides buttons for play, pause, and reverse, along with the current time and date,
 * surrounded by a "shuttle ring" for controlling the speed of animation.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Animation")
public class Animation {
    /**
     * Gets parent container.
     */
    @JsProperty(name = "container")
    public native Element container();
    /**
     * Gets the view model.
     */
    @JsProperty(name = "viewModel")
    public native AnimationViewModel viewModel();

    /**
     * The Animation widget provides buttons for play, pause, and reverse, along with the current time and date,
     * surrounded by a "shuttle ring" for controlling the speed of animation.
     *
     * The "shuttle ring" concept is borrowed from video editing, where typically a "jog wheel" can be rotated to
     * move past individual animation frames very slowly, and a surrounding shuttle ring can be twisted to control
     * direction and speed of fast playback. Cesium typically treats time as continuous (not broken into pre-defined
     * animation frames), so this widget offers no jog wheel. Instead, the shuttle ring is capable of both fast and
     * very slow playback. Click and drag the shuttle ring pointer itself (shown above in green), or click in the
     * rest of the ring area to nudge the pointer to the next preset speed in that direction.
     *
     * The Animation widget also provides a "realtime" button (in the upper-left) that keeps animation time in sync
     * with the end user's system clock, typically displaying "today" or "right now." This mode is not available in
     * ClockRange.CLAMPED or ClockRange.LOOP_STOP mode if the current time is outside of Clock's startTime and endTime.
     * <pre>
     *     Example:
     *     {@code
     *     SimplePanel animationPanel = new SimplePanel();
     *     Clock clock = new Clock();
     *     ClockViewModel clockViewModel = new ClockViewModel(clock);
     *     AnimationViewModel viewModel = new AnimationViewModel(clockViewModel);
     *     animationPanel.addAttachHandler(new AttachEvent.Handler() {
     *         @Override
     *         public void onAttachOrDetach(AttachEvent attachEvent) {
     *             if (attachEvent.isAttached()) {
     *                 Animation animation = new Animation(((SimplePanel) attachEvent.getSource()).getElement(), viewModel);
     *                 animation.resize();
     *
     *                 Cesium.RequestAnimationFrameCallback tick = new Cesium.RequestAnimationFrameCallback() {
     *                     @Override
     *                     public void Callback(Number timestamp) {
     *                         clock.tick();
     *                         Cesium.requestAnimationFrame(this);
     *                     }
     *                 };
     *                 Cesium.requestAnimationFrame(tick);
     *             }
     *         }
     *     });
     * }
     * </pre>
     * @param container The DOM element or ID that will contain the widget.
     * @param viewModel The view model used by this widget.
     */
    @JsConstructor
    public Animation(String container, AnimationViewModel viewModel) {}

    /**
     * The Animation widget provides buttons for play, pause, and reverse, along with the current time and date,
     * surrounded by a "shuttle ring" for controlling the speed of animation.
     *
     * The "shuttle ring" concept is borrowed from video editing, where typically a "jog wheel" can be rotated to
     * move past individual animation frames very slowly, and a surrounding shuttle ring can be twisted to control
     * direction and speed of fast playback. Cesium typically treats time as continuous (not broken into pre-defined
     * animation frames), so this widget offers no jog wheel. Instead, the shuttle ring is capable of both fast and
     * very slow playback. Click and drag the shuttle ring pointer itself (shown above in green), or click in the
     * rest of the ring area to nudge the pointer to the next preset speed in that direction.
     *
     * The Animation widget also provides a "realtime" button (in the upper-left) that keeps animation time in sync
     * with the end user's system clock, typically displaying "today" or "right now." This mode is not available in
     * ClockRange.CLAMPED or ClockRange.LOOP_STOP mode if the current time is outside of Clock's startTime and endTime.
     * <pre>
     *     Example:
     *     {@code
     *     SimplePanel animationPanel = new SimplePanel();
     *     Clock clock = new Clock();
     *     ClockViewModel clockViewModel = new ClockViewModel(clock);
     *     AnimationViewModel viewModel = new AnimationViewModel(clockViewModel);
     *     animationPanel.addAttachHandler(new AttachEvent.Handler() {
     *         @Override
     *         public void onAttachOrDetach(AttachEvent attachEvent) {
     *             if (attachEvent.isAttached()) {
     *                 Animation animation = new Animation(((SimplePanel) attachEvent.getSource()).getElement(), viewModel);
     *                 animation.resize();
     *
     *                 Cesium.RequestAnimationFrameCallback tick = new Cesium.RequestAnimationFrameCallback() {
     *                     @Override
     *                     public void Callback(Number timestamp) {
     *                         clock.tick();
     *                         Cesium.requestAnimationFrame(this);
     *                     }
     *                 };
     *                 Cesium.requestAnimationFrame(tick);
     *             }
     *         }
     *     });
     * }
     * </pre>
     * @param container The DOM element or ID that will contain the widget.
     * @param viewModel The view model used by this widget.
     */
    @JsConstructor
    public Animation(Element container, AnimationViewModel viewModel) {}

    /**
     * Updates the widget to reflect any modified CSS rules for theming.
     */
    //TODO Example
    @JsMethod
    public native void applyThemeChanges();

    /**
     * Destroys the animation widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Resizes the widget to match the container size. This function should be called whenever the container size is changed.
     */
    @JsMethod
    public native void resize();
}
