package com.codedifferently.namazonshoping.orders;

public enum OrderStatus {
    PENDING("order is pending"),SHIPPED("order got shipped"),DELIVERED("order delivered");
    private String name;
    OrderStatus(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }



}
