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
import org.springframework.samples.petclinic.model.EmployEvent;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.EmployeeShift;
import org.springframework.samples.petclinic.model.Event;
import org.springframework.samples.petclinic.model.Inventory;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class EventController {

    private static final String VIEWS_EVENTS_CREATE_OR_UPDATE_FORM = "events/createOrUpdateEventForm";
    private final ClinicService clinicService;

    @Autowired
    public EventController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("event")
    public Event loadUserWithEvent(@PathVariable("userId") int userId) {
        User user = this.clinicService.findUserById(userId);
        Event event = new Event();
        user.addEvent(event);
        return event;
    }
    
    @ModelAttribute("user")
    public User findUser(@PathVariable("userId") int userId) {
        return this.clinicService.findUserById(userId);
    }

    @InitBinder("user")
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping(value = "/{userId}/events/new", method = RequestMethod.GET)
    public String initCreationForm(User user, ModelMap model) {
        Event event = new Event();
        user.addEvent(event);
        model.put("event", event);
        return "auth/userInfoPage";
    }

//    @RequestMapping(value = "/events/new", method = RequestMethod.POST)
//    public String processCreationForm(String name, String amountOfPeople, String eventDate,  String appetizer, 
//    			String entree, String dessert, String description, HttpServletRequest request, HttpSession session) {
//    		name = request.getParameter("username");
//    		amountOfPeople = request.getParameter("amountOfPeople");
//    		eventDate = request.getParameter("eventDate");
//    		appetizer = request.getParameter("appetizer");
//    		entree = request.getParameter("entree");
//    		dessert = request.getParameter("dessert");
//    		description = request.getParameter("description");
//    		
//        Event event = new Event(name, amountOfPeople, eventDate, appetizer, entree, dessert, description);
//        this.clinicService.saveUserEvent(event);
//        if (event == null) {
//            return "users/login";
//        } else {
//            session.setAttribute("currentUser", user);
//            return "auth/userInfoPage";
//        }
//    }
    
    
    
    @RequestMapping(value = "/{userId}/events/{eventId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("eventId") int eventId, ModelMap model) {
        Event event = this.clinicService.findEventById(eventId);
        model.put("event", event);
        return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/{userId}/events/{eventId}/edit", method = RequestMethod.POST)
    public String processUpdateForm(@Valid Event event, BindingResult result, User user, ModelMap model) {
        if (result.hasErrors()) {
            model.put("event", event);
            return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;
        } else {
            user.addEvent(event);
            this.clinicService.saveUserEvent(event);
            return "redirect:/users/{userId}";
        }
    }
    
    @RequestMapping(value = { "/events"}, method = RequestMethod.GET)
    public String showEventList(Map<String, Object> model) {
        Collection<Event> events = this.clinicService.findAllEvent();
        model.put("events", events);
        return "events/eventList";
    }
    
    

}
