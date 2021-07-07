package com.empik.microservices.usersservice.config;

import com.empik.microservices.usersservice.repository.LoginCallingRepository;
import com.empik.microservices.usersservice.service.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UsersConfig {

    @Bean
    public UsersService usersService(@Qualifier("usersRestTemplate") RestTemplate usersRestTemplate,
                                     LoginCallingRepository loginCallingRepository) {
        return new UsersService(usersRestTemplate, loginCallingRepository);
    }

    @Bean("usersRestTemplate")
    public RestTemplate usersRestTemplate() {
        return new RestTemplate();
    }
}
