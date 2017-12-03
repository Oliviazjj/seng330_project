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

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.BaseEntity;
import org.springframework.samples.mealOnWheel.model.Event;

/**
 * Repository class for <code>Event</code> domain objects All method names are compliant with JPA naming
 */
public interface EventRepository {

    /**
     * Save a <code>Event</code> to the data store, either inserting or updating it.
     *
     * @param visit the <code>Event</code> to save
     * @see BaseEntity#isNew
     */
    void save(Event event) throws DataAccessException;

    List<Event> findByUserId(Integer userId) throws DataAccessException;
    Event findById(Integer eventId) throws DataAccessException;
    List<Event> findAll() throws DataAccessException;

}
