package pl.service.science.section.domain;

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

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.localization.domain.Location;
import pl.service.science.translation.domain.Translation;

/**
 * Mapping the class in a database named table: "section"
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "section")
public class Section {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "section_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_id")
	public Long id;
	
	/**
	 * The mapping on a database for column name: "section_email"; the resulting value will be not null
	 */
	@Column(name = "section_email", nullable = false)
	public String email;

	/**
	 * The mapping on a database for column name: "section_enabled"
	 */
	@Column(name = "section_enabled")
	public Boolean enabled;
	
	/**
	 * The mapping on a database for column name: "section_phone"
	 */
	@Column(name = "section_phone")
	public String phone;

	/**
	 * The mapping on a database for column name: "section_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "section_translation_id")
	public Translation section;

	/**
	 * The mapping on a database for column name: "section_type_id"; the mapping on a database is many-to-one
	 */
	@ManyToOne
	@JoinColumn(name = "section_type_id")
	public Type type;

	/**
	 * The mapping on a database for column name: "description_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "description_translation_id")
	public Translation description;

	/**
	 * The mapping on a database for column name: "location_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "location_id")
	public Location location;

	/**
	 * The mapping on a database is one-to-one
	 */
	@OneToOne(mappedBy = "sectionCenter")
	public Center center;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "subsection")
	public List<Center> subsection;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "section")
	public List <Authorization> sectionAutorization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Translation getSection() {
		return section;
	}

	public void setSection(Translation section) {
		this.section = section;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Translation getDescription() {
		return description;
	}

	public void setDescription(Translation description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
