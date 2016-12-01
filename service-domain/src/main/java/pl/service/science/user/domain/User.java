package pl.service.science.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.service.science.localization.domain.City;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Long id;

	@Column(name = "user_email")
	public String email;

	@Column(name = "user_name")
	public String name;

	@Column(name = "user_password")
	public String password;

	@ManyToOne
	@JoinColumn(name = "user_aadress_city")
	public City cityOfResidence;

	@Column(name = "user_enabled")
	public Boolean enabled;

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

	public City getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(City cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
