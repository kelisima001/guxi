package com.smart.service.init;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Info;
import com.smart.model.SelectItem;

@Service
public class InfoInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_INFO;
	}

	@Override
	public void initData() throws Exception {
		List<Info> list = infoService.findAll();
		if(list.isEmpty()){
			SelectItem item = selectItemService.findByCode("info.type.company");
			for(int i=1; i<=10; i++) {
				Info info = new Info();
				info.setType(item);
				info.setTitle("这里是资讯标题" + i);
				info.setContent("资讯内容待定...");
				info.setAbstraction("摘要内容待定...");
				info.setImage("upload/images/pc/activity/act2.jpg");
				infoService.save(info);
			}
			
			SelectItem item1 = selectItemService.findByCode("info.type.market");
			
			for(int i=1; i<=5; i++) {
				Info info = new Info();
				info.setType(item1);
				info.setTitle("这里是活动标题" + i);
				info.setContent("活动内容待定...");
				info.setAbstraction("摘要内容待定...");
				info.setImage("upload/images/pc/activity/act1.jpg");
				infoService.save(info);
			}
		}
	}
}
