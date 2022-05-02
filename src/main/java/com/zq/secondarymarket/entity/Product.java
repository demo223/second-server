package com.zq.secondarymarket.entity;

import lombok.Data;

@Data
public class Product {
    private Integer productId;
    private String productName;
    private Integer categoryId;
    private String productTitle;
    private String productIntro;
    private String productPicture;
    private double productPrice;
    private double productSellingPrice;
    private Integer productNum;
    private Integer productSales;
    private String concatUserId;
}
