package com.taco.cloud.tacocloud.restController;


import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.taco.cloud.tacocloud.domain.Ingredient;
import com.taco.cloud.tacocloud.repositories.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/ingredient")
public class IngredientApiController {

    private final IngredientRepository repository;

    public IngredientApiController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    Ingredient getIngredientById(@PathVariable String id){
        return repository.findById(id).orElseGet(()->null);
    }

    @PostMapping
    Ingredient  createIngredient(@RequestBody Ingredient ingredient){
        return repository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    void deleteIngredient(@PathVariable String  id){
        Ingredient ingredient = repository.findById(id).orElse(null);
        if(null!=ingredient){
            repository.delete(ingredient);
        }
        }


}
