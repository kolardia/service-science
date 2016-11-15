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

import pl.service.science.dao.publication.DaoPublication;
import pl.service.science.dao.publication.impl.ListPublicationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.forms.ContestDTO;
import pl.service.science.service.publication.ServicePublication;

@Controller
public class PublicationController {
	
	
	final static Logger logger = Logger.getLogger(PublicationController.class);
	
	
	@Autowired
	private ListPublicationDAO publicationDao;
	
	
	
	@Autowired
	protected ServicePublication service;
	


	      @RequestMapping("/")
	      public String showIndex(HttpServletRequest request, Model model) {
	    	  Publication contest = new Publication();
	    	  Locale locale = RequestContextUtils.getLocale(request);
	    	  String language = locale.getLanguage();
	    	  
	    		  model.addAttribute("element", contest);
	    		 //model.addAttribute("collection", service.searchLanguage(language, publicationDao.getPublications_en("SELECT k FROM Publication k  WHERE id<1"), publicationDao.getPublications_en("SELECT k FROM Publication k"))); 
	    		 model.addAttribute("collection", service.findAll());
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
		    	contestTemp = service.findById(id);
		    	logger.info("contestDao.getPublication(id): " + service.findById(id));
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
		        	service.save(contest);
		        	
		            return "redirect:/";

		        }
		    }
}
