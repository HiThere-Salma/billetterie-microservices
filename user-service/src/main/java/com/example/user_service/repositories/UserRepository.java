package com.example.user_service.repositories;

import com.example.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this interface as a Spring Data repository
public interface UserRepository extends JpaRepository<User, Long> {

    // You can define custom queries here if needed
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
