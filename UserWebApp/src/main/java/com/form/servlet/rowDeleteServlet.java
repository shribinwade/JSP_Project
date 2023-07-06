package com.form.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.dao.formDAO;


@WebServlet("/rowDeleteServlet")
public class rowDeleteServlet extends HttpServlet{
 static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user_ID = req.getParameter("user_id");
	    
		int userID = Integer.parseInt(user_ID);
	    // TODO: Implement your delete logic here, using the "users" parameter
	    formDAO formDAO=new formDAO();
	    
	    try {
			boolean rowDelete = formDAO.rowDelete(userID);
			
			if(rowDelete==true) {
			    // Redirect back to the page that displays the users list

			    resp.sendRedirect("FormPage.jsp");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   		
		
	}
	
	
	
	
}
