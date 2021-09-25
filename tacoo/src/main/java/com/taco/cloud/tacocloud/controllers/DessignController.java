package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.domain.Ingredient;
import com.taco.cloud.tacocloud.domain.IngredientType;
import com.taco.cloud.tacocloud.domain.Order;
import com.taco.cloud.tacocloud.domain.User;
import com.taco.cloud.tacocloud.repositories.IngredientRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DessignController {

    private final IngredientRepository ingredientRepository;


    public DessignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping
    public String bootstrapData(Model model) {
        List<Ingredient> ingredients = (ArrayList<Ingredient>) ingredientRepository.findAll();
        IngredientType[] ingredientTypes = IngredientType.values();
        for (IngredientType ingredientType : ingredientTypes) {
            model.addAttribute(ingredientType.toString().toLowerCase(), ingredients.stream().
                    filter(i -> i.getIngredientType() == ingredientType).collect(Collectors.toList()));
        }
        return "design";
    }

    @PostMapping
    public String processCreateTaco(Model model, @AuthenticationPrincipal User user) {
        Order order = new Order();
        model.addAttribute("user", user);
        order.setDeliveryName(user.getUsername());
        order.setDeliveryCity(user.getCity());
        order.setDeliveryState(user.getState());
        order.setDeliveryStreet(user.getStreet());
        order.setDeliveryZip(user.getZip());
        order.setUser(user);
        model.addAttribute("order", order);
        return "order";
    }
}
