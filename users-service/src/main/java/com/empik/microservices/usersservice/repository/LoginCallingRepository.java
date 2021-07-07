package com.empik.microservices.usersservice.repository;

import com.empik.microservices.usersservice.entity.LoginCalling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginCallingRepository extends JpaRepository<LoginCalling, Integer> {

    Optional<LoginCalling> findByLogin(String login);

    @Modifying
    @Query("Update LoginCalling lc set lc.requestCount = lc.requestCount+1 where lc.login = :login")
    void increaseCallingNumber(@Param(value = "login") String login);
}
