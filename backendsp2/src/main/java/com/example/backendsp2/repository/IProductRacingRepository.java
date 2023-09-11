package com.example.backendsp2.repository;

import com.example.backendsp2.model.ProductRacing;
import com.example.backendsp2.projection.IProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRacingRepository extends JpaRepository<ProductRacing,Long> {
//    @Query(value = "select * from product_racing p join image i on p.id = i.id_product_racing where name_racing like concat('%', :nameSearch, '%')", nativeQuery = true)
//    Page<ProductRacing> findProductRacing(Pageable pageable, @Param("nameSearch") String nameSearch);
    @Query(value = "SELECT p.id AS id, p.name_racing AS nameRacing , p.price AS price, i.image AS image \n" +
            " FROM product_racing AS p \n" +
            "        INNER JOIN image AS i on p.id = i.id_product_racing\n" +
            " WHERE p.name_racing LIKE concat('%',:nameSearch,'%') AND i.id IN (SELECT MIN(i.id) FROM image AS i GROUP BY i.id_product_racing)",
//            countQuery =
//                    " SELECT COUNT(*)" +
//                            "            FROM product_racing AS p" +
//                            "                    INNER JOIN image AS i on p.id = i.id_product_racing" +
//                            "            WHERE p.name_racing LIKE concat('%',:nameSearch,'%') AND i.id IN (SELECT MIN(i.id) FROM image AS i GROUP BY i.id_product_racing)",
            nativeQuery = true)
    Page<IProductProjection> findProductRacing(Pageable pageable, @Param("nameSearch") String nameSearch);
}
