package FCAI.FawrySystemApi.Transaction;

public class AddTransaction implements Command {
	TransactionInfo transinfo;
	PaymentHistory payHist;
	
	public AddTransaction(TransactionInfo trans,PaymentHistory history){
		this.transinfo=trans;
		this.payHist=history;
		
	}

	@Override
	public boolean execute() {
		if(payHist.addTrancation(transinfo)) {
			System.out.println(payHist.transactionInfo.size());
			return true;
		}
		return false;
		
	}
}
