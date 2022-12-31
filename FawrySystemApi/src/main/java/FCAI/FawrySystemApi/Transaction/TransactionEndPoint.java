package FCAI.FawrySystemApi.Transaction;

import java.util.Vector;

import org.springframework.web.bind.annotation.*;

import FCAI.FawrySystemApi.Services.*;

@RestController
public class TransactionEndPoint {
	HandelPaymentProcess handel=new HandelPaymentProcess();
	@GetMapping("/showAllServices")
	public Vector<Service> showAllServices()
	{
		return handel.getService();
	}
	@GetMapping("/showPaymentMethod/{service}/{provider}")
	public String showPaymentMethod(@PathVariable("service") String service,@PathVariable("provider") String provider)
	{
		return handel.showPayment(service, provider);
	}
	@GetMapping("/getForm/{id}/{service}/{provider}/{method}")
	public Vector<String> getForm(@PathVariable("id") int id,@PathVariable("service") String service,@PathVariable("provider") String provider,@PathVariable("method") String method)
	{
		return handel.getForm(id,service, provider,method);
	}
	@PostMapping("/pay/{id}/{service}/{provider}/{method}")
	public Vector<String> pay(@PathVariable("id") int id,@PathVariable("service") String service,@PathVariable("provider") String provider,@PathVariable("method") String method,@RequestBody Vector<String>answer)
	{
		return handel.pay(id,service, provider,method,answer);
	}
	
	
	

}
