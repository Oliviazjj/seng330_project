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
package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.EmployEvent;
import org.springframework.samples.petclinic.model.EmployEventType;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/employees/{employeeId}")
public class EmployEventController {

    private static final String VIEWS_EMPLOYEVENTS_CREATE_OR_UPDATE_FORM = "employEvents/createOrUpdateEmployEventForm";
    private final ClinicService clinicService;

    @Autowired
    public EmployEventController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("types")
    public Collection<EmployEventType> populateEmployEventTypes() {
        return this.clinicService.findEmployEventTypes();
    }

    @ModelAttribute("employee")
    public Employee findEmployee(@PathVariable("employeeId") int employeeId) {
        return this.clinicService.findEmployeeById(employeeId);
    }

    @InitBinder("employee")
    public void initEmployeeBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("employEvent")
    public void initEmployEventBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new EmployEventValidator());
    }

    @RequestMapping(value = "/employEvents/new", method = RequestMethod.GET)
    public String initCreationForm(Employee employee, ModelMap model) {
        EmployEvent employEvent = new EmployEvent();
        employee.addEmployEvent(employEvent);
        model.put("employEvent", employEvent);
        return VIEWS_EMPLOYEVENTS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/employEvents/new", method = RequestMethod.POST)
    public String processCreationForm(Employee employee, @Valid EmployEvent employEvent, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(employEvent.getName()) && employEvent.isNew() && employee.getEmployEvent(employEvent.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.put("employEvent", employEvent);
            return VIEWS_EMPLOYEVENTS_CREATE_OR_UPDATE_FORM;
        } else {
            employee.addEmployEvent(employEvent);
            this.clinicService.saveEmployEvent(employEvent);
            return "redirect:/employees/{employeeId}";
        }
    }

    @RequestMapping(value = "/employEvents/{employEventId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("employEventId") int employEventId, ModelMap model) {
        EmployEvent employEvent = this.clinicService.findEmployEventById(employEventId);
        model.put("employEvent", employEvent);
        return VIEWS_EMPLOYEVENTS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/employEvents/{employEventId}/edit", method = RequestMethod.POST)
    public String processUpdateForm(@Valid EmployEvent employEvent, BindingResult result, Employee employee, ModelMap model) {
        if (result.hasErrors()) {
            model.put("employEvent", employEvent);
            return VIEWS_EMPLOYEVENTS_CREATE_OR_UPDATE_FORM;
        } else {
            employee.addEmployEvent(employEvent);
            this.clinicService.saveEmployEvent(employEvent);
            return "redirect:/employees/{employeeId}";
        }
    }

}
