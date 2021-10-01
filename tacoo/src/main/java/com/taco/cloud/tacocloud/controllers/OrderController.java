package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.domain.Order;
import com.taco.cloud.tacocloud.domain.Taco;
import com.taco.cloud.tacocloud.domain.User;
import com.taco.cloud.tacocloud.repositories.OrderRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {

   private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, @AuthenticationPrincipal User user){
        order.setUser(user);
        repository.save(order);
        return "redirect:/";
    }

    @PostConstruct
   public void getOrder(){
//      User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  //    System.out.println(user);
    }
}
