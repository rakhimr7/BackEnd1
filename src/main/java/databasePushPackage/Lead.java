package databasePushPackage;

import javax.persistence.*;



@Entity
@Table(name = "leads")
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column (name="fullname")
	private String fullname;	
	
	@Column (name="mobile")
	private String mobile;
	
	@Column (name="email")
	private String email;
	
	@Column (name="password")
	private String password;

	public Lead(String name, String mobile) {
		super();
		this.fullname = fullname;
		this.mobile = mobile;
		this.email = email;
		this.password  = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Lead() {
		super();
	};

}
