package lojavirtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello JDBC!");
		
		Connection connection = ConnectionFactory.getConnection();
		
		Statement sql = connection.createStatement();
		sql.execute("SELECT * FROM PRODUTO");
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
