package com.Data.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Data.beans.UserBean;
import com.Data.model.DataManager;
import com.Data.model.Validation;


@WebServlet("/controller/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String fname;
	private String lname;
	private String contact;
	private String email;
	Validation val=new Validation();
	UserBean data=new UserBean();
	DataManager dm=new DataManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext conf=getServletContext();
		dm.setDbURL(conf.getInitParameter("dbURL"));
		dm.setDbUserName(conf.getInitParameter("dbUserName"));
		dm.setDbPassword(conf.getInitParameter("dbPassword"));
		try
		{
			Class.forName(conf.getInitParameter("jdbcDriver"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
    	user=request.getParameter("username");
		pass=request.getParameter("password");
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		contact=request.getParameter("contact");
		email=request.getParameter("email");
		
		if(val.validate(user, pass))
		{
			data.setUsername(user);
			data.setPassword(pass);
			data.setFirstname(fname);
			data.setLastname(lname);
			data.setContact(contact);
			data.setEmail(email);
			dm.setUserData(data);		
		}
		else
		response.sendRedirect("index.jsp");
}
}
