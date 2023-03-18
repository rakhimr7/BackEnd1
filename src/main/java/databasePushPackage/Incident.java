package databasePushPackage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "Incidents")
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incidentId;
	
	@Column
	private String incidentDesc;
	
	@Column
	private String incidentType;
	
	@Column
	private int userSubmittedId;
	
	//@Column
	//private Date incidentTimestamp;
	
	public Incident(String a,String b,int c) {//Date d
		super();
		a = this.incidentDesc;
		b = this.incidentType;
		c = this.userSubmittedId;
		//d = this.incidentTimestamp;
	}
	
	public Incident() {
		super();
	};
	
	
	
	
	
	public int getIncidentId() {
		return incidentId;
	}
	
	public String getIncidentDesc() {
		return incidentDesc;
	}
	
	public void setIncidentDesc(String desc) {
		this.incidentDesc = desc;
	}
	
	public String getIncidentType() {
		return incidentType;
	}
	
	public void setIncidentType(String type) {
		this.incidentType = type;
	}
	
	public int getIncidentAuthor() {
		return userSubmittedId;
	}
	
	public void setIncidentAuthor(int user) {
		this.userSubmittedId = user;
	}
	
	/*public Date getIncidentTimestamp() {
		return incidentTimestamp;
	}
	
	public void setIncidentTimestamp(Date date) {
		this.incidentTimestamp = date;
	}*/

}
