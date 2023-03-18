package databasePushPackage;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService  {
	
@Autowired
	IncidentRepository incidentRepository;

	@Override
	public boolean saveIncident(Incident incident) {
		try {
		Incident saveIncident =	incidentRepository.save(incident);
		if(saveIncident!=null) {
			return true;
		}
		else {
			return false;
		}
		}
		catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public List<Incident> getIncidents() {

		return incidentRepository.findAll();
	}


}

