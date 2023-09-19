package com.example.backendsp2.service;

import com.example.backendsp2.model.Carts;
import com.example.backendsp2.model.Customers;
import com.example.backendsp2.model.ProductRacing;

import java.util.List;

public interface ICartsService {
    void add(Carts shoppingCart);

    void remove(Long id);
    Carts findById(Long id);

    List<Carts> findAll();
    List<Carts> findAllByShopping(Long id);

    Carts findByCustomersProduct(Customers customers, ProductRacing productRacing);

    void setQuantityShoppingCart(Integer quantity, Long id);

    void deleteById(Customers customers);
    void delete(Carts carts);
}

