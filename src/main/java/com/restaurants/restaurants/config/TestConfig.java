package com.restaurants.restaurants.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.restaurants.restaurants.entites.Order;
import com.restaurants.restaurants.entites.OrderItem;
import com.restaurants.restaurants.entites.Restaurant;
import com.restaurants.restaurants.entites.User;
import com.restaurants.restaurants.enums.OrderStatus;
import com.restaurants.restaurants.repositories.OrderRepository;
import com.restaurants.restaurants.repositories.RestaurantRepository;
import com.restaurants.restaurants.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	private LocalDateTime date = LocalDateTime.parse("2024-09-05T14:30:00");
	private OrderStatus status = OrderStatus.WAITING_PAYMENT;
	private List<OrderItem> orderItem;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1L, "Thales", "Rua xxxx", "thales@gmail.com", "senha123");
		User u2 = new User(2L, "Carrion", "Rua yyyy", "carrion@gmail.com", "senha321");	
		
		Restaurant r1 = new Restaurant(1L, "XXXX", "Rua Valdemiro", "159952561");
		
		orderItem = new OrderItem(1L, 2, 5.0, null, null)
		
		Order o1 = new Order(1L, date, status , 20.0, r1, u1);
		Order o1 = new Order(2L, date, status, 200.0, r1, null, null, u2);

				userRepository.saveAll(Arrays.asList(u1, u2));
		restaurantRepository.saveAll(Arrays.asList(r1));
		orderRepository.saveAll(Arrays.asList(o1));
		
	}
}
