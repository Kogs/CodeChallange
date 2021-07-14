package de.kogs.codechallange.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kogs.codechallange.data.User;
import de.kogs.codechallange.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

}
