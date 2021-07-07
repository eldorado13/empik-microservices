package com.empik.microservices.usersservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.empik.microservices.usersservice"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiMetadata());
    }

    private ApiInfo apiMetadata() {
        return new ApiInfoBuilder()
                .title("Users Info Service")
                .description("Web API for receiving detailed information about given login")
                .version("1.0")
                .build();
    }
}
