package pl.service.science;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
	
		    @RequestMapping("/")
		    public String showIndex(Model model) {
		        model.addAttribute("message", "Publications | BASE");
	
     	        return "index";
		    }
}
		    
		
		

	

