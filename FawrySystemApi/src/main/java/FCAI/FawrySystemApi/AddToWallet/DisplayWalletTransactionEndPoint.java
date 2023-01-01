package FCAI.FawrySystemApi.AddToWallet;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import FCAI.FawrySystemApi.Services.Service;
@RestController
public class DisplayWalletTransactionEndPoint {
	@GetMapping("/displayWallet/{ID}")
	public Vector<WalletTransaction> displayWallet(@PathVariable("ID") int id){
		WalletHistory w=new WalletHistory();
		return w.getAllhistory();
	}
	
}
