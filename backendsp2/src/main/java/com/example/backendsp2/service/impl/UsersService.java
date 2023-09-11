package com.example.backendsp2.service.impl;

import com.example.backendsp2.config.JwtUserDetails;
import com.example.backendsp2.model.Users;
import com.example.backendsp2.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Users users = iUsersRepository.findByUserName(user);
        if (users == null) {
            throw new UsernameNotFoundException("User not found with username: " + user);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = users.getRoles().getRoleName();
        authorities.add(new SimpleGrantedAuthority(role));
        return new JwtUserDetails(users.getId(), users.getUserName(), users.getPass(), authorities);
    }


}
