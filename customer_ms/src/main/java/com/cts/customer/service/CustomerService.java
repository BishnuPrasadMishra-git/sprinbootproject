package com.cts.customer.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cts.customer.dto.CustomerDto;

public interface CustomerService {
	
	public CustomerDto createCustomer(CustomerDto customerDto);
	
	public CustomerDto updateCustomer(Integer id,String address);
	
	public List<CustomerDto> getCustomerDetails();
	
	public CustomerDto getCustomer(Integer id);
	
	public List<CustomerDto> getCustomerByName(String firstName,String lastName );

}
