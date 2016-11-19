package pl.service.science.translation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Translation {
	
	@Id
	public Long id;

	@Column
	public String polish;
	
	@Column
	public String english;
	
	public Translation(Long id, String pl) {
		this.setId(id);
		this.setPolish(pl);
	}
	
	public Translation(Long id, String pl, String en) {
		this.setId(id);
		this.setPolish(pl);
		this.setEnglish(en);
	}
	
	public Translation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolish() {
		return polish;
	}

	public void setPolish(String polish) {
		this.polish = polish;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}
	

}