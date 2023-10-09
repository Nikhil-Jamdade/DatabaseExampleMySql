package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stmt = con.createStatement();

		stmt.executeUpdate("insert into eproduct(name, price, date_added) values('Television', 80000, now())");

		ResultSet result = stmt.executeQuery("select * from eproduct");

		System.out.println("Row is inserted");
		
		while (result.next()) {
			System.out.println("Product ID: " + result.getInt("ID"));
			System.out.println("Product name: " + result.getString("name"));
		}
		con.close();
	}
}