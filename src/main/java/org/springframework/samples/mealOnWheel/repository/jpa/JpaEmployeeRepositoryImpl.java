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
package org.springframework.samples.mealOnWheel.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.samples.mealOnWheel.model.Employee;
import org.springframework.samples.mealOnWheel.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link EmployeeRepository} interface.
 */
@Repository
public class JpaEmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager em;


    /**
     * Important: in the current version of this method, we load Employees with all their Employees and Visits while
     * we do not need Visits at all and we only need one property from the Employee objects (the 'name' property).
     * There are some ways to improve it such as:
     * - creating a Ligtweight class (example here: https://community.jboss.org/wiki/LightweightClass)
     * - Turning on lazy-loading and using {@link OpenSessionInViewFilter}
     */
    @SuppressWarnings("unchecked")
    public Collection<Employee> findByLastName(String lastName) {
        // using 'join fetch' because a single query should load both employees and employees
        // using 'left join fetch' because it might happen that an employee does not have employees yet
        Query query = this.em.createQuery("SELECT DISTINCT employee FROM Employee employee left join fetch employee.employEvents WHERE employee.lastName LIKE :lastName");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // using 'join fetch' because a single query should load both employees and events
        // using 'left join fetch' because it might happen that an employee does not have employees yet
        Query query = this.em.createQuery("SELECT employee FROM Employee employee left join fetch employee.employEvents WHERE employee.id =:id");
        query.setParameter("id", id);
        return (Employee) query.getSingleResult();
    }


    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            this.em.persist(employee);
        } else {
            this.em.merge(employee);
        }

    }

}
