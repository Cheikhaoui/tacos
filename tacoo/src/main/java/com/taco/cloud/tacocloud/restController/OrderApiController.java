package com.taco.cloud.tacocloud.restController;

import com.taco.cloud.tacocloud.domain.Order;
import com.taco.cloud.tacocloud.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
@RequestMapping("/api/order")
public class OrderApiController {

    private final OrderRepository repository;

    public OrderApiController(OrderRepository repository) {
        this.repository = repository;
    }

    @PutMapping
    public void updateOrder(@RequestBody Order order){
        repository.save(order);
    }

    @PatchMapping("/{id}")
    public Order patchOrder(@RequestBody Order patch,@PathVariable Long id){
        Order order = repository.findById(id).orElseGet(null);
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryState());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return repository.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
