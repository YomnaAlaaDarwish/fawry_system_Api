package FCAI.FawrySystemApi.Transaction;
import java.util.Vector;

public class TransactionInfo {
	int TID;  // tranaction ID
	static int id;
	static {
		id = 1;
	}
	int userID;
	String servicename;
	String providername;
	String paymentmethod;
	double payamount;
	Vector<String> answer;
	
	public TransactionInfo(int id,String servicename,String providername,String paymentmethod,double payamount,Vector<String> answer)
	{
		this.servicename = servicename;
		this.providername = providername;
		this.paymentmethod = paymentmethod;
		this.payamount = payamount;
		this.answer=answer;
		userID=id;
		TID = id;
		id++;
	}
	public String  getProvidername()
    {
        return providername;
    }
	public String  getServicename()
    {
        return servicename;
    }
	public int  getUserID()
    {
        return userID;
    }
	public int  getTID()
    {
        return TID;
    }
	public String  getpaymentmethod()
    {
        return paymentmethod;
    }
	public double  getpayamount()
    {
        return payamount;
    }
	public Vector<String> getAnswer(){
		return answer;
	}
}
