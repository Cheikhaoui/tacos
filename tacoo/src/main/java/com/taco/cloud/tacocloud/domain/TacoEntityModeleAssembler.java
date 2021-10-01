package com.taco.cloud.tacocloud.domain;

import com.taco.cloud.tacocloud.restController.DesignTacoController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoEntityModeleAssembler extends RepresentationModelAssemblerSupport<Taco,TacoEntityModel> {

    public TacoEntityModeleAssembler() {
        super(DesignTacoController.class, TacoEntityModel.class);
    }


    @Override
    public TacoEntityModel toModel(Taco entity) {
        return createModelWithId(entity.getId(),entity);
    }

    @Override
    protected TacoEntityModel instantiateModel(Taco entity) {
        return new TacoEntityModel(entity);
    }
}
