package pl.service.science.publication.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PublicationCategory {
	
	@Id
	public Long id;

	@Column
	public String name;

	public PublicationCategory(Long id, String name) {
		this.setId(id);
		this.setName(name);;
	}

	public PublicationCategory(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	





	
	


}