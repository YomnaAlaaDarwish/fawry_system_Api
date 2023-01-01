package FCAI.FawrySystemApi.Transaction;

import FCAI.FawrySystemApi.Refund.RefundRequestController;

public class DeleteTransaction implements Command {
	TransactionInfo transinfo;
	PaymentHistory payHist;
	RefundRequestController refundRequestController;
	boolean reply;
	
	public DeleteTransaction(TransactionInfo trans,PaymentHistory history,RefundRequestController refundRequestController,boolean reply){
		this.payHist=history;
		this.refundRequestController=refundRequestController;
		this.transinfo=trans;
		this.reply = reply;
		
	}
     
	@Override
	public boolean execute() {
		if(payHist.removeTrancation(transinfo) && refundRequestController.remove_refund_request(transinfo,reply)) {
			return true;
		}
		return false;
		
		
	}
		
}


