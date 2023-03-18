package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Booking;
import com.connection.DBConnection;

public class BookingDao {
	String sql;
	PreparedStatement ps;
	ResultSet rs;

	Connection con;
	boolean flag = false;

	public boolean InsertBookingData(Booking userbean) {
		
		sql = "insert into tbl_booking values(null,?,?,?,?,?,?,?)";

		con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userbean.getOwner_id());
			ps.setString(2, userbean.getVehno());
			ps.setString(3, userbean.getMobileno());
			ps.setString(4, userbean.getCity());
			ps.setString(5, userbean.getArea());
			ps.setTimestamp(6, userbean.getTime());
			ps.setString(7, "OPEN");
		
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

}
