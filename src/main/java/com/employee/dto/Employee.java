package com.employee.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@NotBlank(message = "Name is mandatory") // Ensures name is not blank or empty
//	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$", message = "Name must start with a capital letter and contain no digits.")
//	@Size(min = 3, max = 50, message = "Name must start with a capital letter and contain no digits and should be between 3 and 50 characters")
	private String name;
	
//	@Pattern(regexp = "^[A-Z][a-z]*[a-z]$", message = "Address must start with a capital letter, contain no digits, and end with a lowercase letter.")
//	@Size(min = 2, max = 50 , message = "address must me 3 latters")
	private String address;
	 
	@DecimalMin(value = "0.0", inclusive = true, message = "Salary must be a positive number")
	private double salary;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}

	public Employee(long empId, String name, String address, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

}
