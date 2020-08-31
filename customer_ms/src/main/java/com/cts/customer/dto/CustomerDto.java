package com.cts.customer.dto;



//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import java.io.Serializable;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class CustomerDto implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
