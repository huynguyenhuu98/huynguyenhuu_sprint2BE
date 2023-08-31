package com.example.backendsp2.model;

import javax.persistence.*;

@Entity
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_brand")
    private String nameBrand;

    public Brands() {
    }

    public Brands(Long id, String nameBrand) {
        this.id = id;
        this.nameBrand = nameBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }
}
