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

@Entity
@Table(name = "section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_id")
	public Long id;
	
	@Column(name = "section_email")
	public String email;

	@Column(name = "section_enabled")
	public Boolean enabled;
	
	@Column(name = "section_phone")
	public String phone;

	@OneToOne
	@JoinColumn(name = "section_translation_id")
	public Translation section;

	@ManyToOne
	@JoinColumn(name = "section_type_id")
	public Type type;

	@OneToOne
	@JoinColumn(name = "description_translation_id")
	public Translation description;

	@OneToOne
	@JoinColumn(name = "location_id")
	public Location location;

	@OneToOne
	public Center center;
	
	@OneToMany(mappedBy = "subsection")
	public List<Center> subsection;
	
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
