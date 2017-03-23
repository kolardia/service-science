package pl.service.science.localization.domain;

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

import pl.service.science.translation.domain.Translation;

/**
 * The Region mapping  on a database for table name: "region"
 * @author kolardia
 *
 */
@Entity
@Table(name = "region")
public class Region {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "region_id" 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "region_id")
	public Long id;

	/**
	 * The mapping on a database is one-to-one; column name: "region_translation_id"
	 */
	@OneToOne
	@JoinColumn(name = "region_translation_id")
	public Translation region;

	/**
	 * The mapping on a database is many-to-one; column name: "country_id"
	 * Country which is divided into regions
	 */
	@ManyToOne
	@JoinColumn(name = "country_id")
	public Country country;

	/**
	 * The mapping on a database is one-to-many
	 * Cities in the area of the region
	 */
	@OneToMany(mappedBy = "region")
	public List<Region> regions;

	public Region() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getRegion() {
		return region;
	}

	public void setRegion(Translation region) {
		this.region = region;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}