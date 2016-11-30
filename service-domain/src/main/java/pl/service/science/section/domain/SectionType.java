package pl.service.science.section.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.translation.domain.Translation;

@Entity
@Table(name = "section_type")
public class SectionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_type_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "type_translation_id")
	public Translation type;

	@OneToMany(mappedBy = "type")
	public List<Section> types;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getType() {
		return type;
	}

	public void setType(Translation type) {
		this.type = type;
	}

	public List<Section> getTypes() {
		return types;
	}

	public void setTypes(List<Section> types) {
		this.types = types;
	}

}
