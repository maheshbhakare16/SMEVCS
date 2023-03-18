package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Slot;
import com.dao.AdminDao;

@WebServlet("/UpdateSlotController")
public class UpdateSlotController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
    public UpdateSlotController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      PrintWriter out=response.getWriter();
      HttpSession session=request.getSession(false);
		String status = request.getParameter("status");
		System.out.println(status);
		session.setAttribute("status",status); 
		String slot_id = request.getParameter("slot_id");
		
		
		
		if(status != null)
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
			out.println("location='BookingHistoryBefore.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
