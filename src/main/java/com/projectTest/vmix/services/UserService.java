package com.projectTest.vmix.services;

import com.projectTest.vmix.entities.User;
import com.projectTest.vmix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> result = repository.findAll();
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
