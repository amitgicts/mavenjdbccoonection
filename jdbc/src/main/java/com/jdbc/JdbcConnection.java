package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("hello");
		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/myhiber";
			String username = "root";
			String password = "tiger";
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("databse connection"+con);
			String query = "Select * from student";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");

				String email = resultSet.getString("email");
				long fees = resultSet.getLong("fees");
				long phoneno = resultSet.getLong("phone_no");
				String section = resultSet.getString("section");

				System.out.println("name:" + name);

				System.out.println("email:" + email);
				System.out.println("fees:" + fees);
				System.out.println("phoneno:" + phoneno);
				System.out.println("section:" + section);
			}

		} catch (SQLException e) {
			System.out.println("databse not connection");
			e.printStackTrace();
		}

	}
}
