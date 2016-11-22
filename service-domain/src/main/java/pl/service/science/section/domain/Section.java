package pl.service.science.section.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
 * CREATE TABLE Sections (
		name VARCHAR(45) NOT NULL,
        type VARCHAR(45),
		enabled TINYINT NOT NULL DEFAULT 1,
        description VARCHAR(45),
    PRIMARY KEY (name),
    CONSTRAINT fk_type FOREIGN KEY (type) REFERENCES SectionTypes (name)
    );
 * 
 * */

@Entity
@Table(name="section")
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="section_id")
	public Long id;
	
	
	

}
