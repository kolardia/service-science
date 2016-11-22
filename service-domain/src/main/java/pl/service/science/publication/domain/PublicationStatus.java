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
@Table(name="publication_status")
public class PublicationStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="publication_status_id")
	public int id;
	
	@OneToOne
	@JoinColumn(name="status_translation_id")
	public Translation nameTranslation;
	
	public PublicationStatus(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Translation getNameTranslation() {
		return nameTranslation;
	}

	public void setNameTranslation(Translation nameTranslation) {
		this.nameTranslation = nameTranslation;
	}

	@Override
	public String toString() {
		return "PublicationStatus [id=" + id + ", nameTranslation=" + nameTranslation + "]";
	}
		
}