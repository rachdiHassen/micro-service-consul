package org.sid.orderservice.service;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> ordersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
