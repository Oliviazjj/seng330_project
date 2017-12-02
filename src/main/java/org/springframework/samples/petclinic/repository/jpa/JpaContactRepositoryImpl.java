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

import org.springframework.samples.petclinic.model.Contact;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.Food;
import org.springframework.samples.petclinic.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Collection;

/**
 * JPA implementation of the {@link ContactRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaContactRepositoryImpl implements ContactRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @SuppressWarnings("unchecked")
    public Collection<Contact> findAll() {
        return this.em.createQuery("SELECT distinct contact FROM Contact contact left join fetch contact.specialties ORDER BY contact.lastName, contact.firstName").getResultList();
    }
    
    @Override
    public Contact findById(int contactId) {
        Query query = this.em.createQuery("SELECT v FROM Contact v where v.id= :id");
        query.setParameter("id", contactId);
        return (Contact) query.getSingleResult();
    }
    
    @Override
    public void save(Contact contact) {
        if (contact.getId() == null) {
            this.em.persist(contact);
        } else {
            this.em.merge(contact);
        }

    }
}
