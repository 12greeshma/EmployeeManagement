package com.trivium.service;

import java.util.List;

import com.trivium.bean.Employee;
import com.trivium.dao.EmployeeDAO;
import com.trivium.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO employeeDAO = null;
	
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		employeeDAO = new EmployeeDAOImpl();
	}
	
	@Override
	public boolean addEmployeeService(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(emp);
	}

	@Override
	public boolean updateEmployeeService(Employee empUpdate) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(empUpdate);
	}

	@Override
	public Employee getEmployeeService(int eno) {
		// TODO Auto-generated method stub
		 return employeeDAO.getEmployeeById(eno);
	}

	@Override
	public List<Employee> getAllEmployeesService() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}
	
	
	@Override
	public boolean deleteEmployeeService(int eno) {
	    return employeeDAO.deleteEmployee(eno);
	}
	

}
