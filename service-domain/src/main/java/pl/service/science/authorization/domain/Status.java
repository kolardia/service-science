package pl.service.science.authorization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.translation.domain.Translation;

@Entity
@Table(name = "authorization_status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorization_status_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "status_translation_id")
	public Translation authorizationStatus;

	@OneToOne(mappedBy = "authorization")
	public Authorization status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getAuthorizationStatus() {
		return authorizationStatus;
	}

	public void setAuthorizationStatus(Translation authorizationStatus) {
		this.authorizationStatus = authorizationStatus;
	}

	public Authorization getStatus() {
		return status;
	}

	public void setStatus(Authorization status) {
		this.status = status;
	}
	
}
