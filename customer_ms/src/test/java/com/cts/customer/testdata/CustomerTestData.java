package com.cts.customer.testdata;

import java.util.ArrayList;
import java.util.List;

import com.cts.customer.dto.CustomerDto;


public class CustomerTestData {

	private CustomerTestData() {
	}

	public static List<CustomerDto> inputDataForViewCustomerDetails() {

		List<CustomerDto> CustomerDtos = new ArrayList<>();
		CustomerDto CustomerDto = new CustomerDto();
		CustomerDto.setId(1);
		CustomerDto.setFirstName("Bijay");
		CustomerDto.setLastName("Reddy");
		CustomerDto.setAge(28);
		CustomerDto.setAddress("Marathalli");

		CustomerDtos.add(CustomerDto);

		return CustomerDtos;

	}

	public static CustomerDto inputDataForViewCustomer() {

		CustomerDto CustomerDto = new CustomerDto();
		CustomerDto.setId(1);
		CustomerDto.setFirstName("Bijay");
		CustomerDto.setLastName("Reddy");
		CustomerDto.setAge(28);
		CustomerDto.setAddress("Marathalli");
		return CustomerDto;

	}
	
	public static CustomerDto inputForCreateCustomer() {

		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName("Harry");
		customerDto.setLastName("Potter");
		customerDto.setAge(38);
		customerDto.setAddress("Bangalore");
		return customerDto;

	}

}
