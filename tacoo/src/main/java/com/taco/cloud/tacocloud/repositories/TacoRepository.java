package com.taco.cloud.tacocloud.repositories;

import com.taco.cloud.tacocloud.domain.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends JpaRepository<Taco,Long> {
}
