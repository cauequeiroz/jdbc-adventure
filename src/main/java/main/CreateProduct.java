package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CreateProduct {
	public static void main(String[] args) throws SQLException {
		String name = "Soundbar JBL";
		String description = "A powerful soundbar.";		
	
		Connection connection = ConnectionFactory.getConnection();		
		PreparedStatement sql = connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		sql.setString(1, name);
		sql.setString(2, description);
		sql.execute();
		
		ResultSet result = sql.getGeneratedKeys();
		result.next();
		
		System.out.println(String.format("Product added to database successfully. ID = %d", result.getInt(1)));
		
		connection.close();
	}
}
