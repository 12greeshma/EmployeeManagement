package com.trivium.dao;

import java.util.List;

import com.trivium.bean.Employee;

public interface EmployeeDAO {
	
	boolean addEmployee(Employee emp);
	
	boolean updateEmployee (Employee empUpdate);
	
	Employee getEmployeeById(int eno);

	List<Employee> getAllEmployees();
	
	boolean deleteEmployee(int eno);

	

}
