package com.smart.core.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.service.ServiceSupport;


public abstract class AbstractDataInitializeService extends ServiceSupport implements DataInitializeService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int compareTo(DataInitializeService o) {
		return this.getOrder()-o.getOrder();
	}
	
}
