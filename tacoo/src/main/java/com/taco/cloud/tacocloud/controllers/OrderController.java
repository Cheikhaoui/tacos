package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.domain.Order;
import com.taco.cloud.tacocloud.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller("/order")
public class OrderController {

    @GetMapping
    public String getOrder(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("user",user);
        model.addAttribute("deliveryName",user.getUsername());
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, @AuthenticationPrincipal User user){
        order.setUser(user);
        return "redirect:/";
    }

    @PostConstruct
   public void getOrder(){
//      User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  //    System.out.println(user);
    }
}
