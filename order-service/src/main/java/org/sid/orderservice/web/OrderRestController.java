package org.sid.orderservice.web;

import lombok.AllArgsConstructor;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemsRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.sid.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderRestController {
    CustomerRestClientService customerRestClientService;
    InventoryRestClientService inventoryRestClientService;
    OrderRepository orderRepository;
    ProductItemsRepository productItemsRepository;
    OrderService orderService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order =orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItemsList().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
    @GetMapping("/orderByCustomerId/{customerId}")
    public List<Order> ordersByCustomerId(@PathVariable Long customerId){
        return orderService.ordersByCustomerId(customerId);
    }
}
