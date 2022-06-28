package test;

import java.sql.Connection;
import java.sql.SQLException;

import main.ConnectionFactory;
import main.Product;
import main.ProductDAO;

public class CreateProduct {
	public static void main(String[] args) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.save(new Product("Product #1", "Lorem ipsum silor dot amet."));
			productDAO.save(new Product("Product #2", "Lorem ipsum silor dot amet."));
			productDAO.save(new Product("Product #3", "Lorem ipsum silor dot amet."));			
		}
	}
}
