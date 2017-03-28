package pl.service.science.authorization.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.localization.domain.Location;
import pl.service.science.publication.domain.Publication;

/**
 *  The User mapping  on a database for table name: "user"
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "user")
public class User {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "user_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "user_email"
	 */
	@Column(name = "user_email")
	public String email;

	/**
	 * The mapping  on a database for column name: "user_name"
	 */
	@Column(name = "user_name")
	public String name;
	
	/**
	 * The mapping  on a database for column name: "user_surname"
	 */
	@Column(name = "user_surname")
	public String surname;
	
	/**
	 * The mapping  on a database for column name: "user_phone"
	 */
	@Column(name = "user_phone")
	public String phone;
	
	/**
	 * The mapping  on a database for column name: "user_password"
	 */
	@Column(name = "user_password")
	public String password;

	/**
	 * The mapping  on a database for column name: "user_enabled"
	 */
	@Column(name = "user_enabled")
	public Boolean enabled;
	
	/**
	 * The mapping on a database is one-to-one; column name: "user_location"
	 */
	@OneToOne
	@JoinColumn(name = "user_location")
	public Location addressOfResidence;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "user")
	public List <Authorization> user;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "leader")
	public List <Publication> userLider;
	
	@OneToMany(mappedBy= "user")
	public List <Role> roles;

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
	public Location getAddressOfResidence() {
		return addressOfResidence;
	}

	public void setAddressOfResidence(Location addressOfResidence) {
		this.addressOfResidence = addressOfResidence;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
