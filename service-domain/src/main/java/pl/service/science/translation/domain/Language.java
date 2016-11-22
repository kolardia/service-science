package pl.service.science.translation.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*******************************
 * CREATE TABLE language (
 * language_id int(4) NOT NULL AUTO_INCREMENT,
	 * language_code CHAR(2),
 *  PRIMARY KEY (language_id)
 *	);
 ***************************/
@Entity
@Table(name="language")
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="language_id")
	public Long id;
	
	@Column(name="language_code")
	public String code;
	
	@OneToMany(mappedBy= "language")
	public List <TranslationText> text;

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

	public List<TranslationText> getText() {
		return text;
	}

	public void setText(List<TranslationText> text) {
		this.text = text;
	}

	
}
