package com.employee.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee;
import com.employee.dto.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
@Validated
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Validated Employee emp) {
		return service.createEmployee(emp);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<EmployeeResponse> getEmployeeData(@RequestParam ("id") long id) {
		return service.getEmployee(id);
	}
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployee(@RequestParam(defaultValue = "0") int page){
		return service.getAllEmployee(page);
	}
	
	@GetMapping("/employee/salary")
	public List<Employee> getTopsalaryEmployee(@RequestParam(defaultValue = "0") int page){
		return service.getTopSalaryEmployee(page,4);
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		return service.updateEmployee(employee);
	}
	
	
	@PatchMapping("/employee")
	public Employee updateFullEmployees(@RequestBody Employee employee) {
		return service.updatefullEmployees(employee);
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
		return service.deletebyEmployeeByID(id);
	}
	@GetMapping("/employee/top")
	public  List<Employee> getMethodName() {
		  return service.topsalaryEmployees();
	}
	@GetMapping("/employee/{name}")
	public Employee getbyEmployeeName(@PathVariable ("name") String name) {
		return service.findEmployeeByName(name);
	}
	@GetMapping("/employees/{name}")
	public List<Employee> getbyEmployeeNameStartWith(@PathVariable ("name") String name) {
		return service.findEmployeeByNameStartWith(name);
	}
}
