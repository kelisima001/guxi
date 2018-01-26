package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Gallery;
import com.smart.model.GalleryCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface GalleryService extends BaseService<Gallery, GalleryCond, Long>{
	public Gallery findByCode(String code);
}
