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
package org.springframework.samples.mealOnWheel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing an employee.
 */
@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<EmployEvent> employEvents;


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected Set<EmployEvent> getEmployEventsInternal() {
        if (this.employEvents == null) {
            this.employEvents = new HashSet<>();
        }
        return this.employEvents;
    }

    protected void setEmployEventsInternal(Set<EmployEvent> employEvents) {
        this.employEvents = employEvents;
    }

    public List<EmployEvent> getEmployEvents() {
        List<EmployEvent> sortedEmployEvents = new ArrayList<>(getEmployEventsInternal());
        Collections.sort(sortedEmployEvents, new Comparator<EmployEvent>() {
            @Override
            public int compare(EmployEvent e1, EmployEvent e2) {
                return e1.getDate().compareTo(e2.getDate());
            }
        });
        return Collections.unmodifiableList(sortedEmployEvents);
    }

    public void addEmployEvent(EmployEvent employEvent) {
        getEmployEventsInternal().add(employEvent);
        employEvent.setEmployee(this);
    }

    /**
     * Return the EmployEvent with the given name, or null if none found for this Employee.
     *
     * @param name to test
     * @return true if employEmployEvent name is already in use
     */
    public EmployEvent getEmployEvent(String name) {
        return getEmployEvent(name, false);
    }

    /**
     * Return the EmployEvent with the given name, or null if none found for this Employee.
     *
     * @param name to test
     * @return true if employEmployEvent name is already in use
     */
    public EmployEvent getEmployEvent(String eventName, boolean ignoreNew) {
    	eventName = eventName.toLowerCase();
        for (EmployEvent employEvent : getEmployEventsInternal()) {
            if (!ignoreNew || !employEvent.isNew()) {
                String compName = employEvent.getEvent().getName();
                compName = compName.toLowerCase();
                if (compName.equals(eventName)) {
                    return employEvent;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("new", this.isNew())
            .append("lastName", this.getLastName())
            .append("firstName", this.getFirstName())
            .append("address", this.address)
            .append("city", this.city)
            .append("telephone", this.telephone)
            .toString();
    }
}
