package com.smart.service.init;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.SelectItem;
import com.smart.model.SelectType;
import com.smart.util.CollectionUtil;

@Service
public class SelectTypeInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_SELECTTYPE;
	}

	@Override
	public void initData() throws Exception {
		List<?> list = selectTypeService.findAll();
		if(CollectionUtil.isNotEmpty(list)) {
			return;
		}
		SelectType type = new SelectType();
		type.setCode("product.type");
		type.setName("产品类型");
		type.setDescription("产品类型");
		
		selectTypeService.save(type);
		
		SelectItem item = new SelectItem();
		item.setSelectType(type);
		item.setName("默认");
		selectItemService.save(item);
		
		SelectType infoType = new SelectType();
		infoType.setCode("info.type");
		infoType.setName("资讯类型");
		infoType.setDescription("资讯类型");
		selectTypeService.save(infoType);
		
		item = new SelectItem();
		item.setSelectType(infoType);
		item.setCode("info.type.company");
		item.setName("企业动态");
		selectItemService.save(item);
		
		item = new SelectItem();
		item.setSelectType(infoType);
		item.setCode("info.type.industry");
		item.setName("行业动态");
		selectItemService.save(item);
		
		item = new SelectItem();
		item.setSelectType(infoType);
		item.setCode("info.type.market");
		item.setName("市场活动");
		selectItemService.save(item);
	}
}
