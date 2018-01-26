package com.smart.dao;

import java.util.List;

import com.smart.model.GalleryItem;
import com.smart.model.GalleryItemCond;

/**
 * 
 * @author Sunxin
 *
 */
public interface GalleryItemDao extends BaseDao<GalleryItem, GalleryItemCond, Long>{ 
	List<GalleryItem> findByGalleryId(Long id);
}
