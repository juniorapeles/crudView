package com.projectTest.vmix.controllers;

import com.projectTest.vmix.dto.UserDTO;
import com.projectTest.vmix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public UserDTO findById(@PathVariable Long id) {
        UserDTO result = service.findById(id);
        return result;
    }

    @PostMapping
    public UserDTO insert(@RequestBody UserDTO dto) {
        UserDTO result = service.insert(dto);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
