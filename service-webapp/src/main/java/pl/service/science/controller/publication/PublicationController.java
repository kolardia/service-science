package pl.service.science.controller.publication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Request;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import DTO.ContestDTO;
import DTO.PublicationCategoryDTO;
import DTO.SelectDTO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.domain.Category;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.translation.dao.LanguageDAO;
import pl.service.science.translation.dao.TranslationDAO;
import pl.service.science.translation.dao.TranslationTextDAO;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.domain.Language;
import pl.service.science.translation.domain.TextTranslation;
import pl.service.science.translation.service.TranslationService;

@Controller
public class PublicationController {

	final static Logger logger = Logger.getLogger(PublicationController.class);

	// @Autowired
	// protected ServicePublication service;
	@Autowired
	protected ServicePublication service;

	@Autowired
	TranslationService serviceTranslation;

	@Autowired
	TranslationTextDAO serviceTranslationText;

	@Autowired
	LanguageDAO serviceLanguage;

	
	@RequestMapping("panel/editor/published")
	public String published(Model model) {

			model.addAttribute("info", "Controler published");
			return "admin/panel/editorialPanel/publicationsPanel/list/published";

		}

	@RequestMapping("panel/editor/published/sketches")
	public String publishedSketches(Model model, Locale locale) {
		
		model.addAttribute("info", "Controler sketches");
		return "admin/panel/editorialPanel/publicationsPanel/list/published";
	}
	
	@RequestMapping("panel/editor/published/type")
	public String publishedType(Model model, Locale locale) {
		
		model.addAttribute("info", "Controler TYPE");
		return "admin/panel/editorialPanel/publicationsPanel/list/published";
	}

	@RequestMapping("panel/editor/published/search")
	public String publishedSearch(Model model, Locale locale) {
		
		model.addAttribute("info", "Controler search");
		return "admin/panel/editorialPanel/publicationsPanel/list/published";
	}

	@RequestMapping("panel/editor/published/pl")
	public String publishedPL(Model model, Locale locale) {
		
		model.addAttribute("info", "Controler pl");
		return "admin/panel/editorialPanel/publicationsPanel/list/published";
	}
	
	@RequestMapping("panel/editor/published/en")
	public String publishedEN(Model model, Locale locale) {
		
		model.addAttribute("info", "Controler en");
		return "admin/panel/editorialPanel/publicationsPanel/list/published";
	}

	@RequestMapping("/publication/{id}")
	public String detailPublication(@PathVariable("id") Long id, Model model) {

		// Publication contestTemp = new Publication();
		// contestTemp = service.findById(id);

		// PublicationCategory categoryTemp = contestTemp.getCategory();

		// logger.info("contestDao.getPublication(id): " + contestTemp +
		// contestTemp.getTitle() + contestTemp.getContents());
		// model.addAttribute("title", contestTemp.getTitle());
		// model.addAttribute("contents", contestTemp.getContents());
		// model.addAttribute("category", categoryTemp.getName());

		return "details/contest";
	}

	@RequestMapping("/publication/add")
	public String addPublication(Model model) {

		model.addAttribute("info", "PUBLICATION");
		return "forms/contest";
	}

	@RequestMapping("publication/form")
	public String showFormPublication(@ModelAttribute("form") @Valid ContestDTO form, BindingResult result,
			Model model2) {
		if (result.hasErrors()) {

			model2.addAttribute("info", "form not normal!");

			return "forms/contest";

		} else {

			Translation tIdTitle = new Translation();
			serviceTranslation.save(tIdTitle);

			TextTranslation titleTranslation = new TextTranslation();
			titleTranslation.setLanguage(serviceLanguage.findById(new Long(1)));
			titleTranslation.setTranslation(tIdTitle);
			titleTranslation.setText(form.getTitle());
			serviceTranslationText.save(titleTranslation);

			Translation tIdContents = new Translation();
			serviceTranslation.save(tIdContents);

			TextTranslation contentsTranslation = new TextTranslation();
			contentsTranslation.setLanguage(serviceLanguage.findById(new Long(1)));
			contentsTranslation.setTranslation(tIdContents);
			contentsTranslation.setText(form.getContents());
			serviceTranslationText.save(contentsTranslation);

			Publication contest = new Publication();

			contest.setTitle(tIdTitle);
			contest.setContents(tIdContents);

			service.save(contest);

			return "redirect:/";

		}
	}
	@RequestMapping("panel/editor/published/form")
	public String showFormPublicationCategory(@ModelAttribute("form") @Valid PublicationCategoryDTO form,
			BindingResult result, Model model2) {
		if (result.hasErrors()) {

			model2.addAttribute("info", "form not normal!");

			return "forms/category";
		} else {
			Category categoryTemp = new Category();
			categoryTemp.setId(form.getId());
			// categoryTemp.setName(form.getName());

			// ublicationDao.addPublication(contest);

			return "redirect:/";

		}
	}

	@RequestMapping("panel/editor/published/f")
	public String published() {

		return "admin/panel/editorialPanel/publicationsPanel/list/published";

		/*
		 * Locale locale = RequestContextUtils.getLocale(request);
		 * 
		 * List<ContestDTO> contest = new ArrayList<ContestDTO>(); ContestDTO
		 * element = new ContestDTO();
		 * 
		 * for (Publication publication : service.findAll()) { ContestDTO
		 * tempContest = new ContestDTO();
		 * 
		 * tempContest.setTitle(serviceTranslation.
		 * ifExistFinefindByTranslationAndLanguage(publication.getTitle(),
		 * locale)); tempContest.setTitle(serviceTranslation.
		 * ifExistFinefindByTranslationAndLanguage(publication.getContents(),
		 * locale)); contest.add(tempContest); } model.addAttribute("element",
		 * element); model.addAttribute("collection", contest);
		 * 
		 * return "admin/panel/editorialPanel/publicationsPanel/list/published";
		 */
	}
/*
 * 
 * @RequestMapping("panel/editor/published")
	public String publishedForm(@ModelAttribute("form") @Valid SelectDTO form, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {

			model.addAttribute("info", "error");
			// formularz nie jest uzupełniony prawidłowo
			return "admin/panel/editorialPanel/publicationsPanel/list/published";
		} else {
			model.addAttribute("info", "dziala");

			Locale locale = RequestContextUtils.getLocale(request);
			if (form.getLanuage() != null) {

				// locale.setDefault(locale.ENGLISH);

			}
			List<ContestDTO> contest = new ArrayList<ContestDTO>();
			ContestDTO element = new ContestDTO();

			for (Publication publication : service.findAll()) {
				ContestDTO tempContest = new ContestDTO();

				tempContest.setTitle(
						serviceTranslation.ifExistFinefindByTranslationAndLanguage(publication.getTitle(), locale));
				tempContest.setTitle(
						serviceTranslation.ifExistFinefindByTranslationAndLanguage(publication.getContents(), locale));
				contest.add(tempContest);
			}
			model.addAttribute("element", element);
			model.addAttribute("collection", contest);

			return "admin/panel/editorialPanel/publicationsPanel/list/published";

		}

	}
 * */
}
