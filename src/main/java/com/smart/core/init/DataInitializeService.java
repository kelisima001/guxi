package com.smart.core.init;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DataInitializeService extends Comparable<DataInitializeService> {

	/**
	 * 执行顺序
	 * @return
	 */
	public int getOrder();

	/**
	 * 执行初始化操作
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void initData() throws Exception;
}
