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
import org.springframework.samples.petclinic.model.Contact;
import org.springframework.samples.petclinic.model.Contacts;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class ContactController {

	private static final String VIEWS_CONTACT_CREATE_OR_UPDATE_FORM = "contacts/createOrUpdateContactForm";
    private final ClinicService clinicService;


    @Autowired
    public ContactController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = { "/contacts"})
    public String showContactList(Map<String, Object> model) {
        // Here we are returning an object of type 'Contacts' rather than a collection of Contact objects
        // so it is simpler for Object-Xml mapping
        Contacts contacts = new Contacts();
        contacts.getContactList().addAll(this.clinicService.findContacts());
        model.put("contacts", contacts);
        return "contacts/contactList";
    }
    
    
    
 // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before initNewEmployeeShiftForm is called
    @RequestMapping(value = "/contacts/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
    		Contact contact = new Contact();
        model.put("contact", contact);
        return VIEWS_CONTACT_CREATE_OR_UPDATE_FORM;
    }

    // Spring MVC calls method loadEmployEventWithEmployeeShift(...) before processNewEmployeeShiftForm is called
    @RequestMapping(value = "/contacts/new", method = RequestMethod.POST)
    public String processContactForm(@Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "contacts/createOrUpdateContactForm";
        } else {
            this.clinicService.saveContact(contact);
            return "redirect:/contacts";
        }
    }


    @RequestMapping(value = "/contactss/{contactId}/edit", method = RequestMethod.GET)
    public String initUpdateContactForm(@PathVariable("contactId") int contactId, Model model) {
        Contact contact = this.clinicService.findContactById(contactId);
        model.addAttribute(contact);
        return VIEWS_CONTACT_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/contacts/{contactId}/edit", method = RequestMethod.POST)
    public String processUpdateContactForm(@Valid Contact contact, BindingResult result, @PathVariable("contactId") int contactId) {
        if (result.hasErrors()) {
            return VIEWS_CONTACT_CREATE_OR_UPDATE_FORM;
        } else {
            contact.setId(contactId);
            this.clinicService.saveContact(contact);
            return "redirect:/contacts";
        }
    }


}
