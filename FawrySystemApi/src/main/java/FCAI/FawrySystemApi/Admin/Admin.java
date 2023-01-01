package FCAI.FawrySystemApi.Admin;
import java.util.Vector;

import FCAI.FawrySystemApi.Refund.RefundRequestController;
import FCAI.FawrySystemApi.Services.*;

public class Admin {
	
	int Id;
	String userName;
	String password;
	
	static int SId;
	static {
		SId = 100;
	}
	
	RefundRequestController refundRequestController;
	
	public Admin(RefundRequestController refundRequestControlle) {
		
		this.refundRequestController = refundRequestControlle;
	}
	public Admin(String userName,String password) {
		this.userName = userName;
		this.password = password;
		Id =SId;
		SId++;
	}
	public Admin() {
	
	}
	public int getID()
	{
		return Id;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	
    public void addServiceProvider(Service service,String provider_name,Vector<String> vec,boolean acceptCash) {
    	Provider provider=new Provider( provider_name, vec, acceptCash);
    	service.setProvider(provider);
		
	}

}
