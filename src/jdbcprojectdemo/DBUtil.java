package jdbcprojectdemo;
import java.sql.*;
public class DBUtil {

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/Employee_Details",
		"root",
		"SQLsql123@@@"
				
		);

	}

}
