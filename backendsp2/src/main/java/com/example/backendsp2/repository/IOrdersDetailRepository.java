package com.example.backendsp2.repository;

import com.example.backendsp2.model.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Long> {
    @Query(value = "SELECT * FROM  orders_detail as od\n" +
            "     join orders o on o.id = od.id_orders\n" +
            "            WHERE o.id=:id\n", nativeQuery = true)
    List<OrdersDetail> findAllOrders(@Param("id") Long id);

    @Query(value = "SELECT * FROM  orders_detail as od\n" +
            "    left join orders o on o.id = od.id_orders\n" +
            "    left join customers c on c.id = o.id_customers\n" +
            "            WHERE o.id=:id\n", nativeQuery = true)
    List<OrdersDetail> findAllOrdersDetail(@Param("id") Long id);
}

