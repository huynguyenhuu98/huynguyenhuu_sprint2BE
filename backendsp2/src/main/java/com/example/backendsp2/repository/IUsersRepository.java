package com.example.backendsp2.repository;

import com.example.backendsp2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String user);
}