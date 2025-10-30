package com.osamo.foodiesapi.repository;

import com.osamo.foodiesapi.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional <UserEntity> findByEmail(String email);
}
