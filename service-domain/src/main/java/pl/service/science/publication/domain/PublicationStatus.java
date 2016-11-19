package pl.service.science.publication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PublicationStatus {

	@Id
	public int id;
	
	@Column
	public String name;
	
	public PublicationStatus(int id, String name) {
		this.setId(id);;
		this.setName(name);;
	}
	
	public PublicationStatus(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
		
}