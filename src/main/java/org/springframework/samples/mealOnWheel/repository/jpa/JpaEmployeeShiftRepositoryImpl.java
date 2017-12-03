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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.samples.mealOnWheel.model.EmployeeShift;
import org.springframework.samples.mealOnWheel.repository.EmployeeShiftRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link EmployeeShiftRepository} interface.
 */
@Repository
public class JpaEmployeeShiftRepositoryImpl implements EmployeeShiftRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(EmployeeShift employeeShift) {
        if (employeeShift.getId() == null) {
            this.em.persist(employeeShift);
        } else {
            this.em.merge(employeeShift);
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<EmployeeShift> findByEmployEventId(Integer employEventId) {
        Query query = this.em.createQuery("SELECT v FROM EmployeeShift v where v.employEvent.id= :id");
        query.setParameter("id", employEventId);
        return query.getResultList();
    }

}
