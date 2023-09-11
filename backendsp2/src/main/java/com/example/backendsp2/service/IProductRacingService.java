package com.example.backendsp2.service;

import com.example.backendsp2.dto.ProductRacingDTO;
import com.example.backendsp2.model.ProductRacing;
import com.example.backendsp2.projection.IProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductRacingService {
    Page<IProductProjection> getProductRacing(Pageable pageable, String nameSearch);
    ProductRacing findById(Long id);
    Optional<ProductRacing> findByIdProduct(Long id);

}
