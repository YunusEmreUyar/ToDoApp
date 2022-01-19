package com.yeuyar.todo.service;

import com.yeuyar.todo.model.User;
import com.yeuyar.todo.repository.UserRepository;
import com.yeuyar.todo.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(long id) {
        User user = userRepository.getById(id);
        return JwtUserDetails.create(user);
    }

}
