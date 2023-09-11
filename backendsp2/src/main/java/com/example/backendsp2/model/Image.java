package com.example.backendsp2.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image" )
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_product_racing")
    private ProductRacing productRacing;

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductRacing getProductRacing() {
        return productRacing;
    }

    public void setProductRacing(ProductRacing productRacing) {
        this.productRacing = productRacing;
    }
}
