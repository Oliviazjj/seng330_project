package org.springframework.samples.mealOnWheel.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.model.Food;
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
public class FoodControllerTest {

    private static final int TEST_FOOD_ID = 1;
    private static final String VIEWS_FOOD_CREATE_OR_UPDATE_FORM = "foods/createOrUpdateFoodForm";

    @Autowired
    private FoodController foodController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(foodController).build();

        given(this.companyService.findEventById(TEST_FOOD_ID)).willReturn(new Event());

        Food food = new Food();
        food.setId(1);
        given(this.companyService.findFoodById(1)).willReturn(food);
    }

    @Test
    public void testInitCreationForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/foods/new"))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_FOOD_CREATE_OR_UPDATE_FORM));
    }

    @Test
    public void testProcessFoodFormSuccess() throws Exception {
        mockMvc.perform(post("/foods/new")
            .param("name", "nn")
            .param("type", "ty")
            .param("amount", "4")
            .param("expireDate", "2017/06/13")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/foods"));
    }

    @Test
    public void testProcessFoodFormFailed() throws Exception {
        mockMvc.perform(post("/foods/new")
            .param("expireDate", "2017/50/50")      // wrong date
        )
            .andExpect(status().isOk())
            .andExpect(view().name("foods/createOrUpdateFoodForm"));
    }


    @Test
    public void testInitUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/foods/{foodId}/edit", 1))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_FOOD_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testProcessUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/foods/{foodId}/edit", 1)
            .param("name", "nn")
            .param("type", "ty")
            .param("amount", "4")
            .param("expireDate", "2017/06/13")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/foods"));
    }

}

