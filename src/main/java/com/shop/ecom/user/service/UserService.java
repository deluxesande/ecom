package com.shop.ecom.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.ecom.user.model.User;
import com.shop.ecom.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        // user.name must be unique
        Optional<User> userOptional = userRepository.findUserByName(user.getName());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, User user) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));

        if (user.getName() != null && user.getName().length() > 0 && !user.getName().equals(userToUpdate.getName())) {
            userToUpdate.setName(user.getName());
        }
        if (user.getEmail() != null && user.getEmail().length() > 0
                && !user.getEmail().equals(userToUpdate.getEmail())) {
            userToUpdate.setEmail(user.getEmail());
        }
        if (user.getPassword() != null && user.getPassword().length() > 0
                && !user.getPassword().equals(userToUpdate.getPassword())) {
            userToUpdate.setPassword(user.getPassword());
        }
        if (user.getRole() != null && !user.getRole().equals(userToUpdate.getRole())) {
            userToUpdate.setRole(user.getRole());
        }
    }
}
