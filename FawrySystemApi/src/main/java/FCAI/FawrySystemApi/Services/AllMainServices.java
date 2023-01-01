package FCAI.FawrySystemApi.Services;
import java.util.Vector;

public class AllMainServices {
	Vector <MainServices>  mainservices = new Vector<MainServices>();
	
    private static AllMainServices obj;
    private AllMainServices() {}
	public static AllMainServices getInstance()
    {
        if (obj==null)
        {
        	 obj = new AllMainServices();
        }
        return obj;
    }
    public Vector <MainServices> getmainservices() {
    	return mainservices	;
    }
    
}
