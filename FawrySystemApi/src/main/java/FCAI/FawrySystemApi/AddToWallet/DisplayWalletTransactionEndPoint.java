package FCAI.FawrySystemApi.AddToWallet;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import FCAI.FawrySystemApi.Services.Service;
import FCAI.FawrySystemApi.Sign.SignController;
@RestController
public class DisplayWalletTransactionEndPoint {
	WalletHistory w;
	SignController signController;
	
	public DisplayWalletTransactionEndPoint() {
	    w = WalletHistory.getInstance();
	    signController=SignController.getInstance();
	}
	@GetMapping("/displayWallet/{ID}")
	public Vector<WalletTransaction> displayWallet(@PathVariable("ID") int ID){
		Vector<WalletTransaction> allhistory = w.getAllhistory();
		return allhistory;
	}
	
}
