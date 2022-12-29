package FCAI.FawrySystemApi.AddToWallet;
import org.springframework.stereotype.Component;

import FCAI.FawrySystemApi.Payment.*;

import FCAI.FawrySystemApi.Sign.*;
import FCAI.FawrySystemApi.User.*;

@Component
public class HandellAddToWallet {
	
	WalletHistory walletHistory;
	WalletTransaction walletTrans;
	SignController signController;
	public HandellAddToWallet()
	{
		 walletHistory=new WalletHistory();
		 signController=new SignController();
	}
	public String addWalletTransaction(int id,double x)
	{
		boolean loged=signController.chekLogIn(id);
		if(loged)
		{
			IPayment payment=new CreditPayment();
			User user=signController.searchById(id);
			payment.pay(x);
			user.addToWallet(x);
			walletTrans=new WalletTransaction(user,x);
			walletHistory.addRecord(walletTrans);
			return"You have added "+x+" to wallet successfully and the total fund you have noe in wallet = "+user.getWalletAmount();
		}
		return" Error: you must log in first";
		
	}
	
	
}
