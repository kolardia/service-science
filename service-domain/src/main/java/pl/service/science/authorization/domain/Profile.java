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

/**
 * Mapping the class in a database named table: "profile"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "profile")
public class Profile {
	
	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "profile_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profile_id")
	public Long id;
	
	/**
	 * The mapping on a database is one-to-one; column name: "portfolio_translation_id"
	 */
	@OneToOne
	@JoinColumn(name = "portfolio_translation_id")
	public Translation portfolio;
	
	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy="profileAuthorization")
	public Authorization profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Translation portfolio) {
		this.portfolio = portfolio;
	}	

}
