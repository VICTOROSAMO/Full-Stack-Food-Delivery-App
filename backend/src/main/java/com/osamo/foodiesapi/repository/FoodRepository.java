package com.osamo.foodiesapi.repository;

import com.osamo.foodiesapi.entity.FoodEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<FoodEntity, String> {
}
