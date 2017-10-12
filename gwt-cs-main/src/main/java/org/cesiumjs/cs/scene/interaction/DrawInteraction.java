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

package org.cesiumjs.cs.scene.interaction;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.collections.PointPrimitiveCollection;
import org.cesiumjs.cs.collections.PrimitiveCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.enums.KeyboardEventModifier;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseDblClickEvent;
import org.cesiumjs.cs.core.events.MouseDownEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Billboard;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.PointPrimitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.CameraEventType;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.interaction.options.CirclePrimitiveOptions;
import org.cesiumjs.cs.scene.interaction.options.CorridorPrimitiveOptions;
import org.cesiumjs.cs.scene.interaction.options.DrawInteractionOptions;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class DrawInteraction {
    /**
     * {@link Scene} property.
     */
    private final Scene scene;
    /**
     * Options for draw. Need optimizations.
     */
    private final DrawInteractionOptions options;
    /**
     * Collection where created primitives will be stored
     */
    private final PrimitiveCollection collection;
    /**
     * Type of geometry primitive {@link PrimitiveType}.
     */
    private final PrimitiveType type;
    /**
     *
     */
    private ScreenSpaceEventHandler eventHandler;
    private ScreenSpaceEventHandler.Listener leftDownListener;
    private ScreenSpaceEventHandler.Listener leftUpListener;
    private ScreenSpaceEventHandler.Listener mouseMoveListener;
    private ScreenSpaceEventHandler.Listener leftDblCkickListener;

    /**
     * Primitives for points markers
     */
    private PointPrimitiveCollection points;
    /**
     * Billboards for billboards markers
     */
    private BillboardCollection billboards;
    /**
     * Current point primitive
     */
    private PointPrimitive pointPrimitive;
    /**
     * Current billboard primitive
     */
    private Billboard pointBillboard;
    /**
     * First point coordinates
     */
    private Cartographic firstPoint;
    /**
     * All draw positions
     */
    private List<Cartesian3> positions = new ArrayList<>();
    /**
     * {@link RectanglePrimitive}
     */
    private RectanglePrimitive rectangle;
    /**
     * {@link PolygonPrimitive}
     */
    private PolygonPrimitive polygon;
    /**
     * {@link CirclePrimitive}
     */
    private CirclePrimitive circle;
    /**
     * {@link CorridorPrimitive}
     */
    private CorridorPrimitive polyline;
    /**
     * {@link CorridorPrimitive} for circle object.
     */
    private CorridorPrimitive radius;
    /**
     * Geometry markers
     */
    private MarkerGroup markers;
    /**
     * Flag if left mouse button pressed
     */
    private boolean isLeftDown = false;
    /**
     * Flag if shift key down pressed
     */
    private boolean isShiftKeyDown = false;
    /**
     * Backup native {@link CameraEventType}'s for restore state
     */
    private CameraEventType[] cameraEventTypes;

    private List<Listener> drawStartListeners = new ArrayList<>();
    private List<Listener> drawEndListeners = new ArrayList<>();

    /**
     * Constructor of draw interaction.
     * @param scene current scene on which will be drawing primitives.
     * @param options {@link DrawInteractionOptions} object.
     */
    public DrawInteraction(final Scene scene, final DrawInteractionOptions options) {
        this.scene = scene;
        this.options = options;
        this.collection = options.collection == null ? scene.groundPrimitives() : options.collection;
        this.type = options.type;

        if (type == PrimitiveType.POLYGON) {
            options.minPoints = 3;
        } else if (type == PrimitiveType.CORRIDOR || type == PrimitiveType.CIRCLE) {
            options.minPoints = 2;
        }

        eventHandler = new ScreenSpaceEventHandler(scene.canvas());

        leftDownListener = new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                isLeftDown = true;

                onLeftDownEvent(event);
            }
        };

        leftUpListener = new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                isLeftDown = false;
            }
        };

        mouseMoveListener = new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                onMouseMoveEvent(event);
            }
        };

        leftDblCkickListener = new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseDblClickEvent mouseDblClickEvent = (MouseDblClickEvent) event;
                if (mouseDblClickEvent.position == null) {
                    return;
                }

                if (type == PrimitiveType.POLYGON || type == PrimitiveType.CORRIDOR) {
                    if (positions.size() < options.minPoints + 2) {
                        return;
                    }
                    finishDrawing();
                }
            }
        };

        eventHandler.setInputAction(leftDownListener, ScreenSpaceEventType.LEFT_DOWN());
        eventHandler.setInputAction(leftDownListener, ScreenSpaceEventType.LEFT_DOWN(), KeyboardEventModifier.SHIFT());
        eventHandler.setInputAction(leftUpListener, ScreenSpaceEventType.LEFT_UP());
        eventHandler.setInputAction(leftUpListener, ScreenSpaceEventType.LEFT_UP(), KeyboardEventModifier.SHIFT());
        eventHandler.setInputAction(mouseMoveListener, ScreenSpaceEventType.MOUSE_MOVE());
        eventHandler.setInputAction(mouseMoveListener, ScreenSpaceEventType.MOUSE_MOVE(), KeyboardEventModifier.SHIFT());
        eventHandler.setInputAction(leftDblCkickListener, ScreenSpaceEventType.LEFT_DOUBLE_CLICK());

        if (options.markerType == MarkerType.POINT_PRIMITIVE) {
            points = (PointPrimitiveCollection) scene.primitives().add(new PointPrimitiveCollection());
            pointPrimitive = points.add(MarkerGroup.createPoint(options));
        } else if (options.markerType == MarkerType.BILLBOARD_GRAPHIC) {
            billboards = (BillboardCollection) scene.primitives().add(new BillboardCollection());
            pointBillboard = billboards.add(MarkerGroup.createBillboard(options));
        }

        // Key Up/Down handler binding
        RootPanel.get().addDomHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                isShiftKeyDown = event.isShiftKeyDown();
                // Store camera controller event types
                cameraEventTypes = scene.screenSpaceCameraController().lookEventTypes;
                // Switch off camera controller event types
                scene.screenSpaceCameraController().lookEventTypes = (CameraEventType[]) JsObject.undefined();
            }
        }, KeyDownEvent.getType());
        RootPanel.get().addDomHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                isShiftKeyDown = event.isShiftKeyDown();
                // Restore camera controller event types
                scene.screenSpaceCameraController().lookEventTypes = cameraEventTypes;
            }
        }, KeyUpEvent.getType());
    }

    /**
     * Get current primitive collection
     * @return primitive collection
     */
    public PrimitiveCollection getCollection() {
        return collection;
    }

    /**
     * Get type of primitive which current draw
     * @return type of primitive which current draw
     */
    public PrimitiveType getType() {
        return type;
    }

    /**
     * Mouse left button click event
     * @param event {@link MouseDownEvent}
     */
    private void onLeftDownEvent(Object event) {
        startDrawing(event);
    }

    /**
     * Mouse move event
     * @param event {@link MouseMoveEvent}
     */
    private void onMouseMoveEvent(Object event) {
        modifyDrawing(event);
    }

    /**
     * Destroy draw interaction and handlers
     */
    public void destroy() {
        eventHandler.removeInputAction(ScreenSpaceEventType.LEFT_DOWN());
        eventHandler.removeInputAction(ScreenSpaceEventType.MOUSE_MOVE());
        eventHandler.destroy();

        if (billboards != null) {
            billboards.remove(pointBillboard);
            scene.primitives().remove(billboards);
        }
        if (points != null) {
            points.remove(pointPrimitive);
            scene.primitives().remove(points);
        }
    }

    private void startDrawing(Object event) {
        MouseDownEvent mouseDownEvent = (MouseDownEvent) event;
        if (mouseDownEvent.position == null) {
            return;
        }

        Cartesian3 cartesian;

        if (scene.mode.equals(SceneMode.SCENE3D())) {
            Ray ray = scene.camera().getPickRay(mouseDownEvent.position);
            cartesian = scene.globe.pick(ray, scene);
        } else {
            cartesian = scene.camera().pickEllipsoid(mouseDownEvent.position, scene.globe.ellipsoid);
        }

        if (cartesian == null) {
            return;
        }

        Event startEvent = new Event(EventType.DRAW_START, options.type);

        if (type == PrimitiveType.RECTANGLE) {
            if (rectangle == null) {
                firstPoint = scene.globe.ellipsoid.cartesianToCartographic(cartesian);
                Rectangle value = getExtent(firstPoint, firstPoint);
                updateExtent(value);
//                startEvent.setPrimitive();
            } else {
                finishDrawing();
            }
        } else if (type == PrimitiveType.POLYGON || type == PrimitiveType.CORRIDOR) {
            if (polygon == null && type == PrimitiveType.POLYGON) {
                polygon = new PolygonPrimitive(options);
                JsObject.setProperty(polygon, "asynchronous", false);
                collection.add(polygon);
                startEvent.setPrimitive(polygon);
                for (Listener listener : drawStartListeners) {
                    listener.onDraw(startEvent);
                }
            } else if (polyline == null && type == PrimitiveType.CORRIDOR) {
                polyline = new CorridorPrimitive(scene, new CorridorPrimitiveOptions(options));
                JsObject.setProperty(polyline, "asynchronous", false);
                collection.add(polyline);
                startEvent.setPrimitive(polyline);
                for (Listener listener : drawStartListeners) {
                    listener.onDraw(startEvent);
                }
            }
            if (markers == null) {
                markers = new MarkerGroup(scene, options);
            }
            if (positions.size() == 0) {
                positions.add(cartesian.clone());
                markers.add(positions.get(0));
            }
            if (positions.size() >= options.minPoints) {
                if (type == PrimitiveType.POLYGON) {
                    polygon.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                    polygon.createPrimitive = true;
                } else {
                    polyline.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                    polyline.createPrimitive = true;
                }
            }
            positions.add(cartesian);
            markers.add(cartesian);
        } else if (type == PrimitiveType.CIRCLE) {
            if (circle == null) {
                CirclePrimitiveOptions circlePrimitiveOptions = new CirclePrimitiveOptions(options);
                circlePrimitiveOptions.center = cartesian;
                circlePrimitiveOptions.radius = 0;
                circle = new CirclePrimitive(circlePrimitiveOptions);
                collection.add(circle);
                startEvent.setPrimitive(circle);
                for (Listener listener : drawStartListeners) {
                    listener.onDraw(startEvent);
                }

                // Markers
                markers = new MarkerGroup(scene, options);
                markers.add(cartesian);

                // Create radius
                CorridorPrimitiveOptions radiusOptions = new CorridorPrimitiveOptions(options);
                radiusOptions.color = Color.YELLOW();
                radiusOptions.minPoints = 2;
                radius = new CorridorPrimitive(scene, radiusOptions);
                JsObject.setProperty(radius, "asynchronous", false);
                collection.add(radius);
                if (positions.size() == 0) {
                    positions.add(cartesian.clone());
                }
                radius.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                radius.createPrimitive = true;
                positions.add(cartesian);
            } else {
                // Done
                finishDrawing();
            }
        }
    }

    private void modifyDrawing(Object event) {
        MouseMoveEvent mouseMoveEvent = (MouseMoveEvent) event;
        Cartesian2 position = mouseMoveEvent.endPosition;
        if (position == null) {
            return;
        }

        Cartesian3 cartesian;

        if (scene.mode.equals(SceneMode.SCENE3D())) {
            Ray ray = scene.camera().getPickRay(mouseMoveEvent.endPosition);
            cartesian = scene.globe.pick(ray, scene);
        } else {
            cartesian = scene.camera().pickEllipsoid(mouseMoveEvent.endPosition, scene.globe.ellipsoid);
        }

        if (cartesian == null) {
            return;
        }

        if (pointPrimitive != null) {
            pointPrimitive.position = cartesian;
        } else if (pointBillboard != null) {
            pointBillboard.position = cartesian;
        }

        if (type == PrimitiveType.RECTANGLE) {
            if (rectangle != null) {
                Cartographic secondPoint = scene.globe.ellipsoid.cartesianToCartographic(cartesian);
                Rectangle value = getExtent(firstPoint, secondPoint);
                updateExtent(value);
            }
        } else if (type == PrimitiveType.POLYGON || type == PrimitiveType.CORRIDOR) {
            if (positions.size() == 0) {
                return;
            }
            positions.remove(positions.size() - 1);
            cartesian.y += (1 + Math.random());
            positions.add(cartesian);
            if (positions.size() >= options.minPoints) {
                if (type == PrimitiveType.POLYGON) {
                    polygon.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                    polygon.createPrimitive = true;
                } else {
                    polyline.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                    polyline.createPrimitive = true;
                }
            }

            if (isShiftKeyDown && isLeftDown) {
                // Free hand mode
                positions.add(cartesian);
                // Not need display all markers ?
//                markers.add(cartesian);
            } else {
                if (options.markerType == MarkerType.POINT_PRIMITIVE) {
                    markers.getPoint(markers.count() - 1).position = cartesian;
                } else if (options.markerType == MarkerType.BILLBOARD_GRAPHIC) {
                    markers.getBillboard(markers.count() - 1).position = cartesian;
                }
            }
        } else if (type == PrimitiveType.CIRCLE) {
            if (circle == null) {
                return;
            }
            circle.setRadius(Cartesian3.distance(circle.getCenter(), cartesian));

            // Update radius
            positions.remove(positions.size() - 1);
            cartesian.y += (1 + Math.random());
            positions.add(cartesian);
            if (positions.size() >= options.minPoints) {
                radius.setPositions(positions.toArray(new Cartesian3[positions.size()]));
                radius.createPrimitive = true;
            }

            markers.update(new Cartesian3[]{cartesian});
        }
    }

    private void finishDrawing() {
        Event event = new Event(EventType.DRAW_END, options.type);
        if (rectangle != null) {
            collection.remove(rectangle);
            event.primitive = rectangle;
            rectangle = null;
        }
        firstPoint = null;
        if (polygon != null) {
            collection.remove(polygon);
            event.primitive = polygon;
            polygon = null;
        }
        if (polyline != null) {
            collection.remove(polyline);
            event.primitive = polyline;
            polyline = null;
        }
        if (circle != null) {
            collection.remove(circle);
            event.primitive = circle;
            circle = null;
        }
        if (radius != null) {
            collection.remove(radius);
            radius = null;
        }
        if (markers != null) {
            markers.remove();
            markers = null;
        }
        positions.clear();

        for (Listener listener : drawEndListeners) {
            listener.onDraw(event);
        }
    }

    private void updateExtent(Rectangle value) {
        if (rectangle == null) {
            Material material = Material.fromType(Material.ColorType());
            JsObject.setProperty(material.uniforms, "color", options.color);

            JsObject.setProperty(options, "extent", value);
            JsObject.setProperty(options, "material", material);
            JsObject.setProperty(options, "asynchronous", false);
            rectangle = new RectanglePrimitive(options);
            collection.add(rectangle);
        }
        rectangle.setRectangle(value);
        Cartesian3[] corners = getCorners(value);
        if (markers == null) {
            markers = new MarkerGroup(scene, options);
            markers.add(corners);
        } else {
            markers.update(corners);
        }
    }

    private Cartesian3[] getCorners(Rectangle value) {
        return scene.globe.ellipsoid.cartographicArrayToCartesianArray(new Cartographic[]{
                Rectangle.northwest(value),
                Rectangle.northeast(value),
                Rectangle.southeast(value),
                Rectangle.southwest(value)
        });
    }

    private Rectangle getExtent(Cartographic a, Cartographic b) {
        Rectangle extent = new Rectangle();
        extent.west = java.lang.Math.min(a.longitude, b.longitude);
        extent.east = java.lang.Math.max(a.longitude, b.longitude);
        extent.south = java.lang.Math.min(a.latitude, b.latitude);
        extent.north = java.lang.Math.max(a.latitude, b.latitude);

        double epsilon = org.cesiumjs.cs.core.Math.EPSILON7();

        if ((extent.east - extent.west) < epsilon) {
            extent.east += epsilon * 2.0;
        }

        if ((extent.north - extent.south) < epsilon) {
            extent.north += epsilon * 2.0;
        }

        return extent;
    }

    public class Event {
        /**
         * {@link PrimitiveType} which start drawing
         */
        private final PrimitiveType primitiveType;
        /**
         * {@link AbstractPrimitive} which will start or end drawing
         */
        private AbstractPrimitive primitive;
        /**
         * {@link EventType}
         */
        private final EventType eventType;

        public Event(EventType eventType, PrimitiveType primitiveType) {
            this.eventType = eventType;
            this.primitiveType = primitiveType;
        }

        public PrimitiveType getPrimitiveType() {
            return primitiveType;
        }

        public AbstractPrimitive getPrimitive() {
            return primitive;
        }

        public void setPrimitive(AbstractPrimitive primitive) {
            this.primitive = primitive;
        }

        public EventType getEventType() {
            return eventType;
        }
    }

    public enum EventType {
        DRAW_START,
        DRAW_CHANGE,
        DRAW_END
    }

    public interface Listener {
        void onDraw(Event event);
    }

    public void addDrawListener(Listener listener, EventType eventType) {
        if (eventType == EventType.DRAW_START) {
            if (!drawStartListeners.contains(listener)) {
                drawStartListeners.add(listener);
            }
        } else if (eventType == EventType.DRAW_END) {
            if (!drawEndListeners.contains(listener)) {
                drawEndListeners.add(listener);
            }
        }
    }

    public void removeDrawListener(Listener listener, EventType eventType) {
        if (eventType == EventType.DRAW_START) {
            if (drawStartListeners.contains(listener)) {
                drawStartListeners.remove(listener);
            }
        } else if (eventType == EventType.DRAW_END) {
            if (drawEndListeners.contains(listener)) {
                drawEndListeners.remove(listener);
            }
        }
    }
}
