package com.restaurants.restaurants.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.restaurants.restaurants.entites.User;
import com.restaurants.restaurants.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u = new User(1L, "Thales", "Rua xxxx", "thales@gmail.com", "senha123");				userRepository.saveAll(Arrays.asList(u));
	}
}
