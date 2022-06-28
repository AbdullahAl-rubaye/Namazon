package com.codedifferently.namazonshoping.orders;

import com.codedifferently.namazonshoping.Address;
import com.codedifferently.namazonshoping.product.Product;

public class Order {
    private static Long idCount = 1L;
    private Long id;
    private Product product;
    private Address destination;
    private OrderStatus status;


    public Order(Product product, Address destination, OrderStatus status){
        this.id=idCount++;
        this.product=product;
        this.destination=destination;
        this.status=status;

    }

    public static Long getIdCount() {
        return idCount;
    }

    public static void setIdCount(Long idCount) {
        Order.idCount = idCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public  String toString() {
        return String.format("%s %s %s %s ",id,product, destination,  status);
    }
}
