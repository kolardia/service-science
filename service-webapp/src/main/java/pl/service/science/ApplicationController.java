package pl.service.science;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import pl.service.science.publication.dao.Interfejs;
import pl.service.science.publication.dao.impl.ListPublicationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.forms.ContestDTO;

@Controller
public class ApplicationController {
	
	
	final static Logger logger = Logger.getLogger(ApplicationController.class);
	
	
	@Autowired
	private ListPublicationDAO publicationDao;
	
	@Autowired
	protected Interfejs dao;
	

	

	      @RequestMapping("/")
	      public String showIndex(HttpServletRequest request, Model model) {
	    	  Publication contest = new Publication();
	    	  Locale locale = RequestContextUtils.getLocale(request);
	    	  String language = locale.getLanguage();
	    	  
	    		  model.addAttribute("element", contest);
	    		  //model.addAttribute("collection", this.searchLanguage(language, publicationDao.getPublications_en("SELECT k FROM Publication k  WHERE id<1"), publicationDao.getPublications_en("SELECT k FROM Publication k"))); 
	    		  model.addAttribute("collection", dao.findAll());
     	        return "index";
		    }
		    
		  
			@RequestMapping("/add")
		    public String addPublication(Model model) {
			
		    	model.addAttribute("info", "FORM");
		        return "forms/contest";
		    } 
		    
		    @RequestMapping("/{id}")
		    public String detailPublication(@PathVariable("id") Integer id, Model model) {
		    	
		    	Publication contestTemp= new Publication();
		    	contestTemp = dao.findById(id);
		    	logger.info("contestDao.getPublication(id): " + dao.findById(id));
		    	logger.info("contestDao.getPublication(id): " + contestTemp + contestTemp.getTitle() + contestTemp.getContents());
		    	model.addAttribute("title", contestTemp.getTitle());
	 	        model.addAttribute("contents", contestTemp.getContents());
		    	
		        return "details/contest";
		    }
		    
		    @RequestMapping("/form")
		    public String showFormPublication(@ModelAttribute("form") @Valid ContestDTO form, BindingResult result, Model model2) {
		        if (result.hasErrors()) {
		        	
		        	model2.addAttribute("info", "form not normal!");

		            return "forms/contest";
		        } else {
		        	Publication contest = new Publication();
		        	contest.setId(form.getId());
		        	contest.setTitle(form.getTitle());
		        	contest.setContents(form.getContents());
		        	//publicationDao.addPublication(contest);
		        	dao.save(contest);
		        	
		            return "redirect:/";

		        }
		    }

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
