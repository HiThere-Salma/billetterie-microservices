package com.example.user_service.services;

import com.example.user_service.entities.User;
import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}