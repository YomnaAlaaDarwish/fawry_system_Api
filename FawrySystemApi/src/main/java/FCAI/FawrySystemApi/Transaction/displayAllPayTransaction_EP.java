package FCAI.FawrySystemApi.Transaction;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class displayAllPayTransaction_EP {
	
	PaymentHistory pay;
	
	public displayAllPayTransaction_EP(){
		
		pay =PaymentHistory.getInstance();
	}
	
	@GetMapping(value="/showPayHistory")
	public Vector<TransactionInfo>  displayAllPayTrans(){
		return pay.getAllTransInfo();
		
	}

}
