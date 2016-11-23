package pl.service.science.publication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.service.science.translation.domain.Translation;

@Entity
@Table(name = "publication_category")
public class PublicationCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_category_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "category_translation_id")
	public Translation nameTranslation;

	public PublicationCategory() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getNameTranslation() {
		return nameTranslation;
	}

	public void setNameTranslation(Translation nameTranslation) {
		this.nameTranslation = nameTranslation;
	}

	@Override
	public String toString() {
		return "PublicationCategory [id=" + id + ", nameTranslation=" + nameTranslation + "]";
	}

}