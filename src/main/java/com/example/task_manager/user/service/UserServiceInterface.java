package com.example.task_manager.user.service;

import com.example.task_manager.user.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {
    User createUser(User user);
    Optional<User> getUserById(UUID id);
    List<User> getUsers();
    User updateUser(UUID id, User user);
    void deleteUser(UUID id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
}
