package com.smart.service.init;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Software;
import com.smart.util.CollectionUtil;

@Service
public class SoftwareInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_SOFTWARE;
	}

	@Override
	public void initData() throws Exception {
		logger.info("init demo software data at {}", new Date());
		List<?> list = softwareService.findAll();
		if(CollectionUtil.isEmpty(list)) {
			Software s = new Software();
			s.setName("MetaTrader 4");
			s.setShortDescription("MetaTrader桌面版");
			s.setImage("upload/images/pc/download/d1.jpg");
			s.setSort(1);
			s.setUrl("https://download.mql5.com/cdn/web/8338/mt4/tfyglobal4setup.exe");
			s.setDescription("");
			softwareService.save(s);
			
			s = new Software();
			s.setName("MetaTrader 4 Andriod");
			s.setShortDescription("MetaTrader 4 Andriod手机版");
			s.setImage("upload/images/pc/download/d2.jpg");
			s.setSort(2);
			s.setUrl("http://www.tfy-forex.com/download/tfyforexmetatrader4.apk");
			s.setDescription("");
			softwareService.save(s);
			
			s = new Software();
			s.setName("文华财经");
			s.setShortDescription("文华财经桌面版");
			s.setImage("upload/images/pc/download/d3.jpg");
			s.setSort(3);
			s.setUrl("http://116.224.87.20/9635462.s21d-9.faiusrd.com/75/ABUIABBLGAAglbziuwUojs3sswc.exe?wsiphost=local");
			s.setDescription("");
			softwareService.save(s);
			
			s = new Software();
			s.setName("博易大师");
			s.setShortDescription("博易大师桌面版");
			s.setImage("upload/images/pc/download/d4.jpg");
			s.setSort(4);
			s.setUrl("http://9.faiusrd.com/75/ABUIABBLGAAgwb7iuwUos8WorQU.exe");
			s.setDescription("");
			softwareService.save(s);
			
		}
	}
}
