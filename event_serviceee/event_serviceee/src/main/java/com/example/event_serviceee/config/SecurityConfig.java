package com.example.event_serviceee.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // ✅ Active CORS (utilise le bean corsConfigurationSource ci-dessous)
                .cors(Customizer.withDefaults())

                // ✅ Disable CSRF (API stateless)
                .csrf(csrf -> csrf.disable())

                // ✅ Autorise tout (tu sécuriseras plus tard)
                .authorizeHttpRequests(auth -> auth
                        // important pour preflight
                        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Ton front Vite
        config.setAllowedOrigins(List.of("http://localhost:5173"));

        // ✅ Méthodes autorisées
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Headers autorisés
        config.setAllowedHeaders(List.of("*"));

        // ✅ Si tu envoies cookies / auth plus tard (sinon tu peux mettre false)
        config.setAllowCredentials(true);

        // Optionnel : exposer des headers
        config.setExposedHeaders(List.of("Location"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
