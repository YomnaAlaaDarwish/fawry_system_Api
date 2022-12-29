package Sign;
import java.util.Vector;
import User.*;

public class SignController {
	Sign sign = new Sign();
	Vector<Integer>LoginUsersId = new Vector();
	//Vector<User>users = new ;
	public User signIn(String userName,String password) {
		User user;
		user =search(userName,password);
		LoginUsersId .add(user.id);
		return user;

	}
	public boolean chekLogIn(int id)
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
		LoginUsersId .add(user.id);
		//users.addElement(newUser);
		return newUser;
	}
    
    public User searchById(int id)
    {
    	for(int i=0;i< sign.users.size();i++)
		{
		
			if(sign.users.get(i).getID())
			{
				return sign.users.get(i);
			}
		}
    	
    }
    
}
