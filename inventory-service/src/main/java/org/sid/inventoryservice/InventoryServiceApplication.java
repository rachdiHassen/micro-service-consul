package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
//pas besoin de le faire, ca se fait automatiquement
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (ProductsRepository productsRepository){
		Random random=new Random();
		return args -> {
			for (int i = 1; i <10 ; i++) {
				productsRepository.saveAll(List.of(
						Product.builder()
								.name("computer" + i)
								.price(1200+Math.random()*10000)
								.quantity(random.nextInt(20))
								.build()
				));

			}
		};
	}
}
