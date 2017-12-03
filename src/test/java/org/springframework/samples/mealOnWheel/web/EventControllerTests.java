package org.springframework.samples.mealOnWheel.web;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.model.User;
import org.springframework.samples.mealOnWheel.service.CompanyService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
@WebAppConfiguration
public class EventControllerTests {

    private static final int TEST_EVENT_ID = 1;
    private static final String VIEWS_EVENTS_CREATE_OR_UPDATE_FORM = "events/createOrUpdateEventForm";

    @Autowired
    private EventController eventController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();

        given(this.companyService.findEventById(TEST_EVENT_ID)).willReturn(new Event());

        this.currentSession = new MockHttpSession();

        User user = new User();
        user.setId(1);
        currentSession.setAttribute("currentUser", user);
    }

    @Test
    public void testInitCreationForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/{userId}/events/new", 1).session(currentSession))
            .andExpect(status().isOk())
            .andExpect(view().name("auth/userInfoPage"));
    }

    @Test
    public void testSubmitCreationForm() throws Exception {
        mockMvc.perform(post("/{userId}/events/new", 1)
            .param("name", "n")
            .param("amountOfPeople", "2")
            .param("eventDate", "2017/1/10")
            .param("appetizer", "appe")
            .param("entree", "entr")
            .param("dessert", "dessert")
            .param("description", "more details")
        )
            .andExpect(status().is2xxSuccessful())
            .andExpect(view().name("auth/userInfoPage"));
    }

    @Test
    public void testInitUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/events/{eventId}/edit", 1).session(currentSession))
            .andExpect(status().isOk())
            .andExpect(view().name("events/createOrUpdateEventForm"));
    }


    @Test
    public void testProcessUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/events/{eventId}/edit", 1)
            .param("id", "1")
            .param("name", "n")
            .param("amountOfPeople", "2")
            .param("eventDate", "2017/1/10")
            .param("location", "300 graden street")
            .param("appetizer", "appe")
            .param("entree", "entr")
            .param("dessert", "dessert")
            .param("description", "more details")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/events"));
    }

    @Test
    public void testInitCreationEventForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/events/new"))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_EVENTS_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testSubmitCreationEventForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/events/new")
            .param("name", "n")
            .param("amountOfPeople", "2")
            .param("eventDate", "2017/1/10")
            .param("location", "300 graden street")
            .param("appetizer", "appe")
            .param("entree", "entr")
            .param("dessert", "dessert")
            .param("description", "more details")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/events"));
    }

    @Test
    public void testShowEventDetail() throws Exception {
        ResultActions c = mockMvc.perform(get("/events/1"))
            .andExpect(status().isOk())
//            .andExpect(model().attributeHasNoErrors("employeeEvents"))
            .andExpect(view().name("events/eventDetails"));
    }

    @Test
    public void testShowEventList() throws Exception {
        ResultActions c = mockMvc.perform(get("/events"))
            .andExpect(status().isOk())
            .andExpect(view().name("events/eventList"));
    }
}
