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

import pl.service.science.localization.domain.Location;
import pl.service.science.translation.domain.Translation;

@Entity
@Table(name = "section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_id")
	public Long id;

	@Column(name = "section_enabled")
	public Boolean enabled;

	@OneToOne
	@JoinColumn(name = "section_translation_id")
	public Translation section;

	@ManyToOne
	@JoinColumn(name = "section_type_id")
	public SectionType type;

	@OneToOne
	@JoinColumn(name = "description_translation_id")
	public Translation description;

	@OneToOne
	@JoinColumn(name = "location_id")
	public Location location;

	@OneToMany(mappedBy = "sectionCenter")
	public List<SectionCenter> center;

	@OneToMany(mappedBy = "subsection")
	public List<SectionCenter> subsection;

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

	public SectionType getType() {
		return type;
	}

	public void setType(SectionType type) {
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

}
