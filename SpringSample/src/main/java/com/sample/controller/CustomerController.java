package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sample.entity.Customer;
import com.sample.service.CustomerService;
	
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * 
	 * To save, delete,update, get operation on cutsomer 
	 * 
	 * Post--localhost:8080/costco/saveCustomer/
	 * customer
	 * {
	 * fn:ajay
	 * ln:abc
	 * email:
	 * }
	 * get -localhost:8080/costco/getCustomer/1
	 * Delete--localhost:8080/costco/deleteCustomer/1
	 * 
	 * customer
	 * fn:ajay
	 * ln:abc
	 * email:
	 * 
	 * HTTP verbs 
	 * Get--get data
	 * POST--save data
	 * PUT-- update the existing record 
	 *DELETE--remove 
	 *
	 *
	 */
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/helloworld")
	public String handler(Model model) {
		return "helloworld";
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List <Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	
	
	
	
	

}
