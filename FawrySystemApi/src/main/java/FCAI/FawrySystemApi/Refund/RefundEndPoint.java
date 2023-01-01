package FCAI.FawrySystemApi.Refund;

import org.springframework.web.bind.annotation.*;

import FCAI.FawrySystemApi.Services.AllServicesController;
import FCAI.FawrySystemApi.Sign.SignController;
import FCAI.FawrySystemApi.Transaction.Command;
import FCAI.FawrySystemApi.Transaction.PaymentHistory;
import FCAI.FawrySystemApi.Transaction.DeleteTransaction;
import FCAI.FawrySystemApi.Transaction.TransactionProcess;


@RestController
public class RefundEndPoint {
	
	SignController signController;
	AllServicesController allServicesController;
    PaymentHistory paymentHistory;
    TransactionProcess trans=new TransactionProcess();
	private RefundRequestController refundRequestController;
	
   
	public RefundEndPoint(){
		
		refundRequestController = new RefundRequestController();
		allServicesController= AllServicesController.getInstance();
		signController=SignController.getInstance();
		paymentHistory =PaymentHistory.getInstance();
	}
	///Customer request refund
	@GetMapping(value = "/AskForRefund/{TID}") 
	public String AskRefund(@PathVariable("TID") int TID) {
		 return refundRequestController.add_refund_request(TID);
	}
	
	//Admin reply refund
	@PostMapping(value = "/ReplyRefund/{TID}/{answer}") 
	public String ReplyRefund(@PathVariable("TID") int TID,@PathVariable boolean answer) {
		if(!refundRequestController.refundRequestList.isEmpty()) {
		   Command command;
		   command = new DeleteTransaction(refundRequestController.refundRequestList.get(0),paymentHistory,refundRequestController,answer);
	     //  trans.handel_transaction(command);
	       if(trans.handel_transaction(command)) {
				return "The reply done :) ,  And this Transaction deleted from PaymentHistory ";
			}
			else {
				return "Faild Send Reply Again";
			}
		}
		else {
			return "There is not refund requests :)";
		}
	        
	}
	///Admin Show  refund request
	@GetMapping(value = "/DisplayRefund/{id}") 
	public String DisplayRefund(@PathVariable("id") int id) {
		//refundRequestController.displayrefundRequest(refundRequestController.refundRequestList.get(0)); 
		if(signController.checkLogInAdmin(id)) {
		   return refundRequestController.displayrefundRequest(); 
		}
		else {
			return "You have to sign in First !!!!";
		}
	}
	
	
}

/*
// User Add refund to list
	public static void requestrefund()
	{
		//Enter ID Transaction
		 System.out.println("Enter Your ID Transaction : ");
         Scanner obj1 = new Scanner(System.in);
         int TransID = obj1.nextInt();
         // call fun Add to refund list 
         boolean reply = refundRequestController.add_refund_request(TransID);
		 if(reply)
			 System.out.println("The request has been sent Successfully"); 
		 else
			 System.out.println("There is not Transaction with this ID!!!"); 
	}
	// Admin  reply refund 
	public static void replyrefund()
	{
		 Command command ;
		 int Continue = 0;
		 boolean answer = false;
	     // Enter yes if you want to reply the next reply
		do {
			 System.out.println("Enter 1 or 2 if you want to reply the next reply : ");
	         System.out.println("1-Yes\n 2-No");
	         Scanner obj1 = new Scanner(System.in);
	         Continue = obj1.nextInt();
	         displayrefundRequest(refundRequestController.refundRequestList.get(0));
	        // Enter reply 
	         System.out.println("Enter 1 or 2 reply : ");
	         System.out.println("1- Yes\n 2- No");
	         Scanner obj2 = new Scanner(System.in);
	         int reply = obj2.nextInt();
	         if(reply == 1) 
	        	  answer = true;
	         else if(reply == 2)
	        	  answer = false;
			 command = new DeleteTransaction(refundRequestController.refundRequestList.get(0),paymentHistory,refundRequestController,answer);
	         trans.handel_transaction(command);
		}while(Continue == 1 && (!refundRequestController.refundRequestList.isEmpty()));
		
		 
	}
	
*/	




/*
 public static void displayrefundRequest(TransactionInfo refundRequests) {
		 System.out.println("userID : " + refundRequests.userID);
		 System.out.println("servicename : " + refundRequests.servicename);
		 System.out.println("providername : " + refundRequests.providername);
		 System.out.println("paymentmethod : " + refundRequests.paymentmethod);
		 System.out.println("payamount : " +refundRequests.payamount);
		 Service service = allServicesController.search(refundRequests.servicename);
		 provider = trans.choose_Provider(refundRequests.providername,service);
		 for(int i=0;i<provider.form.size();i++) {
		    System.out.println(i + 1+ " - " + provider.form.get(i) + " : " + refundRequests.answer.get(i) );
		 }
	}
 */


