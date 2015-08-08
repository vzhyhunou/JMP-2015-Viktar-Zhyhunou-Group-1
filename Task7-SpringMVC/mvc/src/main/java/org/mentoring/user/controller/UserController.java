package org.mentoring.user.controller;

import java.util.Map;

import org.mentoring.user.form.User;
import org.mentoring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @RequestMapping("/")
    public String listUsers(Map<String, Object> map) {
 
        map.put("user", new User());
        map.put("usersList", userService.listUsers());
 
        return "user";
    }
 
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
                              User user, BindingResult result) {
 
        userService.addUser(user);
 
        return "redirect:/";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId")
                                 Integer userId) {
 
        userService.removeUserWithId(userId);
 
        return "redirect:/";
    }
}