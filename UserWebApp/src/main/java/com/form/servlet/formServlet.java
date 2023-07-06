package com.form.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.dao.formDAO;
import com.form.dto.formDTO;



@WebServlet("/user")
public class formServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		formDAO userDAO=new formDAO();
		List<formDTO> users = userDAO.getUsers();
		
		req.setAttribute("users", users);
		req.getRequestDispatcher("/viewUsers.jsp").forward(req, resp);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capture the data
		String user_name = request.getParameter("name");
		
		String user_email = request.getParameter("email");

		String user_phone = request.getParameter("phone");

		String user_state = request.getParameter("state");

		String user_city = request.getParameter("city");
		
		try {
			//Set Form Data to DTO class
		formDTO setusers = new formDTO();
		
        setusers.setUser_name(user_name);
        setusers.setUser_email(user_email);
        setusers.setUser_phone(Integer.parseInt(user_phone));
        setusers.setUser_state(user_state);
        setusers.setUser_city(user_city);
	    
        //Call the DAO Method
        formDAO formDAO =new formDAO();
        
        
			boolean isSaved = formDAO.formInsert(setusers);
			
			String msg=null;
			
	        if(isSaved) {
	        	
	        	msg=("UserSaved");
	        	
               
		    } else {
		    	msg=("NotSaved");
		    }
	        request.setAttribute("msg", msg);
	        request.getRequestDispatcher("/FormPage.jsp").forward(request, response);;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
      
		
	}
	
	
	
}
