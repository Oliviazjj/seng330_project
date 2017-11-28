package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.EmployEvent;
import org.springframework.samples.petclinic.model.EmployEventType;
import org.springframework.samples.petclinic.model.Contact;
import org.springframework.samples.petclinic.model.EmployeeShift;
import org.springframework.samples.petclinic.repository.EmployeeRepository;
import org.springframework.samples.petclinic.repository.EmployEventRepository;
import org.springframework.samples.petclinic.repository.ContactRepository;
import org.springframework.samples.petclinic.repository.EmployeeShiftRepository;
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

    @Autowired
    public ClinicServiceImpl(EmployEventRepository employEventRepository, ContactRepository contactRepository, EmployeeRepository employeeRepository, EmployeeShiftRepository employeeShiftRepository) {
        this.employEventRepository = employEventRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
        this.employeeShiftRepository = employeeShiftRepository;
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
	public Collection<EmployeeShift> findEmployeeShiftsByEmployEventId(int employEventId) {
		return employeeShiftRepository.findByEmployEventId(employEventId);
	}


}