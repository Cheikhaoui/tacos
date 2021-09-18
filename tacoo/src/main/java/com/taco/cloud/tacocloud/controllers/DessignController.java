package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.domain.Ingredient;
import com.taco.cloud.tacocloud.domain.IngredientType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DessignController {

    @GetMapping
    public String bootstrapData(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );

        IngredientType[] ingredientTypes =  IngredientType.values();
        for (IngredientType ingredientType: ingredientTypes) {
            model.addAttribute(ingredientType.toString().toLowerCase(),ingredients.stream().
                    filter(i->i.getIngredientType() == ingredientType).collect(Collectors.toList()));
        }
        return "design";
    }

    @PostMapping
    public String processCreateTaco(){
        System.out.println("we creaaate");
        return "";
    }
}
