package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
	}
	//build create employee REST API
	//Complete response details can be provided using ResponseEntiry class
	//@PostMapping this is to handle post http request.
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	// build all employee (get all employee) REST API
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
		
	// build get employee (based on id) REST API
	//http://localhost:8080/api/employees/121
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	//build update employee REST API
	//http://localhost:8080/api/employees/121
	//@RequestBody converts json which is given in request to java object.
	@PutMapping("{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	//build delete employee REST API
	
	@DeleteMapping("{id}")
	//http://localhost:8080/api/employees/121
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") long id) {
		//employeeService.deleteEmployee(/*employee,*/ id);
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
	}
	
}
