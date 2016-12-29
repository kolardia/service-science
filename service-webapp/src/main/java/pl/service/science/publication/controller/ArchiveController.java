package pl.service.science.publication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchiveController {

	@RequestMapping("/panel/editor/archives")
	public String selectAllArchives(Model model) {
		
		model.addAttribute("info", "archives");
		return "admin/panel/editorialPanel/archivesPanel/list/allArchives";
	}
	
	@RequestMapping("/panel/editor/archives/add")
	public String addArchive(Model model) {
		
		model.addAttribute("info", "archives");
		return "admin/panel/editorialPanel/archivesPanel/new";
	}

	@RequestMapping("/panel/editor/archives/search-title")
	public String searchArchive(Model model) {
		
		model.addAttribute("info", "search title");
		return "admin/panel/editorialPanel/archivesPanel/list/searchArchive";
	}

	@RequestMapping("/panel/editor/archives/search-date")
	public String searchDateArchive(Model model) {
		
		model.addAttribute("info", "search date");
		return "admin/panel/editorialPanel/archivesPanel/list/dateArchive";
	}
}
