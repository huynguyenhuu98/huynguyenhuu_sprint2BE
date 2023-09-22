package com.example.backendsp2.service.impl;

import com.example.backendsp2.model.Carts;
import com.example.backendsp2.model.Customers;
import com.example.backendsp2.model.ProductRacing;
import com.example.backendsp2.repository.ICartsRepository;
import com.example.backendsp2.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsService implements ICartsService {
    @Autowired
    private ICartsRepository iCartsRepository;

    @Override
    public void add(Carts shoppingCart) {
        iCartsRepository.save(shoppingCart);
    }

    @Override
    public void remove(Long id) {
        iCartsRepository.deleteById(id);
    }

    @Override
    public Carts findById(Long id) {
        return iCartsRepository.findById(id).get();
    }

    @Override
    public List<Carts> findAll() {
        return iCartsRepository.findAll();
    }

    @Override
    public List<Carts> findAllByShopping(Long id) {
        return iCartsRepository.findAllCustomers(id);
    }

    @Override
    public Carts findByCustomersProduct(Customers customers, ProductRacing product) {
        return iCartsRepository.findByCustomersAndProductRacing(customers, product);
    }

//    @Override
//    public void setQuantityShoppingCart(Integer quantity, Long id) {
//        Carts carts = iCartsRepository.findById(id).get();
//        if (quantity == 0) {
//            carts.setQuantity(carts.getQuantity() - 1);
//            iCartsRepository.save(carts);
//        } else {
//            carts.setQuantity(carts.getQuantity() + 1);
//            iCartsRepository.save(carts);
//        }
//    }


    @Override
    public void deleteById(Customers customers) {
        iCartsRepository.deleteShoppingCartByCustomers(customers);
    }

    @Override
    public void delete(Carts carts) {
        iCartsRepository.delete(carts);
    }

    @Override
    public ResponseEntity<?> setQuantityShoppingCart(Integer setQuantity, Long id) {
        Carts carts = iCartsRepository.findById(id).get();
        if (setQuantity == 0) {
            carts.setQuantity(carts.getQuantity() - 1);
            iCartsRepository.save(carts);
        } else {
            if (carts.getQuantity()>= carts.getProductRacing().getQuantity()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("so luong khong du");
            } else {
                carts.setQuantity(carts.getQuantity() + 1);
                 iCartsRepository.save(carts);
                 return new ResponseEntity<>(carts,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
