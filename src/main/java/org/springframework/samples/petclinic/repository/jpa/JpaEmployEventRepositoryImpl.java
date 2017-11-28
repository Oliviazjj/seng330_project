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
package org.springframework.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.samples.petclinic.model.EmployEvent;
import org.springframework.samples.petclinic.model.EmployEventType;
import org.springframework.samples.petclinic.repository.EmployEventRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link EmployEventRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaEmployEventRepositoryImpl implements EmployEventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<EmployEventType> findEmployEventTypes() {
        return this.em.createQuery("SELECT ptype FROM EmployEventType ptype ORDER BY ptype.name").getResultList();
    }

    @Override
    public EmployEvent findById(int id) {
        return this.em.find(EmployEvent.class, id);
    }

    @Override
    public void save(EmployEvent employEvent) {
        if (employEvent.getId() == null) {
            this.em.persist(employEvent);
        } else {
            this.em.merge(employEvent);
        }
    }

}
