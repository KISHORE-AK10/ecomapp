package com.cg.ecomapp.service;

import java.util.List;

import com.cg.ecomapp.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO saveCustomer(CustomerDTO custDto);
	
	CustomerDTO getCustomerById(int custId);
	
	List<CustomerDTO> getAllCustomer();
	
	CustomerDTO updateCustomer(CustomerDTO custDto);
	
	void deleteCustomer(int custId);
}
