package AddToWallet;

import User.User;

public class WalletTransaction {

	User user;
	double amount;
	public WalletTransaction(User u,double x)
	{
		user=u;
		amount=x;
	}
}
