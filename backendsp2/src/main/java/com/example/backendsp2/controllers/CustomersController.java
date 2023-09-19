package com.example.backendsp2.controllers;
import com.example.backendsp2.config.JwtTokenUtil;
import com.example.backendsp2.model.Customers;
import com.example.backendsp2.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomersController {
    @Autowired
    private ICustomersService iCustomersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_ADMIN')")
    public ResponseEntity<?> findAllCustomer(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        String token = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Customers customers = iCustomersService.findUsersId(username);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
