package com.cts.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.customer.dto.CustomerDto;
import com.cts.customer.entity.dto.Customer;
import com.cts.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repositry;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerDto Dtocustomer = null;
		ObjectMapper mapper = new ObjectMapper();

		Customer customer = mapper.convertValue(customerDto, Customer.class);
		customer = repositry.save(customer);
		customerDto = mapper.convertValue(customer, CustomerDto.class);

		return Dtocustomer;
	}

	@Override
	public CustomerDto updateCustomer(Integer id, String address) {

		CustomerDto customerDto = null;
		Customer customer = null;
		try {
			customer = repositry.getOne(id);
			customer.setAddress(address);
			customer = repositry.save(customer);
			ObjectMapper mapper = new ObjectMapper();
			customerDto = mapper.convertValue(customer, CustomerDto.class);
		} catch (Exception e) {

		}

		return customerDto;
	}

	@Override
	public List<CustomerDto> getCustomerDetails() {

		List<Customer> list = repositry.findAll();
		ObjectMapper mapper = new ObjectMapper();
		List<CustomerDto> listOfCustomer = mapper.convertValue(list, List.class);
		return listOfCustomer;
	}

	@Override
	public CustomerDto getCustomer(Integer id) {
		CustomerDto customerDto = null;
		Optional<Customer> customer = repositry.findById(id);

		if (customer.isPresent()) {
			ObjectMapper mapper = new ObjectMapper();
			customerDto = mapper.convertValue(customer.get(), CustomerDto.class);
		}

		return customerDto;

	}

	@Override
	public List<CustomerDto> getCustomerByName(String firstName, String lastName) {

		List<Customer> customers = repositry.findByFirstNameOrLastName(firstName, lastName);
		ObjectMapper mapper = new ObjectMapper();
		List<CustomerDto> listOfCustomer = mapper.convertValue(customers, List.class);
		return listOfCustomer;
	}

}
