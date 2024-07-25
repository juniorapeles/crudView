package com.projectTest.vmix.services;

import com.projectTest.vmix.dto.UserDTO;
import com.projectTest.vmix.entities.User;
import com.projectTest.vmix.repositories.UserRepository;
import com.projectTest.vmix.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    public UserDTO insert(UserDTO dto) {
        User entity = new User(dto);
        User result = repository.save(entity);
        return new UserDTO(result);
    }

    public void deleteById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found " + id));
        repository.deleteById(id);
    }

    public UserDTO update(Long id, UserDTO dto) {
        try{
            User entity = repository.getReferenceById(id);
            entity.setDepartment(dto.getDepartment());
            entity.setEmail(dto.getEmail());
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new UserDTO(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not Found" + id);
        }
    }
}
