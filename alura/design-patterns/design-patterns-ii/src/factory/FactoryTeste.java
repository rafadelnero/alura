package factory;

import java.sql.Connection;

public class FactoryTeste {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
		
		System.out.println(connection);
	}
}
