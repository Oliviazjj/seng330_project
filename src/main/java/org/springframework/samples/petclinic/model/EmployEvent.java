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
package org.springframework.samples.petclinic.model;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple business object representing a employEmployEvent.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 */
@Entity
@Table(name = "employEvents")
public class EmployEvent extends NamedEntity {

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private EmployEventType type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employEvent", fetch = FetchType.EAGER)
    private Set<EmployeeShift> employeeShifts;


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public EmployEventType getType() {
        return this.type;
    }

    public void setType(EmployEventType type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    protected void setEmployee(Employee employee) {
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
        PropertyComparator.sort(sortedEmployeeShifts, new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedEmployeeShifts);
    }

    public void addEmployeeShift(EmployeeShift employeeShift) {
        getEmployeeShiftsInternal().add(employeeShift);
        employeeShift.setEmployEvent(this);
    }

}
