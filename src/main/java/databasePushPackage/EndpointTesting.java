package databasePushPackage;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@SuppressWarnings("unused")
@RestController
public class EndpointTesting {
	
	@Autowired
	private LeadRepository repo;
	
	@CrossOrigin
	@PostMapping(path = "/users")
	public Lead newUser(@RequestBody Lead lead) {
		return repo.save(lead);
	}
	
	@CrossOrigin
	@PatchMapping("/users/{id}")
	public ResponseEntity<Lead> updateUserInfo(@PathVariable int id,@RequestBody Lead details){
			Lead updatedValues = repo.findById(id).orElseThrow( () -> new RuntimeException("no"));
			
			if(details.getFullname() != null) {
				updatedValues.setFullname(details.getFullname());
			}
			
			if(details.getMobile() != null) {
				updatedValues.setMobile(details.getMobile());
			}
			
			if(details.getEmail() != null) {
				updatedValues.setEmail(details.getEmail());
			}
			
			if(details.getPassword() != null) {
			updatedValues.setPassword(details.getPassword());
			
			}
			
			repo.save(updatedValues);
			
			return ResponseEntity.ok(updatedValues);
	}
	
	@CrossOrigin
	@GetMapping("/users")
	public List<Lead> getUserProfilesAll(){
		return repo.findAll();
		
	}
	
	@CrossOrigin
	@GetMapping("/users/{id}")
	public ResponseEntity<Lead> getUserProfiles(@PathVariable int id){
		//System.out.println(repo.findAll());
		return ResponseEntity.ok().body(repo.findById(id).get());
		
	}
	
	/*
	public CommandLineRunner postUsername(LeadRepository rep, String name,String mobile) {
		return (args) -> {
			rep.save(new Lead(name,mobile));
		};
	};
	*/
}
