package com.smart.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.consts.TagType;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Info;
import com.smart.model.InfoCond;
import com.smart.model.InfoTag;
import com.smart.model.InfoTagCond;
import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;
import com.smart.model.SelectTypeCond;
import com.smart.model.Tag;
import com.smart.model.TagCond;

@Controller
public class InfoController extends BaseController{
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value = "admin/info/list")
	public String listInfo1(PageRequest pageRequest, InfoCond cond, Model model) {
		cond.addOrderByDesc("timeUpdated");
		Page<Info> page = infoService.findAll(pageRequest, cond);
		model.addAttribute("page", page);
		model.addAttribute("cond", cond);
		
		SelectTypeCond typeCond = new SelectTypeCond();
		typeCond.setCode("info.type");
		SelectType type = selectTypeService.findOne(typeCond);
		SelectItemCond selectItemCond = new SelectItemCond();
		selectItemCond.setSelectTypeId(type.getId());
		selectItemCond.addOrderByDesc("sort");
		List<SelectItem> items = selectItemService.find(selectItemCond);
		
		model.addAttribute("infoTypes", items);
		
		return "admin/info/list";
	}
	
	@RequestMapping(value = "info/list")
	public String listInfo(PageRequest pageRequest, InfoCond cond, Model model) {
		pageRequest.setPageSize(3);
		cond.addOrderByDesc("timeUpdated");
		Page<Info> page = infoService.findAll(pageRequest, cond);
		
		model.addAttribute("page", page);
		model.addAttribute("cond", cond);
		
		SelectTypeCond typeCond = new SelectTypeCond();
		typeCond.setCode("info.type");
		SelectType type = selectTypeService.findOne(typeCond);
		SelectItemCond selectItemCond = new SelectItemCond();
		selectItemCond.setSelectTypeId(type.getId());
		selectItemCond.addOrderByDesc("sort");
		List<SelectItem> items = selectItemService.find(selectItemCond);
		
		model.addAttribute("infoTypes", items);
		
		return "info/list";
	}
	
	@RequestMapping(value = "info/{id}.html")
	public String viewSuccInfo(@PathVariable Long id) {
		return handleInfoView(id);
	}
	
	@RequestMapping(value = "admin/info/edit", method=RequestMethod.GET)
	public String preEditInfo(String type, Model model, HttpServletRequest request, Long id) {
		if(id!=null){
			Info info = infoService.findOne(id);
			info.setTimeCreatedStr2(FORMATTER.format(info.getTimeCreated()));
			
			TagCond cond = new TagCond();
			cond.setType(TagType.info);
			List<Tag> tags = tagService.find(cond);
			for(Tag tag : tags) {
				InfoTagCond infoTagCond = new InfoTagCond();
				infoTagCond.setInfoId(id);
				infoTagCond.setTagId(tag.getId());
				InfoTag infoTag = infoTagService.findOne(infoTagCond);
				if(infoTag!=null) {
					tag.setUsed(true);
				}
			}
			model.addAttribute("tags", tags);
			model.addAttribute("obj", info);
		}
		
		return "admin/info/edit";
	}
	
	@RequestMapping(value = "admin/info/edit", method=RequestMethod.POST)
	public String editInfo(Info form, HttpServletRequest request, Model model, RedirectAttributes ra) {
		String time = form.getTimeCreatedStr2();
		if(time!=null && !"".equals(time)) {
			Date d = null;
			try {
				d = FORMATTER.parse(time);
			} catch (ParseException e) {
				d = new Date();
			}
			form.setTimeCreated(d);
		}
		infoService.save(form);
		request.setAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/info/delete")
	public @ResponseBody String delete(Long id) {
		infoService.delete(id);
		return "OK";
	}
	
	
	
	@RequestMapping(value = "viewInfo")
	public String listInfo(Long id, Model model) {
		Info info = infoService.findOne(id);
		model.addAttribute("info", info);
		return "viewInfo";
	}
	
	private String handleInfoView(Long id) {
		Info info = infoService.findOne(id);
		info.setViewCount(info.getViewCount() + 1);
		infoService.save(info);
		super.addRequestAttribute("info", info);
		
		Tag tag = tagService.findOneBy("code", "tag.info.recommand");
		InfoTagCond cond = new InfoTagCond();
		cond.setTagId(tag.getId());
		cond.addOrderByDesc("timeCreated");
		PageRequest pageRequest = new PageRequest(1, 4);
		Page<InfoTag> infos = infoTagService.findAll(pageRequest, cond);
		super.addRequestAttribute("infos", infos.getContent());
		
		InfoCond infoCond = new InfoCond();
		infoCond.setIdGt(info.getId());
		infoCond.addOrderByAsc("id");
		Info nextInfo = infoService.findOne(infoCond);
		
		infoCond = new InfoCond();
		infoCond.setIdLe(info.getId());
		infoCond.addOrderByDesc("id");
		Info preInfo = infoService.findOne(infoCond);
		
		super.addRequestAttribute("preInfo", preInfo);
		super.addRequestAttribute("nextInfo", nextInfo);
		return "info/view";
	}
	
}
