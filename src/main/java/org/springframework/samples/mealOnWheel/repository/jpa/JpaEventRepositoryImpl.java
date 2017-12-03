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

import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.repository.EventRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link EventRepository} interface.
 */
@Repository
public class JpaEventRepositoryImpl implements EventRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(Event event) {
        if (event.getId() == null) {
            this.em.persist(event);
        } else {
            this.em.merge(event);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> findByUserId(Integer userId) {
        Query query = this.em.createQuery("SELECT v FROM Event v where v.user.id= :id");
        query.setParameter("id", userId);
        return query.getResultList();
    }
    
    @Override
    public Event findById(Integer eventId) {
        Query query = this.em.createQuery("SELECT v FROM Event v where v.id= :id");
        query.setParameter("id", eventId);
        return (Event) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
	public List<Event> findAll() {
    		Query query = this.em.createQuery("SELECT v FROM Event v");
        return query.getResultList();
	}

}
