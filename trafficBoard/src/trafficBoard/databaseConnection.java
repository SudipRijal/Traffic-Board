package trafficBoard;



import java.sql.*;
// using * will add all library belongs to sql
import javax.swing.*;
//for windows application and Jframe

//connecting to the database
public class databaseConnection {
	
	// creating a connection variable and initializing it 
	Connection conn = null;
	
	// this method will returns the connections
	// creating connecting class
	public static Connection dbConnector() {
		
		try {
			
			
			
			
			
			
			//define the class for connection in sqlite
			Class.forName("org.sqlite.JDBC");
			//create a connection
			Connection conn= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sudip\\eclipse-workspace\\trafficBoard\\Database\\finalfinalTraffic.sqlite");
			//checking if the databse is connected
			
			//JOptionPane.showMessageDialog(null, " Connection successfull");
			
			return conn;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
		
	}

}
