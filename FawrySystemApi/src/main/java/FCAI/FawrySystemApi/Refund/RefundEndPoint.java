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
		if(signController.checkLogInAdmin(id)) {
		   return refundRequestController.displayrefundRequest(); 
		}
		else {
			return "You have to sign in First !!!!";
		}
	}
	
	
}


