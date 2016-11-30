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
	public Translation title;

	@OneToOne
	@JoinColumn(name = "contents_translation_id")
	public Translation contents;

	@OneToOne
	@JoinColumn(name = "category_id")
	public PublicationCategory category;

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

	public Translation getTitle() {
		return title;
	}

	public void setTitle(Translation title) {
		this.title = title;
	}

	public Translation getContents() {
		return contents;
	}

	public void setContents(Translation contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", contents=" + contents + ", category=" + category + "]";
	}

}