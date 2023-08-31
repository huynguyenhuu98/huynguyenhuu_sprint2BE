package com.example.backendsp2.model;

import javax.persistence.*;

@Entity
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "id_customers")
    private Customers customers;
    @ManyToOne
    @JoinColumn(name = "id_product_racing")
    private ProductRacing productRacing;

    public Carts() {
    }

    public Carts(Long id, Integer quantity, Customers customers, ProductRacing productRacing) {
        this.id = id;
        this.quantity = quantity;
        this.customers = customers;
        this.productRacing = productRacing;
    }

    public Carts(Integer quantity, Customers customers, ProductRacing productRacing) {
        this.quantity = quantity;
        this.customers = customers;
        this.productRacing = productRacing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public ProductRacing getProductRacing() {
        return productRacing;
    }

    public void setProductRacing(ProductRacing productRacing) {
        this.productRacing = productRacing;
    }
}
