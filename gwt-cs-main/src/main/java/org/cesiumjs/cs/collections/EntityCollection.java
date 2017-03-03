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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.TimeInterval;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.options.EntityOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "EntityCollection")
public class EntityCollection {
    /**
     * Gets the event that is fired when entities are added or removed from the collection.
     * The generated event is a EntityCollection.collectionChangedEventCallback.
     */
    @JsProperty(name = "collectionChanged")
    public native Event collectionChanged();
    /**
     * Gets a globally unique identifier for this collection.
     */
    @JsProperty(name = "id")
    public native String id();
    /**
     * Gets the owner of this entity collection, ie. the data source or composite entity collection which created it.
     * {@link DataSource} | {@link CompositeEntityCollection}
     */
    @JsProperty(name = "owner")
    public native Object owner();
    /**
     * Gets whether or not this entity collection should be displayed.
     * When true, each entity is only displayed if its own show property is also true.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets the array of Entity instances in the collection. This array should not be modified directly.
     */
    @JsProperty(name = "values")
    public native Entity[] values();

    /**
     * An observable collection of {@link Entity} instances where each entity has a unique id.
     */
    @JsConstructor
    public EntityCollection() {}

    /**
     * An observable collection of {@link Entity} instances where each entity has a unique id.
     * @param object {@link CompositeEntityCollection} Composite entity collection which created this collection.
     */
    @JsConstructor
    public EntityCollection(CompositeEntityCollection object) {}

    /**
     * An observable collection of {@link Entity} instances where each entity has a unique id.
     * @param owner {@link DataSource} The data source which created this collection.
     */
    @JsConstructor
    public EntityCollection(DataSource owner) {}

    /**
     * Add an entity to the collection.
     * @param entity The entity to be added.
     * @return The entity that was added.
     */
    @JsMethod
    public native Entity add(Entity entity);

    /**
     * Add an entity to collection by entity options
     * @param entityOptions Entity options
     * @return The entity that was added.
     */
    @JsMethod
    public native Entity add(EntityOptions entityOptions);
    /**
     * Computes the maximum availability of the entities in the collection. If the collection contains a mix of infinitely available data and non-infinite data, it will return the interval pertaining to the non-infinite data only. If all data is infinite, an infinite interval will be returned.
     * @return The availability of entities in the collection.
     */
    @JsMethod
    public native TimeInterval computeAvailability();

    /**
     * Returns true if the provided entity is in this collection, false otherwise.
     * @param entity true if the provided entity is in this collection, false otherwise.
     * @return true if the provided entity is in this collection, false otherwise.
     */
    @JsMethod
    public native boolean contains(Entity entity);

    /**
     * Gets an entity with the specified id.
     * @param id The id of the entity to retrieve.
     * @return The entity with the provided id or undefined if the id did not exist in the collection.
     */
    @JsMethod
    public native Entity getById(Object id);

    /**
     * Gets an entity with the specified id or creates it and adds it to the collection if it does not exist.
     * @param id The id of the entity to retrieve or create.
     * @return The new or existing object.
     */
    @JsMethod
    public native Entity getOrCreateEntity(Object id);

    /**
     * Removes an entity from the collection.
     * @param entity The entity to be removed.
     * @return true if the item was removed, false if it did not exist in the collection.
     */
    public native boolean remove(Entity entity);

    /**
     * Removes all Entities from the collection.
     */
    @JsMethod
    public native void removeAll();

    /**
     * Removes an entity with the provided id from the collection.
     * @param id The id of the entity to remove.
     * @return true if the item was removed, false if no item with the provided id existed in the collection.
     */
    @JsMethod
    public native boolean removeById(Object id);

    /**
     * Resumes raising EntityCollection#collectionChanged events immediately when an item is added or removed.
     * Any modifications made while while events were suspended will be triggered as a single event when this function is called.
     * This function is reference counted and can safely be called multiple times as long as there are corresponding calls to
     * EntityCollection#resumeEvents.
     */
    @JsMethod
    public native void resumeEvents();

    /**
     * Prevents EntityCollection#collectionChanged events from being raised until a corresponding call is made to
     * EntityCollection#resumeEvents, at which point a single event will be raised that covers all suspended operations.
     * This allows for many items to be added and removed efficiently. This function can be safely called multiple times as
     * long as there are corresponding calls to EntityCollection#resumeEvents.
     */
    @JsMethod
    public native void suspendEvents();

    /**
     * The signature of the event generated by EntityCollection#collectionChanged.
     */
    @JsFunction
    public interface CollectionChangedEventCallback {
        /**
         * The signature of the event generated by EntityCollection#collectionChanged.
         * @param collection The collection that triggered the event.
         * @param added The array of Entity instances that have been added to the collection.
         * @param removed The array of Entity instances that have been removed from the collection.
         * @param changed The array of Entity instances that have been modified.
         */
        void function(EntityCollection collection, Entity[] added, Entity[] removed, Entity[] changed);
    }
}
