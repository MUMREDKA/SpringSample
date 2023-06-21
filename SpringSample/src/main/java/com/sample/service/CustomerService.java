package com.sample.service;


import java.util.List;
import com.sample.entity.Customer;

public interface CustomerService {

	public List <Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}

