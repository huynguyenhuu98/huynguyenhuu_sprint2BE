package com.example.backendsp2.service;

import com.example.backendsp2.model.OrdersDetail;

import java.util.List;

public interface IOrdersDetailService {
    void save(OrdersDetail ordersDetail);
    List<OrdersDetail> findAllOrders (Long id);
    List<OrdersDetail> findAllOrdersDetail(Long id);
}
