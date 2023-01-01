package FCAI.FawrySystemApi.Transaction;

import java.util.Vector;

import org.springframework.stereotype.Component;

import FCAI.FawrySystemApi.Discount.TotalDiscount;
import FCAI.FawrySystemApi.Services.*;
import FCAI.FawrySystemApi.Sign.SignController;
import FCAI.FawrySystemApi.User.User;
@Component
public class HandelPaymentProcess {

	TransactionProcess transactionProcess;
	SignController signController;
	TotalDiscount totalDIscount ; 
	PaymentHistory paymentHistory;
	public  HandelPaymentProcess()
	{
		transactionProcess =new TransactionProcess();
		signController=SignController.getInstance();
		totalDIscount=new TotalDiscount() ;
		paymentHistory=PaymentHistory.getInstance();
	}
	
	public Vector<Service> getService()
	{
		return transactionProcess.get_services();
				
	}
	public Vector<String> checkInfo(int id,String service,String provider,String method)
	{
		Vector<String> str=new Vector<String>();
		boolean loged=signController.checkLogIn(id);
		if(!loged)
			str.add(" Error: you must log in first");
		Service s=transactionProcess.choose_Service(service);
		if(s==null)
			str.add("we have not service with this name"); 
		Provider p=transactionProcess.choose_Provider(provider, s);
		if(p==null)
			str.add( "we have not provider for this service with this name"); 
		if(!method.equals("Credit Card") && !method.equals("Wallet") && !method.equals("Cash"))
			str.add( "we have not payment method with this name");
		if(method.equals("Cash")&&!transactionProcess.choose_Payment(p))
			str.add("this provider does not support cash now");
		return str;
	}
	
	public String showPayment(String service, String provider)
	{
		Service s=transactionProcess.choose_Service(service);
		if(s==null)
			return "we have not service with this name"; 
		Provider p=transactionProcess.choose_Provider(provider, s);
		if(p==null)
			return "we have not provider for this service with this name"; 
		if(transactionProcess.choose_Payment(p))
			return "1-Credit Card\n2-Wallet3-Cash\n";
		return"1-Credit Card\n2-Wallet";
	}
	public Vector<String> getForm(int id,String service,String provider,String method)
	{
		Vector<String> str=checkInfo(id,service, provider, method);
		
		if(str.isEmpty())
		{
			Service s=transactionProcess.choose_Service(service);
			Provider p=transactionProcess.choose_Provider(provider, s);
			return p.getForm();
		}
			
		return str;
	}
	public Vector<String> pay(int id,String service,String provider,String method,Vector<String>answer)
	{
		Vector<String> str=checkInfo(id,service, provider, method);
		if(!str.isEmpty())//have error
			return str;
		Service s=transactionProcess.choose_Service(service);
		User user=signController.searchById(id);
		double cost = totalDIscount.getTotalCost(user, s);
		 if(user.getWallet().getAmount()<cost && method.equals("Wallet"))
		 {
			 str.add("oops! your funds in wallet less than you want to pay you can choose diffrent method or add fund to wallet");
			 return str;
		 }
		 transactionProcess.create_payment_method(method , user.getWallet(),cost);
		 TransactionInfo transinfo=new TransactionInfo  (id,service,provider,method,cost,answer);
		 str.add("this is your Transaction id you will need it if you want to refund : "+transinfo.TID);
			 
			 Command command = new AddTransaction(transinfo,paymentHistory);
			 transactionProcess.handel_transaction(command);
			 user.increaseTimesOfPay();
			 str.add(" ****Congratulation you have finished the payment process**** ");
		 
		return str;
		
	}
	
}
