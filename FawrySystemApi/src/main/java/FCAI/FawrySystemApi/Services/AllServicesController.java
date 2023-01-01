package FCAI.FawrySystemApi.Services;

import java.util.Vector;

import org.springframework.stereotype.Component;

@Component
public class AllServicesController {
	
	
   static AllService allService = AllService.getInstance();
    
    //static int i=0;
    private static AllServicesController obj = null;
   private AllServicesController()
    {}
	public static AllServicesController getInstance()
    {
        if (obj==null)
        {
        	 obj = new AllServicesController();
        	 intial();
        }
        return obj;
    }
    private static void intial() {//to initialize the system with some service 
        
		AllMainServicesControlles allMainServicesControlles = AllMainServicesControlles.getInstance();
		Vector<String> v = new Vector();
		v.add("Your mobile: ");	
		v.add("amount: ");
		//providers
				Provider p = new Provider("vodafoneCash", v,false); 
				
			    //  Service1
				MainServices mainServices1 = new MainServices();
				
				mainServices1.setservicename("Mobile recharge services");
				Service s1 = new Service("Vodafone Mobile",50);
				s1.setProvider(p);
				AddService(s1);
				s1.setProvider(p);
				mainServices1.addService(s1);
				Service s2 = new Service("Etisalat Mobile",60);
				s2.setProvider(p);
				AddService(s2);
				s2.setProvider(p);
				mainServices1.addService(s2);
				Service s3 = new Service("Orange Mobile",70);
				s3.setProvider(p);
				AddService(s3);
				s3.setProvider(p);
				mainServices1.addService(s3);
				Service s4 = new Service("We Mobile",40);
				s4.setProvider(p);
				AddService(s4);
				mainServices1.addService(s4);
				allMainServicesControlles.AddService(mainServices1);
				
			  //  Service2
				MainServices mainServices2 = new MainServices();
				mainServices2.setservicename("Internet Payment services");
				Service s5 = new Service("Vodafone Internet",50);
				s5.setProvider(p);
				AddService(s5);
				mainServices2.addService(s5);
				Service s6 = new Service("Etisalat Internet",60);
				s6.setProvider(p);
				AddService(s6);
				mainServices2.addService(s6);
				Service s7 = new Service("Orange Internet",70);
				s7.setProvider(p);
				AddService(s7);
				mainServices2.addService(s7);
				Service s8 = new Service("We Internet",40);
				s8.setProvider(p);
				AddService(s8);
				mainServices2.addService(s8);
				allMainServicesControlles.AddService(mainServices2);
			//  Service3	
				MainServices mainServices3 = new MainServices();
				mainServices3.setservicename("Landline services");
				Service s9 = new Service("Monthly receipt",200);
				s9.setProvider(p);
				AddService(s9);
				mainServices3.addService(s9);
				Service s10 = new Service("Quarter receipt",400);
				s10.setProvider(p);
				AddService(s10);
				mainServices3.addService(s10);
				allMainServicesControlles.AddService(mainServices3);
			//  Service4	
				MainServices mainServices4 = new MainServices();
				mainServices4.setservicename("Donations");
				Service s11 = new Service("Cancer Hospital",10);
				s11.setProvider(p);
				AddService(s11);
				s11.setProvider(p);
				mainServices4.addService(s11);
				Service s12 = new Service("Schools",20);
				s12.setProvider(p);
				AddService(s12);
				mainServices4.addService(s12);
				Service s13 = new Service("NGOs",15);
				s13.setProvider(p);
				AddService(s13);
				mainServices4.addService(s13);
				allMainServicesControlles.AddService(mainServices4);
    }
	
	public Service search(String str){
		Service s = null;
		for (int i=0; i<allService.services.size() ;i++)
		{
			if (allService.services.get(i).getName().equals(str))
			{
				s = allService.services.get(i);
			}
		}
		return s;
	}
	public static void AddService(Service s){
		allService.services.add(s);
	}
	public Vector<Service> getAllService()
	{
		return allService.services;
	}
	public String CheckDiscountOnService(String name) {
		Service s = search(name);
		if(s != null) {
			return s.CheckSpecificDiscount();
		}
		return "There is not service with this name";
		
	}
}
