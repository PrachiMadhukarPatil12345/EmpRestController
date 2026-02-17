package com.prachi.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prachi.Exception.EmployeeNotFoundException;
import com.prachi.Service.EmpService;
import com.prachi.entity.EmployeeTable;

import com.prachi.repository.EmpRepository;

@Service
public  class EmpServiceImpl implements EmpService
{
	@Autowired
	EmpRepository empRepository;
	@Override
	public String SaveEmp(EmployeeTable employee)
	{
		 empRepository.save(employee);
		return "Emp Registered Successfully" ;
	}
	
//	@Override
//	public String SaveAll(List<Employee> emplist) 
//	{
//		empRepository.saveAll(emplist);
//		return "Employees Added";
//	}

	@Override
	public EmployeeTable getById(Integer id) throws EmployeeNotFoundException
	{
		Optional<EmployeeTable> byId = empRepository.findById(id);
		if(byId.isPresent() )
		{
			EmployeeTable employee = byId.get();
			return employee ;
		}
		
		throw new EmployeeNotFoundException("Employee not found with id :" +id);
	}

	
	
	@Override
	public EmployeeTable getAllEmployeeById(Integer id)
	{
		 Optional<EmployeeTable> byId = empRepository.findById(id);
		 
		 if(byId.isPresent() )
		 {
			 EmployeeTable employee = byId.get();
			 return employee;
		 }
		 throw new RuntimeException("Employee not found with id: " + id);
	}

	@Override
	public List<EmployeeTable> getAllEmployees()
	{
		List<EmployeeTable> all = empRepository.findAll();
		return all;
	}

	

	@Override
	public List<EmployeeTable> findByDepartment(String department) 
	{
		List<EmployeeTable> byDepartment = empRepository.findByDepartment(department);
		
		return byDepartment;
	}

	@Override
	public List<EmployeeTable> getEmployeesBySalaryGreaterThan(Double salary)
	{
		List<EmployeeTable> employeesBySalaryGreaterThan = empRepository.getEmployeesBySalaryGreaterThan(salary);
		return employeesBySalaryGreaterThan;
		
	}

	@Override
	public String UpdateEmployee(Integer id, EmployeeTable emp)
	{
		Optional<EmployeeTable> byId = empRepository.findById(id);
		if(byId.isPresent() )
		{
			EmployeeTable dbemp = byId.get();
			dbemp.setDepartment(emp.getDepartment());
			dbemp.setJobTitle(emp.getJobTitle() );
			
			
			
			empRepository.save(dbemp);
			
		return "Employee updated";
		}
		throw new RuntimeException("Employee not found with id: " + id);
		
		
		
	}

	@Override
	public List<EmployeeTable> findByFirstName(String firstName) {
		
		return empRepository.findByFirstName(firstName);
	}

	
	 public List<EmployeeTable> getEmployeesByFirstName(String firstName)
	 {
	        return empRepository
	                .findByFirstNameStartingWithIgnoreCase(firstName);
	  }

	 @Override
	 public boolean existsById(Integer id)
	 {
		
		return empRepository.existsById(id);
	 }

	 @Override
	 public List<EmployeeTable> findBydepartmentStartingWith(String firstchar)
	 {
		return empRepository
				.findByDepartmentStartingWith(firstchar);
		
	 }

	 @Override
	 public List<EmployeeTable> findByFirstNameEndingWithAndSalaryGreaterThan(String firstName, double salary)
	 {
		return empRepository
				.findByFirstNameEndingWithAndSalaryGreaterThan(firstName, salary);
	 }

	 @Override
	 public List<EmployeeTable> saveAllEmployees(List<EmployeeTable> employees) 
	 {
		
		return empRepository.saveAll(employees);
	 }

	 @Override
	 public HashMap<String, String> DeleteEmp(Integer id)
	 {
		 Optional<EmployeeTable> byId = empRepository.findById(id);
		 if(byId.isPresent() )
		 {
			 // EmployeeTable employeeTable = byId.get();
			empRepository.deleteById(id);
		 }
		 
		 HashMap<String, String> hm = new HashMap<>();
		 hm.put("deleted", "id");
		 return hm;
		 
	 }

	 @Override
	 public List<EmployeeTable> findByFirstNameContainingOrSalaryLessThan(String firstName, double salary)
	 {
		 return empRepository.findByFirstNameContainingOrSalaryLessThan(firstName, salary);
		
	 }

	 @Override
	 public List<EmployeeTable> findByfirstNameLike(String firstName)
	 {
		return  empRepository.findByFirstNameLike("%"+firstName + "%");
		// return null;
	 }

	 

	
	 
	}

	
	
	
	
	
	
	
	
	
	

