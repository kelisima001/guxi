package com.smart.dao;

import java.io.Serializable;

public class PageRequest implements Serializable {

	private static final long serialVersionUID = 8280485938848398236L;

	public static final int DEFAULT_PAGE_NO = 1;
	public static final int DEFAULT_PAGE_SIZE = 15;

	private int pageNumber;
	private int pageSize;

	private int offset;
	private int limit;
	
	private long total = 0;

	/**
	 * 按默认分页参数构建对象
	 */
	public PageRequest() {
		this(DEFAULT_PAGE_NO, DEFAULT_PAGE_SIZE);
	}
	/**
	 * 每页大小,默认15
	 * @param pageNumber 页码
	 */
	public PageRequest(int pageNumber) {
		this(pageNumber, DEFAULT_PAGE_SIZE);
	}

	/**
	 * @param pageNumber 页码，从1开始
	 * @param pageSize 每页大小,默认15
	 */
	public PageRequest(int pageNumber, int pageSize) {
		if (pageNumber < 1) {
			pageNumber = DEFAULT_PAGE_NO;
		}
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.offset = (pageNumber - 1) * pageSize;
		this.limit = pageSize;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber){
		this.pageNumber = pageNumber;
		this.offset = (pageNumber - 1) * pageSize;
		this.limit = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.offset = (pageNumber - 1) * pageSize;
		this.limit = pageSize;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
