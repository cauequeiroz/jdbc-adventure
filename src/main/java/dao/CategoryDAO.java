package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;

public class CategoryDAO {
	Connection connection;
	
	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Category> getAll() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM CATEGORIA";
		
		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();
			
			try (ResultSet result = statement.getResultSet()) {
				while(result.next()) {
					categories.add(new Category(result.getInt("ID"), result.getString("NOME")));
				}
			}
		}
			
		return categories;
	}
	
	public List<Category> getAllWithProducts() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		String sql = """
			SELECT * FROM
			CATEGORIA C INNER JOIN PRODUTO P
			WHERE C.ID = P.CATEGORIA_ID
		""";
		
		try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
			statement.execute();
			
			try (ResultSet result = statement.getResultSet()) {
				Category lastCategory = null;
				
				while(result.next()) {
					if (lastCategory == null || !lastCategory.getName().equals(result.getString(2))) {
						Category category = new Category(result.getInt(1), result.getString(2));
						categories.add(category);
						lastCategory = category;
					}
					
					lastCategory.addProduct(new Product(result.getInt(3), result.getString(4), result.getString(5)));
				}
			}
		}
			
		return categories;
	}
}
