package pl.service.science.translation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Translation {
	

	public int translationId;

	public String translationPl;

	public String translationEn;
	
	public Translation(int translationId, String translationPl) {
		this.setTranslationId(translationId);
		this.setTranslationEn(translationPl);
	}
	
	public Translation(int translationId, String translationPl, String translationEn) {
		this.setTranslationId(translationId);
		this.setTranslationPl(translationPl);
		this.setTranslationEn(translationEn);
	}
	
	public Translation() {
		
	}
	
	public int getTranslationId() {
		return translationId;
	}
	
	public void setTranslationId(int translationId) {
		this.translationId = translationId;
	}
	public String getTranslationPl() {
		return translationPl;
	}
	
	public void setTranslationPl(String translationPl) {
		this.translationPl = translationPl;
	}
	
	public String getTranslationEn() {
		return translationEn;
	}
	
	public void setTranslationEn(String translationEn) {
		this.translationEn = translationEn;
	}
	
}