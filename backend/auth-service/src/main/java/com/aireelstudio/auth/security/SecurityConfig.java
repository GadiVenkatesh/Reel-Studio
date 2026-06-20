package com.aireelstudio.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
 private final JwtAuthenticationFilter jwtAuthenticationFilter;
 @Bean public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
 @Bean public AuthenticationManager authenticationManager(AuthenticationConfiguration c) throws Exception { return c.getAuthenticationManager(); }
 @Bean public SecurityFilterChain securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
  http.csrf(csrf->csrf.disable()).sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(auth->auth.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated());
  return http.build();
 }
}