package com.cg.ecomapp.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.ecomapp.dto.CustomerDTO;
import com.cg.ecomapp.entity.Customer;

public class CustomerMapper {
	
	//convert Customer entity to dto
	public static CustomerDTO entityToDto(Customer customer) {
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCustId(customer.getCustId());
		customerDto.setName(customer.getName());
		customerDto.setAge(customer.getAge());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobile(customer.getMobile());
		
		return customerDto;
	}
	
	//convert Customer dto to entity
	public static Customer dtoToEntity(CustomerDTO customerDto) {
		Customer customer = new Customer();
		customer.setCustId(customerDto.getCustId());
		customer.setName(customerDto.getName());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		customer.setMobile(customerDto.getMobile());
		
		return customer;
	}
	
	//convert Customer entity list to dto list
	public static List<CustomerDTO> entityListToDtoList(List<Customer> customerList){
		List<CustomerDTO> customerDtoList = new ArrayList<>();
		for(Customer customer : customerList) {
			CustomerDTO customerDto = entityToDto(customer);
			customerDtoList.add(customerDto);
		}
		
		return customerDtoList;
	}
	
	//convert Customer dto list to entity list
	public static List<Customer> dtoListToEntityList(List<CustomerDTO> customerDtoList){
		List<Customer> customerList = new ArrayList<>();
		for(CustomerDTO customerDto : customerDtoList) {
			Customer customer = dtoToEntity(customerDto);
			customerList.add(customer);
		}
		
		return customerList;
	}
}
