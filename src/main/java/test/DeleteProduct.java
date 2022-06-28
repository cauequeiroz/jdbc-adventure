package test;

import java.sql.Connection;
import java.sql.SQLException;

import main.ConnectionFactory;
import main.ProductDAO;

public class DeleteProduct {
	public static void main(String[] args) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.removeWithIdGreaterThan(3);
		}
	}
}
