package FCAI.FawrySystemApi.AddToWallet;
import org.springframework.web.bind.annotation.*;

@RestController
public class AWEndPoint {
	HandellAddToWallet handel;
	public  AWEndPoint() 
	{
		handel=new HandellAddToWallet();
	}
	@PostMapping("/addToWallet/{id}/{fund}")
	public String add_wallet(@PathVariable("id") int id,@PathVariable("fund") double fund )
	{
		return handel.addWalletTransaction(id,fund);
	}
	
}
