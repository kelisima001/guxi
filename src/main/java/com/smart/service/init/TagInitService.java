package com.smart.service.init;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Tag;
import com.smart.util.CollectionUtil;

/**
 * 初始化实例标签
 * 
 * @author Xin.Sun
 *
 */
@Service
public class TagInitService extends AbstractDataInitializeService{
	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_TAG;
	}

	@Override
	public void initData() throws Exception {
		logger.info("init demo tag data at {}", new Date());
		List<?> allTags = tagService.findAll();
		if(CollectionUtil.isEmpty(allTags)) {
			Tag tag = new Tag();
			tag.setCode("tag.info.recommand");
			tag.setName("推荐阅读");
			
			tagService.save(tag);
			
			tag = new Tag();
			tag.setCode("tag.info.hot");
			tag.setName("热搜文章");
			
			tagService.save(tag);
			
		}
	}

}
