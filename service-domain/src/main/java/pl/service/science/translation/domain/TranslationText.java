package pl.service.science.translation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "translation_text")
public class TranslationText {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "translation_text_id")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "translation_text_language_id")
	public Language language;

	@OneToOne
	@JoinColumn(name = "translation_text_translation_id")
	public Translation translation;

	@Column(name = "translation_text")
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

}
