package FCAI.FawrySystemApi.Discount;

import org.springframework.web.bind.annotation.*;
import FCAI.FawrySystemApi.Services.*;
import FCAI.FawrySystemApi.User.User;
@RestController
public class DiscountEndPoint {
	
	AllServicesController allServicesController; 
	TotalDiscount totalDIscount;
	
	public  DiscountEndPoint() {
		//allServicesController =new AllServicesController();
		allServicesController= AllServicesController.getInstance();
		totalDIscount=new TotalDiscount();
	}
	
	//add discount
	//specific
	@PostMapping("/addSpecificDiscount/{name}/{amount}")
	public String addSpecificDiscount(@PathVariable("name") String name,@PathVariable("amount") double amount)
	{
		Service service =allServicesController.search(name);
		service.setSpceficDiscount(amount/100.0);
		return "We Added Specific Discount";
	}
	//overall
	@PostMapping("/addOverallDiscount/{number}/{amount}")
	public String addOverallDiscount(@PathVariable("number") int number,@PathVariable("amount")double amount)
	{
		totalDIscount.setOverallDiscount(number, amount/100);
		
		return "We Added Overall Discount";
	}
	
	//Maram
	@GetMapping(value = "/CheckDiscount/{name}") 
	public String DisplayRefund(@PathVariable("name") String name) {
		//refundRequestController.displayrefundRequest(refundRequestController.refundRequestList.get(0)); 
		return allServicesController.CheckDiscountOnService(name);
	}
}
