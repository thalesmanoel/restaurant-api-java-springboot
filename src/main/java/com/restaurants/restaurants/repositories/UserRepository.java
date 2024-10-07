package com.restaurants.restaurants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurants.restaurants.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
