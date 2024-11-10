package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class dbutils {
	public static Connection conn = new SQLServerConnection().initializeDatabase();
	
	public static void CloseConn()
	{
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection is clossed successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Object ExecPreparedStatement(String cmd, Object[] param, boolean isExecStatment)
	{
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = conn.prepareStatement(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Failed to initialize PreparedStatment");
			e.printStackTrace();
		}
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				try {
					preparedStatement.setObject(i+1, param[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("Failed to add parameters to prepared statement");
					e.printStackTrace();
				}
			}
		}
		if (isExecStatment) {
			try {
				rs = preparedStatement.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Failed to exec ExecuteQuery for PreparedStatement");
				e.printStackTrace();
			}
		}
		else {
			try {
				return preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
