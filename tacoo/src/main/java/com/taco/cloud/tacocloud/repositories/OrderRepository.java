package com.taco.cloud.tacocloud.repositories;

import com.taco.cloud.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
