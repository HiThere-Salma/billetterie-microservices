package com.example.user_service.controllers;

import com.example.user_service.entities.User;
import com.example.user_service.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            return ResponseEntity.badRequest().body("Email obligatoire");
        }
        if (user.getNom() == null || user.getNom().isBlank()) {
            return ResponseEntity.badRequest().body("Nom obligatoire");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("Mot de passe obligatoire");
        }
        if (user.getRole() == null) user.setRole(User.Role.CLIENT);

        boolean exists = userRepository.existsByEmail(user.getEmail());
        if (exists) {
            return ResponseEntity.status(409).body("Email déjà utilisé");
        }

        User saved = userRepository.save(user);
        return ResponseEntity.ok(saved);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
