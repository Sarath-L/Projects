package ticketBooking;

import java.sql.*;

public class BusDAO {
	public void displayBusInfo() throws SQLException, ClassNotFoundException {
		String query = "select * from bus";
		Connection con =DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("\t*****Bus Details*****\n");
		while(rs.next()) {
			System.out.println("Bus No: " + rs.getInt(1));
			if(rs.getInt(2)==0)
				System.out.println("AC Available : No");
			else
				System.out.println("AC Available: Yes");
			System.out.println("Capacity: " + rs.getInt(3));
			System.out.println("*****************");
		}
		
		System.out.println("------------------------------------------");
	}
	
	public int getCapacity(int id) throws SQLException, ClassNotFoundException {
		String query = "Select capacity from bus where id=" + id;
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}

}
