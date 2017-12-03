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

import org.springframework.samples.mealOnWheel.model.Inventory;
import org.springframework.samples.mealOnWheel.repository.InventoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Collection;

/**
 * JPA implementation of the {@link InventoryRepository} interface.
 */
@Repository
public class JpaInventoryRepositoryImpl implements InventoryRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @SuppressWarnings("unchecked")
    public Collection<Inventory> findAll() {
        return this.em.createQuery("SELECT v FROM Inventory v").getResultList();
    }
    
    @Override
    public void save(Inventory inventory) {
        if (inventory.getId() == null) {
            this.em.persist(inventory);
        } else {
            this.em.merge(inventory);
        }

    }
    
    @Override
    public Inventory findById(Integer inventoryId) {
        Query query = this.em.createQuery("SELECT v FROM Inventory v where v.id= :id");
        query.setParameter("id", inventoryId);
        return (Inventory) query.getSingleResult();
    }

}


