package com.taco.cloud.tacocloud.restController;

import com.taco.cloud.tacocloud.domain.Taco;
import com.taco.cloud.tacocloud.domain.TacoEntityModel;
import com.taco.cloud.tacocloud.domain.TacoEntityModeleAssembler;
import com.taco.cloud.tacocloud.repositories.TacoRepository;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import java.util.List;
import java.util.Optional;

//@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/design",produces = "application/json")
public class DesignTacoController {

    private final TacoRepository tacoRepository;

    public DesignTacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/recent")
    public CollectionModel<TacoEntityModel> tacoFuck(){
        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
        Iterable<Taco> tacos = tacoRepository.findAll(page).getContent();
       return new CollectionModel<TacoEntityModel>(new TacoEntityModeleAssembler().toCollectionModel(tacos))
                .add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DesignTacoController.class).tacoFuck()).withRel("daniii"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTacoById(@PathVariable Long id ){
        Optional<Taco> taco = tacoRepository.findById(id);
        return taco.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTaco(@RequestBody Taco taco){
        tacoRepository.save(taco);
    }


}
