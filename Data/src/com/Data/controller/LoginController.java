package com.Data.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Data.beans.UserBean;
import com.Data.model.DataManager;
import com.Data.model.Validation;


public class LoginController extends HttpServlet {
	private boolean dbOK=false;
	private String sterror;
	private UserBean user;
	private static final long serialVersionUID = 1L;
	private Validation val=new Validation();
	private DataManager dm=new DataManager();
	public void init(ServletConfig conf)
	{
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
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("user");
	String userpass=request.getParameter("pass");

		
		if(val.validate(username, userpass))
		{
			user=new UserBean();
			user=dm.getUserData(username, userpass);
			if(!user.getFirstname().equals(null))
			{
				dbOK=true;
			}
		}
		else
		{
		    sterror="check username and password again";
			dbOK=false;
		}
		HttpSession session=request.getSession(true);
		
		if(dbOK)
		{
			session.setAttribute("userdata", user);
			RequestDispatcher rd=request.getRequestDispatcher("/data.jsp");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("error", sterror);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
		}
	}

}
