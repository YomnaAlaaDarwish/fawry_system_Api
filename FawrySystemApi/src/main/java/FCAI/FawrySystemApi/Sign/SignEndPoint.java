package FCAI.FawrySystemApi.Sign;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import FCAI.FawrySystemApi.User.User;

@RestController
public class SignEndPoint {
	SignController signController=new SignController();
	//@PathVariable("id") int id 
	@GetMapping("/s")
	public String signin(@RequestBody User user)
	{
		return user.getUserName();
	}
	
}
