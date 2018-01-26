package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.exception.AppRtException;
import com.smart.model.Dict;

@Controller
public class DictController extends BaseController{
	@RequestMapping(value = "admin/dict/list")
	public String listDict(PageRequest pageRequest, Model model){
		Page<Dict> page = dictService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/dict/list";
	}
	
	@RequestMapping(value = "admin/dict/edit", method=RequestMethod.GET)
	public String preEditDict(Long id, Model model) {
		if(id!=null){
			Dict dict = dictService.findOne(id);
			model.addAttribute("dict", dict);
		}
		return "admin/dict/edit";
	}
	
	@RequestMapping(value = "admin/dict/edit", method=RequestMethod.POST)
	public String editDict(Dict form, Model model, RedirectAttributes ra) {
		if(form.getId()==null){
			Dict dict = dictService.getDict(form.getModule(), form.getCode());
			if(dict!=null){
				super.setErrorMsg(model, "字典项已经存在");
				model.addAttribute("dict", form);
				return "admin/dict/edit";
			}
		}
		dictService.save(form);
		model.addAttribute("dict", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}

	@RequestMapping(value = "admin/dict/edit1", method=RequestMethod.POST)
	public @ResponseBody String editDict1(Dict form, RedirectAttributes ra) {
		if(form.getId()==null){
			Dict dict = dictService.getDict(form.getModule(), form.getCode());
			if(dict!=null){
				throw new AppRtException("sys.031", "字典项已存在");
			}
		}
		dictService.save(form);
		return "OK";
	}
	
	@RequestMapping(value = "admin/dict/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteDict(Long id) {
		dictService.delete(id);
		return "OK";
	}
	
}
