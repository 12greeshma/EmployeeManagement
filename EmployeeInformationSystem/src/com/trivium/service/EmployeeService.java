package com.trivium.service;

import java.util.List;

import com.trivium.bean.Employee;

public interface EmployeeService {
	
	boolean addEmployeeService(Employee emp);
	
	boolean updateEmployeeService(Employee empUpdate);
	
	Employee getEmployeeService(int eno);

	List<Employee> getAllEmployeesService();

	boolean deleteEmployeeService(int eno);


	

}
