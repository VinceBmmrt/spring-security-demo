package com.telusko.spring_sec_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()  // toute requête nécessite auth
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll                   // autorise accès à la page login par défaut
                )
                .csrf(AbstractHttpConfigurer::disable);     // désactive CSRF (optionnel pour API REST)
        return http.build();
    }
}
