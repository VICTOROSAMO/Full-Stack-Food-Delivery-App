package com.osamo.foodiesapi.io;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private String id;
    private String name;
    private String email;
}
