package pl.service.science;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.forms.ContestDTO;

@Controller
public class ApplicationController {
	
	      @Autowired
	      private PublicationDAO contestDao;
		        
		        @RequestMapping("/")
			    public String showIndex(Model model) {
			        model.addAttribute("message", "Publications | BASE");
			        
			        Publication contest = new Publication();
	     			model.addAttribute("element", contest);
	     	        model.addAttribute("collection", contestDao.getPublications());
	
     	        return "index";
		    }
		    
		    @RequestMapping("/add")
		    public String addContest(Model model) {
		    	model.addAttribute("info", "form: aad contest");
		        return "forms/contest";
		    } 
		    
		    @RequestMapping("/form")
		    public String showFormContest(@ModelAttribute("form") @Valid ContestDTO form, BindingResult result, Model model2) {
		        if (result.hasErrors()) {
		        	
		        	model2.addAttribute("info", "form not normal!");

		            return "forms/contest";
		        } else {
		        	Publication contest = new Publication();
		        	contest.setTitle(form.getTitle());
		        	contest.setContents(form.getContents());
		        	contestDao.addPublication(contest);
		            return "redirect:/";

		        }
		    }
}
		    

		

	

