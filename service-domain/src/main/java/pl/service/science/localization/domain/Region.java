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

@Entity
@Table(name = "region")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "region_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "region_translation_id")
	public Translation region;

	// Country which is divided into regions
	@ManyToOne
	@JoinColumn(name = "country_id")
	public Country country;

	@OneToMany(mappedBy = "region")
	public List<Region> regions;
	// Cities in the area of the region

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