package com.example.backendsp2.service.impl;

import com.example.backendsp2.model.Customers;
import com.example.backendsp2.repository.ICustomersRepository;
import com.example.backendsp2.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService implements ICustomersService {
    @Autowired
    private ICustomersRepository iCustomersRepository;


    @Override
    public Customers findUsersId(String username) {
        return iCustomersRepository.findUsersName(username);
    }

    @Override
    public Customers getUsersId(Long customer) {
        return iCustomersRepository.getUsersName(customer);
    }
}
