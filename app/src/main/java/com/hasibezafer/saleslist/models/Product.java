package com.hasibezafer.saleslist.models;

/**
 * Created by hasibezafer on 28.12.2017.
 */

public class Product {

    private String productImage;
    private String productName;
    private String productPrice;


    public Product() {
    }

    public Product(String productImage, String productName, String productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }


}
