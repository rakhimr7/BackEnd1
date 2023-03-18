package databasePushPackage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class IncidentController {
	
	@Autowired
	private IncidentRepository repo;
	
	@PostMapping(path="/incident/add")
	public Incident newIncident(@RequestBody Incident incident) {
		return repo.save(incident);
	};
	
	@GetMapping(path="incident/user/{userid}")
	public List<Incident> getUserIncidents(@PathVariable int userid){
		List<Incident> incidents = repo.findAll();
		List<Incident> result = new ArrayList<Incident>();
		for(int i=0;i<incidents.size();i++) {
			int current = incidents.get(i).getIncidentAuthor();
			if(current == userid) {
				result.add(incidents.get(i));
			}
		}
		return result;
	}
	
	@GetMapping(path="incident/user/all")
	public List<Incident> getAllIncidents(){
		return repo.findAll();
	}
	
	// update incident
	// get all incident with specific userID
	
	
	
	}
	
	

