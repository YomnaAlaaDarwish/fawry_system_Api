package Services;
import java.util.*;

public class ServiceController {
	Service servise;
	
	public ServiceController(Service servise) {
		this.servise = servise;
	}
	
	public Provider SearchProvider(String providername) {
		for(int i =0 ;i<servise.providers.size();i++) {
			if(servise.providers.get(i).getName().equals(providername) ) {
				return servise.providers.get(i);
			}
		
	    }
		
			return null;
	}
	public boolean add_provider(Provider p) {
		servise.providers.add(p);
		return true;
	}
	public boolean remove_provider(Provider p) {
		for(int i =0 ;i<servise.providers.size();i++) {
			if(servise.providers.get(i).getName() == p.getName()) {
				servise.providers.remove(p);
				return true;
			}
		}
		return false;
		
	}
	public void addSpceficDiscount(double amount) {
	
		servise.setSpceficDiscount(amount);
		servise.updateCost();
	
	}
	
}
