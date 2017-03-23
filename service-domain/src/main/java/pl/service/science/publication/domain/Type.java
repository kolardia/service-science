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

@Entity
@Table(name = "publication_type")
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_type_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "type_translation_id")
	public Translation typeName;
	
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
