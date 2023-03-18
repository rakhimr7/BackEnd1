package databasePushPackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService  {
	
@Autowired
	LeadRepository leadRepository;

	@Override
	public boolean saveLead(Lead lead) {
		try {
		Lead saveLead =	leadRepository.save(lead);
		if(saveLead!=null) {
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
	public List<Lead> getLeads() {

		return leadRepository.findAll();
	}


}
