package pl.service.science.section.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.translation.domain.Translation;

/*
 * 
 * CREATE TABLE SectionTypes (
			name VARCHAR(45) NOT NULL,
            PRIMARY KEY (name)
            );
 * 
 * 
 * */

@Entity
@Table(name="section_type")
public class SectionType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="section_type_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="type_translation_id")
	private Translation typeTranslation;
	

}
