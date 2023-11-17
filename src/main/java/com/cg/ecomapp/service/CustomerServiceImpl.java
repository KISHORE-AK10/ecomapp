package com.cg.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecomapp.dto.CustomerDTO;
import com.cg.ecomapp.entity.Cart;
import com.cg.ecomapp.entity.Customer;
import com.cg.ecomapp.exception.CustomerNotFoundException;
import com.cg.ecomapp.exception.ResourceNotFoundException;
import com.cg.ecomapp.repository.CartRepository;
import com.cg.ecomapp.repository.CustomerRepository;
import com.cg.ecomapp.util.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository custRes;
	
	@Autowired
	private CartRepository cartRes;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO custDto) {
		// TODO Auto-generated method stub
		
		//convert CustomerDTO to Customer entity
		Customer cust = CustomerMapper.dtoToEntity(custDto);
		
		Cart cart = new Cart();
//		cart.setCartId(0);
		cart.setCartItems(null);
		cart.setTotalAmount(0);
		cart.setCust(cust);
		
		Customer newCust = custRes.save(cust);
		
		cust.setCart(cart);
		
		cartRes.save(cart);
		
		//convert Customer entity to dto
		CustomerDTO newCustDto = CustomerMapper.entityToDto(newCust);
		
		return newCustDto;
	}

	@Override
	public CustomerDTO getCustomerById(int custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> optCust = custRes.findById(custId);
		if(optCust.isEmpty()) {
			//will throw defined exception
			throw new ResourceNotFoundException("Customer not found with id: "+custId);
		}
		Customer cust = optCust.get();
		
		//convert customer entity to customerDto
		CustomerDTO custDto = CustomerMapper.entityToDto(cust);
		
		return custDto;
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> custList = custRes.findAll();

		//convert customer entity list to customerDto list
		List<CustomerDTO> custDtoList = CustomerMapper.entityListToDtoList(custList);
		
		return custDtoList;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO custDto) {
		// TODO Auto-generated method stub
		Optional<Customer> optCust = custRes.findById(custDto.getCustId());
		if(optCust.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id: "+custDto.getCustId());
		}
		//convert CustomerDTO to CUstomer entity
		Customer cust = CustomerMapper.dtoToEntity(custDto);
		
		Customer updatedCust = custRes.save(cust);
		
		//convert Customer entity to dto
		CustomerDTO newCustDto = CustomerMapper.entityToDto(updatedCust);
		
		return newCustDto;
	}

	@Override
	public void deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		Optional<Customer> optCust = custRes.findById(custId);
		if(optCust.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id: "+custId);
		}
		Customer cust = optCust.get();
		custRes.delete(cust);
	}

}
