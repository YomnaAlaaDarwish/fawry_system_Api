package FCAI.FawrySystemApi.Sign;
import java.util.*;

import org.springframework.stereotype.*;

import FCAI.FawrySystemApi.Admin.Admin;
import FCAI.FawrySystemApi.Services.AllServicesController;
import FCAI.FawrySystemApi.User.*;


public class SignController {
	Sign sign ;
	Vector<Integer>LoginUsersId;
	Vector<Integer>LoginAdminId;
	private static SignController obj;
	public SignController() 
	{
		sign = new Sign();
		LoginUsersId = new Vector<Integer> ();
		LoginAdminId = new Vector<Integer> ();
	}
	public static SignController getInstance()
    {
        if (obj==null)
        {
        	 obj = new SignController();
        }
        return obj;
    }
	public User signIn(String userName,String password) {
		User user;
		user =search(userName,password);
		if(user!=null)
		{
			if(!checkLogIn(user.getID()))
				LoginUsersId .add(user.getID());
		}
			
		return user;

	}
	// maram
	public Admin signInAdmin(String userName,String password) {
		Admin admin;
		admin = searchAdmin(userName,password);
		if(admin != null)
		{
				if(!checkLogInAdmin(admin.getID())) {
				LoginAdminId.add(admin.getID());
			}
		}
		return admin;
	}
	public boolean checkLogInAdmin(int id)
	{
		for(int i=0;i<LoginAdminId.size();i++)
		{
			if(LoginAdminId.get(i)==id)
				return true;	
		}
		return false;
	}
	public Admin searchAdmin(String userName,String password) {
		if(sign.admins != null ) 
		{
			for(int i=0;i< sign.admins.size();i++)
			{
				if(sign.admins.get(i).getUserName().equals(userName) && sign.admins.get(i).getPassword().equals(password))
				{
					return sign.admins.get(i);
				}
			}
		}
		return null;
	}
	
	public Admin searchAdmin(int id) {
		if(sign.admins != null ) 
		{
			for(int i=0;i< sign.admins.size();i++)
			{
				if(sign.admins.get(i).getID() == id)
				{
					return sign.admins.get(i);
				}
			}
		}
		return null;
	}
	////
	public boolean checkLogIn(int id)
	{
		for(int i=0;i<LoginUsersId.size();i++)
		{
			if(LoginUsersId.get(i)==id)
				return true;
				
		}
		return false;
	}

	public User search(String userName,String password) {
		if(sign.users != null ) 
		{
			for(int i=0;i< sign.users.size();i++)
			{
				
				if(sign.users.get(i).getUserName().equals(userName) && sign.users.get(i).getPassword().equals(password))
				{
					return sign.users.get(i);
				}
			}
		}
		return null;
	}
	
	
    public User signUp(String userName,String password,String email ) {
		User newUser = new User(userName,password,email);
		sign.users.addElement(newUser);
		LoginUsersId .add(newUser.getID());
		return newUser;
	}
    
    public User searchById(int id)
    {
    	for(int i=0;i< sign.users.size();i++)
		{
		
			if(sign.users.get(i).getID()==id)
			{
				return sign.users.get(i);
			}
		}
    	return null;
    }

    public Sign getsign(){
		return sign;
	}
    public boolean logout(int id)
    {
    	User s=searchById(id);
    	if(s!=null)
    	{
    		LoginUsersId.removeElement(id);
    		return true;
    	}
    	return false;
    }
    
}
