package com.example.microserviceusermanagement.service;

import com.example.microserviceusermanagement.model.User;
import com.example.microserviceusermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements com.example.microserviceusermanagement.service.UserService {

    @Autowired
    private UserRepository userRepository;

    // We will create bean for iot
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user){
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<String> findUsers(List<Long> idList){
        return userRepository.findByIdList(idList);
    }
}
