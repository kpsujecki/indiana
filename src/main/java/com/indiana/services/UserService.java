package com.indiana.services;

import com.indiana.models.User;
import com.indiana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public User getUser(Long id){
        User user = userRepository.findById(id)
                 .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));

        return user;
    }

    public boolean changePassword(Long id, String oldPassword, String password){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
            if(encoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(encoder.encode(password));
                return true;
            }else {
                return false;
            }
    }

    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    }

