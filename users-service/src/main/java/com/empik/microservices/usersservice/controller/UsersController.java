package com.empik.microservices.usersservice.controller;

import com.empik.microservices.usersservice.model.dto.response.UserResponse;
import com.empik.microservices.usersservice.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/{login}")
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<UserResponse> getUserByLogin(@PathVariable String login) {
        UserResponse userResponse = usersService.getUserByLogin(login);
        return new HttpEntity<>(userResponse);
    }

    @GetMapping("/loginCallingNumber/{login}")
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<Integer> getNumberOfLoginCalls(@PathVariable String login) {
        return new HttpEntity<>(usersService.getNumberOfLoginCalls(login));
    }
}
