package pl.service.science.translation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "text_translation")
public class TextTranslation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "text_translation_id")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "language_id", nullable = false)
	public Language language;

	@ManyToOne
	@JoinColumn(name = "translation_id")
	public Translation translation;

	@Column(name = "text_translation")
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
