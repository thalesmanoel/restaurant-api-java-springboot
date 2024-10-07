package com.restaurants.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.restaurants.entites.Dish;
import com.restaurants.restaurants.repositories.DishRepository;
import com.restaurants.restaurants.service.exceptions.ResourceNotFoundException;

@Service
public class DishService {

	@Autowired
	private DishRepository dishRepository;
	
	public List<Dish> findAll(){
		return dishRepository.findAll();
	}
	
	public Dish findDishById(Long id) {
		Optional<Dish> obj = dishRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Dish createDish(Dish dish) {
        return dishRepository.save(dish );
    }
	
	public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
