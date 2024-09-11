package com.restaurants.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurants.restaurants.entites.OrderItem;
import com.restaurants.restaurants.service.OrderItemService;

@RestController
@RequestMapping(value="/orderitems")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> list = orderItemService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id){
		OrderItem obj = orderItemService.findOrderByUserId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
