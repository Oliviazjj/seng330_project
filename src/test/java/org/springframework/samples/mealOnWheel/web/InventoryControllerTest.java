package org.springframework.samples.mealOnWheel.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.model.Food;
import org.springframework.samples.mealOnWheel.model.Inventory;
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
public class InventoryControllerTest {

    private static final int TEST_INVENTORY_ID = 1;
    private static final String VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM = "inventorys/createOrUpdateInventoryForm";

    @Autowired
    private InventoryController inventoryController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();

        given(this.companyService.findInventoryById(TEST_INVENTORY_ID)).willReturn(new Inventory());
    }

    @Test
    public void testInitCreationForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/inventorys/new"))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM));
    }

    @Test
    public void testProcessInventoryForm() throws Exception {
        mockMvc.perform(post("/inventorys/new")
            .param("name", "nn")
            .param("type", "ty")
            .param("amount", "3")
            .param("purchaseDate", "2017/01/01")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/inventorys"));
    }

    @Test
    public void testProcessInventoryFormFailed() throws Exception {
        mockMvc.perform(post("/inventorys/new")
            .param("purchaseDate", "2017/50/50")      // wrong date
        )
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testInitUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/inventorys/{inventoryId}/edit", TEST_INVENTORY_ID))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_INVENTORY_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testProcessUpdateForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/inventorys/{inventoryId}/edit", TEST_INVENTORY_ID)
            .param("id", "1")
            .param("name", "nn")
            .param("type", "ty")
            .param("amount", "4")
            .param("expireDate", "2017/06/13")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/inventorys"));
    }


    @Test
    public void testShowInventoryList() throws Exception {
        ResultActions c = mockMvc.perform(get("/inventorys"))
            .andExpect(status().isOk())
            .andExpect(view().name("inventorys/inventoryList"));
    }
}

