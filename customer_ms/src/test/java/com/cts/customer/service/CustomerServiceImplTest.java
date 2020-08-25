package com.cts.customer.service;
/*
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.customer.controller.CustomerRestController;
import com.cts.customer.dto.CustomerDto;
import com.cts.customer.entity.dto.Customer;
import com.cts.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(PowerMockRunner.class)
public class CustomerServiceImplTest {
	
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	CustomerRepository repositry;
	
	@Test
	public void testGetCustomerDetails() {
		List<Customer> list 

		Mockito.when(repositry.findAll()).thenReturn(list);
		
		
		List<Customer> list = repositry.findAll();
		ObjectMapper mapper = new ObjectMapper();
		List<CustomerDto> listOfCustomer = mapper.convertValue(list, List.class);
		return listOfCustomer;
	}

}
*/