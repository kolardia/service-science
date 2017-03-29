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

/**
 * Mapping the class in a database named table: "publication_category"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "publication_category")
public class Category {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "publication_category_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_category_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "category_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "category_translation_id")
	public Translation categoryName;
	

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