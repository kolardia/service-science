package pl.service.science.publication.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.service.science.translation.dao.DaoTranslation;
import pl.service.science.translation.domain.Translation;

@Controller
public class TranslationController {

	static Logger logger = Logger.getLogger(TranslationController.class);

	@Autowired
	protected DaoTranslation serviceTranslation;

	@RequestMapping("/translation")
	public String showIndex(HttpServletRequest request, Model model) {
		Translation translation = new Translation();

		model.addAttribute("translation", translation);
		model.addAttribute("collectionTranslation", serviceTranslation.findAll());
		// model.addAttribute("collection", service.searchLanguage(language,
		// publicationDao.getPublications_en("SELECT k FROM Publication k WHERE
		// id<1"), publicationDao.getPublications_en("SELECT k FROM Publication
		// k")));

		return "index";
	}

}
