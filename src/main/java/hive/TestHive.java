package hive;

import java.sql.*;

public class TestHive {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection connection = DriverManager.getConnection(
				"jdbc:hive2://192.168.0.223:10000/test", "hive", ""
		);
		Statement statement = connection.createStatement();

		showDatabases(statement);
	}

	private static void showDatabases(Statement statement) throws SQLException {
		String sql = "show databases";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}


}
