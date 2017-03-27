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

/**
 * Mapping the class in a database named table: "section_type"
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "section_type")
public class Type {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "section_type_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_type_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "type_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "type_translation_id")
	public Translation type;

	/**
	 * The mapping on a database is one-to-many
	 */
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
