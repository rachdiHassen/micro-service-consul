package org.sid.orderservice;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.ProductItems;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemsRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository,
							ProductItemsRepository productItemsRepository,
							CustomerRestClientService customerRestClientService,
							InventoryRestClientService inventoryRestClientService){
		return args -> {
			List<Customer> customers =customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts();
			Random random=new Random();
			for (int i = 0; i <10 ; i++) {
				Order order=Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.createdAt(new Date())
						.status(Math.random()>0.5? OrderStatus.CREATED:OrderStatus.PENDING)
						.build();
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < products.size(); j++) {
					if (Math.random()>0.6){
						ProductItems productItems=ProductItems.builder()
								.productId(products.get(j).getId())
								.order(savedOrder)
								.quantity(new Random().nextInt(1+ products.get(j).getQuantity()))
								.price(products.get(j).getPrice())
								.discount(Math.random())
								.build();
						productItemsRepository.save(productItems);
					}

				}
			}

		};
	}
}
