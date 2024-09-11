package com.restaurants.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.restaurants.entites.OrderItem;
import com.restaurants.restaurants.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll(){
		return orderItemRepository.findAll();
	}
	
	public OrderItem findOrderByUserId(Long id) {
		Optional<OrderItem> obj = orderItemRepository.findById(id);
		return obj.get();
	}
}
