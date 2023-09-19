package com.example.backendsp2.service;

import com.example.backendsp2.model.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(Long id);
    void  save(Orders orders);
}
