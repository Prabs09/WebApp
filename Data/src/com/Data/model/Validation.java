package com.Data.model;

public class Validation {
		public Validation() {}
		
		public boolean validate(String username,String userpass)
		{
			if((username.length()> 0&& username.length()<= 8)||(userpass.length()> 8 && userpass.length()<15))
			{
				return true;
			}
			return false;
		}
}
