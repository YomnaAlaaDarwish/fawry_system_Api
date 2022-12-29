package AddToWallet;
import Payment.*;
import Sign.*;
import User.*;
public class HandellAddToWallet {
	
	WalletHistory walletHistory;
	WalletTransaction walletTrans;
	SignController signController;
	public void addWalletTransaction(int id,double x)
	{
		IPayment payment=new CreditPayment();
		User user=signController.searchById(id);
		payment.pay(x);
		user.addToWallet(x);
		walletTrans=new WalletTransaction(user,x);
		walletHistory.addRecord(walletTrans);
	}
	
	
}
