package com.example.demoshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoshop.model.Product;
import com.example.demoshop.model.User;
import com.example.demoshop.service.ProductService;
import com.example.demoshop.service.UserService;

@Controller
public class DemoshopController {
	
	@Autowired
    UserService userService;
	@Autowired
    ProductService productService;
	
	@RequestMapping("/user")
	  public List<User> alluser() {
	    return userService.getAllUsers();
	 }
	
	@DeleteMapping("/user")
	  public String deluser(@RequestParam("user_id") Integer user_id) {
		String ret = userService.delUser(user_id);
		return ret;		
	}
	
	@RequestMapping("/product")
	  public List<Product> allproduct() {
	    return productService.getAllProducts();
	 }
	
	@RequestMapping("/buy")
	  public String buy(@RequestParam("user_id") Integer user_id, 
			  @RequestParam("product_id") Integer product_id) {
		String ret = userService.buyProduct(user_id, product_id);
	    return ret;
	 }
}
