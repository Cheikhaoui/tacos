package com.taco.cloud.tacocloud.repositories;

import com.taco.cloud.tacocloud.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String userName);
}
