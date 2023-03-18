package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBConnection;

import java.sql.*;
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminLoginController() {
        super();
        
    }
    protected boolean isAdmin(String email,String password) {
    	String query=null;
    	ResultSet rs = null;
    	Connection con = null;
    	PreparedStatement ps = null;
    	query = "SELECT count(email) as count_email from tbl_admin where email = ? and password= ?;";
    	try {
    		con = DBConnection.getConnection();
    		if(con != null)
    		{
    			ps = con.prepareStatement(query);
    			
    			ps.setString(1, email);
    			ps.setString(2, password);
    			rs = ps.executeQuery();
    			rs.next();
    			int count = rs.getInt("count_email");
    			if(count > 0)
    			{
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    		else {
    			throw new NullPointerException();
    		}
    		}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
    	catch(NullPointerException e){
			e.printStackTrace();
		}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return true;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(isAdmin(email,password))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successful')");
			out.println("location='AdminHome.jsp';");
			out.println("</script>");
			
			HttpSession ss=request.getSession();
			ss.setAttribute("email", email);
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Fail.......')");
			out.println("location='AdminLogin.jsp';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
