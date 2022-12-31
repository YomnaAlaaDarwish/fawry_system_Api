package FCAI.FawrySystemApi.Transaction;

import java.util.Vector;

import org.springframework.web.bind.annotation.*;

import FCAI.FawrySystemApi.Services.Service;

@RestController
public class TransactionEndPoint {
	TransactionProcess transactionProcess=new TransactionProcess();
	@GetMapping("/showAllServices")
	public Vector<Service> add_wallet( )
	{
		return transactionProcess.get_services();
	}
	

}
