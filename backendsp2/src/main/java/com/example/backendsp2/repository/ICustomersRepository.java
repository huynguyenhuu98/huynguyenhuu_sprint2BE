package com.example.backendsp2.repository;

import com.example.backendsp2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomersRepository extends JpaRepository<Customers,Long> {
    @Query(value = "SELECT * from customers as c\n" +
            "        INNER JOIN users u on u.id = c.users_id\n" +
            "         WHERE u.user_name=:name", nativeQuery = true)
    Customers findUsersName(@Param("name")String name);
    @Query(value = "SELECT * from customers as c\n" +
            "        INNER JOIN users u on u.id = c.users_id\n" +
            "         WHERE u.id=:name", nativeQuery = true)
    Customers getUsersName(@Param("name")Long name);

}
