package com.smart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.GalleryItem;
import com.smart.model.GalleryItemCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface GalleryItemService extends BaseService<GalleryItem, GalleryItemCond, Long>{
	List<GalleryItem> findByGalleryId(Long id);
}
