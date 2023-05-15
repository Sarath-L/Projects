package ticketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/bus_reservation";
	private static final String userName = "root";
	private static final String passWord = "root";

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return  DriverManager.getConnection(url,userName,passWord);
		
	}
}
