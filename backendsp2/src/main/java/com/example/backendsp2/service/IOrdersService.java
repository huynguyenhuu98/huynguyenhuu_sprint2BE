package com.example.backendsp2.service;

import com.example.backendsp2.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrdersService {
    Page<Orders> findAll(Pageable pageable, Long id);
    Page<Orders> findAllOrder(Pageable pageable);
    void  save(Orders orders);
}
