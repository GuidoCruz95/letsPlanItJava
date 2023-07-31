package com.service.lestplanit;

import com.service.lestplanit.security.models.UserEntity;
import com.service.lestplanit.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LestPlanItApplication {

    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(LestPlanItApplication.class, args);
    }

    @Bean
    CommandLineRunner init(){
        return args -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail("admin@user.com");
            userEntity.setUsername("admin");
            userEntity.setPassword("password1234");
            userService.createUser(Set.of("ADMIN"), userEntity);

            UserEntity userEntity2 = new UserEntity();
            userEntity2.setEmail("user@user.com");
            userEntity2.setUsername("user");
            userEntity2.setPassword("password1234");
            userService.createUser(Set.of("USER"), userEntity2);

            UserEntity userEntity3 = new UserEntity();
            userEntity3.setEmail("invited_admin@user.com");
            userEntity3.setUsername("invited_admin");
            userEntity3.setPassword("password1234");
            Set<String> roles3 = new HashSet<String>() {{
                add("ADMIN");
                add("INVITED");
            }};
            userService.createUser(roles3, userEntity3);
        };
    }
}
