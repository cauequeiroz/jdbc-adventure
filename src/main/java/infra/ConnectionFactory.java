package infra;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setMaxPoolSize(5);
		
		this.dataSource = dataSource;		
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
