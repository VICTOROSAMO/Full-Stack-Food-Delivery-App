package com.osamo.foodiesapi.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponse {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private String category;
}
