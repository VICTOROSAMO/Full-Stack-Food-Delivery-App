package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.io.OrderRequest;
import com.osamo.foodiesapi.io.OrderResponse;

public interface OrderService {
    OrderResponse createOrderWithPayment(OrderRequest request);
}
