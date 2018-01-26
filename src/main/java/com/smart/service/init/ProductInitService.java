package com.smart.service.init;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;

@Service
public class ProductInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_PROD;
	}

	@Override
	public void initData() throws Exception {
		
	}
}
