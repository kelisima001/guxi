package com.smart.service.init;

import org.springframework.stereotype.Service;

import com.smart.consts.GalleryCodes;
import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Gallery;

/**
 * 初始化首页图片轮播
 * 
 * @author Xin.Sun
 *
 */
@Service
public class GalleryInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_GALLERY;
	}

	@Override
	public void initData() throws Exception {
		Gallery gallery = galleryService.findByCode(GalleryCodes.GALLERY_PC_HOME);
		if(gallery!=null){
			return;
		}
		gallery = new Gallery();
		gallery.setCode(GalleryCodes.GALLERY_PC_HOME);
		gallery.setName("PC首页轮播");
		gallery.setPlayInterval(5);
		galleryService.save(gallery);
		
		gallery = new Gallery();
		gallery.setCode(GalleryCodes.GALLERY_MOBILE_HOME);
		gallery.setName("手机首页轮播");
		gallery.setPlayInterval(5);
		galleryService.save(gallery);
		
	}

}
