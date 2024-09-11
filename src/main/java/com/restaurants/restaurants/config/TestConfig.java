package com.restaurants.restaurants.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.restaurants.restaurants.entites.Delivery;
import com.restaurants.restaurants.entites.Dish;
import com.restaurants.restaurants.entites.Order;
import com.restaurants.restaurants.entites.OrderItem;
import com.restaurants.restaurants.entites.Restaurant;
import com.restaurants.restaurants.entites.User;
import com.restaurants.restaurants.enums.OrderStatus;
import com.restaurants.restaurants.enums.Role;
import com.restaurants.restaurants.repositories.DeliveryRepository;
import com.restaurants.restaurants.repositories.DishRepository;
import com.restaurants.restaurants.repositories.OrderItemRepository;
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
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private DishRepository dishRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	private LocalDateTime date = LocalDateTime.parse("2024-09-05T14:30:00");
	private OrderStatus status = OrderStatus.WAITING_PAYMENT;
	private Role role = Role.COSTUMER;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Thales", "Rua xxxx", "thales@gmail.com", "senha123", role);
		User u2 = new User(null, "Carrion", "Rua yyyy", "carrion@gmail.com", "senha321", role);	
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Restaurant r1 = new Restaurant(null, "XXXX", "Rua Valdemiro", "159952561");
		restaurantRepository.saveAll(Arrays.asList(r1));
		
		Dish dish = new Dish(1L, "Arroz com ovo", "XXXX", 25.0);
		dishRepository.saveAll(Arrays.asList(dish));
		
		
		
		Order o1 = new Order(null, date, status, 22.0, r1, null, u2, null);
		Order o2 = new Order(null, date, status, 25.0, r1, null, u2, null);
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		Delivery delivery = new Delivery(null, "45min", "Rua XXXYYY", o1);
		o1.setDelivery(delivery);
		deliveryRepository.save(delivery);
		
		OrderItem oi1 = new OrderItem(null, 2, 5.0, dish);
		OrderItem oi2 = new OrderItem(null, 4, 3.0, dish);
		
		oi1.setOrder(o1);
		oi2.setOrder(o1);

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

		o1.setOrderItem(Arrays.asList(oi1));
		o2.setOrderItem(Arrays.asList(oi2));

		orderRepository.saveAll(Arrays.asList(o1, o2));
		
	}
}
