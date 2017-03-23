package pl.service.science.controller.publication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import DTO.ContestDTO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Controller
@RequestMapping("/panel/editor/archives")
public class ArchiveController {

	@Autowired
	protected ServicePublication service;

	@Autowired
	TranslationService serviceTranslation;

	@RequestMapping("/")
	public String selectAllArchives(Model model, HttpServletRequest request) {
		model.addAttribute("info", "archives");
		Locale locale = RequestContextUtils.getLocale(request);
		List<ContestDTO> contest = new ArrayList<ContestDTO>();
		ContestDTO element = new ContestDTO();
		for (Publication publication : service.findAll()) {
			ContestDTO tempContest = new ContestDTO();
			tempContest.setTitle(	serviceTranslation.CheckingTextTranslation(publication.getTitle(), locale));
			contest.add(tempContest);
		}
		model.addAttribute("element", element);
		model.addAttribute("collection", contest);
		return "admin/panel/editorialPanel/archivesPanel/list/allArchives";
	}

	@RequestMapping("/en")
	public String selectAllArchivesEn(Model model) {

		Locale enLocale = Locale.ENGLISH;
		model.addAttribute("info", "archives");

		List<ContestDTO> contest = new ArrayList<ContestDTO>();
		ContestDTO element = new ContestDTO();

		for (Publication publication : service.findAll()) {
			ContestDTO tempContest = new ContestDTO();

			tempContest.setTitle(
					serviceTranslation.CheckingTextTranslation(publication.getTitle(), enLocale));
			contest.add(tempContest);
		}
		model.addAttribute("element", element);
		model.addAttribute("collection", contest);

		return "admin/panel/editorialPanel/archivesPanel/list/allArchives";
	}

	@RequestMapping("/pl")
	public String selectAllArchivesPl(Model model) {



		Locale plLocale = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
		model.addAttribute("info", "archives");

		List<ContestDTO> contest = new ArrayList<ContestDTO>();
		ContestDTO element = new ContestDTO();

		for (Publication publication : service.findAll()) {
			ContestDTO tempContest = new ContestDTO();

			tempContest.setTitle(
					serviceTranslation.CheckingTextTranslation(publication.getTitle(), plLocale));
			contest.add(tempContest);
		}
		model.addAttribute("element", element);
		model.addAttribute("collection", contest);

		return "admin/panel/editorialPanel/archivesPanel/list/allArchives";
	}

	@RequestMapping("/add")
	public String addArchive(Model model) {

		Publication contest = new Publication();

		contest.setTitle(service.insert(new Translation()));
		contest.setContents(service.insert(new Translation()));

		service.save(contest);

		service.saveText(contest.getTitle(), "xxxx dupa se jest 31 grudniA", "PL");
		service.saveText(contest.getTitle(), "new publication title en", "EN");
		service.saveText(contest.getContents(), "new publication contents pl", "PL");
		service.saveText(contest.getContents(), "new publication contents en", "EN");

		model.addAttribute("info", "archives");
		return "admin/panel/editorialPanel/archivesPanel/new";
	}

	@RequestMapping("/search-title")
	public String searchArchive(Model model) {

		model.addAttribute("info", "search title");
		return "admin/panel/editorialPanel/archivesPanel/list/searchArchive";
	}

	@RequestMapping("/search-date")
	public String searchDateArchive(Model model) {

		model.addAttribute("info", "search date");
		return "admin/panel/editorialPanel/archivesPanel/list/dateArchive";
	}
}
