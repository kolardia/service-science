package pl.service.science.authorization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.publication.domain.Publication;
import pl.service.science.section.domain.Section;

@Entity
@Table(name = "authorization")
public class Authorization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorization_id")
	public Long id;
	
	@OneToOne
	@JoinColumn(name = "authorization_status_id")
	public Status authorization;

	@ManyToOne
	@JoinColumn(name = "authorization_user_id")
	public User user;
	
	@ManyToOne
	@JoinColumn(name = "authorization_section_id")
	public Section section;
	
	@OneToOne
	@JoinColumn(name = "authorization_profile_id")
	public Profile profileAuthorization;
	
	@Column(name = "authorization_enabled")
	public Boolean enabled;
	
	@OneToOne(mappedBy="autorization")
	public Publication publication;

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
