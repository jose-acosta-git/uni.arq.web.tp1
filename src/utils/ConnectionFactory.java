package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static final String MYSQL = "mysql";
	public static final String DERBY = "derby";
	
	private static ConnectionFactory instance = new ConnectionFactory();
	private Connection connection;

	private ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection connect(String type) {

		if (this.connection != null) {
			this.disconnect();
		}
		if (type.equals(MYSQL)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TPE1", "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (type.equals(DERBY)) {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				this.connection = DriverManager.getConnection("jdbc:derby:DBTPE1;create=true");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return this.connection;
	}

	public Connection connection() {
		return this.connection;
	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
