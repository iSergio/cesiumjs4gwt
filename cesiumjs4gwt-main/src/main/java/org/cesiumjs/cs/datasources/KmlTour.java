/*
 * Copyright 2022 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.widgets.CesiumWidget;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.Widget;

/**
 * Describes a KmlTour, which uses {@link KmlTourFlyTo}, and {@link KmlTourWait} to guide the camera to a specified
 * destinations on given time intervals.
 */
@JsType(isNative = true, namespace = "Cesium", name = "KmlTour")
public class KmlTour {
    /**
     * Event will be called when entry from playlist ends to play. Event callback will be called with following
     * parameters: 1. entry - entry 2. terminated - true if playback was terminated by calling KmlTour#stop
     */
    @JsProperty
    public Event<EntryEndCallback> entryEnd;

    /**
     * Event will be called when entry from playlist starts to play.
     * Event callback will be called with curent entry as first parameter.
     */
    @JsProperty
    public Event<EntryStartCallback> entryStart;

    /**
     * Id of kml gx:Tour entry
     */
    @JsProperty
    public String id;

    /**
     * Tour name
     */
    @JsProperty
    public String name;

    /**
     * Array of playlist entries
     */
    @JsProperty
    public JsArray<KmlTourEntry> playlist;

    /**
     * Index of current entry from playlist
     */
    @JsProperty
    public Number playlistIndex;

    /**
     * Event will be called when all playlist entries are played, or tour playback being canceled. If tour playback
     * was terminated, event callback will be called with terminated=true parameter.
     */
    @JsProperty
    public Event<TourEndCallback> tourEnd;

    /**
     * Event will be called when tour starts to play, before any playlist entry starts to play.
     */
    @JsProperty
    public Event<TourStartCallback> tourStart;

    @JsConstructor
    public KmlTour(String name, String id, JsArray playlist) {}

    /**
     * Add entry to this tour playlist.
     * @param entry KmlTourFlyTo | KmlTourWait	an entry to add to the playlist.
     */
    @JsMethod
    public native void addPlaylistEntry(KmlTourEntry entry);

    /**
     * Play this tour.
     * @param widget The widget.
     */
    @JsMethod
    public native void play(Widget widget);

    /**
     * Play this tour.
     * @param widget The widget.
     * @param cameraOptions these options will be merged with Camera#flyTo options for FlyTo playlist entries.
     */
    @JsMethod
    public native void play(Widget widget, JsObject cameraOptions);

    /**
     * Stop curently playing tour.
     */
    @JsMethod
    public native void stop();

    @JsFunction
    public interface TourStartCallback {
        void function();
    }

    @JsFunction
    public interface TourEndCallback {
        void function(boolean terminated);
    }

    @JsFunction
    public interface EntryStartCallback {
        void function(KmlTourEntry entry);
    }
    @JsFunction
    public interface EntryEndCallback {
        void function(KmlTourEntry entry, boolean terminated);
    }
}
