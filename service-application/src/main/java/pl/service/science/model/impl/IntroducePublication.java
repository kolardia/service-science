package pl.service.science.model.impl;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import pl.service.science.publication.domain.Publication;

public class IntroducePublication {
	
	final static Logger logger = Logger.getLogger(IntroducePublication.class);
	
	@SuppressWarnings("static-access")
	public List<Publication>  searchLanguage(Locale locale, List<Publication> list_en, List<Publication> list_pl){
		if(locale.ENGLISH == locale){
		logger.info("***list_en: locale.ENGLISH ***");
		return list_en;
	}else{
		logger.info("***list_pl: defaultLocale ***");
		return list_pl;
	/*}else{
		 List<Publication> list= null;
		 logger.info("***A NEW EMPTY LIST: Translation not found: locale ***");
		return list ;*/
	}
	}
}
