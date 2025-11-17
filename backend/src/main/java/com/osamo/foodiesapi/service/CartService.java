package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.io.CartRequest;
import com.osamo.foodiesapi.io.CartResponse;

public interface CartService {
    CartResponse addToCart(CartRequest request);

    CartResponse getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);
}
