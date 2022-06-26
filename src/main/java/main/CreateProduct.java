package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProduct {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		
		Statement sql = connection.createStatement();
		sql.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('Nintendo Switch', 'Nintendo game console')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = sql.getGeneratedKeys();
		result.next();
		
		System.out.println(String.format("Product added to database successfully. ID = %d", result.getInt(1)));
		
		connection.close();
	}
}
