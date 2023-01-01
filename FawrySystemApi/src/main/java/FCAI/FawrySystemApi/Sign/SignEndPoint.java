package FCAI.FawrySystemApi.Sign;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import FCAI.FawrySystemApi.Admin.Admin;
import FCAI.FawrySystemApi.User.User;

@RestController
public class SignEndPoint {
	SignController signController;
	
	public  SignEndPoint() 
	{
		 //signController=new SignController();
		signController = SignController.getInstance();
	}
	@GetMapping("/signin/{UserName}/{password}")
	public String signin(@PathVariable("UserName") String name,@PathVariable("password")String password)
	{
		User user=null;
		user=signController.signIn(name,password);
		
		if(user!=null)
			return "Welcome "+user.getUserName()+"your id is:"+user.getID()+" you will need to path it in the url later";
			
		return " oops! we are not found you can you sign up ?or try again";
	}
	
	@PostMapping("/signup/{UserName}/{password}/{Email}")
	public String signup(@PathVariable("UserName") String name,@PathVariable("password")String password,@PathVariable("Email")String Email)
	{
		User user=null;
		user=signController.signUp(name,password,Email);
		
			return "Welcome "+user.getUserName()+"your id is:"+user.getID()+" you will need to path it in the url later";
			
	}
	@PostMapping("/logout/{id}")
	public String User_logout(@PathVariable("id") int id)
	{
		if(signController.logout(id))
			return"see you soon :)";
		
			return "you cannot logout because you dont log in";
			
	}
	
	// Maram
	@GetMapping("/signInAdmin/{UserName}/{password}")
	public String signInAdmin(@PathVariable("UserName") String name,@PathVariable("password")String password)
	{
		Admin admin=null;
		admin = signController.signInAdmin(name,password);
		
		if(admin!=null)
			return "Welcome "+admin.getUserName()+"your id is:"+admin.getID()+" you will need to path it in the url later";
			
		return " oops! we are not found you can you sign up ?or try again";
	}
	
}
