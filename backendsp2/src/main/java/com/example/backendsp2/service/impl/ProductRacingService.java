package com.example.backendsp2.service.impl;


import com.example.backendsp2.model.ProductRacing;
import com.example.backendsp2.projection.IProductProjection;
import com.example.backendsp2.repository.IProductRacingRepository;
import com.example.backendsp2.service.IProductRacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRacingService implements IProductRacingService {
    @Autowired
    private IProductRacingRepository iProductRacingRepository;

    @Override
    public Page<IProductProjection> getProductRacing(Pageable pageable, String nameSearch) {
        return  iProductRacingRepository.findProductRacing(pageable, nameSearch);


    }

    @Override
    public Page<IProductProjection> getProduct(Pageable pageable, String nameSearch, String productType) {
        return iProductRacingRepository.findProduct(pageable,nameSearch,productType);
    }

    @Override
    public ProductRacing findById(Long id) {
        return iProductRacingRepository.findById(id).get();
    }

    @Override
    public List<IProductProjection> findProductByType(Long id) {
        return iProductRacingRepository.findProductByType(id);
    }

    @Override
    public Optional<ProductRacing> findByIdProduct(Long id) {
        return iProductRacingRepository.findById(id);
    }

    @Override
    public void saveProduct(ProductRacing productRacing) {
        iProductRacingRepository.save(productRacing);
    }
}
