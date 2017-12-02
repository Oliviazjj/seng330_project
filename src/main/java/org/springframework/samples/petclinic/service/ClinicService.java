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

	//event actions
    Collection<Event> findEventOptions() throws DataAccessException;
    void saveEmployEvent(EmployEvent employEvent) throws DataAccessException;

    	//employee actions
    Employee findEmployeeById(int id) throws DataAccessException;
    EmployEvent findEmployEventById(int id) throws DataAccessException;
    void saveEmployee(Employee employee) throws DataAccessException;
    Collection<Employee> findEmployeeByLastName(String lastName) throws DataAccessException;
    
    
    //employee shift actions
    void saveEmployeeShift(EmployeeShift employeeShift) throws DataAccessException;
    Collection<EmployeeShift> findEmployeeShiftsByEmployEventId(int employEventId) throws DataAccessException;

    //contact actions
    Collection<Contact> findContacts() throws DataAccessException;
    void saveContact(Contact contact) throws DataAccessException;
    Contact findContactById(int contactId);

    //food actions
    Collection<Food> findFood() throws DataAccessException;
    void saveFood(Food food) throws DataAccessException;
    Food findFoodById(int foodId);

    //inventory actions
    Collection<Inventory> findInventory() throws DataAccessException;
    void saveInventory(Inventory inventory) throws DataAccessException;
    Inventory findInventoryById(int inventoryId);
    

    //user actions
    User login(String username, String password) throws DataAccessException;
    void saveUser(User user) throws DataAccessException;
    User findUserById(int userId) throws DataAccessException;
    
    //user events
    Collection<Event> findEventsByUserId(int userId) throws DataAccessException;
    void saveEvent(Event event) throws DataAccessException;
    Event findEventById(int eventId) throws DataAccessException;
	Collection<Event> findAllEvent() throws DataAccessException;

	

}
