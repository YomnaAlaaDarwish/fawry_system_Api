package FCAI.FawrySystemApi.AddToWallet;

import FCAI.FawrySystemApi.User.User;

public class WalletTransaction {
    
	User user;
	double amount;
	public WalletTransaction(User u,double x)
	{
		System.out.println(x);
		user=u;
		amount=x;
	}
}
