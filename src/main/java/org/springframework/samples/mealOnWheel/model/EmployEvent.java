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

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple business object representing a employEmployEvent.
 */
@Entity
@Table(name = "employEvents")
public class EmployEvent extends BaseEntity {

    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date eventDate;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employEvent", fetch = FetchType.EAGER)
    private Set<EmployeeShift> employeeShifts;
    
    public Date getDate() {
        return this.event.getEventDate();
    }

    public void setDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    protected Set<EmployeeShift> getEmployeeShiftsInternal() {
        if (this.employeeShifts == null) {
            this.employeeShifts = new HashSet<>();
        }
        return this.employeeShifts;
    }

    protected void setEmployeeShiftsInternal(Set<EmployeeShift> employeeShifts) {
        this.employeeShifts = employeeShifts;
    }

    public List<EmployeeShift> getEmployeeShifts() {
        List<EmployeeShift> sortedEmployeeShifts = new ArrayList<>(getEmployeeShiftsInternal());
        Collections.sort(sortedEmployeeShifts, new Comparator<EmployeeShift>() {
            @Override
            public int compare(EmployeeShift e1, EmployeeShift e2) {
                return e1.getDate().compareTo(e2.getDate());
            }
        });
        return Collections.unmodifiableList(sortedEmployeeShifts);
    }

    public void addEmployeeShift(EmployeeShift employeeShift) {
        getEmployeeShiftsInternal().add(employeeShift);
        employeeShift.setEmployEvent(this);
    }

}
