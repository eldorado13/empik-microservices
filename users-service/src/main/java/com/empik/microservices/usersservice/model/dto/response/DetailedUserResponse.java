package com.empik.microservices.usersservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedUserResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("login")
    private String login;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("followers")
    private Integer followers;

    @JsonProperty("public_repos")
    private Integer publicRepos;
}
