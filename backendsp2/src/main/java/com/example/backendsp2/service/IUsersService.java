package com.example.backendsp2.service;

import com.example.backendsp2.model.Users;

public interface IUsersService {
    Users findByUserName(String username);
}
