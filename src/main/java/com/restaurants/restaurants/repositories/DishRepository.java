package com.restaurants.restaurants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurants.restaurants.entites.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{
	
}