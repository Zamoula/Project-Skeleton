package com.project.jamel.services;

import com.project.jamel.entities.User;
import com.project.jamel.repositories.GenericRepository;
import com.project.jamel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends Crud<User, Long> {
    @Autowired
    private UserRepository userRepository;

    protected GenericRepository<User, Long> getRepository() {
        return userRepository;
    }
}
