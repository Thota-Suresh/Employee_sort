package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.Employee;
import com.employee.dto.EmployeeResponse;
import com.employee.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public ResponseEntity<EmployeeResponse> createEmployee(Employee emp) {
		Employee existingEmployee = dao.findByNameIgnoreCaseAndAddressIgnoreCase(emp.getName(), emp.getAddress());
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (existingEmployee != null) {
			throw new EmployeeException(
					"Employee with name " + emp.getName() + " and address " + emp.getAddress() + " already exists.");
		}
		Employee e = dao.save(emp);
		employeeResponse.setAddress(e.getAddress());
		employeeResponse.setEmpId(e.getEmpId());
		employeeResponse.setName(e.getName());
		employeeResponse.setSalary(e.getSalary());
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeResponse> getEmployee(Long id) {
		Optional<Employee> emp = dao.findById(id);
		if (emp.isEmpty()) {
			throw new EmployeeException(" given  ID is employee record is not avaiable");
		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		Employee e = emp.get();
		employeeResponse.setAddress(e.getAddress());
		employeeResponse.setEmpId(e.getEmpId());
		employeeResponse.setName(e.getName());
		employeeResponse.setSalary(e.getSalary());

		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
	}

	@Override
	public List<Employee> getAllEmployee(int pageNo) {

		PageRequest pageable = PageRequest.of(pageNo, 4);
		Page<Employee> employees = dao.findAll(pageable);
		return employees.getContent();
	}

	@Override
	public List<Employee> getTopSalaryEmployee(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> employees = dao.findTopSalaries(pageable);
		return employees.getContent();
	}

	@Override
	public Employee updateEmployee(Employee emps) {
		
		if (emps.getEmpId() == 0) {
			throw new EmployeeException(" please give employee id");
		}
		Optional<Employee> emp = dao.findById(emps.getEmpId());
		if (emp.isEmpty()) {
			throw new EmployeeException(" given  ID is employee record is not avaiable");
		}
		Employee updateEmployee = emp.get();
		updateEmployee.setAddress(emps.getAddress());
		updateEmployee.setName(emps.getName());
		updateEmployee.setSalary(emps.getSalary());
		return dao.save(updateEmployee);

	}
	
	@Override
	public Employee updatefullEmployees(Employee emps) {
		if (emps.getEmpId() == 0) {
			throw new EmployeeException(" please give employee id");
		}
		Optional<Employee> emp = dao.findById(emps.getEmpId());
		if (emp.isEmpty()) {
			throw new EmployeeException(" given  ID is employee record is not avaiable");
		}
		Employee updateEmployee = emp.get();
		updateEmployee.setAddress(emps.getAddress());
		updateEmployee.setName(emps.getName());
		updateEmployee.setSalary(emps.getSalary());
		return dao.save(updateEmployee);

	}

	@Override
	public ResponseEntity<String> deletebyEmployeeByID(long id) {
		Optional<Employee> emp = dao.findById(id);
		if (emp.isEmpty()) {
			throw new EmployeeException(" given  ID is employee record is not avaiable");
		}
	  dao.deleteById(id);
		
		return new ResponseEntity<>("Employee Record is deleted ",HttpStatus.OK);
	}

	@Override
	public List<Employee> topsalaryEmployees() {
		return dao.findTop3ByOrderBySalaryDesc();
	}

	@Override
	public Employee findEmployeeByName(String name) {
		return dao.findByNameIgnoreCase(name);
	}

	@Override
	public List<Employee> findEmployeeByNameStartWith(String name) {
		return dao.findByNameStartingWith(name);
	}

}
