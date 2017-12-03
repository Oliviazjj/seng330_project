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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mealOnWheel.model.EmployEvent;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.model.User;
import org.springframework.samples.mealOnWheel.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Collection;
import java.util.Map;



@Controller
public class EventController {

    private static final String VIEWS_EVENTS_CREATE_OR_UPDATE_FORM = "events/createOrUpdateEventForm";
    private final CompanyService clinicService;

    @Autowired
    public EventController(CompanyService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder("user")
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    
    @RequestMapping(value = "/{userId}/events/new", method = RequestMethod.GET)
    public String initCreationForm(@PathVariable("userId") int userId, ModelMap model, HttpSession session) {
        User user = (User)session.getAttribute("currentUser");
        if (user == null) {
            return "redirect:/login";
        }

        Event event = new Event();
//        user.addEvent(event);
        model.put("event", event);

        Collection<Event> eventList = this.clinicService.findEventsByUserId(user.getId());
        model.put("eventList", eventList);
        return "auth/userInfoPage";
    }


    @RequestMapping(value = "/{userId}/events/new", method = RequestMethod.POST)
    public String submitCreationForm(@Valid Event event, BindingResult result, HttpSession session, ModelMap model) {
        User user = (User)session.getAttribute("currentUser");
        event.setUser(user);
        if (result.hasErrors()) {
            model.put("event", event);
              return "auth/userInfoPage";

        } else {
            this.clinicService.saveEvent(event);
//            return "redirect:/" + user.getId()+"/events";
            return "auth/userInfoPage";
        }
    }


    @RequestMapping(value = "events/{eventId}/edit", method = RequestMethod.GET)
    public String initUpdateForm( @PathVariable("eventId") int eventId, ModelMap model) {
        Event event = this.clinicService.findEventById(eventId);
        model.put("event", event);
        return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "events/{eventId}/edit", method = RequestMethod.POST)
    public String processUpdateForm(@Valid Event event, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("event", event);
            return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;
        } else {
            this.clinicService.saveEvent(event);
            return "redirect:/events";
        }
    }
    
    @RequestMapping(value = "/events/new", method = RequestMethod.GET)
    public String initCreationEventForm(ModelMap model, HttpSession session) {
        Event event = new Event();
        model.put("event", event);
        return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;
    }


    @RequestMapping(value = "/events/new", method = RequestMethod.POST)
    public String submitCreationEventForm(@Valid Event event, BindingResult result, HttpSession session, ModelMap model) {
    	
        if (result.hasErrors()) {
            model.put("event", event);
              return VIEWS_EVENTS_CREATE_OR_UPDATE_FORM;

        } else {
            this.clinicService.saveEvent(event);
            return "redirect:/events";
        }
    }
    
    @RequestMapping("/events/{eventId}")
    public ModelAndView showEventDetail(@PathVariable("eventId") int eventId) {
        ModelAndView mav = new ModelAndView("events/eventDetails");
        mav.addObject(this.clinicService.findEventById(eventId));
        Collection<EmployEvent> employeeEvents = this.clinicService.findEmployeeEventByEventId(eventId);
        mav.addObject(employeeEvents);
        
        return mav;
    }

    @RequestMapping(value = { "/events"}, method = RequestMethod.GET)
    public String showEventList(Map<String, Object> model) {
        Collection<Event> events = this.clinicService.findAllEvent();
        model.put("events", events);
        return "events/eventList";
    }



}
