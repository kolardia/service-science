package pl.service.science.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.service.science.user.domain.User;

@Controller
public class UsersController {
	
	@RequestMapping("/panel/service/base_address/organizer")
	public String baseAddressForOrganizer(Model model) {
		
		User user = new User();
		user.setName("Monika");
		user.setEmail("kolardia@gmail.com");
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		
		//model.addAttribute("name", user.name);
		//model.addAttribute("surname", "service panel!");
		//model.addAttribute("phone", "service panel!");
		//model.addAttribute("mail", user.email);
		//model.addAttribute("enabled", user.enabled);

		return "admin/panel/serviceNavigation";
	}
	
	@RequestMapping("/panel/service/base_address/editors")
	public String baseAddressForEditors(Model model) {
		
		User user = new User();
		user.setName("Monika");
		user.setEmail("kolardia@gmail.com");
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		
		//model.addAttribute("name", user.name);
		//model.addAttribute("surname", "service panel!");
		//model.addAttribute("phone", "service panel!");
		//model.addAttribute("mail", user.email);
		//model.addAttribute("enabled", user.enabled);

		return "admin/panel/serviceNavigation";
	}
	
	
	@RequestMapping("/panel/service/base_address/search") //P?
	public String baseAddressForSearch(Model model) {
		
		User user = new User();
		user.setName("Monika");
		user.setEmail("kolardia@gmail.com");
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		
		//model.addAttribute("name", user.name);
		//model.addAttribute("surname", "service panel!");
		//model.addAttribute("phone", "service panel!");
		//model.addAttribute("mail", user.email);
		//model.addAttribute("enabled", user.enabled);

		return "admin/panel/serviceNavigation";
	}
	
}
