package com.taco.cloud.tacocloud.controllers;

import com.taco.cloud.tacocloud.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String register(){
        return "registration";
    }

    @PostMapping
    public String register(RegistrationForm registrationForm){
    userRepository.save(registrationForm.toUser(passwordEncoder));
    return "redirect:/login";
    }
}
