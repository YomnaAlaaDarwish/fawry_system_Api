package Services;
import java.util.Vector;

public class Provider {
	Command command;
	String name;
	boolean accept_cash;
	Vector<String> form=new Vector();
	
	public Provider(String providerName,Vector<String> v,boolean c) {
		name=providerName;
		form=v;
		accept_cash=c;
		
	}
	public Provider() {}
	public String getName() {
		return name;
	}
	public boolean checkCash() {
		return accept_cash;
	}
	
	

}
