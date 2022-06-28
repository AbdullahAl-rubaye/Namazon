package com.codedifferently.namazonshoping.product;

public enum ProductCategory {
    ELECTRONICS("iphone charger"),ATHLETICS("boxing gloves"),CLOTHING("tie"),HOME_APPLIANCES("kitchen set");
    private String name;
    ProductCategory(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
