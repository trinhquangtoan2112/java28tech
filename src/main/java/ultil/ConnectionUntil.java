package ultil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.repository.entity.BuildingEntity;

@PropertySource("classpath:application.properties")
public class ConnectionUntil {
	private static final String hostName = "localhost:3306";
	private static final String dbName = "jpatest123";
	private static final String username = "root";
	private static final String password = "#Quangtoan2112";
	private static final String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	
	 
	public static Connection getConnection() {
		Connection conn =null;
		try {
			 conn = DriverManager.getConnection(connectionURL, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return conn;
	}
}
