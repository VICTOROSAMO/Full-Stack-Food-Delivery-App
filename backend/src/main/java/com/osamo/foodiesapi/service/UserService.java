package com.osamo.foodiesapi.service;

import com.osamo.foodiesapi.io.UserRequest;
import com.osamo.foodiesapi.io.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest request);
}
