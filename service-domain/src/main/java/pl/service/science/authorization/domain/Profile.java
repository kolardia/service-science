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
@Table(name = "profile")
public class Profile {
	
	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "user_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profile_id")
	public Long id;
	
	@OneToOne
	@JoinColumn(name = "portfolio_translation_id")
	public Translation portfolio;
	
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
