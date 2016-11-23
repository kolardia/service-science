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

	@ManyToOne
	@JoinColumn(name = "city_translation_id")
	public Translation cityTranslation;

	@ManyToOne
	@JoinColumn(name = "city_region_id")
	public Region region;

	@OneToMany(mappedBy = "sectonLocationCity")
	public List<SectionLocation> locationCity;

	@OneToOne(mappedBy = "userAdressCity")
	public User adressCity;

	public City() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Translation getCityTranslation() {
		return cityTranslation;
	}

	public void setCityTranslation(Translation cityTranslation) {
		this.cityTranslation = cityTranslation;
	}

}