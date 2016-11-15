package pl.service.science.service.publication.impl;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.dao.publication.DaoPublication;
import pl.service.science.publication.domain.Publication;
import pl.service.science.service.publication.ServicePublication;

@Service
public class ServicePublicationImpl implements ServicePublication{

	
	@Autowired
	protected  DaoPublication dao;
	

	 public Publication findById(int id){
		 
		 return dao.findById(id);
		 
	 };
	 public List<Publication> findAll(){
		 return dao.findAll();
	 };
	
	public Publication  save(Publication contest){
		 return dao.save(contest);
	 };
	
	final static Logger logger = Logger.getLogger(ServicePublicationImpl.class);
	
	
	public List<Publication>  searchLanguage(String language, List<Publication> listLanguage_en, List<Publication> listLanguage_pl){
		/*https://docs.oracle.com/javase/tutorial/i18n/locale/create.html
		   * http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html
		   * Region Codes
		   * Country A 2     A 3     Number
		   * POLAND  PL      POL     616 
		   * */
		  /*
		   * http://www.loc.gov/standards/iso639-2/php/code_list.php
		   * Language Code
		   * ISO 639-2 Code 	ISO 639-1 Code 	English name of Language
		   * pol 				pl 				Polish
		   * */
		  Locale plLocale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
		  Locale enLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
		  
		  String plLanguage = plLocale.getLanguage();
		  String enLanguage = enLocale.getLanguage();
		  
		  if(language == plLanguage){
			  logger.info("***list_en: locale.ENGLISH ***");
			  return  listLanguage_pl; 
		  }else if(language == enLanguage ){
			  logger.info("***list_pl: defaultLocale ***");
			 return  listLanguage_en; 
		  }else{
				 List<Publication> list= null;
				 logger.info("***A NEW EMPTY LIST: Translation not found: locale ***");
				return list ;	
		  }	
	}
	
}
