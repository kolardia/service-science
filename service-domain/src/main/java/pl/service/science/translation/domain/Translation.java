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

import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.Profile;
import pl.service.science.localization.domain.City;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.domain.Category;
import pl.service.science.publication.domain.State;
import pl.service.science.section.domain.Section;
import pl.service.science.section.domain.Type;

/**
 * The TextTranslation mapping  on a database for table name: "translation"
 * @author kolardia
 *
 */
@Entity
@Table(name = "translation")
public class Translation {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "translation_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "translation_id")
	public Long id;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToMany(mappedBy = "translation")
	public List<TextTranslation> textTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "title")
	public Publication titlePublication;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "statusName")
	public State statusTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "categoryName")
	public Category categoryTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "contents")
	public Publication contentsTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "city")
	public City cityTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "region")
	public Region regionTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "country")
	public Country countryTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "type")
	public Type typeTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "section")
	public Section sectionTranslation;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "description")
	public Section descriptionTranslation;
	
	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "portfolio")
	public Profile portfolioTranslation;
	
	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "authorizationStatus")
	public Status authorizationStatusTranslation;
	
	@OneToOne(mappedBy = "candidateProfile")
	public Publication candidateProfileTranslation;
	
	@OneToOne(mappedBy = "purposeOfEvent")
	public Publication purposeOfEventTranslation;
	
	@OneToOne(mappedBy = "eventProgram")
	public Publication eventProgramTranslation;
	
	@OneToOne(mappedBy = "methodology")
	public Publication methodologyTranslation;
	
	@OneToOne(mappedBy = "initialRequirements")
	public Publication initialRequirements;
	
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

	public State getStatusTranslation() {
		return statusTranslation;
	}

	public void setStatusTranslation(State statusTranslation) {
		this.statusTranslation = statusTranslation;
	}

	public Category getCategoryTranslation() {
		return categoryTranslation;
	}

	public void setCategoryTranslation(Category categoryTranslation) {
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

	public Type getTypeTranslation() {
		return typeTranslation;
	}

	public void setTypeTranslation(Type typeTranslation) {
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

}