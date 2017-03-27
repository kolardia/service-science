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

import pl.service.science.translation.domain.Translation;

/**
 * Mapping the class in a database named table: "authorization_status"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "authorization_status")
public class Status {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "authorization_status_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorization_status_id")
	public Long id;

	/**
	 *  The mapping on a database is one-to-one; column name: "status_translation_id"
	 */
	@OneToOne
	@JoinColumn(name = "status_translation_id")
	public Translation authorizationStatus;

	/**
	 *  The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "authorization")
	public List <Authorization> status;

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

	public List<Authorization> getStatus() {
		return status;
	}

	public void setStatus(List<Authorization> status) {
		this.status = status;
	}
}
