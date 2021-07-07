package com.empik.microservices.usersservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String calculations;
}
