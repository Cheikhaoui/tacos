package com.taco.cloud.tacocloud;

import com.taco.cloud.tacocloud.controllers.RegistrationForm;
import com.taco.cloud.tacocloud.domain.User;
import com.taco.cloud.tacocloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                RegistrationForm registrationForm = new RegistrationForm();
                User user = new User("hicham","123","","","","","","");
                registrationForm.setUsername(user.getUsername());
                registrationForm.setPassword(user.getPassword());
                userRepository.save(registrationForm.toUser(passwordEncoder));
            }
        };
    }
}
