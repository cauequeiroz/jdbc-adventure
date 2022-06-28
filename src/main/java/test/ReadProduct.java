package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.ConnectionFactory;
import main.Product;
import main.ProductDAO;

public class ReadProduct {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().getConnection()) {

			ProductDAO productDAO = new ProductDAO(connection);
			List<Product> products = productDAO.getAll();
			products.forEach(System.out::println);
		}
	}
}
