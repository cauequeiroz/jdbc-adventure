package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadProduct {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement sql = connection.prepareStatement("SELECT * FROM PRODUTO");
		sql.execute();
		ResultSet results = sql.getResultSet();
		
		while (results.next()) {
			Integer id = results.getInt("ID");
			String nome = results.getString("NOME");
			String descricao = results.getString("DESCRICAO");
			
			System.out.println(String.format("[%d] %s: %s", id, nome, descricao));
		}
		
		connection.close();
	}
}