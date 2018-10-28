package fernando.estudos.alura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.0.10/Caelum", "fernando", "110ombro");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
