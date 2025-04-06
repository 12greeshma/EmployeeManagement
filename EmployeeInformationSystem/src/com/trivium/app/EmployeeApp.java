package com.trivium.app;
import java.util.*;

import com.trivium.bean.Employee;
import com.trivium.service.EmployeeService;
import com.trivium.service.EmployeeServiceImpl;
public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice =0;
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		do {
			System.out.println("1. Add an Employee");
			System.out.println("2. Edit an Employee");
			System.out.println("3. List an Employee");
			System.out.println("4. List all the Employees");
			System.out.println("5. Delete an Employee");
			System.out.println("6. Exit the Application");
			
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				
				System.out.println("Enter Eno");
				int eno = sc.nextInt();
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Bp");
				float bp = sc.nextFloat();
				Employee emp = new Employee();
				
				emp.setEno(eno);
				emp.setName(name);
				emp.setBp(bp);
				
				boolean result = employeeService.addEmployeeService(emp);
				if (result)
					System.out.println("Employee record added successfully!!!");
				else
					System.out.println("Fail to add Employee record!!!");
				break;
				
			case 2:
				System.out.println("Enter Employee eno to update");
				int enoUpdate = sc.nextInt();
				sc.nextLine();
//				System.out.println("Enter new Employee name");
//				String nameUpdate = sc.next();
				System.out.println("Enter new Employee Basic Pay");
				float bpUpdate = sc.nextFloat();
				Employee empUpdate = new Employee();
				empUpdate.setEno(enoUpdate);
//				empUpdate.setName(nameUpdate);
				empUpdate.setBp(bpUpdate);
				
				boolean resultUpdate = employeeService.updateEmployeeService(empUpdate);
				if (resultUpdate)
					System.out.println("Updated Successfully!!!");
				else
					System.out.println("Fail to update Employee record!!!");
				break;
				
			case 3:
			    System.out.println("Enter eno to fetch details");
			    int enoFetch = sc.nextInt();
			    
			    Employee empFetched = employeeService.getEmployeeService(enoFetch);
			    
			    if (empFetched != null) {
			        System.out.println("Details of Employee eno: " + enoFetch);
			        System.out.println("Employee Name: " + empFetched.getName());
			        System.out.println("Employee Basic Pay: " + empFetched.getBp());
			    } else {
			        System.out.println("No Employee found with eno: " + enoFetch);
			    }
			    break;
			    
			case 4:
			    List<Employee> employees = employeeService.getAllEmployeesService();

			    if (employees.isEmpty()) {
			        System.out.println("No Employees found.");
			    } else {
			        System.out.println("List of Employees:");
			        System.out.println("---------------------------");
			        for (Employee emp1 : employees) {
			            System.out.println("Eno: " + emp1.getEno());
			            System.out.println("Name: " + emp1.getName());
			            System.out.println("Basic Pay: " + emp1.getBp());
			            System.out.println("---------------------------");
			        }
			    }
			    break;

			case 5:
			    System.out.println("Enter Employee eno to delete:");
			    int enoDelete = sc.nextInt();
			    
			    boolean resultDelete = employeeService.deleteEmployeeService(enoDelete);
			    if (resultDelete)
			        System.out.println("Employee deleted successfully!");
			    else
			        System.out.println("Failed to delete Employee! Employee not found");
			    break;		
				
			case 6:
				System.out.println("The Application is Terminating...");
				System.exit(0);
				
				
			}
		}while(choice >0 && choice <6);

		sc.close();
	}
	

}
