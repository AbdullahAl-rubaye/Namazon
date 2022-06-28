package com.codedifferently.namazonshoping.accounts;

import com.codedifferently.namazonshoping.exceptions.ProductNotAvailableException;
import com.codedifferently.namazonshoping.orders.Order;
import com.codedifferently.namazonshoping.product.Product;
import com.codedifferently.namazonshoping.product.ProductCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendor extends Account{
    private String brandName;
    private Map<Product, Integer> inventory;
    private List<Order> Orders;
    private Product[] showcase;


    public Vendor(String firstName, String lastName, String email, String password,String brandName) {
        super(firstName, lastName, email, password);
        this.brandName=brandName;
        this.inventory=new HashMap<>();
        this.Orders=new ArrayList<>();
        this.showcase=new Product[5];
    }

    public String getBrandName() {
        return brandName;
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public Product[] getShowcase() {
        return showcase;
    }
    public void addProduct(Product product){
        String Product = product.toString();
        if(inventory.containsKey(product)){
            Integer currentCount = inventory.get(product) + 1;
            inventory.put(product, currentCount);
        }else {
            inventory.put(product, 1);
        }

    }
    public Boolean modifyProduct(Product product){
        return null;

    }
    public Boolean removeProduct(Product product){

        if(inventory.containsKey(product)){
            inventory.remove(product);
            return true;
        }
        return false;
    }
    public boolean cancelOrder(Order order){
        if(Orders.contains(order)){
            Orders.remove(order);
            return true;

        }
        return false;
    }
    public Product[] addProductToShowCase(){
        return showcase;
    }
    public Product purchase(){
        return null;
    }
    public List<Product> searchByCategory(ProductCategory category) throws ProductNotAvailableException {
        List<Product> searched = new ArrayList<>();
        for (Product c : inventory.keySet()) {
            ProductCategory looking = c.getCategory();
            if (looking.name().equals(category.name())) {
                searched.add(c);

            } else {
                throw new ProductNotAvailableException();
            }

        }
        return searched;
    }
    public Order displayAllOrders(Order order){
        return order;
    }
    @Override
    public String toString(){
        return super.toString();
    }



}
