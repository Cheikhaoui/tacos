package com.taco.cloud.tacocloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value= {"/","/logout"})
    public String getHomePage(){
        return "home";
    }

    @GetMapping(value = "/log")
    public String getDesignPage(){
        return "redirect:/login";
    }






}
