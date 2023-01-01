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

@RestController
public class addServiceProvider_EP {
	
	  AllServicesController allServicesController;
	
	public addServiceProvider_EP() {
		allServicesController=AllServicesController.getInstance();
	}
	
	@PostMapping(value="/providers/{str}")
	public String addServiceProvider(@RequestBody Provider provider,@PathVariable("str")String str) {
		Service service;
	    service = allServicesController.search(str);
		if(service==null)
			return "service not found";
		
	    Admin admin= new Admin();
	    admin.addServiceProvider(service,provider.name,provider.form,provider.accept_cash);

		return "add successfully";
	}

}
