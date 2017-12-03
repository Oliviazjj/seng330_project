package org.springframework.samples.mealOnWheel.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.samples.mealOnWheel.model.Contact;
import org.springframework.samples.mealOnWheel.service.CompanyService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
@WebAppConfiguration
public class ContactControllerTest {

    private static final int TEST_CONTACT_ID = 1;
    private static final String VIEWS_CONTACT_CREATE_OR_UPDATE_FORM = "contacts/createOrUpdateContactForm";

    @Autowired
    private ContactController contactController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();

        given(this.companyService.findContactById(TEST_CONTACT_ID)).willReturn(new Contact());
    }

    @Test
    public void testInitCreationForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/contacts/new"))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_CONTACT_CREATE_OR_UPDATE_FORM));
    }

    @Test
    public void testProcessContactForm() throws Exception {
        mockMvc.perform(post("/contacts/new")
            .param("firstName", "first")
            .param("lastName", "last")
            .param("email", "ee@ee.com")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/contacts"));
    }


    @Test
    public void testInitUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/contacts/{contactId}/edit", TEST_CONTACT_ID))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_CONTACT_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testProcessUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/contacts/{contactId}/edit", TEST_CONTACT_ID)
            .param("id", "1")
            .param("firstName", "first")
            .param("lastName", "last")
            .param("email", "ee@ee.com")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/contacts"));
    }


    @Test
    public void testShowInventoryList() throws Exception {
        ResultActions c = mockMvc.perform(get("/contacts"))
            .andExpect(status().isOk())
            .andExpect(view().name("contacts/contactList"));
    }
}
