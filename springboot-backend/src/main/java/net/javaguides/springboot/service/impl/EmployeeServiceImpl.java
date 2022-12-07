package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeReposiotory;
	
	public EmployeeServiceImpl(EmployeeRepository employeeReposiotory) {
		super();
		this.employeeReposiotory = employeeReposiotory;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeReposiotory.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
	    return employeeReposiotory.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		//  Optional<Employee> employee = employeeReposiotory.findById(id);
		//  if(employee.isPresent()) 
		//	  return employee.get();
		//  else throw new ResourceNotFoundException("Employee", "Id", id);		 		
		return employeeReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id exist in db or not
		Employee existingEmployee = employeeReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save
		employeeReposiotory.save(existingEmployee);
		return existingEmployee;
	}
	
	/*@Override
	public void deleteEmployee(long id) {
		//check whether an employee exist in a database or not
		//employeeReposiotory.delete(employee);	
		employeeReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		employeeReposiotory.deleteById(id);		
	}*/


	@Override
	public void deleteEmployee(long id) {
		//check whether an employee exist in a database or not
		employeeReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		employeeReposiotory.deleteById(id);		
	}

	
	
}
