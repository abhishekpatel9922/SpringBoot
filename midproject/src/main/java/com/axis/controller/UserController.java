package com.axis.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ApiResponse;
import com.axis.model.User;
import com.axis.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return userService.findAllUsers();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") Integer userId) {
        return userService.deleteUserById(userId);
    }

    @GetMapping("/getBy/{id}")
    @ResponseBody
    public ApiResponse getById(@PathVariable(name = "id") Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getOrdersByUserId/{id}")
    public ApiResponse getOrdersByUserId(@PathVariable(name = "id") Integer userId) {
        return userService.getOrdersByUserId(userId);
    }
}