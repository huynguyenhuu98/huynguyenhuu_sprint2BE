package com.example.backendsp2.service.impl;

import com.example.backendsp2.model.OrdersDetail;
import com.example.backendsp2.repository.IOrdersDetailRepository;
import com.example.backendsp2.service.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailService implements IOrdersDetailService {
    @Autowired
    private IOrdersDetailRepository iOrdersDetailRepository;

    @Override
    public void save(OrdersDetail ordersDetail) {
        iOrdersDetailRepository.save(ordersDetail);
    }

    @Override
    public List<OrdersDetail>  findAllOrders(Long id) {
        return iOrdersDetailRepository.findAllOrders(id);
    }

    @Override
    public List<OrdersDetail> findAllOrdersDetail(Long id) {
        return iOrdersDetailRepository.findAllOrdersDetail(id);
    }
}
