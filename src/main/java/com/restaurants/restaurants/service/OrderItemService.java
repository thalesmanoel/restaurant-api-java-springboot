package com.restaurants.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.restaurants.entites.OrderItem;
import com.restaurants.restaurants.repositories.OrderItemRepository;
import com.restaurants.restaurants.service.exceptions.ResourceNotFoundException;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll(){
		return orderItemRepository.findAll();
	}
	
	public OrderItem findOrderByUserId(Long id) {
		Optional<OrderItem> obj = orderItemRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem );
    }
	
	public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
	
	public OrderItem updateOrderItem(Long id, OrderItem orderItemUpdated) {
        Optional<OrderItem> orderItemOpt = orderItemRepository.findById(id);
        
        
        if (orderItemOpt.isPresent()) {
            OrderItem orderItem = orderItemOpt.get();
            
            orderItem.setQuantity(orderItemUpdated.getQuantity());
            orderItem.setPrice(orderItemUpdated.getPrice());
            orderItem.setDish(orderItemUpdated.getDish());
            
            return orderItemRepository.save(orderItem);
        }
        else 
        {
        	throw new ResourceNotFoundException(id);
        }
    }
}
