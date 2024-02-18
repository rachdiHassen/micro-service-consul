package org.sid.orderservice.service;


import org.sid.orderservice.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> ordersByCustomerId (Long customerId);
}
