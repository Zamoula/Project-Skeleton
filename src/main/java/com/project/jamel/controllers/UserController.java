package com.project.jamel.controllers;

import com.project.jamel.entities.User;
import com.project.jamel.services.Crud;
import com.project.jamel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends Controller<User, Long>{

    @Autowired
    private UserService userService;

    @Override
    protected Crud<User, Long> getService() {
        return userService;
    }
}
