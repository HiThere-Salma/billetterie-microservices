package com.example.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())   // ✅ active CORS
                .csrf(csrf -> csrf.disable())      // ✅ disable csrf pour REST
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // ✅ pour tester
                )
                .build();
    }
}
