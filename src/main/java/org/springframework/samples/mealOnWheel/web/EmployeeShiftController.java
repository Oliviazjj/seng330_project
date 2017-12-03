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
package org.springframework.samples.mealOnWheel.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mealOnWheel.model.EmployEvent;
import org.springframework.samples.mealOnWheel.model.EmployeeShift;
import org.springframework.samples.mealOnWheel.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeeShiftController {

    private final CompanyService clinicService;


    @Autowired
    public EmployeeShiftController(CompanyService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that EmployEvent object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param employEventId
     * @return EmployEvent
     */
    @ModelAttribute("employeeShift")
    public EmployeeShift loadEmployEventWithEmployeeShift(@PathVariable("employEventId") int employEventId) {
        EmployEvent employEvent = this.clinicService.findEmployEventById(employEventId);
        EmployeeShift employeeShift = new EmployeeShift();
        employEvent.addEmployeeShift(employeeShift);
        return employeeShift;
    }

    // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before initNewEmployeeShiftForm is called
    @RequestMapping(value = "/employees/*/employEvents/{employEventId}/employeeShifts/new", method = RequestMethod.GET)
    public String initNewEmployeeShiftForm(@PathVariable("employEventId") int employEventId, Map<String, Object> model) {
        return "employEvents/createOrUpdateEmployeeShiftForm";
    }

    // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before processNewEmployeeShiftForm is called
    @RequestMapping(value = "/employees/{employeeId}/employEvents/{employEventId}/employeeShifts/new", method = RequestMethod.POST)
    public String processNewEmployeeShiftForm(@Valid EmployeeShift employeeShift, BindingResult result) {
        if (result.hasErrors()) {
            return "employEvents/createOrUpdateEmployeeShiftForm";
        } else {
            this.clinicService.saveEmployeeShift(employeeShift);
            return "redirect:/employees/{employeeId}";
        }
    }

    @RequestMapping(value = "/employees/*/employEvents/{employEventId}/employeeShifts", method = RequestMethod.GET)
    public String showEmployeeShifts(@PathVariable int employEventId, Map<String, Object> model) {
        model.put("employeeShifts", this.clinicService.findEmployEventById(employEventId).getEmployeeShifts());
        return "employeeShiftList";
    }

}
