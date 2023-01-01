package FCAI.FawrySystemApi.AddToWallet;
import java.util.*;

import FCAI.FawrySystemApi.Transaction.PaymentHistory;
import FCAI.FawrySystemApi.Transaction.TransactionInfo;

public class WalletHistory {
	Vector<WalletTransaction> allhistory;
	private static WalletHistory obj;
	private WalletHistory() { allhistory=new Vector<WalletTransaction>();}
	public static WalletHistory getInstance()
    {
        if (obj==null) 
            obj = new WalletHistory();
        return obj;
    }
	public void addRecord(WalletTransaction w)
	{
		allhistory.add(w);
	}
	public Vector<WalletTransaction>   getAllhistory()
	{
		return allhistory;
	}
	
}
