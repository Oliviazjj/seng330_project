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
import org.springframework.samples.petclinic.model.Food;
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
public class FoodController {

	private static final String VIEWS_FOOD_CREATE_OR_UPDATE_FORM = "foods/createOrUpdateFoodForm";
    private final ClinicService clinicService;


    @Autowired
    public FoodController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = { "/foods"})
    public String showFoodList(Map<String, Object> model) {
        // Here we are returning an object of type 'Foods' rather than a collection of Food objects
        // so it is simpler for Object-Xml mapping
        Collection<Food> foods = this.clinicService.findFood();
        model.put("foods", foods);
        return "foods/foodList";
    }
    
    
    
 // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before initNewEmployeeShiftForm is called
    @RequestMapping(value = "/foods/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
    		Food food = new Food();
        model.put("food", food);
        return VIEWS_FOOD_CREATE_OR_UPDATE_FORM;
    }

    // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before processNewEmployeeShiftForm is called
    @RequestMapping(value = "/foods/new", method = RequestMethod.POST)
    public String processFoodForm(@Valid Food food, BindingResult result) {
        if (result.hasErrors()) {
            return "foods/createOrUpdateFoodForm";
        } else {
            this.clinicService.saveFood(food);
            return "redirect:/foods";
        }
    }
    
    @RequestMapping(value = "/foods/{foodId}/edit", method = RequestMethod.GET)
    public String initUpdateFoodForm(@PathVariable("foodId") int foodId, Model model) {
        Food food = this.clinicService.findFoodById(foodId);
        model.addAttribute(food);
        return VIEWS_FOOD_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/foods/{foodId}/edit", method = RequestMethod.POST)
    public String processUpdateFoodForm(@Valid Food food, BindingResult result, @PathVariable("foodId") int foodId) {
        if (result.hasErrors()) {
            return VIEWS_FOOD_CREATE_OR_UPDATE_FORM;
        } else {
            food.setId(foodId);
            this.clinicService.saveFood(food);
            return "redirect:/foods";
        }
    }


}
