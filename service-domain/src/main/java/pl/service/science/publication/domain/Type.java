package pl.service.science.publication.domain;

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
 * Mapping the class in a database named table: "publication_type"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "publication_type")
public class Type {
	
	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "publication_type_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_type_id")
	public Long id;
	
	/**
	 * The mapping on a database for column name: "type_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "type_translation_id")
	public Translation typeName;
	
	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "type")
	List <Publication> publicationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getTypeName() {
		return typeName;
	}

	public void setTypeName(Translation typeName) {
		this.typeName = typeName;
	}
	
}
