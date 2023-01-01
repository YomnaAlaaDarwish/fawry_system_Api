package FCAI.FawrySystemApi.Sign;
import java.util.*;

import org.springframework.stereotype.Component;

import FCAI.FawrySystemApi.Admin.Admin;
import FCAI.FawrySystemApi.Transaction.TransactionInfo;
import FCAI.FawrySystemApi.User.*;
@Component
public class Sign {
	public Vector<User>users ;
	
	public Sign() {
		users = new Vector<User>();
		User s=new User("yomna","123","y.com");
		users.add(s);
		//System.out.println("0");
		
		//maram
		admins = new Vector<Admin>();
		Admin admin =new Admin("HassanMourad","7856924");
		admins.add(admin);
	}
	public Vector<User> getAllUsers(){
		return users;
	}
	
	//maram
		public Vector<Admin> admins;
		
	
}