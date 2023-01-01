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
		 walletHistory= WalletHistory.getInstance() ;
		 //signController=new SignController();
		 signController=SignController.getInstance();
	}
	public String addWalletTransaction(int id,double x)
	{
		if(x<=0)
			return "You can not add 0 or negative value";
		boolean loged=signController.checkLogIn(id);
		//System.out.println(loged);
		if(loged)
		{
			System.out.println("i reach");
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
