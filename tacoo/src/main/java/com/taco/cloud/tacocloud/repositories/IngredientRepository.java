package com.taco.cloud.tacocloud.repositories;

import com.taco.cloud.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {
}
