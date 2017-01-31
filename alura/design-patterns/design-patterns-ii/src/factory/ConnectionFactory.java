package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		Connection connection;

		try {
			String banco = System.getenv("tipoBanco");
			
			if (banco.equals("mysql")) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "usuario", "senha");
			} else {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/postgres", "usuario", "senha");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao tentar criar a conexão.");
		}

		return connection;
	}
}
