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
@Table(name = "region")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "region_id")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "region_translation_id")
	public Translation regionTranslation;

	@ManyToOne
	@JoinColumn(name = "country_id")
	public Country country;

	@OneToMany(mappedBy = "region")
	public List<City> city;

	public Region() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getRegionTranslation() {
		return regionTranslation;
	}

	public void setRegionTranslation(Translation regionTranslation) {
		this.regionTranslation = regionTranslation;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
}