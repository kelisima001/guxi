package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.CompanyHistory;

@Controller
public class CompanyHistoryController extends BaseController{
	@RequestMapping(value = "admin/companyHistory/list")
	public String listCompanyHistory(PageRequest pageRequest, Model model){
		Page<CompanyHistory> page = companyHistoryService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/companyHistory/list";
	}
	
	@RequestMapping(value = "admin/companyHistory/edit", method=RequestMethod.GET)
	public String preEditCompanyHistory(Long id, Model model) {
		if(id!=null){
			CompanyHistory companyHistory = companyHistoryService.findOne(id);
			model.addAttribute("obj", companyHistory);
		}
		return "admin/companyHistory/edit";
	}
	
	@RequestMapping(value = "admin/companyHistory/edit", method=RequestMethod.POST)
	public String editCompanyHistory(CompanyHistory form, Model model, RedirectAttributes ra) {
		companyHistoryService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/companyHistory/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteCompanyHistory(Long id) {
		companyHistoryService.delete(id);
		return "OK";
	}
	

}
