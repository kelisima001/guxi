package com.smart.service.init;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.smart.consts.DictModules;
import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Dict;

/**
 * 初始化必须的字典
 * 
 * @author Xin.Sun
 *
 */
@Service
public class DictInitService extends AbstractDataInitializeService{
	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_DICT;
	}

	@Override
	public void initData() throws Exception {
		logger.info("init dict data at {}", new Date());
		Dict obj = dictService.getDict(DictModules.MOD_SYS, "company.name");
		if(obj==null){
			Dict dict = new Dict();
			dict.setName("公司名称");
			dict.setModule(DictModules.MOD_SYS);
			dict.setCode("company.name");
			dict.setValue("上海古玺资产管理有限公司");
			dictService.save(dict);
			
			dict = new Dict();
			dict.setModule(DictModules.MOD_SYS);
			dict.setCode("site.baidu.code");
			dict.setName("baidu推广代码");
			dict.setValue("<script></script>");
			dictService.save(dict);
		}
	}
}
