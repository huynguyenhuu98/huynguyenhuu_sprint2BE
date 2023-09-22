package com.example.backendsp2.service.impl;

import com.example.backendsp2.model.Orders;
import com.example.backendsp2.repository.IOrdersRepository;
import com.example.backendsp2.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {
    @Autowired
    private IOrdersRepository iOrdersRepository;

    @Override
    public void save(Orders orders) {
        iOrdersRepository.save(orders);
    }
    @Override
    public Page<Orders> findAll(Pageable pageable,Long id) {
        return iOrdersRepository.findAll(pageable, id);
    }

    @Override
    public Page<Orders> findAllOrder(Pageable pageable) {
        return iOrdersRepository.findAllOrder(pageable);
    }
}
