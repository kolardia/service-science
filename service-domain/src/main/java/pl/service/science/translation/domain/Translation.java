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
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.domain.PublicationCategory;
import pl.service.science.publication.domain.PublicationStatus;
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

	@OneToMany(mappedBy = "translation")
	public List<TextTranslation> textTranslation;

	@OneToOne(mappedBy = "title")
	public Publication titlePublication;

	@OneToOne(mappedBy = "statusName")
	public PublicationStatus statusTranslation;

	@OneToOne(mappedBy = "categoryName")
	public PublicationCategory categoryTranslation;

	@OneToOne(mappedBy = "contents")
	public Publication contentsTranslation;

	@OneToOne(mappedBy = "city")
	public City cityTranslation;

	@OneToOne(mappedBy = "region")
	public Region regionTranslation;

	@OneToOne(mappedBy = "country")
	public Country countryTranslation;

	@OneToOne(mappedBy = "type")
	public SectionType typeTranslation;

	@OneToOne(mappedBy = "section")
	public Section sectionTranslation;

	@OneToOne(mappedBy = "description")
	public Section descriptionTranslation;

	@OneToOne(mappedBy = "authorizationStatus")
	public AuthorizationStatus authorizationTranslation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TextTranslation> getTextTranslation() {
		return textTranslation;
	}

	public void setTextTranslation(List<TextTranslation> textTranslation) {
		this.textTranslation = textTranslation;
	}

	public Publication getTitlePublication() {
		return titlePublication;
	}

	public void setTitlePublication(Publication titlePublication) {
		this.titlePublication = titlePublication;
	}

	public PublicationStatus getStatusTranslation() {
		return statusTranslation;
	}

	public void setStatusTranslation(PublicationStatus statusTranslation) {
		this.statusTranslation = statusTranslation;
	}

	public PublicationCategory getCategoryTranslation() {
		return categoryTranslation;
	}

	public void setCategoryTranslation(PublicationCategory categoryTranslation) {
		this.categoryTranslation = categoryTranslation;
	}

	public Publication getContentsTranslation() {
		return contentsTranslation;
	}

	public void setContentsTranslation(Publication contentsTranslation) {
		this.contentsTranslation = contentsTranslation;
	}

	public City getCityTranslation() {
		return cityTranslation;
	}

	public void setCityTranslation(City cityTranslation) {
		this.cityTranslation = cityTranslation;
	}

	public Region getRegionTranslation() {
		return regionTranslation;
	}

	public void setRegionTranslation(Region regionTranslation) {
		this.regionTranslation = regionTranslation;
	}

	public Country getCountryTranslation() {
		return countryTranslation;
	}

	public void setCountryTranslation(Country countryTranslation) {
		this.countryTranslation = countryTranslation;
	}

	public SectionType getTypeTranslation() {
		return typeTranslation;
	}

	public void setTypeTranslation(SectionType typeTranslation) {
		this.typeTranslation = typeTranslation;
	}

	public Section getSectionTranslation() {
		return sectionTranslation;
	}

	public void setSectionTranslation(Section sectionTranslation) {
		this.sectionTranslation = sectionTranslation;
	}

	public Section getDescriptionTranslation() {
		return descriptionTranslation;
	}

	public void setDescriptionTranslation(Section descriptionTranslation) {
		this.descriptionTranslation = descriptionTranslation;
	}

	public AuthorizationStatus getAuthorizationTranslation() {
		return authorizationTranslation;
	}

	public void setAuthorizationTranslation(AuthorizationStatus authorizationTranslation) {
		this.authorizationTranslation = authorizationTranslation;
	}
}