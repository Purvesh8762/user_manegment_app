package com.usermanagement.app.service;

import com.usermanagement.app.dto.UserRequestDTO;
import com.usermanagement.app.entity.User;
import com.usermanagement.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1️⃣ ADD USER
    public User addUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    // 2️⃣ GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 3️⃣ UPDATE USER
    public User updateUser(Long id, UserRequestDTO dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());

        return userRepository.save(existingUser);
    }

    // 4️⃣ DELETE USER
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
