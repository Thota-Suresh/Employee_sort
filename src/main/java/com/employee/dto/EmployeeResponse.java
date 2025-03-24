package com.employee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

	private Long empId;
	private String name;
	private String address;
	private double salary;
	private String response;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	 
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public EmployeeResponse(Long empId, String name, String address, double salary, String response) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.response = response;
	}

	public EmployeeResponse() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeResponse [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", response=" + response + "]";
	}

}
