package com.service.lestplanit.security.controller;

import com.service.lestplanit.security.controller.request.CreateUserDTO;
import com.service.lestplanit.security.models.UserEntity;
import com.service.lestplanit.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

/**
 * Controller class to handle user-related operations.
 */
@RestController
@RequestMapping("/system-users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
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
        UserEntity newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());

        return userService.createUser(new HashSet<>(user.getRoles()), newUser);
    }
}
