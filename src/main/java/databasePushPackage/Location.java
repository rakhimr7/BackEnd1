package databasePushPackage;

import java.util.ArrayList;

public class Location {
	private String locationName;
	private ArrayList<Incident>[] incidentList;
	
	public Location(String a,ArrayList<Incident>[] b) {
		a = this.locationName;
		b = this.incidentList;
	}

}
