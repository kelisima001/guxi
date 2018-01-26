package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Gallery;
import com.smart.model.GalleryCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class GalleryDaoImpl extends BaseEntityDao<Gallery, GalleryCond, Long> implements GalleryDao{

}
