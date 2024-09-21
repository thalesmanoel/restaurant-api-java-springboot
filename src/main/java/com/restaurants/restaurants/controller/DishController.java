package com.restaurants.restaurants.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurants.restaurants.entites.Dish;
import com.restaurants.restaurants.service.DishService;

@RestController
@RequestMapping(value="/dishes")
public class DishController {

	@Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> findAll() {
        List<Dish> restaurants = dishService.findAll();
        return ResponseEntity.ok(restaurants);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dish>> findDishById(@PathVariable Long id) {
        Optional<Dish> dish = dishService.findDishById(id);
        return ResponseEntity.ok().body(dish);
    }
    
    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish createdDish = dishService.createDish(dish);
        return ResponseEntity.ok(createdDish);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
