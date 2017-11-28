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
package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.*;


/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface ClinicService {

    Collection<EmployEventType> findEmployEventTypes() throws DataAccessException;

    Employee findEmployeeById(int id) throws DataAccessException;

    EmployEvent findEmployEventById(int id) throws DataAccessException;

    void saveEmployEvent(EmployEvent employEvent) throws DataAccessException;

    void saveEmployeeShift(EmployeeShift employeeShift) throws DataAccessException;

    Collection<Contact> findContacts() throws DataAccessException;
    void saveContact(Contact contact) throws DataAccessException;

    Collection<Food> findFood() throws DataAccessException;
    void saveFood(Food food) throws DataAccessException;

    Collection<Inventory> findInventory() throws DataAccessException;
    void saveInventory(Inventory inventory) throws DataAccessException;

    void saveEmployee(Employee employee) throws DataAccessException;

    Collection<Employee> findEmployeeByLastName(String lastName) throws DataAccessException;

	Collection<EmployeeShift> findEmployeeShiftsByEmployEventId(int employEventId);


    User login(String username, String password);
    void saveUser(User user) throws DataAccessException;

}
