package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.io.FoodRequest;
import com.osamo.foodiesapi.io.FoodResponse;
import com.osamo.foodiesapi.repository.FoodRepository;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request, MultipartFile file);
}
