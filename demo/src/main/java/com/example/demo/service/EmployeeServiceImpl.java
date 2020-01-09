package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> listEmployees()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
		
	}
	
	public String deleteEmployee(@RequestParam Long id) {
	        return employeeRepository.findById(id).map(emp -> {
	        	employeeRepository.delete(emp);
	            return "deleted";
	        }).orElseThrow(() -> new ResourceNotFoundException("Employee Id " + id + " not found"));
	}
	public  Employee findByEmployeeId(Long id){
		Optional<Employee> opt=employeeRepository.findById(id);
		Employee e=opt.get();
		return e;
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> emps=employeeRepository.findByName(name);
		return emps;
	}

	@Override
	public List<Employee> findByDesig(String desig) {
		List<Employee> emps=employeeRepository.findByDesig(desig);
		return emps;
	}

	@Override
	public List<Employee> findByDeptNo(int deptNo) {
		List<Employee> emps=employeeRepository.findByDeptNo(deptNo);
		return emps;
	}

}
