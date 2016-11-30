package pl.service.science.translation.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {
	@Id
	@Column(name = "language_id")
	public Long id;

	@Column(name = "language_code", nullable = false)
	public String code;

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
