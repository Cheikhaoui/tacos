package com.taco.cloud.tacocloud.repositories;

import com.taco.cloud.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco,Long> {
}
