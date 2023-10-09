package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stmt = con.createStatement();

		stmt.executeUpdate("delete from eproduct where name='Television';");

		System.out.println("Prroduct is deleted");

		ResultSet result = stmt.executeQuery("select * from eproduct");

		while (result.next()) {
			System.out.println("Product ID: " + result.getInt("ID"));
			System.out.println("Product name: " + result.getString("name"));
			System.out.println("Price is: " + result.getDouble("price"));
		}
		con.close();
	}
}