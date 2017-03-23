package pl.service.science.controller.authorization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.service.science.authorization.domain.User;

@Controller
public class SectionsController {
	
	/** SART PAGE : SERVICE ==> SECTION DESCRIPTIOM IN THE POLISH LANGUAGE **/
	@RequestMapping("/panel/service/section/pl")
	public String plSection(Model model) {
		model.addAttribute("info", "service panel!");
		
		// FULL DESCRIPTION
		model.addAttribute("phone", "service panel!");
		
		// SECTION
		
		model.addAttribute("phone", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("address", "service panel!");
		model.addAttribute("city", "service panel!");
		model.addAttribute("province", "service panel!");
		model.addAttribute("country", "service panel!");

		// ORGANIZE
		
		User user = new User();
		model.addAttribute("name", user);
		
		model.addAttribute("name", "service panel!");
		model.addAttribute("surname", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("phone", "service panel!");
		model.addAttribute("account", "service panel!");

	
		// CENTER
		
		model.addAttribute("phone", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("address", "service panel!");
		model.addAttribute("city", "service panel!");
		model.addAttribute("province", "service panel!");
		model.addAttribute("country", "service panel!");
		
		// GALERIA
		
		
		return "admin/panel/serviceNavigation";
	}
	/**  PAGE MENU: SERVICE ==> SECTION DESCRIPTION IN THE ENGLISH LANGUAGE **/
	@RequestMapping("/panel/service/section/en")
	public String enSectionOrganize(Model model) {
		
		// FULL DESCRIPTION
		model.addAttribute("phone", "service panel!");
		
		// SECTION
		
		model.addAttribute("phone", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("address", "service panel!");
		model.addAttribute("city", "service panel!");
		model.addAttribute("province", "service panel!");
		model.addAttribute("country", "service panel!");

		// ORGANIZE
		
		model.addAttribute("name", "service panel!");
		model.addAttribute("surname", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("phone", "service panel!");
		model.addAttribute("account", "service panel!");

	
		// CENTER
		
		model.addAttribute("phone", "service panel!");
		model.addAttribute("mail", "service panel!");
		model.addAttribute("address", "service panel!");
		model.addAttribute("city", "service panel!");
		model.addAttribute("province", "service panel!");
		model.addAttribute("country", "service panel!");
		
		// GALERIA
		
		
		return "admin/panel/serviceNavigation";
	} 

}
