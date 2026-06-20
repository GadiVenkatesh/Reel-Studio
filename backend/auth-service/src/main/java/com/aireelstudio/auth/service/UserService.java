package com.aireelstudio.auth.service;

import com.aireelstudio.auth.dto.RegisterRequest;
import com.aireelstudio.auth.entity.Role;
import com.aireelstudio.auth.entity.User;
import com.aireelstudio.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
 private final UserRepository userRepository;
 private final PasswordEncoder passwordEncoder;
 public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){this.userRepository=userRepository;this.passwordEncoder=passwordEncoder;}
 public User register(RegisterRequest request){
  if(userRepository.findByEmail(request.getEmail()).isPresent()) throw new RuntimeException("Email already exists");
  User user=User.builder().name(request.getName()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).createdAt(LocalDateTime.now()).build();
  return userRepository.save(user);
 }
 public Optional<User> findByEmail(String email){ return userRepository.findByEmail(email);} 
}