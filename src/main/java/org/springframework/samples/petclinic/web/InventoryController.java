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

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Inventory;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.EmployeeShift;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class InventoryController {

	private static final String VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM = "inventorys/createOrUpdateInventoryForm";
    private final ClinicService clinicService;


    @Autowired
    public InventoryController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = { "/inventorys"})
    public String showInventoryList(Map<String, Object> model) {
        // Here we are returning an object of type 'Inventorys' rather than a collection of Inventory objects
        // so it is simpler for Object-Xml mapping
        Collection<Inventory> inventorys = this.clinicService.findInventory();
        model.put("inventorys", inventorys);
        return "inventorys/inventoryList";
    }
    
    
    
 // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before initNewEmployeeShiftForm is called
    @RequestMapping(value = "/inventorys/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
    		Inventory inventory = new Inventory();
        model.put("inventory", inventory);
        return VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM;
    }

    // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before processNewEmployeeShiftForm is called
    @RequestMapping(value = "/inventorys/new", method = RequestMethod.POST)
    public String processInventoryForm(@Valid Inventory inventory, BindingResult result) {
        if (result.hasErrors()) {
            return "inventorys/createOrUpdateInventoryForm";
        } else {
            this.clinicService.saveInventory(inventory);
            return "redirect:/inventorys";
        }
    }
    
    @RequestMapping(value = "/inventorys/{inventoryId}/edit", method = RequestMethod.GET)
    public String initUpdateEmployeeForm(@PathVariable("inventoryId") int inventoryId, Model model) {
        Inventory inventory = this.clinicService.findInventoryById(inventoryId);
        model.addAttribute(inventory);
        return VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/inventorys/{inventoryId}/edit", method = RequestMethod.POST)
    public String processUpdateEmployeeForm(@Valid Inventory inventory, BindingResult result, @PathVariable("inventoryId") int inventoryId) {
        if (result.hasErrors()) {
            return VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM;
        } else {
            inventory.setId(inventoryId);
            this.clinicService.saveInventory(inventory);
            return "redirect:/inventorys";
        }
    }


}
