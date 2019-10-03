package com.algorithm.basic;

import java.sql.*;

public class MyConnection {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bang_test", "root", "123456");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("show tables;");
			while (rs.next())
				System.out.println(rs.getString(1));
		} catch (Exception e) {
			System.out.println(e);
		}
		if(rs != null) {
			rs.close();
		}
	}
}
