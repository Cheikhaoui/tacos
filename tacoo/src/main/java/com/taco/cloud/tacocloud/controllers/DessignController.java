package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.domain.*;
import com.taco.cloud.tacocloud.repositories.IngredientRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
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
    public String processCreateTaco(Model model, @AuthenticationPrincipal User user, @Valid Taco taco,@ModelAttribute Order orderAttribute) {
        model.addAttribute("user", user);
        orderAttribute.setDeliveryName(user.getUsername());
        orderAttribute.setDeliveryCity(user.getCity());
        orderAttribute.setDeliveryState(user.getState());
        orderAttribute.setDeliveryStreet(user.getStreet());
        orderAttribute.setDeliveryZip(user.getZip());
        orderAttribute.setUser(user);
        if(orderAttribute.getTacos() == null){
            orderAttribute.setTacos(new ArrayList<>());
        }
        orderAttribute.getTacos().add(taco);
        return "order";
    }

    @ModelAttribute(name = "order")
    public Order getOrder(){
        return new Order();
    }

}
