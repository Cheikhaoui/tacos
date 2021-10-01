package com.taco.cloud.tacocloud.domain;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class IngredientEntityModel extends RepresentationModel<IngredientEntityModel> {

    @Getter
    private String name;
    @Getter
    private IngredientType ingredientType;

    public IngredientEntityModel(Ingredient model) {
        this.name = model.getName();
        this.ingredientType = model.getIngredientType();
    }
}
