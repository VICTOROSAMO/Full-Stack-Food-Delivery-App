package com.osamo.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class OrderRequest {
    private String userId;
    private List<OrderItems> orderedItems;
    private String userAddress;
    private double amount;
}
