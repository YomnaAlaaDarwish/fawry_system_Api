package FCAI.FawrySystemApi.Sign;
import java.util.*;

import FCAI.FawrySystemApi.User.*;

public class Sign {
	Vector<User>users ;
	public Sign() {
		users = new Vector();
	}
	public Vector<User> getAllUsers(){
		return users;
	}
}