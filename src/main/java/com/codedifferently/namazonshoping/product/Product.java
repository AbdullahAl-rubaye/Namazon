package com.codedifferently.namazonshoping.product;

import com.codedifferently.namazonshoping.orders.OrderStatus;

public class Product {
    private static Long idCount = 1L;
    private Long id;
    private String name;
    private Double price;
    private ProductCategory category;



    public Product(Long id, String name, Double price, ProductCategory category){
        this.id = idCount++;
        this.name=name;
        this.price=price;
        this.category=category;
    }

    public static Long getIdCount() {
        return idCount;
    }

    public static void setIdCount(Long idCount) {
        Product.idCount = idCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}

