package com.taco.cloud.tacocloud.domain;

import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class TacoEntityModel extends RepresentationModel<TacoEntityModel> {

    @Getter
    private String name;
    @Getter
    private Date createdAt;
    @Getter
    private CollectionModel<IngredientEntityModel> ingredients;

    public TacoEntityModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = new IngredientEntityModeleAssembler().toCollectionModel(taco.getIngredients());
    }
}
