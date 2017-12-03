package org.springframework.samples.mealOnWheel.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.mealOnWheel.model.*;
import org.springframework.samples.mealOnWheel.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all mealOnWheel controllers
 * Also a placeholder for @Transactional annotations
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private EmployEventRepository employEventRepository;
    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeShiftRepository employeeShiftRepository;
    private FoodRepository foodRepository;
    private InventoryRepository inventoryRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;


    @Autowired
    public CompanyServiceImpl(EmployEventRepository employEventRepository, ContactRepository contactRepository, EmployeeRepository employeeRepository,
                             EmployeeShiftRepository employeeShiftRepository, FoodRepository foodRepository, InventoryRepository inventoryRepository,
                             UserRepository userRepository, EventRepository eventRepository) {
        this.employEventRepository = employEventRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
        this.employeeShiftRepository = employeeShiftRepository;
        this.foodRepository = foodRepository;
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    //employeeEvent
    @Override
    @Transactional(readOnly = true)
    public Collection<Event> findEventOptions() throws DataAccessException {
        return employEventRepository.findEventOptions();
    }

    
    //employee
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

    //
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
    @Transactional(readOnly = true)
	public Collection<EmployEvent> findEmployeeEventByEventId(int eventId) {
    		return employEventRepository.findByEventId(eventId);
	}

    @Override
    @Transactional
    public void saveEmployEvent(EmployEvent employEvent) throws DataAccessException {
        employEventRepository.save(employEvent);
    }

    @Override
    @Transactional(readOnly = true)
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
	 @Transactional(readOnly = true)
	public Collection<EmployeeShift> findEmployeeShiftsByEmployEventId(int employEventId) {
		return employeeShiftRepository.findByEmployEventId(employEventId);
	}

	//Event
	 @Override
	 @Transactional
	 public void saveEvent(Event event) throws DataAccessException {
		 eventRepository.save(event);
	 }
	 @Override
	 @Transactional
	 public Collection<Event> findEventsByUserId(int userId) {
		return eventRepository.findByUserId(userId);
	}


//	User Part

    @Override
    @Transactional
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    @Override
    @Transactional
    public void saveUser(User user) throws DataAccessException {
        userRepository.save(user);
    }

	@Override
	public User findUserById(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	@Transactional
	public Event findEventById(int eventId) {
		return eventRepository.findById(eventId);
	}

	@Override
	@Transactional
	public Collection<Event> findAllEvent() throws DataAccessException {
		return eventRepository.findAll();
	}

	@Override
	@Transactional
	public Inventory findInventoryById(int inventoryId) {
		return inventoryRepository.findById(inventoryId);
	}

	@Override
	@Transactional
	public Food findFoodById(int foodId) {
		return foodRepository.findById(foodId);
	}

	@Override
	@Transactional
	public Contact findContactById(int contactId) {
		return contactRepository.findById(contactId);
	}

	

}
