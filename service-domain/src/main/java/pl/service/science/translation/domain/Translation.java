package pl.service.science.translation.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.SectionType;
import pl.service.science.user.domain.AuthorizationStatus;

@Entity
@Table(name = "translation")
public class Translation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "translation_id")
	public Long id;

	@OneToOne(mappedBy = "translation")
	public TranslationText text;

	@OneToMany(mappedBy = "cityTranslation")
	public List<City> city;

	@OneToMany(mappedBy = "regionTranslation")
	public List<Region> region;

	@OneToMany(mappedBy = "countryTranslation")
	public List<Country> country;

	@OneToMany(mappedBy = "typeTranslation")
	public List<SectionType> type;

	@OneToMany(mappedBy = "sectionTranslation")
	public List<Section> section;

	@OneToMany(mappedBy = "descriptionTranslation")
	public List<Section> description;

	@OneToMany(mappedBy = "authorizationStatusTranslation")
	public List<AuthorizationStatus> authorizationStatus;

	public Translation() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TranslationText getText() {
		return text;
	}

	public void setText(TranslationText text) {
		this.text = text;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public List<Region> getRegion() {
		return region;
	}

	public void setRegion(List<Region> region) {
		this.region = region;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public List<SectionType> getType() {
		return type;
	}

	public void setType(List<SectionType> type) {
		this.type = type;
	}

}