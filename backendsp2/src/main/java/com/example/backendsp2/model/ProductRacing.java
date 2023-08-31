package com.example.backendsp2.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProductRacing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_racing")
    private String nameRacing;
    private Long price;
    private String note;
    private Integer quantity;
    private String images;
    @CreationTimestamp
    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brands brands;

    public ProductRacing() {
    }

    public ProductRacing(Long id, String nameRacing, Long price, String note, Integer quantity, String images, LocalDateTime createDate, ProductType productType) {
        this.id = id;
        this.nameRacing = nameRacing;
        this.price = price;
        this.note = note;
        this.quantity = quantity;
        this.images = images;
        this.createDate = createDate;
        this.productType = productType;
    }

    public ProductRacing(Long id, String nameRacing, Long price, String note, Integer quantity, String images, LocalDateTime createDate, ProductType productType, Brands brands) {
        this.id = id;
        this.nameRacing = nameRacing;
        this.price = price;
        this.note = note;
        this.quantity = quantity;
        this.images = images;
        this.createDate = createDate;
        this.productType = productType;
        this.brands = brands;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRacing() {
        return nameRacing;
    }

    public void setNameRacing(String nameRacing) {
        this.nameRacing = nameRacing;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }
}
