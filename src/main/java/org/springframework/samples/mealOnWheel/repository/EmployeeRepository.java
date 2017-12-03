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

import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.BaseEntity;
import org.springframework.samples.mealOnWheel.model.Employee;


/**
 * Repository class for <code>Employee</code> domain objects All method names are compliant with JPA naming
 */
public interface EmployeeRepository {

    /**
     * Retrieve <code>Employee</code>s from the data store by last name, returning all employees whose last name <i>starts</i>
     * with the given name.
     *
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>Employee</code>s (or an empty <code>Collection</code> if none
     * found)
     */
    Collection<Employee> findByLastName(String lastName) throws DataAccessException;

    /**
     * Retrieve an <code>Employee</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Employee</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Employee findById(int id) throws DataAccessException;


    /**
     * Save an <code>Employee</code> to the data store, either inserting or updating it.
     *
     * @param employee the <code>Employee</code> to save
     * @see BaseEntity#isNew
     */
    void save(Employee employee) throws DataAccessException;


}
