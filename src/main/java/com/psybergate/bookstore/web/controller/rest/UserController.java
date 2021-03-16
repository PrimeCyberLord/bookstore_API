package com.psybergate.bookstore.web.controller.rest;

import com.psybergate.bookstore.domain.Order;
import com.psybergate.bookstore.domain.User;
import com.psybergate.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
