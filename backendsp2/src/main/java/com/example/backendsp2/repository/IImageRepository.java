package com.example.backendsp2.repository;

import com.example.backendsp2.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "select * from image i \n" +
//            "inner join product_racing p on i.id_product_racing = p.id\n" +
            "where i.id_product_racing = :id", nativeQuery = true)
    List<Image> getAllByProductId(@Param("id") Long id);
}
