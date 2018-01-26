package com.smart.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Gallery;
import com.smart.model.GalleryItem;
import com.smart.util.CollectionUtil;
import com.smart.util.JsonUtil;

@Controller
public class GalleryController extends BaseController{
	@RequestMapping(value = "admin/gallery/list")
	public String listGallery(PageRequest pageRequest, Model model){
		Page<Gallery> page = galleryService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/gallery/list";
	}
	
	@RequestMapping(value = "admin/gallery/edit", method=RequestMethod.GET)
	public String preEditGallery(Long id, Model model) {
		if(id!=null){
			Gallery gallery = galleryService.findOne(id);
			gallery.setItems(galleryItemService.findByGalleryId(id));
			model.addAttribute("gallery", gallery);
		}
		return "admin/gallery/edit";
	}
	
	@RequestMapping(value = "admin/gallery/edit", method=RequestMethod.POST)
	public String editGallery(Gallery form, Model model, RedirectAttributes ra) {
		galleryService.save(form);
		model.addAttribute("gallery", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/gallery/{galleryId}/addItem")
	public @ResponseBody String addItem(@PathVariable Long galleryId, String path, HttpServletRequest request) {
		Gallery gallery = galleryService.findOne(galleryId);
		GalleryItem item = new GalleryItem();
		item.setGallery(gallery);
		item.setSort(0);
		item.setImage(path);
		item.setText("无");
		item.setTitle("无");
		galleryItemService.save(item);
		return "OK";
	}
	
	@RequestMapping(value = "admin/gallery/{galleryId}/upload")
	public @ResponseBody String uploadGalleryItemImages(@PathVariable Long galleryId, HttpServletRequest request) {
		List<String> uploadedImages = super.handleMultipleUploadFields(request);
		
		if(CollectionUtil.isEmpty(uploadedImages)) {
			return "[]";
		}
		Gallery gallery = galleryService.findOne(galleryId);
		for(String file : uploadedImages) {
			GalleryItem item = new GalleryItem();
			item.setGallery(gallery);
			item.setSort(0);
			item.setImage(file);
			item.setText("无");
			item.setTitle("无");
			galleryItemService.save(item);
		}
		
		return JsonUtil.collection2json(uploadedImages);
	}
	
	@RequestMapping(value = "admin/gallery/item/edit", method=RequestMethod.GET)
	public @ResponseBody String addGalleryItem(GalleryItem item, Model model) {
		galleryItemService.save(item);
		return "OK";
	}
	
	@RequestMapping(value = "admin/gallery/item/delete", method=RequestMethod.GET)
	public @ResponseBody String removeGalleryItem(Long id, Model model) {
		galleryItemService.delete(id);
		return "OK";
	}
	
	
}
