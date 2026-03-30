package jdbcprojectdemo;

import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(
					"""
	                \n--- EMPLOYEE MANAGEMENT ---
	                1. Add Employee
	                2. View Employees
	                3. Update Salary
	                4. Delete Employee
	                5. Batch Insert
	                6. Transfer Salary
	                0. Exit
	            """
					
			);
			
			System.out.print("Choose: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 : EmployeeDAO.insertEmployee();
			case 2 : EmployeeDAO.viewEmployees();
			case 3 : EmployeeDAO.updateSalary();
			case 4 : EmployeeDAO.deleteEmployee();
			case 5 : EmployeeDAO.batchInsert();
			case 6 : EmployeeDAO.transferSalary();
			
			case 0 : {
				System.out.println("Bye");
				return;
			}
			
			default : System.out.println("Invalid choice");
			}
		}
	}

}
