package com.work1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yking on 2017/9/28.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/s",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String validationUser(Model model){
        model.addAttribute("user", "yang");
        return "welcome";
    }

}
