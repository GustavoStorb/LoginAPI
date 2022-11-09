package com.gustavostorb.auth.user.service;

import com.gustavostorb.auth.user.dto.CreateUserDTO;
import com.gustavostorb.auth.user.dto.UpdateUserDTO;
import com.gustavostorb.auth.user.enums.UserType;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exists.");
        }

        return user.get();
    }
    public User store(CreateUserDTO createUserDTO) {
        if(createUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        User user = createUserDTO.toUser();
        return this.userRepository.save(user);
    }
    public User update(Long id, UpdateUserDTO updateUserDTO) {
        if(updateUserDTO == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid body.");
        }

        User user = this.userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exists.");
        }

        updateUserDTO.updateUser(user);
        this.userRepository.save(user);
        return user;
    }
    public void delete(Long id){
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
        }
    }

}
