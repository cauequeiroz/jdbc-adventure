package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProduct {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			try (PreparedStatement sql = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > 3")) {
				sql.execute();
				System.out.println(String.format("%d row(s) affected.", sql.getUpdateCount()));
			}

			connection.createStatement().execute("ALTER TABLE PRODUTO AUTO_INCREMENT = 3");
		}
	}
}
