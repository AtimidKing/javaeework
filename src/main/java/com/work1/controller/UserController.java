package com.work1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yking on 2017/9/28.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String validationUser(Model model){
        model.addAttribute("user", "yang");
        return "welcome";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String validationUser(String name ,String password,Model model){
        Subject user= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        System.out.println("name:"+name);
        user.login(token);
        model.addAttribute("username",user.getPrincipal());
        return "welcome";
    }

}
