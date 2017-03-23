package pl.service.science.translation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The TextTranslation mapping  on a database for table name: "text_translation"
 * @author kolardia
 *
 */
@Entity
@Table(name = "text_translation")
public class TextTranslation {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "text_translation_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "text_translation_id")
	public Long id;

	/**
	 * The mapping on a database is many-to-one; the resulting value will be not null
	 */
	@ManyToOne
	@JoinColumn(name = "language_id", nullable = false)
	public Language language;

	/**
	 * The mapping on a database is many-to-one; column name: "translation_id"
	 */
	@ManyToOne
	@JoinColumn(name = "translation_id", nullable = false)
	public Translation translation;

	/**
	 * The mapping  on a database for column name: "text_translation"
	 */
	@Column(name = "text_translation", nullable = false)
	public String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TextTranslation [id=" + id + ", language=" + language + ", translation=" + translation + ", text="
				+ text + "]";
	}
}
