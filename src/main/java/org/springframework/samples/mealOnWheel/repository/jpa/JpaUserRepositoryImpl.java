package org.springframework.samples.mealOnWheel.repository.jpa;


import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.User;
import org.springframework.samples.mealOnWheel.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * JPA implementation of the {@link UserRepository} interface.
 */

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findById(int id) {
        return this.em.find(User.class, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public User login(String username, String password) throws DataAccessException {
        Query query = this.em.createQuery("FROM User u where u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> list = query.getResultList();
        if (list.size() == 0) {
            return null;
        }
        else {
            return list.get(0);
        }
    }

        @Override
    public void save(User user) {
        if (user.getId() == null) {
            this.em.persist(user);
        } else {
            this.em.merge(user);
        }
    }
}
