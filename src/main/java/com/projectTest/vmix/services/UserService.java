package com.projectTest.vmix.services;

import com.projectTest.vmix.dto.UserDTO;
import com.projectTest.vmix.entities.User;
import com.projectTest.vmix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public User findById(Long id) {
        User result = repository.findById(id).get();
        return result;
    }

    public User insert(User user) {
        User result = repository.save(user);
        return result;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
