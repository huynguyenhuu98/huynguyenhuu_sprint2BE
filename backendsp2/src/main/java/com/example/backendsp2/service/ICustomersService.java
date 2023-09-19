package com.example.backendsp2.service;

import com.example.backendsp2.model.Customers;

public interface ICustomersService {
    Customers findUsersId(String username);
    Customers getUsersId(Long customer);

}
