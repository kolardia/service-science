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
import javax.persistence.Table;

import pl.service.science.translation.domain.Translation;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="coutry_transation_id")
	public Translation countryTranslation;
	 
	@OneToMany(mappedBy= "country")
	public List<Region> region;
	
	public Country(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

	public Translation getCountryTranslation() {
		return countryTranslation;
	}

	public void setCountryTranslation(Translation countryTranslation) {
		this.countryTranslation = countryTranslation;
	}

	public List<Region> getRegion() {
		return region;
	}

	public void setRegion(List<Region> region) {
		this.region = region;
	}




	

}