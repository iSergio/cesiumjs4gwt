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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Camera")
public class Camera {
    /**
     * The default heading/pitch/range that is used when the camera flies to a location that contains a bounding sphere.
     */
    @JsProperty
    public static HeadingPitchRange DEFAULT_OFFSET;
    /**
     * A scalar to multiply to the camera position and add it back after setting the camera to view the rectangle.
     * A value of zero means the camera will view the entire {@link Camera#DEFAULT_VIEW_RECTANGLE},
     * a value greater than zero will move it further away from the extent, and a value less than zero will move it close to the extent.
     */
    @JsProperty
    public static double DEFAULT_VIEW_FACTOR;
    /**
     * The default rectangle the camera will view on creation.
     */
    @JsProperty
    public static Rectangle DEFAULT_VIEW_RECTANGLE;
    /**
     * Gets the event that will be raised when the camera has changed by percentageChanged.
     */
    @JsProperty(name = "changed")
    public native Event changed();
    /**
     * If set, the camera will not be able to rotate past this axis in either direction.
     * Default Value:  undefined
     */
    @JsProperty
    public Cartesian3 constrainedAxis;
    /**
     * The default amount to rotate the camera when an argument is not provided to the look methods.
     Default Value:  Math.PI / 60.0
     */
    @JsProperty
    public double defaultLookAmount;
    /**
     * The default amount to move the camera when an argument is not provided to the move methods.
     * Default: 100000.0;
     */
    @JsProperty
    public double defaultMoveAmount;
    /**
     * The default amount to rotate the camera when an argument is not provided to the rotate methods.
     * Default: Math.PI / 3600.0
     */
    @JsProperty
    public double defaultRotateAmount;
    /**
     * The default amount to move the camera when an argument is not provided to the zoom methods.
     * Default: 100000.0;
     */
    @JsProperty
    public double defaultZoomAmount;
    /**
     * The view direction of the camera.
     */
    @JsProperty
    public Cartesian3 direction;
    /**
     * Gets the view direction of the camera in world coordinates.
     */
    @JsProperty(name = "directionWC")
    public native Cartesian3 directionWC();
    /**
     * The region of space in view.
     * Default: PerspectiveFrustum()
     * @see PerspectiveFrustum
     * @see PerspectiveOffCenterFrustum
     * @see OrthographicFrustum
     */
    @JsProperty
    public Frustum frustum;
    /**
     * Gets the camera heading in radians.
     */
    @JsProperty(name = "heading")
    public native double heading();
    /**
     * Gets the inverse camera transform.
     * Default: Matrix4.IDENTITY
     */
    @JsProperty(name = "inverseTransform")
    public native Matrix4 inverseTransform();
    /**
     * Gets the inverse view matrix.
     * @see #viewMatrix
     */
    @JsProperty(name = "inverseViewMatrix")
    public native Matrix4 inverseViewMatrix();
    /**
     * The factor multiplied by the the map size used to determine where to clamp the camera position when zooming
     * out from the surface. The default is 1.5. Only valid for 2D and the map is rotatable.
     * Default: 1.5
     */
    @JsProperty
    public double maximumZoomFactor;
    /**
     * Gets the event that will be raised when the camera has stopped moving.
     */
    @JsProperty(name = "moveEnd")
    public native Event moveEnd();

    /**
     * Gets the event that will be raised at when the camera starts to move.
     */
    @JsProperty(name = "moveStart")
    public native Event moveStart();

    /**
     * The amount the camera has to change before the changed event is raised. The value is a percentage in the [0, 1] range.
     * Default: 0.5
     */
    @JsProperty
    public float percentageChanged;
    /**
     * Gets the camera pitch in radians.
     */
    @JsProperty(name = "pitch")
    public native double pitch();
    /**
     * The position of the camera.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets the Cartographic position of the camera, with longitude and latitude expressed in radians and height in meters.
     * In 2D and Columbus View, it is possible for the returned longitude and latitude to be outside the range of valid
     * longitudes and latitudes when the camera is outside the map.
     */
    @JsProperty(name = "positionCartographic")
    public native Cartographic positionCartographic();
    /**
     * Gets the position of the camera in world coordinates.
     */
    @JsProperty(name = "positionWC")
    public native Cartesian3 positionWC();
    /**
     * The right direction of the camera.
     */
    @JsProperty
    public Cartesian3 right;
    /**
     * Gets the right direction of the camera in world coordinates.
     */
    @JsProperty(name = "rightWC")
    public native Cartesian3 rightWC();
    /**
     * Gets the camera roll in radians.
     */
    @JsProperty(name = "roll")
    public native double roll();
    /**
     * Gets the camera's reference frame. The inverse of this transformation is appended to the view matrix.
     * Default: Matrix4.IDENTITY
     */
    @JsProperty(name = "transform")
    public native Matrix4 transform();
    /**
     * The up direction of the camera.
     */
    @JsProperty
    public Cartesian3 up;
    /**
     * Gets the up direction of the camera in world coordinates.
     */
    @JsProperty(name = "upWC")
    public native Cartesian3 upWC();
    /**
     * Gets the view matrix.
     * @see #inverseViewMatrix()
     */
    @JsProperty(name = "viewMatrix")
    public native Matrix4 viewMatrix();
    /**
     * The camera is defined by a position, orientation, and view frustum.
     *
     * The orientation forms an orthonormal basis with a view, up and right = view x up unit vectors.
     *
     * The viewing frustum is defined by 6 planes. Each plane is represented by a {@link org.cesiumjs.cs.core.Cartesian4} object, where the x, y, and z
     * components define the unit vector normal to the plane, and the w component is the distance of the plane
     * from the origin/camera position.
     * @param scene The scene.
     */
    // TODO: Example
    @JsConstructor
    public Camera(Scene scene) {}

    /**
     * Transform a vector or point from the camera's reference frame to world coordinates.
     * @param cartesian The vector or point to transform.
     * @return The transformed vector or point.
     */
    @JsMethod
    public native Cartesian4 cameraToWorldCoordinates(Cartesian4 cartesian);

    /**
     * Transform a vector or point from the camera's reference frame to world coordinates.
     * @param cartesian The vector or point to transform.
     * @param result The object onto which to store the result.
     * @return The transformed vector or point.
     */
    @JsMethod
    public native Cartesian4 cameraToWorldCoordinates(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Transform a point from the camera's reference frame to world coordinates.
     * @param cartesian The point to transform.
     * @return The transformed point.
     */
    @JsMethod
    public native Cartesian3 cameraToWorldCoordinatesPoint(Cartesian3 cartesian);

    /**
     * Transform a point from the camera's reference frame to world coordinates.
     * @param cartesian The point to transform.
     * @param result The object onto which to store the result.
     * @return The transformed point.
     */
    @JsMethod
    public native Cartesian3 cameraToWorldCoordinatesPoint(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Transform a vector from the camera's reference frame to world coordinates.
     * @param cartesian The vector to transform.
     * @return The transformed vector.
     */
    @JsMethod
    public native Cartesian3 cameraToWorldCoordinatesVector(Cartesian3 cartesian);

    /**
     * Transform a vector from the camera's reference frame to world coordinates.
     * @param cartesian The vector to transform.
     * @param result The object onto which to store the result.
     * @return The transformed vector.
     */
    @JsMethod
    public native Cartesian3 cameraToWorldCoordinatesVector(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Cancels the current camera flight if one is in progress. The camera is left at it's current location.
     */
    @JsMethod
    public native void cancelFlight();

    /**
     * Computes the approximate visible rectangle on the ellipsoid.
     * @return The visible rectangle or undefined if the ellipsoid isn't visible at all.
     */
    @JsMethod
    public native Rectangle computeViewRectangle();

    /**
     * Computes the approximate visible rectangle on the ellipsoid.
     * @param ellipsoid The ellipsoid that you want to know the visible region. Default: {@link Ellipsoid#WGS84()}
     * @return The visible rectangle or undefined if the ellipsoid isn't visible at all.
     */
    @JsMethod
    public native Rectangle computeViewRectangle(Ellipsoid ellipsoid);

    /**
     * Computes the approximate visible rectangle on the ellipsoid.
     * @param ellipsoid The ellipsoid that you want to know the visible region. Default: {@link Ellipsoid#WGS84()}
     * @param result The rectangle in which to store the result
     * @return The visible rectangle or undefined if the ellipsoid isn't visible at all.
     */
    @JsMethod
    public native Rectangle computeViewRectangle(Ellipsoid ellipsoid, Rectangle result);

    /**
     * Return the distance from the camera to the front of the bounding sphere.
     * @param boundingSphere The bounding sphere in world coordinates.
     * @return The distance to the bounding sphere.
     */
    @JsMethod
    public native double distanceToBoundingSphere(BoundingSphere boundingSphere);

    /**
     * Fly the camera to the home view.
     * Use {@link Camera#DEFAULT_VIEW_RECTANGLE} to set the default view for the 3D scene.
     * The home view for 2D and columbus view shows the entire map.
     */
    @JsMethod
    public native void flyHome();

    /**
     * Fly the camera to the home view.
     * Use {@link Camera#DEFAULT_VIEW_RECTANGLE} to set the default view for the 3D scene.
     * The home view for 2D and columbus view shows the entire map.
     * @param duration The number of seconds to complete the camera flight to home. @see #flyTo
     */
    @JsMethod
    public native void flyHome(double duration);

    //TODO: Example
    /**
     * Flies the camera from its current position to a new position.
     * @param options Options.
     */
    @JsMethod
    public native void flyTo(CameraFlyToOptions options);

    /**
     * Flies the camera to a location where the current view contains the provided bounding sphere.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame.
     * The heading is the angle from y axis and increasing towards the x axis.
     * Pitch is the rotation from the xy-plane. Positive pitch angles are below the plane.
     * Negative pitch angles are above the plane. The range is the distance from the center.
     * If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D and Columbus View, there must be a top down view. The camera will be placed above the target looking down. The height above the target will be the range. The heading will be aligned to local north.
     * @param boundingSphere The bounding sphere to view, in world coordinates.
     * @param options Options
     */
    @JsMethod
    public native void flyToBoundingSphere(BoundingSphere boundingSphere, CameraFlyToOptions options);

    /**
     * Gets the magnitude of the camera position. In 3D, this is the vector magnitude. In 2D and Columbus view, this is the distance to the map.
     * @return The magnitude of the position.
     */
    @JsMethod
    public native double getMagnitude();

    /**
     * Create a ray from the camera position through the pixel at windowPosition in world coordinates.
     * @param windowPosition The x and y coordinates of a pixel.
     * @return Returns the Cartesian3 position and direction of the ray.
     */
    @JsMethod
    public native Ray getPickRay(Cartesian2 windowPosition);

    /**
     * Create a ray from the camera position through the pixel at windowPosition in world coordinates.
     * @param windowPosition The x and y coordinates of a pixel.
     * @param result The object onto which to store the result.
     * @return Returns the Cartesian3 position and direction of the ray.
     */
    @JsMethod
    public native Ray getPickRay(Cartesian2 windowPosition, Ray result);

    /**
     * Return the pixel size in meters.
     * @param boundingSphere The bounding sphere in world coordinates.
     * @param drawingBufferWidth The drawing buffer width.
     * @param drawingBufferHeight The drawing buffer height.
     * @return The pixel size in meters.
     */
    @JsMethod
    public native double getPixelSize(BoundingSphere boundingSphere, double drawingBufferWidth, double drawingBufferHeight);

    /**
     * Get the camera position needed to view an rectangle on an ellipsoid or map
     * @param rectangle The rectangle to view.
     * @return The camera position needed to view the rectangle
     */
    @JsMethod
    public native Cartesian3 getRectangleCameraCoordinates(Rectangle rectangle);

    /**
     * Get the camera position needed to view an rectangle on an ellipsoid or map
     * @param rectangle The rectangle to view.
     * @param result The camera position needed to view the rectangle
     * @return The camera position needed to view the rectangle
     */
    @JsMethod
    public native Cartesian3 getRectangleCameraCoordinates(Rectangle rectangle, Cartesian3 result);

    /**
     * Rotate each of the camera's orientation vectors around axis by angle
     * @param axis The axis to rotate around.
     * @see #lookUp
     * @see #lookDown
     * @see #lookLeft
     * @see #lookRight
     */
    @JsMethod
    public native void look(Cartesian3 axis);

    /**
     * Rotate each of the camera's orientation vectors around axis by angle
     * @param axis The axis to rotate around.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultLookAmount.
     * @see #lookUp
     * @see #lookDown
     * @see #lookLeft
     * @see #lookRight
     */
    @JsMethod
    public native void look(Cartesian3 axis, double angle);

    //TODO: Example
    /**
     * Sets the camera position and orientation using a target and offset.
     * The target must be given in world coordinates. The offset can be either a cartesian or heading/pitch/range in
     * the local east-north-up reference frame centered at the target. If the offset is a cartesian,
     * then it is an offset from the center of the reference frame defined by the transformation matrix.
     * If the offset is heading/pitch/range, then the heading and the pitch angles are defined in the reference frame
     * defined by the transformation matrix. The heading is the angle from y axis and increasing towards the x axis.
     * Pitch is the rotation from the xy-plane. Positive pitch angles are below the plane.
     * Negative pitch angles are above the plane. The range is the distance from the center. In 2D,
     * there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the magnitude of the offset. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The target position in world coordinates.
     * @param offset The offset from the target in the local east-north-up reference frame centered at the target.
     */
    @JsMethod
    public native void lookAt(Cartesian3 target, Cartesian3 offset);

    //TODO: Example
    /**
     * Sets the camera position and orientation using a target and offset.
     * The target must be given in world coordinates. The offset can be either a cartesian or heading/pitch/range in
     * the local east-north-up reference frame centered at the target. If the offset is a cartesian,
     * then it is an offset from the center of the reference frame defined by the transformation matrix.
     * If the offset is heading/pitch/range, then the heading and the pitch angles are defined in the reference frame
     * defined by the transformation matrix. The heading is the angle from y axis and increasing towards the x axis.
     * Pitch is the rotation from the xy-plane. Positive pitch angles are below the plane.
     * Negative pitch angles are above the plane. The range is the distance from the center. In 2D,
     * there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the magnitude of the offset. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The target position in world coordinates.
     * @param offset The offset from the target in the local east-north-up reference frame centered at the target.
     */
    @JsMethod
    public native void lookAt(Cartesian3 target, HeadingPitchRange offset);

    //TODO: Example
    /**
     * Sets the camera position and orientation using a target and transformation matrix.
     * The offset can be either a cartesian or heading/pitch/range. If the offset is a cartesian, then it is an offset
     * from the center of the reference frame defined by the transformation matrix. If the offset is heading/pitch/range,
     * then the heading and the pitch angles are defined in the reference frame defined by the transformation matrix.
     * The heading is the angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are below the plane. Negative pitch angles are above the plane. The range is the distance
     * from the center. In 2D, there must be a top down view. The camera will be placed above the center of the reference frame.
     * The height above the target will be the magnitude of the offset. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param transform The transformation matrix defining the reference frame.
     */
    @JsMethod
    public native void lookAtTransform(Matrix4 transform);

    //TODO: Example
    /**
     * Sets the camera position and orientation using a target and transformation matrix.
     * The offset can be either a cartesian or heading/pitch/range. If the offset is a cartesian, then it is an offset
     * from the center of the reference frame defined by the transformation matrix. If the offset is heading/pitch/range,
     * then the heading and the pitch angles are defined in the reference frame defined by the transformation matrix.
     * The heading is the angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are below the plane. Negative pitch angles are above the plane. The range is the distance
     * from the center. In 2D, there must be a top down view. The camera will be placed above the center of the reference frame.
     * The height above the target will be the magnitude of the offset. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param transform The transformation matrix defining the reference frame.
     * @param offset The offset from the target in a reference frame centered at the target.
     */
    @JsMethod
    public native void lookAtTransform(Matrix4 transform, Cartesian3 offset);

    //TODO: Example
    /**
     * Sets the camera position and orientation using a target and transformation matrix.
     * The offset can be either a cartesian or heading/pitch/range. If the offset is a cartesian, then it is an offset
     * from the center of the reference frame defined by the transformation matrix. If the offset is heading/pitch/range,
     * then the heading and the pitch angles are defined in the reference frame defined by the transformation matrix.
     * The heading is the angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are below the plane. Negative pitch angles are above the plane. The range is the distance
     * from the center. In 2D, there must be a top down view. The camera will be placed above the center of the reference frame.
     * The height above the target will be the magnitude of the offset. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param transform The transformation matrix defining the reference frame.
     * @param offset The offset from the target in a reference frame centered at the target.
     */
    @JsMethod
    public native void lookAtTransform(Matrix4 transform, HeadingPitchRange offset);

    /**
     * Rotates the camera around its right vector by amount, in radians, in the opposite direction of its up vector.
     * @see #lookUp()
     */
    @JsMethod
    public native void lookDown();

    /**
     * Rotates the camera around its right vector by amount, in radians, in the opposite direction of its up vector.
     * @param amount The amount, in radians, to rotate by. Default: {@link #defaultLookAmount}
     * @see #lookUp()
     */
    @JsMethod
    public native void lookDown(double amount);

    /**
     * Rotates the camera around its up vector by amount, in radians, in the opposite direction of its right vector.
     * @see #lookRight()
     */
    @JsMethod
    public native void lookLeft();

    /**
     * Rotates the camera around its up vector by amount, in radians, in the opposite direction of its right vector.
     * @param amount The amount, in radians, to rotate by. Default: {@link #defaultLookAmount}
     * @see #lookRight()
     */
    @JsMethod
    public native void lookLeft(double amount);

    /**
     * Rotates the camera around its up vector by amount, in radians, in the direction of its right vector.
     * @see #lookLeft()
     */
    @JsMethod
    public native void lookRight();

    /**
     * Rotates the camera around its up vector by amount, in radians, in the direction of its right vector.
     * @param amount The amount, in radians, to rotate by. Default: {@link #defaultLookAmount}
     * @see #lookLeft()
     */
    @JsMethod
    public native void lookRight(double amount);

    /**
     * Rotates the camera around its right vector by amount, in radians, in the direction of its up vector.
     * @see #lookDown()
     */
    @JsMethod
    public native void lookUp();

    /**
     * Rotates the camera around its right vector by amount, in radians, in the direction of its up vector.
     * @param amount The amount, in radians, to rotate by. Default: {@link #defaultLookAmount}.
     * @see #lookDown()
     */
    @JsMethod
    public native void lookUp(double amount);

    /**
     * Translates the camera's position by amount along direction.
     * @param direction The direction to move.
     */
    @JsMethod
    public native void move(Cartesian3 direction);

    /**
     * Translates the camera's position by amount along direction.
     * @param direction The direction to move.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveBackward()
     * @see #moveForward()
     * @see #moveLeft()
     * @see #moveRight()
     * @see #moveUp()
     * @see #moveDown()
     */
    @JsMethod
    public native void move(Cartesian3 direction, double amount);

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's view vector.
     * @see #moveForward()
     */
    @JsMethod
    public native void moveBackward();

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's view vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveForward()
     */
    @JsMethod
    public native void moveBackward(double amount);

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's up vector.
     * @see #moveUp()
     */
    @JsMethod
    public native void moveDown();

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's up vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveUp()
     */
    @JsMethod
    public native void moveDown(double amount);

    /**
     * Translates the camera's position by amount along the camera's view vector.
     * @see #moveBackward()
     */
    @JsMethod
    public native void moveForward();

    /**
     * Translates the camera's position by amount along the camera's view vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveBackward()
     */
    @JsMethod
    public native void moveForward(double amount);

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's right vector.
     * @see #moveRight()
     */
    @JsMethod
    public native void moveLeft();

    /**
     * Translates the camera's position by amount along the opposite direction of the camera's right vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveRight()
     */
    @JsMethod
    public native void moveLeft(double amount);

    /**
     * Translates the camera's position by amount along the camera's right vector.
     * @see #moveLeft()
     */
    public native void moveRight();

    /**
     * Translates the camera's position by amount along the camera's right vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveLeft()
     */
    @JsMethod
    public native void moveRight(double amount);

    /**
     * Translates the camera's position by amount along the camera's up vector.
     * @see #moveDown()
     */
    @JsMethod
    public native void moveUp();

    /**
     * Translates the camera's position by amount along the camera's up vector.
     * @param amount The amount, in meters, to move. Defaults to defaultMoveAmount.
     * @see #moveDown()
     */
    @JsMethod
    public native void moveUp(double amount);

    /**
     * Pick an ellipsoid or map.
     * @param windowPosition The x and y coordinates of a pixel.
     * @return If the ellipsoid or map was picked, returns the point on the surface of the ellipsoid or map in world coordinates.
     * If the ellipsoid or map was not picked, returns undefined.
     */
    @JsMethod
    public native Cartesian3 pickEllipsoid(Cartesian2 windowPosition);

    /**
     * Pick an ellipsoid or map.
     * @param windowPosition The x and y coordinates of a pixel.
     * @param ellipsoid The ellipsoid to pick. Default: {@link Ellipsoid#WGS84()}
     * @return If the ellipsoid or map was picked, returns the point on the surface of the ellipsoid or map in world coordinates.
     * If the ellipsoid or map was not picked, returns undefined.
     */
    @JsMethod
    public native Cartesian3 pickEllipsoid(Cartesian2 windowPosition, Ellipsoid ellipsoid);

    /**
     * Pick an ellipsoid or map.
     * @param windowPosition The x and y coordinates of a pixel.
     * @param ellipsoid The ellipsoid to pick. Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return If the ellipsoid or map was picked, returns the point on the surface of the ellipsoid or map in world coordinates.
     * If the ellipsoid or map was not picked, returns undefined.
     */
    @JsMethod
    public native Cartesian3 pickEllipsoid(Cartesian2 windowPosition, Ellipsoid ellipsoid, Cartesian3 result);

    /**
     * Rotates the camera around axis by angle. The distance of the camera's position to the center of the camera's reference frame remains the same.
     * @param axis The axis to rotate around given in world coordinates.
     * @see #rotateUp()
     * @see #rotateDown()
     * @see #rotateLeft()
     * @see #rotateRight()
     */
    @JsMethod
    public native void rotate(Cartesian3 axis);

    /**
     * Rotates the camera around axis by angle. The distance of the camera's position to the center of the camera's reference frame remains the same.
     * @param axis The axis to rotate around given in world coordinates.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultRotateAmount.
     * @see #rotateUp()
     * @see #rotateDown()
     * @see #rotateLeft()
     * @see #rotateRight()
     */
    @JsMethod
    public native void rotate(Cartesian3 axis, double angle);

    /**
     * Rotates the camera around the center of the camera's reference frame by angle downwards.
     * @see #rotateUp()
     * @see #rotate(org.cesiumjs.cs.core.Cartesian3)
     * @see #rotate(org.cesiumjs.cs.core.Cartesian3, double)
     */
    @JsMethod
    public native void rotateDown();

    /**
     * Rotates the camera around the center of the camera's reference frame by angle downwards.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultRotateAmount.
     * @see #rotateUp()
     * @see #rotate(org.cesiumjs.cs.core.Cartesian3)
     * @see #rotate(org.cesiumjs.cs.core.Cartesian3, double)
     */
    @JsMethod
    public native void rotateDown(double angle);

    /**
     * Rotates the camera around the center of the camera's reference frame by angle to the left.
     * @see #rotateRight()
     * @see #rotate()
     */
    @JsMethod
    public native void rotateLeft();

    /**
     * Rotates the camera around the center of the camera's reference frame by angle to the left.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultRotateAmount.
     * @see #rotateRight()
     * @see #rotate()
     */
    @JsMethod
    public native void rotateLeft(double angle);

    /**
     * Rotates the camera around the center of the camera's reference frame by angle to the right.
     * @see #rotateLeft()
     * @see #rotate()
     */
    @JsMethod
    public native void rotateRight();

    /**
     * Rotates the camera around the center of the camera's reference frame by angle to the right.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultRotateAmount.
     * @see #rotateLeft()
     * @see #rotate()
     */
    @JsMethod
    public native void rotateRight(double angle);

    /**
     * Rotates the camera around the center of the camera's reference frame by angle upwards.
     * @param angle The angle, in radians, to rotate by. Defaults to defaultRotateAmount.
     * @see #rotateDown()
     * @see #rotate()
     */
    @JsMethod
    public native void rotateUp(double angle);

    //TODO: Examples
    /**
     * Sets the camera position, orientation and transform.
     * @param options Options
     */
    @JsMethod
    public native void setView(ViewOptions options);

    /**
     * Switches the frustum/projection to orthographic. This function is a no-op in 2D which will always be orthographic.
     */
    @JsMethod
    public native void switchToOrthographicFrustum();

    /**
     * Switches the frustum/projection to perspective. This function is a no-op in 2D which must always be orthographic.
     */
    @JsMethod
    public native void switchToPerspectiveFrustum();

    /**
     * Rotate the camera counter-clockwise around its direction vector by amount, in radians.
     * @see #twistRight()
     */
    @JsMethod
    public native void twistLeft();

    /**
     * Rotate the camera counter-clockwise around its direction vector by amount, in radians.
     * @param amount The amount, in radians, to rotate by. Defaults to defaultLookAmount.
     * @see #twistRight()
     */
    @JsMethod
    public native void twistLeft(double amount);

    /**
     * Rotate the camera counter-clockwise around its direction vector by amount, in radians.
     * @see #twistLeft()
     */
    @JsMethod
    public native void twistRight();

    /**
     * Rotate the camera counter-clockwise around its direction vector by amount, in radians.
     * @param amount The amount, in radians, to rotate by. Defaults to defaultLookAmount.
     * @see #twistLeft()
     */
    @JsMethod
    public native void twistRight(double amount);

    /**
     * Sets the camera so that the current view contains the provided bounding sphere.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame.
     * The heading is the angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are below the plane. Negative pitch angles are above the plane.
     * The range is the distance from the center.
     * If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param boundingSphere The bounding sphere to view, in world coordinates.
     */
    @JsMethod
    public native void viewBoundingSphere(BoundingSphere boundingSphere);

    /**
     * Sets the camera so that the current view contains the provided bounding sphere.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame.
     * The heading is the angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are below the plane. Negative pitch angles are above the plane.
     * The range is the distance from the center.
     * If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param boundingSphere The bounding sphere to view, in world coordinates.
     * @param offset The offset from the target in the local east-north-up reference frame centered at the target.
     */
    @JsMethod
    public native void viewBoundingSphere(BoundingSphere boundingSphere, HeadingPitchRange offset);

    /**
     * Transform a vector or point from world coordinates to the camera's reference frame.
     * @param cartesian The vector or point to transform.
     * @return The transformed vector or point.
     */
    @JsMethod
    public native Cartesian4 worldToCameraCoordinates(Cartesian4 cartesian);

    /**
     * Transform a vector or point from world coordinates to the camera's reference frame.
     * @param cartesian The vector or point to transform.
     * @param result The object onto which to store the result.
     * @return The transformed vector or point.
     */
    @JsMethod
    public native Cartesian4 worldToCameraCoordinates(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Transform a point from world coordinates to the camera's reference frame.
     * @param cartesian The point to transform.
     * @return The transformed point.
     */
    @JsMethod
    public native Cartesian3 worldToCameraCoordinatesPoint(Cartesian3 cartesian);

    /**
     * Transform a point from world coordinates to the camera's reference frame.
     * @param cartesian The point to transform.
     * @param result The object onto which to store the result.
     * @return The transformed point.
     */
    @JsMethod
    public native Cartesian3 worldToCameraCoordinatesPoint(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Transform a vector from world coordinates to the camera's reference frame.
     * @param cartesian The vector to transform.
     * @return The transformed vector.
     */
    @JsMethod
    public native Cartesian3 worldToCameraCoordinatesVector(Cartesian3 cartesian);

    /**
     * Transform a vector from world coordinates to the camera's reference frame.
     * @param cartesian The vector to transform.
     * @param result The object onto which to store the result.
     * @return The transformed vector.
     */
    @JsMethod
    public native Cartesian3 worldToCameraCoordinatesVector(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Zooms amount along the camera's view vector.
     * @see #zoomOut()
     */
    @JsMethod
    public native void zoomIn();

    /**
     * Zooms amount along the camera's view vector.
     * @param amount The amount to move. Defaults to defaultZoomAmount.
     * @see #zoomOut()
     */
    @JsMethod
    public native void zoomIn(double amount);

    /**
     * Zooms amount along the opposite direction of the camera's view vector.
     * @see #zoomIn()
     */
    @JsMethod
    public native void zoomOut();

    /**
     * Zooms amount along the opposite direction of the camera's view vector.
     * @param amount The amount to move. Defaults to defaultZoomAmount.
     * @see #zoomIn()
     */
    @JsMethod
    public native void zoomOut(double amount);

    @JsFunction
    public interface MoveListener {
        void function();
    }

    @JsFunction
    public interface ChangedListener{
        void function(double areaPercentage);
    }

    /**
     * A function that will execute when a flight is cancelled.
     */
    @JsFunction
    public interface FlightCancelledCallback {
        /**
         * A function that will execute when a flight is cancelled.
         */
        void on();
    }

    /**
     * A function that will execute when a flight completes.
     */
    @JsFunction
    public interface FlightCompleteCallback {
        /**
         * A function that will execute when a flight completes.
         */
        void on();
    }
}
