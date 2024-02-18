package org.sid.orderservice.model;

import lombok.Data;

@Data
public class Customer {
    private Long Id;
    private String name;
    private String email;
}
