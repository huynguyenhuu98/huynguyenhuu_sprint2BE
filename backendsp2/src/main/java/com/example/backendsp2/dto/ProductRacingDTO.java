package com.example.backendsp2.dto;

import com.example.backendsp2.model.Brands;
import com.example.backendsp2.model.Image;
import com.example.backendsp2.model.ProductType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ProductRacingDTO {
    private Long id;
    @NotBlank
    private String nameRacing;
    @NotBlank
    private Long price;
    @NotBlank
    private String note;
    @NotBlank
    private Integer quantity;
    private LocalDateTime createDate;
    @NotBlank
    private ProductType productType;
    @NotBlank
    private Brands brands;
    @NotBlank
    private Image image;

    public ProductRacingDTO() {
    }

    public ProductRacingDTO(Long id, String nameRacing, Long price, String note, Integer quantity, LocalDateTime createDate, ProductType productType, Brands brands, Image image) {
        this.id = id;
        this.nameRacing = nameRacing;
        this.price = price;
        this.note = note;
        this.quantity = quantity;
        this.createDate = createDate;
        this.productType = productType;
        this.brands = brands;
        this.image = image;
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

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
