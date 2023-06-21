package com.sample.repository;

import java.util.List;

import com.sample.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

	public List<Customer> getCustomers();
}
