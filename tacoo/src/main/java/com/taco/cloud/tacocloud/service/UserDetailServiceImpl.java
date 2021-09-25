package com.taco.cloud.tacocloud.service;

import com.taco.cloud.tacocloud.domain.User;
import com.taco.cloud.tacocloud.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=  userRepository.findUserByUsername(username);
        if(null == user)
            throw new UsernameNotFoundException("Sorry but we don't have a user with that name !");
        return user;
    }
}
