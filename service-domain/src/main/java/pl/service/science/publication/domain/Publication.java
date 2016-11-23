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
@Table(name = "publication")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "title_translation_id")
	public Translation translationTitle;

	@OneToOne
	@JoinColumn(name = "contents_translation_id")
	public Translation translationContents;

	@OneToOne
	@JoinColumn(name = "category_id")
	public PublicationCategory category;

	/*
	 * @OneToMany(mappedBy="department") private Set<Employee> employees;
	 */

	/*
	 * @OneToMany(mappedBy="id") public List<PublicationCategory> categoryId;
	 */

	public Publication() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PublicationCategory getCategory() {
		return category;
	}

	public void setCategory(PublicationCategory category) {
		this.category = category;
	}

	public Translation getTranslationTitle() {
		return translationTitle;
	}

	public void setTranslationTitle(Translation translationTitle) {
		this.translationTitle = translationTitle;
	}

	public Translation getTranslationContents() {
		return translationContents;
	}

	public void setTranslationContents(Translation translationContents) {
		this.translationContents = translationContents;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", translationTitle=" + translationTitle + ", translationContents="
				+ translationContents + ", category=" + category + "]";
	}

}