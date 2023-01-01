package FCAI.FawrySystemApi.User;
public class Wallet {
	double amount;
	public Wallet()
	{
		amount=0;
	}
	public void addAmount(double x)
	{
		amount+=x;
	}
	public boolean consumeAmount(double x)
	{
		if(amount>=x)
		{
			amount-=x;
			return true;
		}
		else //not valid 
		{
			return false;
		}
		
	}
	public double getAmount()
	{
		return amount;
	}

}
