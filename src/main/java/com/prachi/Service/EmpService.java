package com.prachi.Service;

import java.util.HashMap;
import java.util.List;

import org.hibernate.query.Page;
import org.jspecify.annotations.Nullable;

import com.prachi.Exception.EmployeeNotFoundException;
import com.prachi.entity.EmployeeTable;

public interface EmpService
{
	String SaveEmp(EmployeeTable employee);
	//String SaveAll(List<Employee> emplist);
	
	EmployeeTable getById(Integer id) throws EmployeeNotFoundException;
	
	 EmployeeTable getAllEmployeeById(Integer id);
	 
	 public List<EmployeeTable> getAllEmployees() ;
	        
	 List<EmployeeTable> findByDepartment(String department);
	 
	List<EmployeeTable> getEmployeesBySalaryGreaterThan(Double salary);
	
	String UpdateEmployee(Integer id, EmployeeTable emp);
	
	 List<EmployeeTable> findByFirstName(String firstName);
	    
	 List<EmployeeTable> getEmployeesByFirstName(String firstName);
	 
	 boolean existsById(Integer id);
	 
	 List<EmployeeTable> findBydepartmentStartingWith(String firstchar);
	
	 List<EmployeeTable> findByFirstNameEndingWithAndSalaryGreaterThan(String firstName, double salary);
	 
	  List<EmployeeTable> saveAllEmployees(List<EmployeeTable> employees);
	  
	  @Nullable HashMap<String, String> DeleteEmp(Integer id);
	  
	  List<EmployeeTable> findByFirstNameContainingOrSalaryLessThan(String firstName, double salary);
	  
	  List<EmployeeTable> findByfirstNameLike(String firstName);
	  

	    // ✅ Pagination Methods
	  
}
	     
