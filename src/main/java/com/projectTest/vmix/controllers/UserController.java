package com.projectTest.vmix.controllers;

import com.projectTest.vmix.dto.UserDTO;
import com.projectTest.vmix.entities.User;
import com.projectTest.vmix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> findAll() {
        List<UserDTO> result = service.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User result = service.findById(id);
        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user) {
        User result = service.insert(user);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
         service.deleteById(id);
    }
}
