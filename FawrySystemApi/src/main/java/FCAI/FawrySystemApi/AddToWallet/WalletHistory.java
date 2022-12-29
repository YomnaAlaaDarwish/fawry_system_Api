package FCAI.FawrySystemApi.AddToWallet;
import java.util.*;

public class WalletHistory {
	Vector<WalletTransaction> allhistory;
	
	public  WalletHistory()
	{
		allhistory=new Vector();
	}
	public void addRecord(WalletTransaction w)
	{
		allhistory.add(w);
	}
	public Vector<WalletTransaction> getAllhistory()
	{
		return allhistory;
	}
	
}
