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

import org.springframework.samples.mealOnWheel.model.Food;
import org.springframework.samples.mealOnWheel.repository.FoodRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Collection;

/**
 * JPA implementation of the {@link FoodRepository} interface.
 */
@Repository
public class JpaFoodRepositoryImpl implements FoodRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @SuppressWarnings("unchecked")
    public Collection<Food> findAll() {
        return this.em.createQuery("SELECT v FROM Food v").getResultList();
    }
    
    @Override
    public void save(Food food) {
        if (food.getId() == null) {
            this.em.persist(food);
        } else {
            this.em.merge(food);
        }

    }
    
    @Override
    public Food findById(Integer foodId) {
        Query query = this.em.createQuery("SELECT v FROM Food v where v.id= :id");
        query.setParameter("id", foodId);
        return (Food) query.getSingleResult();
    }

}

