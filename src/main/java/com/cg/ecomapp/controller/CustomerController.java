package com.cg.ecomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecomapp.dto.CustomerDTO;
import com.cg.ecomapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custSer;
	
	@GetMapping("/all")
	public ResponseEntity<List<CustomerDTO>>  fetchAllCustomers(){
		List<CustomerDTO> cust = custSer.getAllCustomer();
		ResponseEntity<List<CustomerDTO>> responseEntity = new ResponseEntity<>(cust,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String>  addCustomer(@RequestBody CustomerDTO custDto) {
		custSer.saveCustomer(custDto);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("New Customer saved",HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/get{id}")
	public ResponseEntity<CustomerDTO>  fetchCustomerDetails(@PathVariable("id") int custId) {
		CustomerDTO cust = custSer.getCustomerById(custId);
		ResponseEntity<CustomerDTO> responseEntity = new ResponseEntity<>(cust,HttpStatus.ACCEPTED);
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<CustomerDTO> modifyCustomerDetails(@RequestBody CustomerDTO custDto){
		CustomerDTO updatedCust = custSer.updateCustomer(custDto);
		return new ResponseEntity<>(updatedCust, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") int custId){
		custSer.deleteCustomer(custId);
		return new ResponseEntity<>("Customer Deleted with id: "+custId, HttpStatus.ACCEPTED);
	}
}
