package lojavirtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProduct {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		
		Statement sql = connection.createStatement();
		sql.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('Xbox Series X', 'Microsoft game console')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet result = sql.getGeneratedKeys();
		result.next();
		
		System.out.println(String.format("Produto adicionado com sucesso. ID = %d", result.getInt(1)));
		
		connection.close();
	}
}
