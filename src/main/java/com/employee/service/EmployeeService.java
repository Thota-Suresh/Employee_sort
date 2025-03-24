package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dto.Employee;
import com.employee.dto.EmployeeResponse;

@Service
public interface EmployeeService {

	public ResponseEntity<EmployeeResponse> createEmployee(Employee emp);
	public ResponseEntity<EmployeeResponse> getEmployee(Long id);
	public List<Employee> getAllEmployee(int page);
	public List<Employee> getTopSalaryEmployee(int page,int pageSize);
	public Employee updatefullEmployees(Employee emp);
	public Employee updateEmployee(Employee emp);
	public ResponseEntity<String> deletebyEmployeeByID(long id);
	public List<Employee> topsalaryEmployees();
	public Employee findEmployeeByName(String name);
	public List<Employee> findEmployeeByNameStartWith(String name);
}
