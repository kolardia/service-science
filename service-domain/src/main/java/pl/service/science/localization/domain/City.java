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

import pl.service.science.section.domain.SectionLocation;
import pl.service.science.translation.domain.Translation;
import pl.service.science.user.domain.User;

/**
 * @author kolardia
 *
 */
@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id")
	Long id;

	@OneToOne
	@JoinColumn(name = "city_translation_id")
	public Translation city;

	@ManyToOne
	@JoinColumn(name = "city_region_id")
	public Region cityRegion;

	@OneToMany(mappedBy = "sectonLocation")
	public List<SectionLocation> cities;

	@OneToOne(mappedBy = "cityOfResidence")
	public User cityOfResidence;

	public City() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getCity() {
		return city;
	}

	public void setCity(Translation city) {
		this.city = city;
	}

	public Region getCityRegion() {
		return cityRegion;
	}

	public void setCityRegion(Region cityRegion) {
		this.cityRegion = cityRegion;
	}

	public List<SectionLocation> getCities() {
		return cities;
	}

	public void setCities(List<SectionLocation> cities) {
		this.cities = cities;
	}

	public User getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(User cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

}