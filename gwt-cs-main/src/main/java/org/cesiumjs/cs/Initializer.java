/*
 * Copyright 2016 iserge.
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

package org.cesiumjs.cs;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Initializer {
    private static final Logger LOGGER = Logger.getLogger(Initializer.class.getName());
    private final String _path;
    private final Document _document;
    private static Map<Document, Initializer> _initializerMap = new HashMap<>();
    private List<Callback<Void, Exception>> _callbacks = new ArrayList<>();

    public Initializer(String path, Document document, Callback<Void, Exception> callback) {
        _path = path;
        _document = document;
        addCallback(callback);
        _initializerMap.put(document, this);
    }

    public void initialize() {
        String path = _path + "Cesium.js";

        ScriptInjector.fromUrl(path).setWindow(getWindow(_document)).setCallback(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception e) {
                for (Callback<Void, Exception> callback : _callbacks) {
                    callback.onFailure(e);
                }
            }

            @Override
            public void onSuccess(Void aVoid) {
                createSetter(_document);

                ScriptInjector.fromString("document.setGlobalInGWT(Cesium);").setWindow(getWindow(_document)).inject();
            }
        }).inject();
    }

    public void invokeCallback() {
        for (Callback<Void, Exception> callback : _callbacks) {
            try {
                callback.onSuccess(null);
            } catch (Throwable t) {
                LOGGER.log(Level.SEVERE, "Error initialization a cesium: " + t.getLocalizedMessage(), t);
            }
        }
    }

    public void addCallback(Callback<Void, Exception> callback) {
        _callbacks.add(callback);
    }

    public static Initializer get(Document document) {
        return _initializerMap.get(document);
    }

    private static native JavaScriptObject getWindow(Document document) /*-{
        var win = document.parentWindow || document.defaultView;
        return win
    }-*/;

    private native void createSetter(Document document) /*-{
        var outerThis = this

        document.setGlobalInGWT = function (toSet) {
            Cesium = toSet;
            outerThis.@org.cesiumjs.cs.Initializer::invokeCallback()();
        }
    }-*/;

}
