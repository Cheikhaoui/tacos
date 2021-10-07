package com.taco.cloud.tacocloud.consumers;

import com.taco.cloud.tacocloud.domain.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientConsumer {

    private final RestTemplate template;


    public IngredientConsumer(RestTemplate template) {
        this.template = template;
    }


    public Ingredient getIngredient(String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        return template.getForObject("http://localhost:8081/ingredient/{id}",Ingredient.class,map);
    }

    public Ingredient postIngredient(Ingredient ingredient){
        return template.postForObject("http://localhost:8081/ingredient",ingredient,Ingredient.class);
    }

    public void deleteIngredient(String id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
         template.delete("http://localhost:8081/ingredient/{id}",map);
    }

}
