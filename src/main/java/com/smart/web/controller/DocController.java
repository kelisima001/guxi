package com.smart.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.consts.DocType;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Doc;
import com.smart.model.Menu;
import com.smart.util.IOUtil;
import com.smart.util.JsonUtil;

@Controller
public class DocController extends BaseController{
	@RequestMapping(value = "admin/doc/list")
	public String listDoc(PageRequest pageRequest, Model model){
		Page<Doc> page = docService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/doc/list";
	}
	
	@RequestMapping(value = "admin/doc/edit", method=RequestMethod.GET)
	public String preEditDoc(Long id, Model model) {
		if(id!=null){
			Doc doc = docService.findOne(id);
			model.addAttribute("doc", doc);
		}
		return "admin/doc/edit";
	}
	
	@RequestMapping(value = "admin/doc/edit", method=RequestMethod.POST)
	public String editDoc(Doc form, Model model, RedirectAttributes ra) {
		docService.save(form);
		model.addAttribute("doc", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}

	@RequestMapping(value = "doc/view/${id}", method=RequestMethod.GET)
	public void preEditDoc(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Doc doc = docService.findOne(id);
		String content = doc.getContent();
		if(content!=null){
			content = content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		}
		IOUtil.copy(new ByteArrayInputStream(content.getBytes("utf-8")),response.getOutputStream());
	}
	
	@RequestMapping(value = "listDocByType", method=RequestMethod.GET)
	public void listDoc(DocType type, HttpServletResponse response) throws IOException {
		List<Doc> docs = docService.findBy("type", type);
		String result = JsonUtil.collection2json(docs);
		IOUtil.copy(new ByteArrayInputStream(result.getBytes("utf-8")),response.getOutputStream());
	}
	
	@RequestMapping(value = "viewDoc", method=RequestMethod.GET)
	public String viewDoc(String code, Long id, String menu2Code, String menu1Highlight, String menu2Highlight, 
				HttpServletResponse response, Model model) throws IOException {
		Doc doc = null;
		if(code!=null){
			doc = docService.findOneBy("code", code);
		}
		else if(id!=null){
			doc = docService.findOne(id);
		}
		if(doc==null){
			throw new NullPointerException("找不到文档");
		}
		List<Menu> menus = menuService.findBy("parent.code", menu2Code);
		model.addAttribute("doc", doc);
		model.addAttribute("menus", menus);
		model.addAttribute("menu1Highlight", menu1Highlight);
		model.addAttribute("menu2Highlight", menu2Highlight);
		return "viewDoc";
	}
	
}
