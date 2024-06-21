package hms;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class conn {

	
	Connection connection;
	java.sql.Statement statement; 
	public conn() {
		try{
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			statement=  connection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
