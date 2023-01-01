package FCAI.FawrySystemApi.Services;
import java.util.*;

public class AllService {
	Vector<Service>services ;
	private static AllService obj;
	private AllService() {services = new Vector<Service>();}
	public static AllService getInstance()
    {
        if (obj==null)
            obj = new AllService();
        
        return obj;
    }
	public void AddService(Service s){
		services.add(s);
	}
	
}
