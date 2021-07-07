package com.empik.microservices.usersservice.service;

import com.empik.microservices.usersservice.entity.LoginCalling;
import com.empik.microservices.usersservice.model.dto.response.DetailedUserResponse;
import com.empik.microservices.usersservice.model.dto.response.UserResponse;
import com.empik.microservices.usersservice.repository.LoginCallingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

public class UsersService {

    private final static String BASE_URL = "https://api.github.com/users/";

    private final RestTemplate usersRestTemplate;
    private final LoginCallingRepository loginCallingRepository;

    public UsersService(RestTemplate usersRestTemplate, LoginCallingRepository loginCallingRepository) {
        this.usersRestTemplate = usersRestTemplate;
        this.loginCallingRepository = loginCallingRepository;
    }

    @Transactional
    public Integer getNumberOfLoginCalls(String login) {
        Optional<LoginCalling> byLogin = loginCallingRepository.findByLogin(login);
        return byLogin.isEmpty() ? 0 : byLogin.get().getRequestCount();
    }

    @Transactional
    public UserResponse getUserByLogin(String login) {
        ResponseEntity<DetailedUserResponse> response = this.usersRestTemplate.getForEntity(BASE_URL + login, DetailedUserResponse.class);
        DetailedUserResponse detailedUserResponse = Objects.requireNonNull(response.getBody());
        writeIntoDatabase(login);

        return UserResponse.builder()
                .id(detailedUserResponse.getId())
                .login(detailedUserResponse.getLogin())
                .name(detailedUserResponse.getName())
                .type(detailedUserResponse.getType())
                .avatarUrl(detailedUserResponse.getAvatarUrl())
                .calculations(doCalculation(detailedUserResponse))
                .build();
    }

    private void writeIntoDatabase(String login) {
        if (loginCallingRepository.findByLogin(login).isEmpty()) {
            loginCallingRepository.save(LoginCalling.builder().login(login).requestCount(1).build());
        } else {
            loginCallingRepository.increaseCallingNumber(login);
        }
    }

    private String doCalculation(DetailedUserResponse detailedUserResponse) {
        if (detailedUserResponse.getFollowers() == 0) {
            return "Followers number is 0. Calculation is not possible.";
        } else {
            double result = (6.0 / detailedUserResponse.getFollowers()) * (2.0 + detailedUserResponse.getPublicRepos());
            return String.valueOf(result);
        }
    }
}