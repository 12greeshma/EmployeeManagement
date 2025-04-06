package com.trivium.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trivium.bean.DBUtil;
import com.trivium.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	PreparedStatement statement = null;

	public EmployeeDAOImpl() {

		connection = DBUtil.getConnection();

	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		// init();
		int result = 0;
		try {
			statement = connection.prepareStatement("insert into Employee values(?,?,?);");
			statement.setInt(1, emp.getEno());
			statement.setString(2, emp.getName());
			statement.setFloat(3, emp.getBp());

			result = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateEmployee(Employee empUpdate) {
		// TODO Auto-generated method stub
		// init();
		int resultUpdate = 0;
		try {
			statement = connection.prepareStatement("UPDATE Employee SET bp=? WHERE eno=?;");
			statement.setInt(2, empUpdate.getEno());
			// statement.setString(1, empUpdate.getName());
			statement.setFloat(1, empUpdate.getBp());

			resultUpdate = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (resultUpdate > 0)
			return true;
		else
			return false;
	}

	@Override
	public Employee getEmployeeById(int eno) {
		Employee emp = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM Employee WHERE eno = ?");
			statement.setInt(1, eno);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				emp = new Employee();
				emp.setEno(resultSet.getInt("eno"));
				emp.setName(resultSet.getString("name"));
				emp.setBp(resultSet.getFloat("bp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM Employee");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setEno(resultSet.getInt("eno"));
				emp.setName(resultSet.getString("name"));
				emp.setBp(resultSet.getFloat("bp"));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	@Override
	public boolean deleteEmployee(int eno) {
		int result = 0;
		try {
			statement = connection.prepareStatement("DELETE FROM Employee WHERE eno=?;");
			statement.setInt(1, eno);

			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result > 0;
	}

}
