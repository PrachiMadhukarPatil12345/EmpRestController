package com.prachi.rest;

import java.util.HashMap;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prachi.Exception.EmployeeNotFoundException;
import com.prachi.Service.EmpService;
import com.prachi.Service.Impl.EmpServiceImpl;
import com.prachi.entity.EmployeeTable;

@RestController
 //@RequestMapping("/api/employees")
public class EmpRestController 
{
	@Autowired
	EmpService empservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> Save(@RequestBody EmployeeTable employee)
	{
		String msg=empservice.SaveEmp(employee);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<EmployeeTable> getAll(@RequestParam Integer id) throws EmployeeNotFoundException
	{
		EmployeeTable msg = empservice.getById(id);
		return new ResponseEntity<EmployeeTable>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<EmployeeTable> getEmployeeById(@PathVariable Integer id) {
	    EmployeeTable emp = empservice.getAllEmployeeById(id);
	    return ResponseEntity.ok(emp);
	}

	
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeTable>> getAllEmployees() {
        List<EmployeeTable> employees = empservice.getAllEmployees();
        return new ResponseEntity<List<EmployeeTable>>(employees,HttpStatus.CREATED);
   }
    
    @GetMapping("/bydep")  //{department}"
   
	public ResponseEntity<List<EmployeeTable>> findbydep(@RequestParam String s)
	{
		List<EmployeeTable> byDepartment = empservice.findByDepartment(s);
		return new ResponseEntity<List<EmployeeTable>> (byDepartment,HttpStatus.OK);
	}
    
    @GetMapping("bysalary")
    public ResponseEntity<List<EmployeeTable>> findbySalary(@RequestParam Double salary)
    {
    	List<EmployeeTable> employeesBySalaryGreaterThan = empservice.getEmployeesBySalaryGreaterThan(salary);
    	
    	return new ResponseEntity<List<EmployeeTable>>(employeesBySalaryGreaterThan,HttpStatus.OK);
    }
      
    
//    @PutMapping("/update/{id}")
//    public String Update(@RequestParam Integer id,@RequestBody Employee employee)
//    {
//    	String updateEmployee = empservice.UpdateEmployee(id, employee);
//		return updateEmployee;
//    	
//    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Integer id,
            @RequestBody EmployeeTable employee)
    {

        String updatedEmployee = empservice.UpdateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @GetMapping("/employees/by-name")
    public ResponseEntity<List<EmployeeTable>> findbyname(@RequestParam String firstName)
    {
    	List<EmployeeTable> names = empservice.findByFirstName(firstName);
    	return new ResponseEntity<List<EmployeeTable>>(names,HttpStatus.OK);
    }

    

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeTable>> searchByFirstName(@RequestParam String firstName) 
    {

       return ResponseEntity.ok(
                empservice.getEmployeesByFirstName(firstName)
        );
    }
    
    @GetMapping("/existsbyid{id}")
    public ResponseEntity<Boolean> existabyid(@PathVariable Integer id)
    {
    	boolean existsById = empservice.existsById(id);
    	return ResponseEntity.ok(existsById); 
    }
    
//    @GetMapping("/dept/{department}")
//    public ResponseEntity<List<EmployeeTable>> findBydepartmentStartingWith(
//            @PathVariable String department) {
//
//        List<EmployeeTable> list = empservice.findBydepartmentStartingWith(department);
//        return ResponseEntity.ok(list);
//    }

    @GetMapping("/dept/{department}")
    public ResponseEntity<List<EmployeeTable>> findBydepartmentStartingWith(
            @PathVariable String department) {

        List<EmployeeTable> list = empservice.findBydepartmentStartingWith(department);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(list);
    }
    
    
    @GetMapping("/nameAndsalary")
    public ResponseEntity<List<EmployeeTable>> 
        getByFirstNameEndingWithAndSalaryGreaterThan(
            @RequestParam String firstName,
            @RequestParam double salary) 
    {

        List<EmployeeTable> list = empservice
                .findByFirstNameEndingWithAndSalaryGreaterThan(firstName, salary);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(list);
    }
    
    
    @PostMapping("/saveAllemp")
    public ResponseEntity<List<EmployeeTable>> saveAllEmployees(
            @RequestBody List<EmployeeTable> employees)
    {

        List<EmployeeTable> savedEmployees =
                empservice.saveAllEmployees(employees);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(savedEmployees);
    }

    
    @GetMapping("/delete")
    public ResponseEntity<HashMap<String, String>> deleteEmp (@RequestParam Integer id)
    {
    	@Nullable HashMap<String, String> emp = empservice.DeleteEmp(id);
    	emp.put("Message : "," Deleted Record");
		return new ResponseEntity<HashMap<String,String> >(emp,HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/nameSal")
    public ResponseEntity<List<EmployeeTable>> nameOrSalary
    (@RequestParam String firstName,
     @RequestParam Double salary)
    
    {
    	List<EmployeeTable> nameSal = empservice.findByFirstNameContainingOrSalaryLessThan(firstName, salary);
    	
    	return new ResponseEntity< List<EmployeeTable >>(nameSal,HttpStatus.OK);
    }
    
    @GetMapping("/namelike")
    public ResponseEntity<List<EmployeeTable>> searchemp (@RequestParam String name)
    {
    	List<EmployeeTable> namelike = empservice.findByfirstNameLike(name);
    	return new ResponseEntity< List<EmployeeTable >>(namelike,HttpStatus.ACCEPTED);
    }
    
    
}




// 












































































