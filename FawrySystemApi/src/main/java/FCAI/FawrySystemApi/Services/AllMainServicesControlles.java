package FCAI.FawrySystemApi.Services;
import java.util.Vector;

public class AllMainServicesControlles {
	 AllMainServices allMainservices;
	 
	    private static AllMainServicesControlles obj;
	    private AllMainServicesControlles() {
	    	allMainservices = AllMainServices.getInstance();
	    }
		public static AllMainServicesControlles getInstance()
	    {
	        if (obj==null)
	        {
	        	 obj = new AllMainServicesControlles();
	        }
	        return obj;
	    }
     public Vector<Service> search(String mainservice){
    	 
    	Vector<Service>services = new Vector();
		for (int i=0; i <allMainservices.getmainservices().size() ;i++)
		{
			if (allMainservices.getmainservices().get(i).getName().equals(mainservice))
			{
				services = allMainservices.getmainservices().get(i).getSubService();
			}
		}
		if(!services.isEmpty())
		    return services;
		else
			return null;
	}
    public void AddService(MainServices s){
    	allMainservices.mainservices.add(s);
 	}
 	 

}
