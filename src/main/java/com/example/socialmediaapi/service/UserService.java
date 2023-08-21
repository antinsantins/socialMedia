package com.example.socialmediaapi.service;

import com.example.socialmediaapi.entity.StatusEnum;
import com.example.socialmediaapi.entity.User;
import com.example.socialmediaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public List<User> getAllUserWithStatus(String status) {
        return userRepository.findAllByStatus(StatusEnum.valueOf(status));
    }
    public void saveUser(User user) {
        user.setPassword(encoder().encode(user.getPassword()));
        userRepository.save(user);
    }

}
