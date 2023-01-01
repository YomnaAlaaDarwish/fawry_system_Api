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
	/*public  WalletHistory()
	{
		allhistory=new Vector();
	}*/
	public void addRecord(WalletTransaction w)
	{
		System.out.println("Record");
		allhistory.add(w);
		System.out.println(allhistory.size());
	}
	public Vector<WalletTransaction>   getAllhistory()
	{
		System.out.println("Yomna"+allhistory.size());
		return allhistory;
	}
	
}
