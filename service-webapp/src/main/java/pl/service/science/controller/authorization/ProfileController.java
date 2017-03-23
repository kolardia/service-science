package pl.service.science.controller.authorization;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import DTO.ProfileDTO;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.UserService;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.translation.service.LanguageService;
import pl.service.science.translation.service.TranslationTextService;

/*
 * https://docs.oracle.com/javase/tutorial/i18n/locale/create.html
 * http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html Region Codes
 * Country A 2 A 3 Number POLAND PL POL 616
 */
/*
 * http://www.loc.gov/standards/iso639-2/php/code_list.php Language Code
 * ISO 639-2 Code ISO 639-1 Code English name of Language pol pl Polish
 */

@Controller
public class ProfileController {

	@Autowired
	protected LanguageService serviceLanguage;

	@Autowired
	protected UserService serviceUser;

	@Autowired
	protected LocationService serviceLocation;

	@Autowired
	protected CityService serviceCity;

	@Autowired
	TranslationTextService serviceTranslation;

	@RequestMapping("/panel/editor/profile")
	public String profile(HttpServletRequest request, Model model) {

		Locale locale = RequestContextUtils.getLocale(request);

		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");

		ProfileDTO tempProfil = new ProfileDTO();

		tempProfil.setName(user.getName());
		tempProfil.setSurname("Senderecka");
		tempProfil.setEmail(user.getEmail());
		tempProfil.setPhone("884-456-876");
		// tempProfil.setAddress(
		// String.valueOf((user.getAddressOfResidence().getId())));

		model.addAttribute("editor", tempProfil);

		return "admin/panel/editorialPanel/profileMenu";

	}

	@RequestMapping(value = "panel/editor/profile/edition")
	public String profileEdition() {

		return "admin/panel/editorialPanel/profilePanel/edition";
	}

	@RequestMapping(value = "panel/editor/profile/upade")
	public @ResponseBody String profileUpade(HttpServletRequest request,
			@ModelAttribute("profil") @Valid ProfileDTO profil, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "error";
		} else {

			User userTemp = new User();

			userTemp.setName(profil.getName());
			serviceUser.save(userTemp);

			// userTemp.setEmail(profil.getEmail()); serviceUser.save(userTemp);

			/*
			 * Location location = new Location();
			 * location.setPostalAddress(form.getAddress());
			 * location.setRegon(serviceLocation.findOrSaveRegion("PL",
			 * form.getProvince(), form.getCountry()));
			 * location.setCity(serviceCity.newCity(form.getCity(), "PL"));
			 * 
			 * serviceLocation.save(location);
			 * userTemp.setAddressOfResidence(location);
			 */

			return "sukces";
		}
	}

	@RequestMapping("/panel/editor/profile/pl")
	public String profileEditorPL(Model model) {

		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");

		ProfileDTO tempProfil = new ProfileDTO();

		tempProfil.setName(user.getName());
		tempProfil.setSurname("xxx");
		tempProfil.setEmail(user.getEmail());
		tempProfil.setPhone("pppppp");
		// tempProfil.setAddress(
		// String.valueOf((user.getAddressOfResidence().getId())));

		model.addAttribute("editor", tempProfil);

		return "admin/panel/editorialPanel/profileMenu";
	}

	@RequestMapping("/panel/editor/profile/en")
	public String profileEditorEN(Model model) {

		ProfileDTO tempProfil = new ProfileDTO();

		User user = new User();
		user = serviceUser.CheckingUser("m.senderecka@gmail.com");
		tempProfil.setName(user.getName());
		tempProfil.setSurname("xxx");
		tempProfil.setEmail(user.getEmail());
		tempProfil.setPhone("pppppp");

		// serviceTranslation.findByTranslationAndLanguage(transation ,
		// this.selectedLocale(langCode));

		model.addAttribute("editor", tempProfil);

		return "admin/panel/editorialPanel/profileMenu";
	}

	@RequestMapping(value = "/panel/editor/profile/form")
	public String profileUserForm(HttpServletRequest request, Model model) {

		return "admin/panel/editorialPanel/profilePanel/userForm";

	}
	/*
	 * @RequestMapping(value = "/panel/editor/profile/edition") public String
	 * profileEdition(HttpServletRequest request, Model model) {
	 * 
	 * /* User user = new User(); user =
	 * serviceUser.findByEmail("m.senderecka@gmail.com");
	 * tempProfil.setName(user.getName()); tempProfil.setSurname("xxx");
	 * tempProfil.setEmail(user.getEmail()); tempProfil.setPhone("pppppp");
	 * model.addAttribute("editor", tempProfil);
	 *//*
		 * 
		 * return "admin/panel/editorialPanel/profilePanel/edition";
		 * 
		 * }
		 */

	@RequestMapping("/panel/editor/profile/deactivation")
	public String profileDeactivation(Model model) {

		model.addAttribute("info",
				"porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci veniam, quis nostrum exer ");

		return "admin/panel/editorialPanel/profilePanel/deactivation";
	}

}
