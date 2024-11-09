package dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.sqlConnection;

public class dbutils {
	public static Connection conn = new sqlConnection().getConnection();
	
	
	public static Object ExecutePrepareStatment(String query, Object[] paramValues, boolean isExecQuery) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			if (conn!=null) {
				System.out.println("conn is not null");
			}
			preparedStatement = conn.prepareStatement(query);
			for (int i = 0; i < paramValues.length; i++) {
				preparedStatement.setObject(i+1, paramValues[i]);
			}
			if (isExecQuery) {
				rs = preparedStatement.executeQuery();
				return rs;
			}
			else {
				return preparedStatement.executeUpdate();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured when executing prepared statment!");
			e.printStackTrace();
		}
		finally {
			/* dbutils.ClosePreparedStament(preparedStatement); */
		}
		return null;
	}
	public static ResultSet ExecuteQuery(String query)
	{
		ResultSet rs = null;
		Statement statement = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			return rs;
		} catch (Exception e) {
			System.out.println("Error occured when executing query!");
			e.printStackTrace();
		}
		return null;
	}
	public static void CloseResultset(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void ClosePreparedStament(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void CloseStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
