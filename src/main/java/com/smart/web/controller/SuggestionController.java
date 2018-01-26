package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Suggestion;

@Controller
public class SuggestionController extends BaseController{
	@RequestMapping(value = "admin/listSuggestion")
	public String listSuggestion(PageRequest pageRequest, Model model) {
		Page<Suggestion> page = suggestionService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/listSuggestion";
	}
	
	@RequestMapping(value = "addSuggestion")
	public @ResponseBody String addSuggestion(Suggestion form) {
		suggestionService.save(form);
		return "OK";
	}
}
