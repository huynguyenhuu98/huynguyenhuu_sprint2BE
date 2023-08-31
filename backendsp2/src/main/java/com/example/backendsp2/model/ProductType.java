package com.example.backendsp2.model;

import javax.persistence.*;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_type")
    private String nameType;

    public ProductType() {
    }

    public ProductType(Long id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
