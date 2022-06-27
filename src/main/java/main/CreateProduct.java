package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CreateProduct {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement sql = connection.prepareStatement(
					"INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				create("Product #1", "Lorem ipsum silor dot amet.", sql);
				create("Product #2", "Lorem ipsum silor dot amet.", sql);
				create("Product #3", "Lorem ipsum silor dot amet.", sql);

				connection.commit();
			} catch (Exception error) {
				System.out.println("Rollback transaction.");
				connection.rollback();
			}
		}
	}

	public static void create(String name, String description, PreparedStatement sql) throws SQLException {
		sql.setString(1, name);
		sql.setString(2, description);
		sql.execute();

		try (ResultSet result = sql.getGeneratedKeys()) {
			result.next();
			System.out.println(String.format("Product added to database successfully. ID = %d", result.getInt(1)));
		}
	}
}
