package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcontext {

	public Connection getConnection() throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName="
					+ dbName + ";encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2", userID, password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return conn;
		}
		return conn;
	}

//    }
	/* Insert your other code right after this comment */
	/*
	 * Change/update information of your database connection, DO NOT change name of
	 * instance variables in this class
	 */
	private final String serverName = "VPS-22-11-14-14\\SQLEXPRESS";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String userID = "sa";
	private final String password = "Trungvuonghd09";

	public static void main(String[] args) {
		try {
			System.out.println(new Dbcontext().getConnection());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
