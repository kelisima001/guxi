package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Product;
import com.smart.model.ProductCond;

@Controller
public class ProductController extends BaseController{
	@RequestMapping(value = "admin/product/list")
	public String listProduct(PageRequest pageRequest, ProductCond cond, Model model){
		cond.addOrderByDesc("sort");
		Page<Product> page = productService.findAll(pageRequest, cond);
		model.addAttribute("page", page);
		return "admin/product/list";
	}
	
	@RequestMapping(value = "admin/product/edit", method=RequestMethod.GET)
	public String preEditProduct(Long id, Model model) {
		if(id!=null){
			Product product = productService.findOne(id);
			model.addAttribute("obj", product);
		}
		return "admin/product/edit";
	}
	
	@RequestMapping(value = "admin/product/edit", method=RequestMethod.POST)
	public String editProduct(Product form, Model model, RedirectAttributes ra) {
		productService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/product/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteProduct(Long id) {
		productService.delete(id);
		return "OK";
	}
	
	@RequestMapping(value = "product/list")
	public String listProduct1(PageRequest pageRequest, ProductCond cond, Model model){
		cond.addOrderByDesc("sort");
		Page<Product> page = productService.findAll(pageRequest, cond);
		model.addAttribute("page", page);
		return "product/list";
	}
	
	@RequestMapping(value = "product/{id}.html")
	public String listProduct1(@PathVariable Long id, Model model){
		Product product = productService.findOne(id);
		model.addAttribute("obj", product);
		return "product/view";
	}
	

}
