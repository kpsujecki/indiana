package pl.sujecki.indiana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sujecki.indiana.model.User;
import pl.sujecki.indiana.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

}
