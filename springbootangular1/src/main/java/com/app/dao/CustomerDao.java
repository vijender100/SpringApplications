package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface CustomerDao{
	
	public List<Customer> getAllCustomers() ;
	public Customer saveCustomer(Customer customer);
	public void deleteCustomer(int id) ;
	public void updateCustomer(Customer customer) ;
}