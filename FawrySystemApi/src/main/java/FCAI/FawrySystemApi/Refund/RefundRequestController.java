package FCAI.FawrySystemApi.Refund;
import java.util.Vector;


import org.springframework.stereotype.Component;

import FCAI.FawrySystemApi.Services.AllServicesController;
import FCAI.FawrySystemApi.Services.Provider;
import FCAI.FawrySystemApi.Services.Service;
import FCAI.FawrySystemApi.Sign.SignController;
import FCAI.FawrySystemApi.Transaction.PaymentHistory;
import FCAI.FawrySystemApi.Transaction.TransactionInfo;
import FCAI.FawrySystemApi.Transaction.TransactionProcess;
import FCAI.FawrySystemApi.User.User;
 
public class RefundRequestController {
	 
	Provider provider;
	AllServicesController allServicesController;
	TransactionProcess trans=new TransactionProcess();
	RefundRequests refundrequest ; 
	SignController signController;
	Vector<TransactionInfo>refundRequestList;
	PaymentHistory paymentHistory;
	 
	public RefundRequestController() {
		allServicesController = AllServicesController.getInstance();
		refundrequest = RefundRequests.getInstance() ; 
		signController = SignController.getInstance();
	    refundRequestList = refundrequest.getAllRefund();
	    paymentHistory =PaymentHistory.getInstance();
	}
	// Add refund to the list
	public String add_refund_request(int IDTransaction) {
		boolean check = false;
		 Vector <TransactionInfo> transactionInfo = paymentHistory.getAllTransInfo();
		 for(int i = 0 ;i <transactionInfo.size();i++ ) {
			 if(paymentHistory.getVectorTransactionInfo().get(i).getTID() == IDTransaction) {
				 refundrequest.refundRequestList.add((paymentHistory.getVectorTransactionInfo().get(i)));
				 check = true; 
				 break;
				 
			 }
		 }
		 
		 if(check) {
			return("The request has been sent Successfully");
		 }
		 else {
			 return("There is not Transaction with this ID!!!"); 
		 }
	 }
	
	
	 // Admin reply refund request
	public void addAmounttoWallet(User user , double amount) {
		user.getwallet().addAmount(amount);
	}
	
	 public boolean remove_refund_request(TransactionInfo transinfo , boolean reply) {
		 int UserID = transinfo.getUserID();
    	  
          for(int i =0; i < signController.getsign().users.size() ;i++) {
        	   if(signController.getsign().users.get(i).getID() == UserID) {
        		   
        		   if(reply) {
        			   signController.getsign().users.get(i).setrefundRequestState(true);
        			   addAmounttoWallet(signController.getsign().users.get(i),transinfo.getpayamount());
        		   }
        		   else
        		       signController.getsign().users.get(i).setrefundRequestState(false);
        	   }
          }
          for(int i = 0; i < refundrequest.refundRequestList.size() ;i++) {
  		    if(refundrequest.refundRequestList.get(i).getTID() ==  transinfo.getTID()) {
		    	 refundrequest.refundRequestList.remove(i);
		    	 return true;
	         }
		 
	    }
        return false;
     }
	 
	///maram phase 2
		 public  String displayrefundRequest() {
			 if(refundRequestList.isEmpty()) {
				 return "There is not refund request list";
			 }
			 else {
				 String s2 = "";
				 String s1 = "userID : " + refundRequestList.get(0).getUserID() +"\n"+
						 "servicename : " + refundRequestList.get(0).getServicename() + "\n"+
						 "providername : " + refundRequestList.get(0).getProvidername() + "\n" +
						 "paymentmethod : " + refundRequestList.get(0).getpaymentmethod() + "\n" +
						 "payamount : " +refundRequestList.get(0).getpayamount() + "\n" ;
				 Service service = allServicesController.search(refundRequestList.get(0).getServicename());
				 provider = trans.choose_Provider(refundRequestList.get(0).getProvidername(),service);
				 for(int i=0;i < provider.getForm().size();i++) {
				    s2 += (i + 1+ " - " + provider.getForm().get(i) + " : " + refundRequestList.get(0).getAnswer().get(i))+ "\t";
			     }
				 return s1 + s2;
	  	
		     }
	  
        }
}