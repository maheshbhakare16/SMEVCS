package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Slot;
import com.connection.DBConnection;
import com.dao.AdminDao;

@WebServlet("/ChangeSlotStatus")
public class ChangeSlotStatus extends HttpServlet {
private static final long serialVersionUID = 1L;
       
String sql;
PreparedStatement ps;
ResultSet rs;

Connection con;
    public ChangeSlotStatus() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      PrintWriter out=response.getWriter();
      boolean flag = false;
		String slot_id = request.getParameter("slot_id");
		System.out.println(slot_id);
		con = DBConnection.getConnection();
		String sql = "UPDATE tbl_booking set status='CLOSED' where id = " + slot_id +"" ;
		try {
			ps = con.prepareStatement(sql);
			int index = ps.executeUpdate();
			if (index > 0) 
			{
				flag = true;
			} 
			else 
			{
				flag = false;
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		if(flag == true)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Slot Status Updated')");
			out.println("location='BookingHistoryAfter.jsp';");
			out.println("</script>");
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Unable to update Slot Status .....')");
			out.println("location='BookingHistoryAfter.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
