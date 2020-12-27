package com.Data.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Data.beans.UserBean;

public class DataManager {
	private String dbURL;
	private String dbUserName;
	private String dbPassword;
	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	public Connection getConnection()
	{
		Connection con=null;
		try {
				con = DriverManager.getConnection(getDbURL(),getDbUserName(),getDbPassword());
		}
		catch (Exception e)
		{
			System.out.println("test");
			e.printStackTrace();
		}
		return con;
	}
	
	public void putConnection(Connection con)
	{
		if(con != null)
		{
			try {
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public UserBean getUserData(String username, String password)
	{
		UserBean user=new UserBean();
		Connection con=getConnection();
		if(con != null)
		{
			ResultSet rs= null;
			PreparedStatement st= null;
			try
			{
				String query="select firstname,lastname,contact,email from user where username=? and password=?";
				st=con.prepareStatement(query);
				st.setString(1, username);
				st.setString(2, password);
				rs=st.executeQuery();
				
				while(rs.next())
				{
					user.setContact(rs.getString("contact"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					rs.close();
					st.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				putConnection(con);
			}
		}
		return user;
	}
}
