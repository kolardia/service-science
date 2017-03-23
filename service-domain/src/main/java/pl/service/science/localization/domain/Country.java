package pl.service.science.localization.domain;

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
 * The Country mapping  on a database for table name: "country"
 * @author kolardia
 *
 */
@Entity
@Table(name = "country")
public class Country {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "country_id" 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	public Long id;

	/**
	 * The mapping on a database is one-to-one; column name: "coutry_transation_id"
	 */
	@OneToOne
	@JoinColumn(name = "coutry_transation_id")
	public Translation country;

	/**
	 * The mapping on a database is one-to-many.
	 * Country which is divided into regions
	 */
	@OneToMany(mappedBy = "country")
	public List <Region> region;

	public Long getId() {
		return id;
	}

	public Translation getCountry() {
		return country;
	}

	public void setCountry(Translation country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}
}