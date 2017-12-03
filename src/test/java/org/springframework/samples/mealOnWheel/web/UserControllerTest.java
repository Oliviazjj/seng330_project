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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        given(this.companyService.login("user", "pass")).willReturn(new User());
    }

    @Test
    public void testLogin() throws Exception {
        ResultActions c = mockMvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("users/login"));
    }

    @Test
    public void testLoginPost() throws Exception {
        mockMvc.perform(post("/login")
            .param("username", "user")
            .param("password", "pass")
        )
            .andExpect(status().isOk())
            .andExpect(view().name("auth/userInfoPage"));
    }

    @Test
    public void testLoginPostFailed() throws Exception {
        mockMvc.perform(post("/login")
            .param("username", "first")
            .param("password", "last")
        )
            .andExpect(status().isOk())
            .andExpect(view().name("users/login"));
    }

    @Test
    public void testLogout() throws Exception {
        ResultActions c = mockMvc.perform(get("/logout"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/auth"));
    }

    @Test
    public void testAdminPost() throws Exception {
        mockMvc.perform(post("/admin")
            .param("username", "admin123")
            .param("password", "admin123")
        )
            .andExpect(status().isOk())
            .andExpect(view().name("welcome"));
    }

    @Test
    public void testAdminPostFailed() throws Exception {
        mockMvc.perform(post("/admin")
            .param("username", "first")
            .param("password", "last")
        )
            .andExpect(status().isOk())
            .andExpect(view().name("auth/adminPage"));
    }

}
