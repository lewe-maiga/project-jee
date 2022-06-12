package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {

	    static Connection bdConnection;
	    static void Connection() {
	    	try {	
				String username = "root";
		        String password = "2119";
		        String database = "projetcoding";
		        String dbUrl = "jdbc:mysql://localhost:3306/"+ database +"?serverTimezone=GMT";
		       if(bdConnection == null) {
		    	   	Class.forName("com.mysql.jdbc.Driver");
					bdConnection = DriverManager.getConnection(dbUrl, username, password );
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	       
	       }
	  
	               			
						
				
	            
	    

	

}
