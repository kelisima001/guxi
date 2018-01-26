package com.smart.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.model.Menu;
import com.smart.util.CollectionUtil;

@Controller
public class MenuController extends BaseController{
	@RequestMapping(value = "admin/menu/list")
	public String listMenu(Long parentId, Model model){
		Menu parent = null;
		if(parentId==null){
			parent = menuService.findOneBy("code", Menu.ROOT_MENU_CODE);
			parentId = parent.getId();
		}
		else{
			parent = menuService.findOne(parentId);
		}
		List<Menu> list = menuService.findBy("parent.id", parentId);
		model.addAttribute("list", list);
		model.addAttribute("parent", parent);
		return "admin/menu/list";
	}
	
	@RequestMapping(value = "admin/menu/edit", method=RequestMethod.GET)
	public String preEditMenu(Long id, Long parentId, Model model) {
		if(id!=null){
			Menu menu = menuService.findOne(id);
			model.addAttribute("obj", menu);
		}
		else if(parentId!=null){
			// 添加子菜单
			Menu parent = menuService.findOne(parentId);
			Menu menu = new Menu();
			menu.setParent(parent);
			model.addAttribute("obj", menu);
		}
		return "admin/menu/edit";
	}
	
	@RequestMapping(value = "admin/menu/edit", method=RequestMethod.POST)
	public String editMenu(Menu form, Model model) {
		menuService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(model);
		return "admin/menu/edit";
	}
	
	@RequestMapping(value = "admin/menu/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteMenu(Long id, HttpServletResponse response) {
		List<Menu> list = menuService.findBy("parent.id", id);
		if(!CollectionUtil.isEmpty(list)){
			try {
				response.sendError(501);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		menuService.delete(id);
		return "OK";
	}
	

}
