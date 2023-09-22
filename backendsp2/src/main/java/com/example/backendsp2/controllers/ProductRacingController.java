package com.example.backendsp2.controllers;

import com.example.backendsp2.dto.ProductRacingDTO;
import com.example.backendsp2.model.ProductRacing;
import com.example.backendsp2.projection.IProductProjection;
import com.example.backendsp2.service.IProductRacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductRacingController {
    @Autowired
    private IProductRacingService iProductRacingService;

    @GetMapping("")
    public ResponseEntity<Page<IProductProjection>> getProductRacing(@PageableDefault(sort = "name_racing", direction = Sort.Direction.DESC, size = 44) Pageable pageable,
                                                                     @RequestParam(required = false, defaultValue = "") String nameSearch) {
        Page<IProductProjection> productRacingPage = iProductRacingService.getProductRacing(pageable, nameSearch);
        if (productRacingPage.isEmpty() && productRacingPage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productRacingPage, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<IProductProjection>> getProductRacing(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(required = false, defaultValue = "") String nameSearch,
                                                                     @RequestParam(value = "productType", defaultValue = "") String productType,
                                                                     @RequestParam(value = "orderBy", defaultValue = "0") String orderBy) {
        Sort sort = checkOrderBy(orderBy);
        Pageable pageable = PageRequest.of(page, 44, sort);
//        Page<IProductProjection> productRacingPage = iProductRacingService.getProduct(pageable, nameSearch,productType);
//        if (productRacingPage.isEmpty() && productRacingPage == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(productRacingPage, HttpStatus.OK);
        try {
            return new ResponseEntity<>(iProductRacingService.getProduct(pageable, nameSearch, productType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public Sort checkOrderBy(String orderBy) {
        Sort sort;
        switch (orderBy) {
            case "new":
                sort = Sort.by("id").descending();
                break;
            case "a-z":
                sort = Sort.by("nameRacing").ascending();
                break;
            case "z-a":
                sort = Sort.by("nameRacing").descending();
                break;
            case "priceAscending":
                sort = Sort.by("price").ascending();
                break;
            case "priceDescending":
                sort = Sort.by("price").descending();
                break;
            default:
                sort = Sort.by("id").ascending();
                break;
        }
        return sort;
    }

    @GetMapping("detailProduct/{id}")
    public ResponseEntity<ProductRacing> detailPosts(@PathVariable Long id) {
        Optional<ProductRacing> productRacing = iProductRacingService.findByIdProduct(id);
        if (!productRacing.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productRacing.get(), HttpStatus.OK);
    }

    @GetMapping("typeProduct/{id}")
    public ResponseEntity<List<IProductProjection>> getProductByType(@PathVariable Long id) {
        List<IProductProjection> productRacings = iProductRacingService.findProductByType(id);
//        if (!productRacings.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(productRacings, HttpStatus.OK);
    }
}
