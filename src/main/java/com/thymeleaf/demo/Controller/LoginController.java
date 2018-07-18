package com.thymeleaf.demo.Controller;


import com.thymeleaf.demo.Model.Role;
import com.thymeleaf.demo.Model.User;

import com.thymeleaf.demo.Repositories.RoleRepository;
import com.thymeleaf.demo.Repositories.UserRepository;

import com.thymeleaf.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");

        return modelAndView;

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExist = userService.findByEmail(user.getEmail());
        if(userExist != null){
            bindingResult
                    .rejectValue("email", "error.user", "There is already a user with the email provided ");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }else{

            userService.saveUser(user);
            modelAndView.addObject("successMessage","User has been registered Successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;

    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}






