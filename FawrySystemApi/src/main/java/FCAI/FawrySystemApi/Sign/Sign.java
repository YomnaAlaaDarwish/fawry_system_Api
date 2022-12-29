package FCAI.FawrySystemApi.Sign;
import java.util.*;

import org.springframework.stereotype.Component;

import FCAI.FawrySystemApi.User.*;
@Component
public class Sign {
	public Vector<User>users ;
	public Sign() {
		users = new Vector<User>();
		User s=new User("yomna","123","y.com");
		users.add(s);
		//System.out.println("0");
	}
	public Vector<User> getAllUsers(){
		return users;
	}
}