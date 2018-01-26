package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.consts.Status;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;

@Controller
public class SelectTypeController extends BaseController{
	@RequestMapping(value = "admin/selectType/list")
	public String list(PageRequest pageRequest, Model model){
		Page<SelectType> page = selectTypeService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/selectType/list";
	}
	
	@RequestMapping(value = "admin/selectType/edit", method=RequestMethod.GET)
	public String preEdit(Long id, Model model) {
		if(id!=null){
			SelectType selectType = selectTypeService.findOne(id);
			selectType.setItems(selectItemService.findBySelectTypeId(id));
			model.addAttribute("obj", selectType);
		}
		return "admin/selectType/edit";
	}
	
	@RequestMapping(value = "admin/selectType/edit", method=RequestMethod.POST)
	public String edit(SelectType form, Model model, RedirectAttributes ra) {
		if(form.getId()==null){
			SelectType selectType = selectTypeService.findByCode(form.getCode());
			if(selectType!=null){
				super.setErrorMsg(model, "选项类型key已经存在");
				model.addAttribute("obj", form);
				return "admin/selectType/edit";
			}
		}
		selectTypeService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/selectType/delete")
	public @ResponseBody String delete(Long id) {
		selectTypeService.delete(id);
		return "OK";
	}
	
	@RequestMapping(value = "admin/selectType/{selectTypeId}/addItem")
	public @ResponseBody String addItem(@PathVariable Long selectTypeId, String name) {
		SelectItemCond cond = new SelectItemCond();
		cond.setName(name);
		cond.setSelectTypeId(selectTypeId);
		long count = selectItemService.count(cond);
		
		if(count>0) {
			return "EXISTS";
		}
		
		SelectType type = selectTypeService.findOne(selectTypeId);
		SelectItem newItem = new SelectItem();
		newItem.setSelectType(type);
		newItem.setName(name);
		selectItemService.save(newItem);
		return "OK";
	}
	
	@RequestMapping(value = "admin/selectType/{selectTypeId}/saveItem")
	public @ResponseBody String saveItem(@PathVariable Long selectTypeId, SelectItem item) {
		SelectItemCond cond = new SelectItemCond();
		cond.setName(item.getName());
		cond.setSelectTypeId(selectTypeId);
		
		SelectType type = selectTypeService.findOne(selectTypeId);
		item.setSelectType(type);
		selectItemService.save(item);
		return "OK";
	}
	
	@RequestMapping(value = "admin/selectType/disableSelectItem")
	public @ResponseBody String disableItem(Long itemId) {
		SelectItem item = selectItemService.findOne(itemId);
		item.setStatus(Status.inactive);
		selectItemService.save(item);
		return "OK";
	}
	
	@RequestMapping(value = "admin/selectType/enableSelectItem")
	public @ResponseBody String enableItem(Long itemId) {
		SelectItem item = selectItemService.findOne(itemId);
		item.setStatus(Status.active);
		selectItemService.save(item);
		return "OK";
	}
	
}
