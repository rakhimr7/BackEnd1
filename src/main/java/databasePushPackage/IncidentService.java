package databasePushPackage;

import java.util.List;

public interface IncidentService {


	
boolean saveIncident(Incident incident);

	List<Incident> getIncidents();

	

}
