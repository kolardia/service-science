package pl.service.science.translation.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Language mapping  on a database for table name: "language"
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "language")
public class Language {
	
	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "language_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "language_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "language_code"; the resulting value will be not null
	 */
	@Column(name = "language_code", nullable = false)
	public String code;

	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "language")
	public List<TextTranslation> text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TextTranslation> getText() {
		return text;
	}

	public void setText(List<TextTranslation> text) {
		this.text = text;
	}

}
