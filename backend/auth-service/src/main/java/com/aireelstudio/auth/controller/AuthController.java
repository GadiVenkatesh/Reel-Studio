package com.aireelstudio.auth.controller;

import com.aireelstudio.auth.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

 @GetMapping("/health")
 public String health(){ return "Auth Service Running"; }

 @PostMapping("/register")
 public AuthResponse register(@RequestBody RegisterRequest request){
   return AuthResponse.builder().email(request.getEmail()).message("Registration Successful").build();
 }

 @PostMapping("/login")
 public AuthResponse login(@RequestBody LoginRequest request){
   return AuthResponse.builder().email(request.getEmail()).message("Login Successful").build();
 }
}
