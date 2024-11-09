package connection;

import java.sql.Connection;
import java.sql.DriverManager;import jakarta.security.auth.message.MessageInfo;

public class sqlConnection {
	String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://MEOWWW\\DAT:1305";
	String dbName = "OnTapKiemTra";
	String dbUsername = "sa";
	String dbPassword = "123";
	String connectionURL = dbURL + ";databaseName=" + dbName +";trustServerCertificate=true";
	Connection conn = null;
	public Connection getConnection()
	{

		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
			System.out.println("connect successfully!");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println(connectionURL);
			System.out.println("Lỗi không tìm thấy Driver!");
		}
		return conn;
	}
	public void CloseConnection()
	{	
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Succesfully closing the connection");
			} catch (Exception e) {
				System.out.println("Error while closing the connection");
				e.printStackTrace();
			}
		}
	}
}
