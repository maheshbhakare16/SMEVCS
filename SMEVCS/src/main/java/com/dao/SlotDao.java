package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Booking;
import com.bean.Slot;
import com.bean.User;
import com.connection.DBConnection;

public class SlotDao {
	String sql;
	PreparedStatement ps;
	ResultSet rs;

	Connection con;
	boolean flag = false;

	public Slot CheckSlot(int slot_id) {

		Slot s = new Slot();
		sql = "select * from tbl_slot where id= " + slot_id + " ";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				s.setArea(rs.getString("area"));
				s.setCity(rs.getString("city"));
				s.setCountry(rs.getString("country"));
				s.setState(rs.getString("state"));
				s.setAddress(rs.getString("address"));
				s.setSlotname(rs.getString("slotname"));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return s;
	}
}
