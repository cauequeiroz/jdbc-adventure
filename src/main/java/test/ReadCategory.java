package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import infra.ConnectionFactory;
import model.Category;

public class ReadCategory {
	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().getConnection()) {
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> categories = categoryDAO.getAll();
			categories.forEach(System.out::println);
			
			System.out.println("---------");
			
			List<Category> categoriesWithProducts = categoryDAO.getAllWithProducts();
			categoriesWithProducts.forEach(category -> {
				System.out.println(category);				
				category.getProducts().forEach(System.out::println);
			});
		}
	}
}
