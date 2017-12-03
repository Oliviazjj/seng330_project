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
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.samples.mealOnWheel.model.EmployEvent;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.repository.EmployEventRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link EmployEventRepository} interface.
 */
@Repository
public class JpaEmployEventRepositoryImpl implements EmployEventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> findEventOptions() {
        return this.em.createQuery("SELECT event FROM Event event ORDER BY event.name").getResultList();
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

	@Override
	@SuppressWarnings("unchecked")
	public Collection<EmployEvent> findByEventId(int eventId) {		
		Query query = this.em.createQuery("SELECT employEvent FROM EmployEvent employEvent WHERE employEvent.event.id= :eventId ORDER BY employEvent.event.name");
        query.setParameter("eventId", eventId);
        return query.getResultList();
	}

}
