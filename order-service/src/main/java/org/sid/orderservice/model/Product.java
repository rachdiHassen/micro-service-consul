package org.sid.orderservice.model;

import lombok.Data;

@Data
public class Product {
    private Long Id;
    private String name;
    private double price;
    private int quantity;
}
