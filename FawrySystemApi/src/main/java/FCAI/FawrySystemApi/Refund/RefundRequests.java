package FCAI.FawrySystemApi.Refund;
import java.util.*;

import FCAI.FawrySystemApi.Services.AllServicesController;
import FCAI.FawrySystemApi.Services.Provider;
import FCAI.FawrySystemApi.Services.Service;
import FCAI.FawrySystemApi.Transaction.TransactionInfo;
import FCAI.FawrySystemApi.Transaction.TransactionProcess;

public class RefundRequests {
	
	    Vector<TransactionInfo>refundRequestList=new Vector();
	  
	    private static RefundRequests obj;
		private RefundRequests() {}
		public static RefundRequests getInstance()
	    {
	        if (obj==null)
	            obj = new RefundRequests();
	        return obj;
	    }
        public Vector<TransactionInfo> getAllRefund(){
           return refundRequestList;
        }
   
}
