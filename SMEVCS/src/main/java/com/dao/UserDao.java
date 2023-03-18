package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.User;
import com.connection.DBConnection;

public class UserDao {
	
	
	String sql;
	PreparedStatement ps;
	ResultSet rs;

	Connection con;
	boolean flag = false;

	public boolean InsertUserData(User userbean) {
		
		sql = "insert into tbl_user values(?,?,?,?,?,?,?)";

		con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, userbean.getEmail());
			ps.setString(2, userbean.getName());
			ps.setString(3, userbean.getAddress());
			ps.setString(4, userbean.getMobile_no());
			ps.setString(5, userbean.getPassword());
			ps.setString(6, userbean.getVehicle_no());
			ps.setString(7, userbean.getVehicle_name());
		
			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean alreadyUser(String email) throws SQLException {
		String sql = "select * from tbl_user where email=?";
		con = DBConnection.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		return flag;
	}

	
	public User CheckUser(String email, String password) {
		User bean = new User();
		sql = "select * from tbl_user where email='" + email + "' and password='" + password + "' ";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				bean.setEmail(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setMobile_no(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setVehicle_no(rs.getString(6));
				bean.setVehicle_name(rs.getString(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bean;
	}
	
	public User CheckUser(String email) {

		User bean = new User();
		sql = "select * from tbl_user where email='" + email + "' ";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				bean.setEmail(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setMobile_no(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setVehicle_no(rs.getString(6));
				bean.setVehicle_name(rs.getString(7));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bean;
	}

}
