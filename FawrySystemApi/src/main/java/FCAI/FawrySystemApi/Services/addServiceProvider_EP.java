package FCAI.FawrySystemApi.Services;


import java.util.Scanner;
import java.util.Vector;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FCAI.FawrySystemApi.Admin.Admin;
import FCAI.FawrySystemApi.Sign.SignController;

@RestController
public class addServiceProvider_EP {
	
	AllServicesController allServicesController;
    SignController signController;
	public addServiceProvider_EP() {
		allServicesController=AllServicesController.getInstance();
		signController=SignController.getInstance();
	}
	
	@PostMapping(value="/providers/{str}/{id}")
	public String addServiceProvider(@RequestBody Provider provider,@PathVariable("str")String str, @PathVariable("id") int id) {
	   if(signController.checkLogInAdmin(id)) {
			Service service;
		    service = allServicesController.search(str);
			if(allServicesController.search(str)==null)
				return "service not found";
			
		    Admin admin = signController.searchAdmin(id);
		    
		    admin.addServiceProvider(service,provider.name,provider.form,provider.accept_cash);
	
			return "add successfully";
	 }
	 else {
		return "You have to sign in First !!!!";
	 }

   }
}
