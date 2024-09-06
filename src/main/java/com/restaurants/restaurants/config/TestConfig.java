package com.restaurants.restaurants.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.restaurants.restaurants.entites.User;
import com.restaurants.restaurants.repositories.OrderRepository;
import com.restaurants.restaurants.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1L, "Thales", "Rua xxxx", "thales@gmail.com", "senha123");
		User u2 = new User(2L, "Carrion", "Rua yyyy", "carrion@gmail.com", "senha321");			userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
