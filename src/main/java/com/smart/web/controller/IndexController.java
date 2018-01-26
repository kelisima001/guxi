package com.smart.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Info;
import com.smart.model.InfoCond;
import com.smart.model.SelectItem;
import com.smart.model.Software;
import com.smart.model.SoftwareCond;

@Controller
public class IndexController extends BaseController {
	@RequestMapping(value = "index.html")
	public String index(Model model, PageRequest pageRequest) {
		pageRequest.setLimit(5);
		InfoCond cond = new InfoCond();
		SelectItem item = selectItemService.findByCode("info.type.company");
		cond.setTypeId(item.getId());
		cond.addOrderByDesc("timeCreated");
		Page<Info> infoPage = infoService.findAll(pageRequest, cond);
		List<Info> infos = infoPage.getContent();
		model.addAttribute("infos", infos);
		
		pageRequest.setLimit(3);
		SelectItem item1 = selectItemService.findByCode("info.type.market");
		cond = new InfoCond();
		cond.setTypeId(item1.getId());
		cond.addOrderByDesc("timeCreated");
		Page<Info> result = infoService.findAll(pageRequest, cond);
		List<Info> activities = result.getContent();
		model.addAttribute("activities", activities);
		
		pageRequest.setLimit(3);
		SelectItem item2 = selectItemService.findByCode("info.type.company");
		cond = new InfoCond();
		cond.setTypeId(item2.getId());
		cond.addOrderByDesc("timeCreated");
		Page<Info> result1 = infoService.findAll(pageRequest, cond);
		List<Info> activities1 = result1.getContent();
		model.addAttribute("activities1", activities1);
		
		pageRequest.setLimit(3);
		SoftwareCond softwareCond = new SoftwareCond();
		softwareCond.addOrderByAsc("sort");
		Page<Software> page = softwareService.findAll(pageRequest, softwareCond);
		model.addAttribute("softwares", page.getContent());
		
		model.addAttribute("marketActivityInfoType", item1);
		model.addAttribute("companyActivityInfoType", item2);
		
		return "index";
	}
	
	@RequestMapping(value = "/")
	public String index1(Model model, PageRequest pageRequest) {
		return index(model, pageRequest);
	}
	
	@RequestMapping(value = "geguqiquan.html")
	public String gequqiquan() {
		return "geguqiquan";
	}
	
	
}
