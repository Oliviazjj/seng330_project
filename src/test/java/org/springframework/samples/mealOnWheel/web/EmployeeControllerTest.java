package org.springframework.samples.mealOnWheel.web;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.samples.mealOnWheel.model.Employee;
import org.springframework.samples.mealOnWheel.model.Event;
import org.springframework.samples.mealOnWheel.model.User;
import org.springframework.samples.mealOnWheel.service.CompanyService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
@WebAppConfiguration
public class EmployeeControllerTest {

    private static final int TEST_EMPLOYEE_ID = 1;
    private static final String VIEWS_EMPLOYEE_CREATE_OR_UPDATE_FORM = "employees/createOrUpdateEmployeeForm";

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private CompanyService companyService;

    private MockMvc mockMvc;

//    private MockHttpSession currentSession;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

        given(this.companyService.findEmployeeById(TEST_EMPLOYEE_ID)).willReturn(new Employee());

//        this.currentSession = new MockHttpSession();
    }

    @Test
    public void testInitCreationForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/employees/new"))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_EMPLOYEE_CREATE_OR_UPDATE_FORM));
    }

    @Test
    public void testProcessCreationForm() throws Exception {
        mockMvc.perform(post("/employees/new")
            .param("firstName", "nn")
            .param("lastName", "ln")
            .param("address", "addn")
            .param("city", "ci")
            .param("telephone", "97652019")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/employees.html?lastName="));
    }

    @Test
    public void testInitFindForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/employees/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("employees/findEmployees"));
    }

    @Test
    public void testProcessFindFormEmpty() throws Exception {
        ResultActions c = mockMvc.perform(get("/employees"))
            .andExpect(status().isOk())
            .andExpect(view().name("employees/findEmployees"));
    }

    @Test
    public void testProcessFindForm1Employee() throws Exception {
        Collection<Employee> employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setId(1);
        employees.add(emp);
        given(this.companyService.findEmployeeByLastName("")).willReturn(employees);

        ResultActions c = mockMvc.perform(get("/employees"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/employees/1"));
    }


    @Test
    public void testInitUpdateEmployeeForm() throws Exception {
        ResultActions c = mockMvc.perform(get("/employees/{employeeId}/edit", 1))
            .andExpect(status().isOk())
            .andExpect(view().name(VIEWS_EMPLOYEE_CREATE_OR_UPDATE_FORM));
    }


    @Test
    public void testProcessUpdateEmployeeForm() throws Exception {
        ResultActions c = mockMvc.perform(post("/employees/{employeeId}/edit", 1)
            .param("id", "1")
            .param("firstName", "nn")
            .param("lastName", "ln")
            .param("address", "addn")
            .param("city", "ci")
            .param("telephone", "97652019")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/employees/{employeeId}"));
    }

    @Test
    public void testShowEventDetail() throws Exception {
        ResultActions c = mockMvc.perform(get("/employees/{employeeId}", 1))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("employee"))
            .andExpect(view().name("employees/employeeDetails"));
    }
}
