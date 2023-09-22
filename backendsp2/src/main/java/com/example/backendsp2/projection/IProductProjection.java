package com.example.backendsp2.projection;

import com.example.backendsp2.model.ProductType;

public interface IProductProjection {
    String getId();

    String getNameRacing();

    String getPrice();

    String getImage();
    String getQuantity();
    String getProductType();
    String getCreateDate();
//    String getNameType();
//    Long getIdType();
}
