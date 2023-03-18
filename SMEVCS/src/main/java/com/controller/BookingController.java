package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Booking;
import com.bean.Slot;
import com.bean.User;
import com.dao.BookingDao;
import com.dao.SlotDao;
import com.dao.UserDao;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BookingController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(false);
		int slot_id = (int)session.getAttribute("slot_id");
		String uname = (String)session.getAttribute("username");
		UserDao u = new UserDao();
		User new_user = u.CheckUser(uname);
		SlotDao s = new SlotDao();
		Slot new_slot = s.CheckSlot(slot_id);
		Booking b = new Booking();
		b.setOwner_id(new_user.getEmail());
		b.setVehno(new_user.getVehicle_no());
		b.setMobileno(new_user.getMobile_no());
		b.setArea(new_slot.getArea());
		b.setCity(new_slot.getCity());
		Calendar cal = Calendar.getInstance(); 
		java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
		b.setTime(timestamp);
		BookingDao bdao = new BookingDao();
		if(bdao.InsertBookingData(b))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Successful')");
			out.println("location='Search.jsp';");
			out.println("</script>");
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Fail.......')");
			out.println("location='Search.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}
