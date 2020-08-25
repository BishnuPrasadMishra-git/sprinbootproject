package com.cts.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.customer.dto.CustomerDto;
import com.cts.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@Api(value = "CustomerService", produces = "application/json")
@RestController
@RequestMapping("/customer/v1")
public class CustomerRestController {

	@Autowired
	CustomerService service;

	@ApiOperation(value="create customer",response=CustomerDto.class)
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "CREATED" ,response = CustomerDto.class),
		@ApiResponse(code = 400, message = "Bad Request" ),
		@ApiResponse(code = 401, message = "UnAuthorised" ),
		@ApiResponse(code = 403, message = "Forbidden" ),
		@ApiResponse(code = 405, message = "Not Found" )})
	
	@PostMapping(value = "/create")
	public ResponseEntity<CustomerDto> createCustomer(
			@ApiParam(value = "information required to create customer" ,required=true ,name="Create Customer Request") @RequestBody CustomerDto customerDto) {
		CustomerDto customer = service.createCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value="update customer",response=CustomerDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS" ,response = CustomerDto.class),
			@ApiResponse(code = 400, message = "Bad Request" ),
			@ApiResponse(code = 401, message = "UnAuthorised" ),
			@ApiResponse(code = 403, message = "Forbidden" ),
			@ApiResponse(code = 405, message = "Not Found" )})
		
	@PutMapping(value = "/update/{id}/{address}")
	public ResponseEntity<CustomerDto> updateCustomer(
			@ApiParam(value = "id required to update customer" ,required=true ,name="id") @PathVariable("id") Integer id,
			@ApiParam(value = "address required to update customer" ,required=true ,name="address") @PathVariable("address") String address) {
		CustomerDto customer = service.updateCustomer(id,address);
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.OK);
	}

	@ApiOperation(value="get list of customer details",response=CustomerDto.class)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS" ,response = CustomerDto.class),
			@ApiResponse(code = 400, message = "Bad Request" ),
			@ApiResponse(code = 401, message = "UnAuthorised" ),
			@ApiResponse(code = 403, message = "Forbidden" ),
			@ApiResponse(code = 405, message = "Not Found" )
			})
	@GetMapping(value = "/getCustomerDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDto>> getCustomeretails() {
		List<CustomerDto> CustomerDtos = service.getCustomerDetails();
		return new ResponseEntity<List<CustomerDto>>(CustomerDtos, HttpStatus.OK);
	}


	@ApiOperation(value="get customer details",response=CustomerDto.class)	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "SUCCESS" ,response = CustomerDto.class),
		@ApiResponse(code = 400, message = "Bad Request" ),
		@ApiResponse(code = 401, message = "UnAuthorised" ),
		@ApiResponse(code = 403, message = "Forbidden" ),
		@ApiResponse(code = 405, message = "Not Found" )
		})
	@GetMapping(value = "/getCustomer/{id}")
	public ResponseEntity<CustomerDto> getCustomer(
			@ApiParam(value = "id required to get customer deatils" ,required=true ,name="id") @PathVariable("id") Integer id) {
		return new ResponseEntity<CustomerDto>(service.getCustomer(id), HttpStatus.OK);
	}

	@ApiOperation(value="get customer details",response=CustomerDto.class)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS" ,response = CustomerDto.class),
			@ApiResponse(code = 400, message = "Bad Request" ),
			@ApiResponse(code = 401, message = "UnAuthorised" ),
			@ApiResponse(code = 403, message = "Forbidden" ),
			@ApiResponse(code = 405, message = "Not Found" )
			})
	@GetMapping(value = "/getCustomerByName")
	public ResponseEntity<List<CustomerDto>> getCustomerByName(
			@ApiParam(value = "firstName required to get customer details", required = false  ,name="firstName") @RequestParam(required = false) String firstName,
			@ApiParam(value = "lastName required to get customer details", required = false  ,name="lastName")@RequestParam(required = false) String lastName) {
		return new ResponseEntity<List<CustomerDto>>(service.getCustomerByName(firstName, lastName), HttpStatus.OK);
	}
	
	

	

}
