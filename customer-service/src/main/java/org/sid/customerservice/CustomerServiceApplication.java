package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (CustomerRepository customerRepository){
		return args -> {
			List.of("hassen","habiba","samira").forEach(name->{
				Customer customer=Customer.builder()
						.name(name)
						.email(name + "@gmal.com")
						.build();
				customerRepository.save(customer);
			});

		};
	}
}
