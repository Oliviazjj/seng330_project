/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.mealOnWheel.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.BaseEntity;
import org.springframework.samples.mealOnWheel.model.EmployEvent;
import org.springframework.samples.mealOnWheel.model.Event;


/**
 * Repository class for <code>EmployeeEvent</code> domain objects All method names are compliant with JPA naming
 */
public interface EmployEventRepository {

    /**
     * Retrieve all <code>EmployEventType</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>EmployEventType</code>s
     */
    List<Event> findEventOptions() throws DataAccessException;

    /**
     * Retrieve a <code>EmployEvent</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>EmployEvent</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    EmployEvent findById(int id) throws DataAccessException;

    /**
     * Save a <code>EmployEvent</code> to the data store, either inserting or updating it.
     *
     * @param employEvent the <code>EmployEvent</code> to save
     * @see BaseEntity#isNew
     */
    void save(EmployEvent employEvent) throws DataAccessException;

	Collection<EmployEvent> findByEventId(int eventId);

}
