package com.form.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.dao.formDAO;
import com.form.dto.formDTO;
@WebServlet("/editRowServlet")
public class editrowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String UserID = req.getParameter("user_id");
		String UserName = req.getParameter("name");
		String UserEmail = req.getParameter("email");
		String UserPhone = req.getParameter("phone");
		String UserState = req.getParameter("state");
		String UserCity = req.getParameter("city");

         int userID=Integer.parseInt(UserID);
		 int userPhone=Integer.parseInt(UserPhone);
		 try {	
				formDTO setusers = new formDTO();
		        setusers.setUser_id(userID);
		        setusers.setUser_name(UserName);
		        setusers.setUser_email(UserEmail);
		        setusers.setUser_phone(userPhone);
		        setusers.setUser_state(UserState);
		        setusers.setUser_city(UserCity);
		        
		    formDAO formDAO=new formDAO();
			    
			String editmsg=null;
			 
			boolean rowEdit = formDAO.rowEdit(setusers);
			
			 if(rowEdit) {
				 editmsg="Row Updated Successfully";

				    
				 //resp.sendRedirect();
			 }else {
				 editmsg="Row Updated Fail";

			 }
			    req.setAttribute("editmsg", editmsg);
				req.getRequestDispatcher("editRow.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
}
