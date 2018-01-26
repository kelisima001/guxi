package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.GalleryDao;
import com.smart.dao.GalleryItemDao;
import com.smart.model.Gallery;
import com.smart.model.GalleryCond;
import com.smart.util.CollectionUtil;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class GalleryServiceImpl extends BaseEntityService<Gallery, GalleryCond, Long> implements GalleryService{

	@Autowired
	private GalleryDao dao;
	
	@Autowired
	private GalleryItemDao galleryItemDao;
	
	@Override
	protected BaseDao<Gallery, GalleryCond, Long> getDao() {
		return dao;
	}

	@Override
	public Gallery findByCode(String code) {
		List<Gallery> list = this.findBy("code", code);
		if(CollectionUtil.isEmpty(list)){
			return null;
		}
		Gallery gallery = list.get(0);
		gallery.setItems(galleryItemDao.findByGalleryId(gallery.getId()));
		return gallery;
	}
	
	
}
