package com.smart.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Info;
import com.smart.model.InfoTag;
import com.smart.model.InfoTagCond;
import com.smart.model.Tag;
import com.smart.util.CollectionUtil;

@Controller
public class InfoTagController extends BaseController{
	@RequestMapping(value = "admin/infoTag/list")
	public String listInfoTag(PageRequest pageRequest, Model model){
		Page<InfoTag> page = infoTagService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/infoTag/list";
	}
	
	@RequestMapping(value = "infoTag/add")
	public @ResponseBody String addInfoTag(Long infoId, Long tagId, Model model){
		InfoTagCond cond = new InfoTagCond();
		cond.setInfoId(infoId);
		cond.setTagId(tagId);
		List<InfoTag> list = infoTagService.find(cond);
		if(CollectionUtil.isNotEmpty(list)) {
			return "OK";
		}
		
		InfoTag obj = new InfoTag();
		Info info = new Info();
		info.setId(infoId);
		Tag tag = new Tag();
		tag.setId(tagId);
		obj.setInfo(info);
		obj.setTag(tag);
		infoTagService.save(obj);
		return "OK";
	}
	
	@RequestMapping(value = "infoTag/delete")
	public @ResponseBody String deleteInfoTag(Long infoId, Long tagId, Model model){
		InfoTagCond cond = new InfoTagCond();
		cond.setInfoId(infoId);
		cond.setTagId(tagId);
		List<InfoTag> list = infoTagService.find(cond);
		for(InfoTag it : list) {
			infoTagService.delete(it);
		}
		return "OK";
	}
	
	@RequestMapping(value = "admin/infoTag/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteInfoTag(Long id) {
		infoTagService.delete(id);
		return "OK";
	}
	

}
