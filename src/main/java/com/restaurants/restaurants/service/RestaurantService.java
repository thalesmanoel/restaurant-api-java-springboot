package com.restaurants.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.restaurants.entites.Restaurant;
import com.restaurants.restaurants.repositories.RestaurantRepository;
import com.restaurants.restaurants.service.exceptions.ResourceNotFoundException;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurantsById(Long id) {
    	Optional<Restaurant> obj = restaurantRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
