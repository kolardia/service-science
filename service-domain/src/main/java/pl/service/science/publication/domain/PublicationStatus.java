package pl.service.science.publication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


public class PublicationStatus {


	public int idStatus;
	
	public String nameStatus;
	
	public PublicationStatus(int id, String name) {
		this.setIdStatus(id);;
		this.setNameStatus(name);;
	}
	
	public PublicationStatus(){
		
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
	
		
}