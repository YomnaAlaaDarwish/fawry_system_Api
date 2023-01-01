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
	static AllServicesController allServicesController=new AllServicesController();
	
	
	@GetMapping(value="/search/{str}")
	public static Service searchForService(@PathVariable("str")String str) {
		Service test = new Service("orange",50);
		allServicesController.AddService(test);
		Service service;
	    service = allServicesController.search(str);
	    return service;
	}
			

	
	@PostMapping(value="/providers/{str}")
	public static String addServiceProvider(@RequestBody Provider provider,@PathVariable("str")String str) {
		Service service;
		Service test = new Service("orange",50);
		allServicesController.AddService(test);
	    service = allServicesController.search(str);
		if(service==null)
			return "service not found";
		
	    Admin admin= new Admin();
	    admin.addServiceProvider(service,provider.name,provider.form,provider.accept_cash);

		return "add successfully";
	}

}
