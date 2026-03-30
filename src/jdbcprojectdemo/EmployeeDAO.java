package jdbcprojectdemo;
import java.sql.*;
public class EmployeeDAO {

	public static void insertEmployee() {
		String sql = "INSERT INTO employees values (?,?,?,?,?,?,?,?)";
		try(Connection con = DBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		java.util.Scanner sc = new java.util.Scanner(System.in);
		)
		{
			System.out.print("Emp no");
			ps.setInt(1, sc.nextInt());
			
			System.out.print("Name: ");
			ps.setInt(2, sc.nextInt());
			
			System.out.print("Job: ");
			ps.setInt(3, sc.nextInt());
			
			ps.setDate(4, Date.valueOf("2020-01-01"));
			
			System.out.print("Manager Id: ");
			ps.setInt(5, sc.nextInt());
			
			System.out.print("Salary: ");
			ps.setInt(6, sc.nextInt());
			
			ps.setInt(7, 0);
			
			System.out.print("Dept no: ");
			ps.setInt(8, sc.nextInt());
			
			ps.executeUpdate();
			System.out.println("Employee Inserted");
}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void viewEmployees() {
		String sql = "Select empno, ename, sal from from";
		
		try(
		Connection con = DBUtil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		)
		{
			System.out.println("EMPNO | name | salary");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "|" + rs.getInt(2) + "|" + rs.getInt(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


    public static void updateSalary() {
    	String sql = "update emp set sal = ? where empno = ?";
    	
    	try(Connection con = DBUtil.getConnection();
    	PreparedStatement ps = con.prepareStatement(sql);
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    			
        )
    	{
    		
    		System.out.print("Emp no: ");
    		int empno = sc.nextInt();
    		
    		System.out.print("New salary: ");
    		int sal = sc.nextInt();
    		
    		ps.setInt(1, sal);
    		ps.setInt(2, empno);
    		
    		int rows = ps.executeUpdate();
    		System.out.println(rows + "rows updated");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void deleteEmployee() {
    	String sql = "delete from employees where empno = ?";
    	try(Connection con = DBUtil.getConnection();
    	PreparedStatement ps = con.prepareStatement(sql);
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	)
    	{
    		System.out.print("Empno: ");
    		ps.setInt(1,sc.nextInt());
    		
    		int rows = ps.executeUpdate();
    		System.out.println(rows + "rows deleted");
    	}
    	catch(Exception e) {e.printStackTrace();}
    }
    
    public static void batchInsert() {
    	String sql = "Insert into employees values (?,?,?,?,?,?,?,?)";
    	try(Connection con = DBUtil.getConnection();
    	PreparedStatement ps = con.prepareStatement(sql);
    	)
    	{
    		con.setAutoCommit(false);
    		
    		for(int i =1; i<=5; i++) {
    			ps.setInt(1,9000+i);
    			ps.setString(2, "BatchEmp" + i);
    			ps.setString(3, "clerk");
    			ps.setDate(4, Date.valueOf("2020-01-01"));
    			ps.setInt(5, 7902);
    			ps.setInt(6, 1200);
    			ps.setInt(7, 0);
    			ps.setInt(8, 30);
    			
    			ps.addBatch();	
    		}
    		ps.executeBatch();
    		con.commit();
    	    System.out.println("Batch insert successfull");
    	}
    	
        catch(Exception e) {e.printStackTrace();}
    	
    }
    
    public static void transferSalary() {
    	try(Connection con = DBUtil.getConnection();
        java.util.Scanner sc = new java.util.Scanner(System.in)
    	)
    	{
    		con.setAutoCommit(false);
    		
    		PreparedStatement debit = con.prepareStatement("update emp set sal = sal - ? where empno = ?");
    		PreparedStatement credit = con.prepareStatement("update emp set sal = sal + ? where empno = ?");
    		
    		System.out.print("From empno: ");
    		int from = sc.nextInt();
    		
    		System.out.print("To Emp no: ");
    		int to = sc.nextInt();
    		
    		System.out.print("Amount: ");
    		int amt = sc.nextInt();
    		
    		debit.setInt(1, amt);
    		debit.setInt(2, from);
    		debit.executeUpdate();
    		
    		credit.setInt(1, amt);
    		credit.setInt(2, to);
    		credit.executeUpdate();
    		
    		con.commit();
    		System.out.println("Salary Transferred");
    	}
    	catch(Exception e ) {e.printStackTrace();}
    }
    
}
