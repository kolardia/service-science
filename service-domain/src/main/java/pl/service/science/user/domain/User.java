package pl.service.science.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.localization.domain.Location;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Long id;

	@Column(name = "user_email")
	public String email;

	public Location getAddressOfResidence() {
		return addressOfResidence;
	}

	public void setAddressOfResidence(Location addressOfResidence) {
		this.addressOfResidence = addressOfResidence;
	}

	@Column(name = "user_name")
	public String name;

	@Column(name = "user_password")
	public String password;

	@Column(name = "user_enabled")
	public Boolean enabled;
	
	@OneToOne
	@JoinColumn(name = "user_location")
	public Location addressOfResidence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
