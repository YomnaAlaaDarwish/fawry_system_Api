package FCAI.FawrySystemApi.Transaction;
import java.util.*;

//import org.springframework.stereotype.Component;
//@Component
public class PaymentHistory {

	public Vector<TransactionInfo>transactionInfo ;

	private static PaymentHistory obj;
	private PaymentHistory() {transactionInfo =new Vector<TransactionInfo>();}
	public static PaymentHistory getInstance()
    {
        if (obj==null)
            obj = new PaymentHistory();
        return obj;
    }
	public boolean addTrancation(TransactionInfo trans) {
		transactionInfo.add(trans);
		return true;
	}
	  
	public Vector<TransactionInfo> getAllTransInfo(){
		return transactionInfo;
	}
	public boolean removeTrancation(TransactionInfo trans) {
		return transactionInfo.remove(trans);
	}
	
	public Vector <TransactionInfo> getVectorTransactionInfo()
    {
        return transactionInfo;
    }
	
	
}
