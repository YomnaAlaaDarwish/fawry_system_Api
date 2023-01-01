package FCAI.FawrySystemApi.Services;

import java.util.Vector;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class searchForServise_EP {
	AllMainServicesControlles all;
	
	public searchForServise_EP() {
		all=AllMainServicesControlles.getInstance();
	}
	
	@PostMapping(value="/searchForService/{serviseName}")
	public Vector<Service> searchForServise(@PathVariable("serviseName")String serviseName) {
		
		return all.search(serviseName);
	}

}
