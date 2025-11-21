package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.entity.OrderEntity;
import com.osamo.foodiesapi.io.OrderRequest;
import com.osamo.foodiesapi.io.OrderResponse;
import com.osamo.foodiesapi.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final PesapalService pesapalService;

    @Value("${pesapal_key}")
    private String PESAPAL_KEY;

    @Value("${pesapal_secret}")
    private  String PESAPAL_SECRET;

    @Override
    public OrderResponse createOrderWithPayment(OrderRequest request) {
        OrderEntity newOrder = convertToEntity(request);
        newOrder = orderRepository.save(newOrder);

        //create pesapal payment order

      return null;
    }

    private OrderEntity convertToEntity(OrderRequest request) {
        return OrderEntity.builder()
                .userId(request.getUserId())
                .userAddress(request.getUserAddress())
                .amount(request.getAmount())
                .orderedItems(request.getOrderedItems())
                .build();
    }
}
