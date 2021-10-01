package com.taco.cloud.tacocloud.domain;

import com.taco.cloud.tacocloud.restController.DesignTacoController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientEntityModeleAssembler extends RepresentationModelAssemblerSupport<Ingredient,IngredientEntityModel> {

    public IngredientEntityModeleAssembler() {
        super(DesignTacoController.class, IngredientEntityModel.class);
    }

    @Override
    public IngredientEntityModel toModel(Ingredient entity) {
        return createModelWithId(entity.getId(),entity);
    }

    @Override
    protected IngredientEntityModel instantiateModel(Ingredient entity) {
        return new IngredientEntityModel(entity);
    }
}
