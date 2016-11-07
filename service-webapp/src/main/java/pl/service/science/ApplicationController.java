package pl.service.science;

import java.util.Locale;

import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import pl.service.science.model.impl.IntroducePublication;
import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.forms.ContestDTO;

@Controller
public class ApplicationController {
	
	public Locale locale;
	final static Logger logger = Logger.getLogger(ApplicationController.class);

	
	@Autowired
	private PublicationDAO contestDao;
	
	      @RequestMapping("/")
	      public String showIndex(Model model) {
	    	  Locale locale = LocaleContextHolder.getLocale();
	    	  
			        model.addAttribute("message", "Publications | BASE");	        
			        Publication contest = new Publication();
			        IntroducePublication local = new IntroducePublication();
	     			model.addAttribute("element", contest);
	     	        model.addAttribute("collection", local.searchLanguage(locale, contestDao.getPublications_en(), contestDao.getPublications_pl()));
	
     	        return "index";
		    }
		    
		  
			@RequestMapping("/add")
		    public String addContest(Model model) {
			
		    	model.addAttribute("info", "FORM");
		        return "forms/contest";
		    } 
		    
		    @RequestMapping("/{id}")
		    public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
		    	
		    	Publication contestTemp= new Publication();
		    	contestTemp = contestDao.getPublication(id);
		    	logger.info("contestDao.getPublication(id): " + contestTemp + contestTemp.getTitle() + contestTemp.getContents());
		    	model.addAttribute("title", contestTemp.getTitle());
	 	        model.addAttribute("contents", contestTemp.getContents());
		    	
		        return "details/contest";
		    }
		    
		    @RequestMapping("/form")
		    public String showFormContest(@ModelAttribute("form") @Valid ContestDTO form, BindingResult result, Model model2) {
		        if (result.hasErrors()) {
		        	
		        	model2.addAttribute("info", "form not normal!");

		            return "forms/contest";
		        } else {
		        	Publication contest = new Publication();
		        	contest.setId(form.getId());
		        	contest.setTitle(form.getTitle());
		        	contest.setContents(form.getContents());
		        	contestDao.addPublication(contest);
		        	
		            return "redirect:/";

		        }
		    }
}

	

