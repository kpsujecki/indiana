package com.indiana.services;


import com.indiana.models.User;
import com.indiana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User getUser(Long id){
        User user = userRepository.findById(id)
                 .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));

        return user;
    }
}
