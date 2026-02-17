package com.prachi.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prachi.entity.EmployeeTable;

public interface EmpRepository extends JpaRepository<EmployeeTable,Integer>
{
	List<EmployeeTable> findByDepartment(String department);
	List<EmployeeTable> getEmployeesBySalaryGreaterThan(Double salary);
	
	

	    List<EmployeeTable> findByFirstName(String firstName);
	
	    List<EmployeeTable> findByFirstNameStartingWithIgnoreCase(String firstName);
	    
	    boolean existsById(Integer id);
	    
	  
	    List<EmployeeTable> findByDepartmentStartingWith(String department);
	    
	    List<EmployeeTable> findByFirstNameEndingWithAndSalaryGreaterThan(String firstName,double salary);
	    
	    List<EmployeeTable> findByFirstNameContainingOrSalaryLessThan(String lastchar, double salary);
	    
		//HashMap<String, String> findByFirstNameContainingOrSalaryLessThan(String firstName, double salary);
	    
	    
	    List<EmployeeTable> findByFirstNameLike(String firstName);
	    
	    Page<EmployeeTable> findByDepartment(String department, Pageable pageable);
	    
	    Page<EmployeeTable> findBySalaryGreaterThan(Double salary, Pageable pageable);

	    Page<EmployeeTable> findByFirstNameContaining(String firstName, Pageable pageable);
}
























