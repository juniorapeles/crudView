package com.projectTest.vmix.services;

import com.projectTest.vmix.dto.UserDTO;
import com.projectTest.vmix.entities.User;
import com.projectTest.vmix.repositories.UserRepository;
import com.projectTest.vmix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> users =  repository.findAll();

        List<UserDTO> result = users.stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
        return result;
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found " + id));
        return new UserDTO(entity);
    }

    public User insert(User user) {
        User result = repository.save(user);
        return result;
    }

    public void deleteById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found " + id));
        repository.deleteById(id);
    }
}
