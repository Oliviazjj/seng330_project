package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.*;
import org.springframework.samples.petclinic.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all EmployEventclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private EmployEventRepository employEventRepository;
    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeShiftRepository employeeShiftRepository;
    private FoodRepository foodRepository;
    private InventoryRepository inventoryRepository;
    private UserRepository userRepository;


    @Autowired
    public ClinicServiceImpl(EmployEventRepository employEventRepository, ContactRepository contactRepository, EmployeeRepository employeeRepository,
                             EmployeeShiftRepository employeeShiftRepository, FoodRepository foodRepository, InventoryRepository inventoryRepository,
                             UserRepository userRepository) {
        this.employEventRepository = employEventRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
        this.employeeShiftRepository = employeeShiftRepository;
        this.foodRepository = foodRepository;
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<EmployEventType> findEmployEventTypes() throws DataAccessException {
        return employEventRepository.findEmployEventTypes();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployeeById(int id) throws DataAccessException {
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Employee> findEmployeeByLastName(String lastName) throws DataAccessException {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) throws DataAccessException {
        employeeRepository.save(employee);
    }


    @Override
    @Transactional
    public void saveEmployeeShift(EmployeeShift employeeShift) throws DataAccessException {
        employeeShiftRepository.save(employeeShift);
    }


    @Override
    @Transactional(readOnly = true)
    public EmployEvent findEmployEventById(int id) throws DataAccessException {
        return employEventRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveEmployEvent(EmployEvent employEvent) throws DataAccessException {
        employEventRepository.save(employEvent);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "contacts")
    public Collection<Contact> findContacts() throws DataAccessException {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public void saveContact(Contact contact) throws DataAccessException {
        contactRepository.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Food> findFood() throws DataAccessException {
        return foodRepository.findAll();
    }

    @Override
    @Transactional
    public void saveFood(Food food) throws DataAccessException {
        foodRepository.save(food);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Inventory> findInventory() throws DataAccessException {
        return inventoryRepository.findAll();
    }

    @Override
    @Transactional
    public void saveInventory(Inventory inventory) throws DataAccessException {
        inventoryRepository.save(inventory);
    }

	@Override
	public Collection<EmployeeShift> findEmployeeShiftsByEmployEventId(int employEventId) {
		return employeeShiftRepository.findByEmployEventId(employEventId);
	}



//	User Part

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    @Override
    @Transactional
    public void saveUser(User user) throws DataAccessException {
        userRepository.save(user);
    }

}
