package com.employee.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.dto.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	Employee findByNameIgnoreCaseAndAddressIgnoreCase(String name, String address);

	@Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
	Page<Employee> findTopSalaries(Pageable pageable);
	
	List<Employee> findTop3ByOrderBySalaryDesc();

	List<Employee> findTop1ByOrderBySalaryDesc();
	List<Employee> findByNameStartingWith(String name);
	Employee findByNameIgnoreCase(String name);

}
