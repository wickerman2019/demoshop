package com.example.demoshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoshop.model.Product;
import com.example.demoshop.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }
	
	public String buyProduct(Integer user_id, Integer product_id) {
		Optional<User> user = userRepository.findById(user_id);
		if (user != null) {
			Optional<Product> product = productRepository.findById(product_id);
			if(product != null) {
				float money = user.get().getMoney();
				float price = product.get().getPrice();
				if (money >= price) {
					user.get().setMoney(money - price);
					userRepository.save(user.get());
					return "OK";
				}
				else return "NOT ENOUGH MONEY";
			} else return "PRODUCT NOT FOUND";
		} else return "USER NOT FOUND";
	}
}
