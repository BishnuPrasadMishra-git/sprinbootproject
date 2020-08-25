package com.cts.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.customer.entity.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

}
