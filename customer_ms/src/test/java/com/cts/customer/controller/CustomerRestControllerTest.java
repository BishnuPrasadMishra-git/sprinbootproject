package com.cts.customer.controller;

import static com.cts.customer.testdata.CustomerTestData.inputDataForViewCustomer;
import static com.cts.customer.testdata.CustomerTestData.inputDataForViewCustomerDetails;
import static com.cts.customer.testdata.CustomerTestData.inputForCreateCustomer;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import static com.cts.customer.request.utils.RequestTestDataFile.REQUEST_INFORMATION_REQUEST;

import com.cts.customer.dto.CustomerDto;
import com.cts.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CustomerService.class })
public class CustomerRestControllerTest {

	@InjectMocks
	private CustomerRestController controller;

	@Mock
	private CustomerService service;

	private MockMvc mockMvc;
	
	private static String createNewCustomerRequestJson;

	@Before
	public void setup() throws Exception {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@BeforeClass
	public static void init() {
		createNewCustomerRequestJson =REQUEST_INFORMATION_REQUEST.getJsonString();
	}

/*	@Test
	public void testCreateCustomer() throws Exception {

		String url = "/customer/v1/create";
		// input and response data
		CustomerDto customerDto = inputForCreateCustomer();

		Mockito.when(service.createCustomer(Mockito.any(CustomerDto.class))).thenReturn(customerDto);

		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(customerDto)))
				.andExpect(status().isCreated()).andReturn();

		verify(service, times(1)).createCustomer(customerDto);
		verifyNoMoreInteractions(service);

	}
	*/
	
	@Test
	public void testCreateCustomer() throws Exception {

		String url = "/customer/v1/create";
		// input and response data
		CustomerDto customerDto = inputForCreateCustomer();

		Mockito.when(service.createCustomer(Mockito.any(CustomerDto.class))).thenReturn(customerDto);

		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(createNewCustomerRequestJson))
				.andExpect(status().isCreated()).andReturn();

		verify(service, times(1)).createCustomer(customerDto);
		verifyNoMoreInteractions(service);

	}
	
	
	@Test
	@PutMapping(value = "/update/{id}/{address}")
	public void testUpdateCustomer() throws Exception{
		
		String url = "/customer/v1/update/{id}/{address}";
		//input data
		int id = 1;
		String address = "varthurUpdate";
		
		//response
		CustomerDto customerDto = inputDataForViewCustomer(); 
		customerDto.setAddress(address);
		
		//Mock
		Mockito.when(service.updateCustomer(Mockito.anyInt(),Mockito.anyString())).thenReturn(customerDto);
		
		
		mockMvc.perform(put(url,id,address).contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(customerDto)))
		.andExpect(status().isOk()).andReturn();
		
		
		//verify(service, times(1)).updateCustomer(id, address);
		//verifyNoMoreInteractions(service);

		
	}
	

	@Test
	public void testGetCustomeretails() throws Exception {

		String url = "/customer/v1/getCustomerDetails";

		// Response Data
		List<CustomerDto> customerDtos = inputDataForViewCustomerDetails();
		Mockito.when(service.getCustomerDetails()).thenReturn(customerDtos);

		MvcResult mvcResult = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertNotNull(mvcResult.getResponse());
		verify(service, times(1)).getCustomerDetails();
		verifyNoMoreInteractions(service);
	}

	@Test
	public void testGetCustomer() throws Exception {

		String url = "/customer/v1/getCustomer/{id}";
		// input data
		int id = 1;
		// response

		CustomerDto customerDto = inputDataForViewCustomer();

		Mockito.when(service.getCustomer(Mockito.anyInt())).thenReturn(customerDto);

		MvcResult mvcResult = mockMvc.perform(get(url, id).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertNotNull(mvcResult.getResponse());
		verify(service, times(1)).getCustomer(id);

	}

	@Test
	public void testGetCustomerByName() throws Exception {

		String url = "/customer/v1/getCustomerByName";

		// input data
		String firstName = "Bijay";
		String lastName = "Reddy";

		// Response Data
		List<CustomerDto> customerDtos = inputDataForViewCustomerDetails();

		Mockito.when(service.getCustomerByName(Mockito.any(), Mockito.any())).thenReturn(customerDtos);

		MvcResult mvcResult = mockMvc.perform(get(url, firstName, lastName).param("firstName", firstName)
				.param("lastName", lastName).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andReturn();

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertNotNull(mvcResult.getResponse());
		verify(service, times(1)).getCustomerByName(firstName, lastName);
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
