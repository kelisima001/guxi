package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.GalleryItemDao;
import com.smart.model.GalleryItem;
import com.smart.model.GalleryItemCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class GalleryItemServiceImpl extends BaseEntityService<GalleryItem, GalleryItemCond, Long> implements GalleryItemService{

	@Autowired
	private GalleryItemDao dao;
	
	@Override
	protected BaseDao<GalleryItem, GalleryItemCond, Long> getDao() {
		return dao;
	}
	
	public List<GalleryItem> findByGalleryId(Long id){
		return dao.findByGalleryId(id);
	}
	
}
