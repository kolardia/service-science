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
@Table(name = "publication_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_category_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "category_translation_id")
	public Translation categoryName;
	
	@OneToMany(mappedBy = "category")
	List <Publication> publicationCategory;

	public Category() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(Translation categoryName) {
		this.categoryName = categoryName;
	}

}