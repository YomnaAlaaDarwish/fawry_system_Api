package FCAI.FawrySystemApi.Sign;
import java.util.*;

import org.springframework.stereotype.*;

import FCAI.FawrySystemApi.Services.AllServicesController;
import FCAI.FawrySystemApi.User.*;


public class SignController {
	Sign sign ;
	Vector<Integer>LoginUsersId;
	//Vector<User>users = new ;
	private static SignController obj;
	public SignController() 
	{
		sign = new Sign();
		LoginUsersId = new Vector<Integer> ();
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
		//System.out.println("id"+user.getID());
		if(user!=null)
		{
			//System.out.println("befor"+LoginUsersId.size());
			if(!checkLogIn(user.getID()))
				LoginUsersId .add(user.getID());
			//System.out.println("aft"+LoginUsersId.size());
		}
			
		return user;

	}
	public boolean checkLogIn(int id)
	{
		//System.out.println("ch"+LoginUsersId.size());
		for(int i=0;i<LoginUsersId.size();i++)
		{
			//System.out.println("for"+id+" "+LoginUsersId.get(i));
			if(LoginUsersId.get(i)==id)
				return true;
				
		}
		return false;
	}

	public User search(String userName,String password) {
		//System.out.println(sign.users.size());
		if(sign.users != null ) 
		{
			//System.out.println("1");
			for(int i=0;i< sign.users.size();i++)
			{
				//System.out.println(sign.users.get(i).getUserName()+" "+sign.users.get(i).getPassword()+" "+userName+" "+password);
			
				if(sign.users.get(i).getUserName().equals(userName) && sign.users.get(i).getPassword().equals(password))
				{
					//System.out.println("2");
					//System.out.println(sign.users.get(i).getUserName() + sign.users.get(i).getPassword());
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
		//users.addElement(newUser);
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
    
}
