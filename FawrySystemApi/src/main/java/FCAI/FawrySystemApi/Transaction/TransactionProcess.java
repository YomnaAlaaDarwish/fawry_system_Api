package FCAI.FawrySystemApi.Transaction;
import java.util.Vector;

import FCAI.FawrySystemApi.Payment.*;
import FCAI.FawrySystemApi.Services.*;
import FCAI.FawrySystemApi.User.Wallet;

public class TransactionProcess {
	IPayment payment;
	AllServicesController all_service_control;
	public TransactionProcess() {
		//all_service_control = new AllServicesController();
		all_service_control = AllServicesController.getInstance();
	}
	public Vector<Service> get_services(){
		return all_service_control.getAllService();
	}
	
	public Service choose_Service(String serviceName) {
		return all_service_control.search(serviceName);
	}
	
	public Vector<Provider> get_provider(Service service) {
		
		return service.getProviders();
	}
	
	public Provider choose_Provider(String providerName,Service service) {
		ServiceController service_control = new ServiceController(service);
		return service_control.SearchProvider(providerName);
	}
	
	public boolean choose_Payment(Provider provider) {
		return provider.checkCash();
	}
	
	public void create_payment_method(String type,Wallet wallet,double cost) {
		if(type.equals("Cash"))
			payment=new CashPayment();
		else if(type.equals("Credit Card"))
			payment=new CreditPayment();
		else if(type.equals("Wallet"))
		{
			if(wallet !=null) {
				payment=new WalletPayment(wallet);
			}
		}
			
		else 
			payment=new CreditPayment();
		payment.pay(cost);

			
	}
	public boolean handel_transaction(Command c) {
		
		return c.execute();
			
	}
	
	public TransactionInfo set_transaction_info(int id,String servicename,String providername,String paymentmethod,double payamount,Vector<String>answer) {
		TransactionInfo transinfo=new TransactionInfo( id, servicename, providername, paymentmethod, payamount,answer);
		return transinfo;
	}
	
	
}


