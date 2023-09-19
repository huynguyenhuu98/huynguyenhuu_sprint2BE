package com.example.backendsp2.repository;

import com.example.backendsp2.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IOrdersRepository extends JpaRepository<Orders,Long> {
        @Query(value = "SELECT * FROM orders as o\n" +
                "LEFT JOIN customers c on c.id = o.id_customers\n" +
                "WHERE c.id=:idCustomer", nativeQuery = true)
        List<Orders> findAll(@Param("idCustomer") Long idCustomer);
    }

