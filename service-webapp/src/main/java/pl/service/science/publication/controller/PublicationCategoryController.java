package pl.service.science.publication.controller;

import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.service.science.publication.dao.DaoPublicationCategory;
import pl.service.science.publication.domain.PublicationCategory;
import pl.service.science.publication.forms.ContestDTO;
import pl.service.science.publication.forms.PublicationCategoryDTO;
import pl.service.science.publication.service.ServicePublicationCategory;

@Controller
public class PublicationCategoryController {

	final static Logger logger = Logger.getLogger(PublicationCategoryController.class);
	
	@Autowired
	ServicePublicationCategory serviceCategory;

	
    @RequestMapping("/category")
    public String showIndexCategory(Model model) {
  	  PublicationCategory category = new PublicationCategory();
  	  
  		 model.addAttribute("category", category);
  		 model.addAttribute("collectionCategory", serviceCategory.findAll());
  		 
	        return "index";
	    }
    
    @RequestMapping("/category/{id}")
    public String detailCategory(@PathVariable("id") Long id, Model model) {
    	
    	PublicationCategory categoryTemp= new PublicationCategory();
    	categoryTemp = serviceCategory.findById(id);
    	
    	model.addAttribute("title", categoryTemp.getId());
        model.addAttribute("contents", categoryTemp.getName());
    	
        return "details/contest";
    }
    
	@RequestMapping("/category/add")
    public String addPublicationCategory(Model model) {
		
        return "forms/category";
    } 
	

    
    @RequestMapping("category/form")
    public String showFormPublicationCategory(@ModelAttribute("form") @Valid PublicationCategoryDTO form, BindingResult result, Model model2) {
        if (result.hasErrors()) {
        	
        	model2.addAttribute("info", "form not normal!");

            return "forms/category";
        } else {
        	PublicationCategory categoryTemp= new PublicationCategory();
        	categoryTemp.setId(form.getId());
        	categoryTemp.setName(form.getName());
 
        	//ublicationDao.addPublication(contest);
        	serviceCategory.save(categoryTemp);
        
        	
            return "redirect:/";

        }
    }
}