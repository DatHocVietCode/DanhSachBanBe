package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnection {
	public static Connection initializeDatabase()
	    { 
	        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	        String dbURL = "jdbc:sqlserver://MEOWWW\\DAT:1305"; 
	        // Database name to access 
	        String dbName = "DanhSachBanBe"; 
	        String dbUsername = "sa"; 
	        String dbPassword = "123"; 
	        String connectionURL = dbURL + ";databaseName=" + dbName +
	        		";encrypt=true;trustServerCertificate=true";
	        Connection conn = null;
	        try {
	            Class.forName(dbDriver);
	            conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn; 
	    } 
}
