package org.springframework.samples.mealOnWheel.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.User;


/**
 * Repository class for <code>User</code> domain objects All method names are compliant with JPA naming
 */
public interface UserRepository {
    User findById(int id) throws DataAccessException;
    User login(String username, String password) throws DataAccessException;
    void save(User user) throws DataAccessException;
}
