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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.TimeInterval;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.datasources.Entity;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CompositeEntityCollection")
public class CompositeEntityCollection {
    /**
     * Gets the event that is fired when entities are added or removed from the collection. The generated event is a
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
     */
    @JsProperty(name = "owner")
    public native Object owner();
    /**
     * Gets the array of Entity instances in the collection. This array should not be modified directly.
     */
    @JsProperty(name = "values")
    public native Entity[] values();

    /**
     * Non-destructively composites multiple {@link EntityCollection} instances into a single collection. If a Entity with the
     * same ID exists in multiple collections, it is non-destructively merged into a single new entity instance.
     * If an entity has the same property in multiple collections, the property of the Entity in the last collection of
     * the list it belongs to is used. CompositeEntityCollection can be used almost anywhere that a EntityCollection is used.
     */
    @JsConstructor
    public CompositeEntityCollection() {}

    /**
     * Non-destructively composites multiple {@link EntityCollection} instances into a single collection. If a Entity with the
     * same ID exists in multiple collections, it is non-destructively merged into a single new entity instance.
     * If an entity has the same property in multiple collections, the property of the Entity in the last collection of
     * the list it belongs to is used. CompositeEntityCollection can be used almost anywhere that a EntityCollection is used.
     * @param collections The initial list of EntityCollection instances to merge.
     */
    @JsConstructor
    public CompositeEntityCollection(EntityCollection[] collections) {}

    /**
     * Non-destructively composites multiple {@link EntityCollection} instances into a single collection. If a Entity with the
     * same ID exists in multiple collections, it is non-destructively merged into a single new entity instance.
     * If an entity has the same property in multiple collections, the property of the Entity in the last collection of
     * the list it belongs to is used. CompositeEntityCollection can be used almost anywhere that a EntityCollection is used.
     * @param collections The initial list of EntityCollection instances to merge.
     * @param owner The data source (or composite entity collection) which created this collection.
     */
    @JsConstructor
    public CompositeEntityCollection(EntityCollection[] collections, DataSource owner) {}

    /**
     * Non-destructively composites multiple {@link EntityCollection} instances into a single collection. If a Entity with the
     * same ID exists in multiple collections, it is non-destructively merged into a single new entity instance.
     * If an entity has the same property in multiple collections, the property of the Entity in the last collection of
     * the list it belongs to is used. CompositeEntityCollection can be used almost anywhere that a EntityCollection is used.
     * @param collections The initial list of EntityCollection instances to merge.
     * @param owner The data source (or composite entity collection) which created this collection.
     */
    @JsConstructor
    public CompositeEntityCollection(EntityCollection[] collections, CompositeEntityCollection owner) {}

    /**
     * Adds a collection to the composite.
     * @param collection the collection to add.
     */
    @JsMethod
    public native void addCollection(EntityCollection collection);

    /**
     * Adds a collection to the composite.
     * @param collection the collection to add.
     * @param index the index to add the collection at. If omitted, the collection will added on top of all existing collections.
     */
    @JsMethod
    public native void addCollection(EntityCollection collection, Integer index);

    /**
     * Computes the maximum availability of the entities in the collection. If the collection contains a mix of infinitely
     * available data and non-infinite data, It will return the interval pertaining to the non-infinite data only.
     * If all data is infinite, an infinite interval will be returned.
     * @return The availability of entities in the collection.
     */
    @JsMethod
    public native TimeInterval computeAvailability();

    /**
     * Returns true if the provided entity is in this collection, false otherwise.
     * @param entity The entity.
     * @return true if the provided entity is in this collection, false otherwise.
     */
    @JsMethod
    public native boolean contains(Entity entity);

    /**
     * Checks to see if the composite contains a given collection.
     * @param collection the collection to check for.
     * @return true if the composite contains the collection, false otherwise.
     */
    @JsMethod
    public native boolean containsCollection(EntityCollection collection);

    /**
     * Gets an entity with the specified id.
     * @param id The id of the entity to retrieve.
     * @return The entity with the provided id or undefined if the id did not exist in the collection.
     */
    public native Entity getById(Object id);

    /**
     * Gets a collection by index from the composite.
     * @param index the index to retrieve.
     * @return collection by index
     */
    @JsMethod
    public native EntityCollection getCollection(Integer index);

    /**
     * Gets the number of collections in this composite.
     * @return
     */
    @JsMethod
    public native Integer getCollectionsLength();

    /**
     * Determines the index of a given collection in the composite.
     * @param collection The collection to find the index of.
     * @return The index of the collection in the composite, or -1 if the collection does not exist in the composite.
     */
    @JsMethod
    public native Integer indexOfCollection(EntityCollection collection);

    /**
     * Lowers a collection down one position in the composite.
     * @param collection the collection to move.
     */
    @JsMethod
    public native void lowerCollection(EntityCollection collection);

    /**
     * Lowers a collection to the bottom of the composite.
     * @param collection the collection to move.
     */
    @JsMethod
    public native void lowerCollectionToBottom(EntityCollection collection);

    /**
     * Raises a collection up one position in the composite.
     * @param collection the collection to move.
     */
    @JsMethod
    public native void raiseCollection(EntityCollection collection);

    /**
     * Raises a collection to the top of the composite.
     * @param collection the collection to move.
     */
    @JsMethod
    public native void raiseCollectionToTop(EntityCollection collection);

    /**
     * Removes all collections from this composite.
     */
    @JsMethod
    public native void removeAllCollections();

    /**
     * Removes a collection from this composite, if present.
     * @param collection The collection to remove.
     * @return true if the collection was in the composite and was removed, false if the collection was not in the composite.
     */
    @JsMethod
    public native boolean removeCollection(EntityCollection collection);

    /**
     * Resumes raising {@link EntityCollection#collectionChanged} events immediately when an item is added or removed.
     * Any modifications made while while events were suspended will be triggered as a single event when this function is called.
     * This function also ensures the collection is recomposited if events are also resumed. This function is reference
     * counted and can safely be called multiple times as long as there are corresponding calls to {@link EntityCollection#resumeEvents}.
     */
    @JsMethod
    public native void resumeEvents();

    /**
     * Prevents {@link EntityCollection#collectionChanged} events from being raised until a corresponding call is made
     * to {@link EntityCollection#resumeEvents}, at which point a single event will be raised that covers all
     * suspended operations. This allows for many items to be added and removed efficiently. While events are suspended,
     * recompositing of the collections will also be suspended, as this can be a costly operation. This function can be
     * safely called multiple times as long as there are corresponding calls to {@link EntityCollection#resumeEvents}.
     */
    @JsMethod
    public native void suspendEvents();
}
