package br.com.projetoFintech.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManagement {
	private static ConnectionManagement connection;

	private ConnectionManagement() {
	
	}

	public static ConnectionManagement getInstance() {
		if (connection == null) {
			connection = new ConnectionManagement();
		}
		return connection;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.drive.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96513","100700");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
