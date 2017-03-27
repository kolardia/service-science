package pl.service.science.authorization.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.publication.domain.Publication;
import pl.service.science.section.domain.Section;

/**
 * Mapping the class in a database named table: "authorization"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "authorization")
public class Authorization {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "authorization_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorization_id")
	public Long id;
	
	/**
	 * The mapping on a database is many-to-one; column name: "authorization_status_id"
	 */
	@ManyToOne
	@JoinColumn(name = "authorization_status_id")
	public Status authorization;

	/**
	 * The mapping on a database is many-to-one; column name: "authorization_user_id"
	 */
	@ManyToOne
	@JoinColumn(name = "authorization_user_id")
	public User user;
	
	/**
	 * The mapping on a database is many-to-one; column name: "authorization_section_id"
	 */
	@ManyToOne
	@JoinColumn(name = "authorization_section_id")
	public Section section;
	
	/**
	 * The mapping on a database is one-to-one; column name: "authorization_profile_id"
	 */
	@OneToOne
	@JoinColumn(name = "authorization_profile_id")
	public Profile profileAuthorization;
	
	/**
	 * Column name: "authorization_enabled"
	 */
	@Column(name = "authorization_enabled")
	public Boolean enabled;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy="autorization")
	public List <Publication> publication;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Profile getProfileAuthorization() {
		return profileAuthorization;
	}

	public void setProfileAuthorization(Profile profileAuthorization) {
		this.profileAuthorization = profileAuthorization;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Status getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Status authorization) {
		this.authorization = authorization;
	}

}
