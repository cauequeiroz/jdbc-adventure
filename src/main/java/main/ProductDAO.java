package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection connection;
	
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Product product) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		
		try (PreparedStatement statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				result.next();
				product.setId(result.getInt(1));				
			}
			
			System.out.println(product);
		}
	}
	
	public List<Product> getAll() throws SQLException {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM PRODUTO";
		
		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();
			
			try (ResultSet result = statement.getResultSet()) {
				while(result.next()) {
					products.add(new Product(result.getInt("ID"), result.getString("NOME"), result.getString("DESCRICAO")));
				}
			}
		}
			
		return products;
	}
	
	public void removeWithIdGreaterThan(int id) throws SQLException {
		String sql = "DELETE FROM PRODUTO WHERE ID > ?";
		
		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
			System.out.println(String.format("%d row(s) affected.", statement.getUpdateCount()));
		}
		
		// TODO: Delete this line
		connection.createStatement().execute("ALTER TABLE PRODUTO AUTO_INCREMENT = " + id);
	}
}
