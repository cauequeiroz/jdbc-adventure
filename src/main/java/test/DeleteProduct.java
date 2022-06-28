package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ProductDAO;
import infra.ConnectionFactory;

public class DeleteProduct {
	public static void main(String[] args) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductDAO productDAO = new ProductDAO(connection);
			productDAO.removeWithIdGreaterThan(3);
		}
	}
}
