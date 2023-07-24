package com.service.lestplanit.controller.security;

import com.service.lestplanit.controller.request.CreateUserDTO;
import com.service.lestplanit.models.security.ERole;
import com.service.lestplanit.models.security.RoleEntity;
import com.service.lestplanit.models.security.UserEntity;
import com.service.lestplanit.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Controller class to handle user-related operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserEntity objects representing all users.
     */
    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    /**
     * Creates a new user based on the provided CreateUserDTO.
     *
     * @param user CreateUserDTO object containing user information.
     * @return UserEntity representing the newly created user.
     */
    @PostMapping("/create-user")
    public UserEntity createUser(@RequestBody CreateUserDTO user) {
        Set<RoleEntity> roles = user.getRoles().stream()
                .map(role -> new RoleEntity(ERole.valueOf(role)))
                .collect(Collectors.toSet());

        UserEntity newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());

        return userService.createUser(roles, newUser);
    }
}