package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Employee;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

//    private static final String VIEWS_EMPLOYEE_CREATE_OR_UPDATE_FORM = "users/login";
    private final ClinicService clinicService;

    @Autowired
    public UserController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "users/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerProcess(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/register";
        } else {
            this.clinicService.saveUser(user);
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Map<String, Object> model) {
        return "users/login";
    }
    

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(String username, String password, HttpServletRequest request, HttpSession session) {
        username = request.getParameter("username");
        password = request.getParameter("password");
        User user = this.clinicService.login(username, password);
        if (user == null) {
            return "users/login";
        } else {
            session.setAttribute("currentUser", user);
            return "auth/userInfoPage";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.setAttribute("currentUser", null);
        return "redirect:/auth";
    }
    
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String Admin(Map<String, Object> model) {
        return "auth/adminPage";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String AdminProcess(String username, String password, HttpServletRequest request, HttpSession session) {
    		username = request.getParameter("username");
        password = request.getParameter("password");
        if(username=="admin123"&&password=="admin123") { 		
        		return "welcome";
        }
        else return "auth/adminPage";
    }
    
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String UserInfoPage(Map<String, Object> model) {
        return "auth/userInfoPage";
    }

   
}
