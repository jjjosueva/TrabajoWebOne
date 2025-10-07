package com.example.mvccrudlogin.security;

import com.example.mvccrudlogin.model.User;
import com.example.mvccrudlogin.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) { this.userRepo = userRepo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(),
                List.of(new SimpleGrantedAuthority(u.getRole()))
        );
    }
}
