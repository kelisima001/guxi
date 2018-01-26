package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.InfoRecommend;

@Controller
public class InfoRecommendController extends BaseController{
	@RequestMapping(value = "admin/infoRecommend/list")
	public String listInfoRecommend(PageRequest pageRequest, Model model){
		Page<InfoRecommend> page = infoRecommendService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/infoRecommend/list";
	}
	
	@RequestMapping(value = "admin/infoRecommend/edit", method=RequestMethod.GET)
	public String preEditInfoRecommend(Long id, Model model) {
		if(id!=null){
			InfoRecommend infoRecommend = infoRecommendService.findOne(id);
			model.addAttribute("obj", infoRecommend);
		}
		return "admin/infoRecommend/edit";
	}
	
	@RequestMapping(value = "admin/infoRecommend/add", method=RequestMethod.GET)
	public @ResponseBody String add(InfoRecommend form, Model model) {
		boolean exist = infoRecommendService.recommendExists(form.getType(), form.getInfo().getId());
		if(exist) {
			return "EXISTS";
		}
		infoRecommendService.save(form);
		return "OK";
	}
	
	@RequestMapping(value = "admin/infoRecommend/edit", method=RequestMethod.POST)
	public String editInfoRecommend(InfoRecommend form, Model model) {
		InfoRecommend dbObj = infoRecommendService.findOne(form.getId());
		dbObj.setSort(form.getSort());
		infoRecommendService.save(dbObj);
		model.addAttribute("obj", dbObj);
		setSuccessMsg(model);
		return "admin/infoRecommend/edit";
	}
	
	@RequestMapping(value = "admin/infoRecommend/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteInfoRecommend(Long id) {
		infoRecommendService.delete(id);
		return "OK";
	}
	

}
