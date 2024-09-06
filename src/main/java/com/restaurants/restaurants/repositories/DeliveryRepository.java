package com.restaurants.restaurants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurants.restaurants.entites.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{
	
}